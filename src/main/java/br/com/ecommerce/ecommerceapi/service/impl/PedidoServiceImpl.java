package br.com.ecommerce.ecommerceapi.service.impl;

import br.com.ecommerce.ecommerceapi.dto.ItemPedidoDTO;
import br.com.ecommerce.ecommerceapi.dto.PedidoDTO;
import br.com.ecommerce.ecommerceapi.exception.InsufficientStockException;
import br.com.ecommerce.ecommerceapi.model.*;
import br.com.ecommerce.ecommerceapi.repository.EstoqueRepository;
import br.com.ecommerce.ecommerceapi.repository.PedidoRepository;
import br.com.ecommerce.ecommerceapi.repository.ProdutoRepository;
import br.com.ecommerce.ecommerceapi.service.EstoqueService;
import br.com.ecommerce.ecommerceapi.service.PedidoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {

    private EstoqueService estoqueService;
    private PedidoRepository pedidoRepository;
    private EstoqueRepository estoqueRepository;
    private ProdutoRepository produtoRepository;

    private static Logger logger = LoggerFactory.getLogger(PedidoServiceImpl.class);

    public PedidoServiceImpl(PedidoRepository pedidoRepository, EstoqueRepository estoqueRepository, EstoqueService estoqueService, ProdutoRepository produtoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.estoqueRepository = estoqueRepository;
        this.estoqueService = estoqueService;
        this.produtoRepository = produtoRepository;
    }

    @Override
    public List<PedidoDTO> findAll() {
        return pedidoRepository.findAll().stream().map(PedidoDTO::new).collect(Collectors.toList());
    }

    @Override
    public PedidoDTO findById(Integer id) {
        Pedido pedido = pedidoRepository.findById(id).get();

        return new PedidoDTO(pedido);
    }

    @Override
    public PedidoDTO save(PedidoDTO pedidoDTO) throws InsufficientStockException {
        pedidoDTO.setDataPedido(LocalDateTime.now());
        BigDecimal valorTotal = calcularValorTotalDosItensPedido(pedidoDTO);

        //verifica se tem estoque para os produtos
        boolean estoque = verificarEstoque(pedidoDTO);

        if(!estoque){
            throw new InsufficientStockException("Quantidade de estoque não disponivel!");
        }

        retirarDoEstoque(pedidoDTO);
        Pedido pedido = new Pedido(pedidoDTO);
        //setar o valor total
        pedido.setValorTotal(valorTotal);
        //setar o status aguardando pagamento
        pedido.setStatus(new Status(1));
        Pedido pedidoSaved = pedidoRepository.save(pedido);
        return new PedidoDTO(pedidoSaved);
    }

    private BigDecimal calcularValorTotalDosItensPedido(PedidoDTO pedidoDTO) {
        BigDecimal valorItens = new BigDecimal(0);
        List<ItemPedidoDTO> itemPedidoDTOS = pedidoDTO.getItemPedidoDTOS();
        //soma dos itens
        for(ItemPedidoDTO itemPedidoDTO : itemPedidoDTOS){
           Produto produto = produtoRepository.findById(itemPedidoDTO.getProdutoId()).get();
             valorItens = valorItens.add(produto.getValorUnitario().multiply(BigDecimal.valueOf(itemPedidoDTO.getQuantidade())));
        }
        return valorItens;
    }

    //se a quantidade de estoque de algum produto for menor que a quantidade pedida retorna false
    private boolean verificarEstoque(PedidoDTO pedidoDTO) {
        boolean verificarEstoque = true;
        List<ItemPedidoDTO> itemPedidoDTOS = pedidoDTO.getItemPedidoDTOS();
        for(ItemPedidoDTO itemPedidoDTO : itemPedidoDTOS){
            Estoque estoque = estoqueRepository.findByProdutoId(itemPedidoDTO.getProdutoId());
            if(estoque == null){
                logger.error("Estoque do produto não disponível!");
                return false;
            }
            if(estoque.getQuantidade() < itemPedidoDTO.getQuantidade()){
                verificarEstoque = false;
                logger.error("Estoque do produto "+ estoque.getProduto().getId() + " " + estoque.getProduto().getDescricao() +", não disponível!");
            }
        }
        return verificarEstoque;
    }

    private void retirarDoEstoque(PedidoDTO pedidoDTO) {
        List<ItemPedidoDTO> itemPedidoDTOList = pedidoDTO.getItemPedidoDTOS();
        for(ItemPedidoDTO itemPedidoDTO : itemPedidoDTOList){
            Estoque estoque = estoqueRepository.findByProdutoId(itemPedidoDTO.getProdutoId());
                estoque.setQuantidade(estoque.getQuantidade() - itemPedidoDTO.getQuantidade());
                estoqueRepository.save(estoque);
            logger.info("Retirado do estoque "+ itemPedidoDTO.getQuantidade() + " quantidade do produto(s) " + estoque.getProduto().getDescricao());
            logger.info("Quantidade atual do produto(s) "+estoque.getProduto().getDescricao() + " em estoque: "+estoque.getQuantidade());
        }

    }

    @Override
    public PedidoDTO update(Integer id, PedidoDTO pedidoDTO) throws InsufficientStockException {
        //verifica se tem estoque para os produtos
        boolean estoque = verificarEstoque(pedidoDTO);

        if(!estoque){
            throw new InsufficientStockException("Quantidade de estoque não disponivel!");
        }

        retirarDoEstoque(pedidoDTO);
        BigDecimal valorTotal = calcularValorTotalDosItensPedido(pedidoDTO);

        Pedido pedido = pedidoRepository.findById(id).get();
        pedido.setCliente(new Cliente(pedidoDTO.getClienteId()));
        pedido.setDataPedido(pedidoDTO.getDataPedido());
        pedido.setEndereco(new Endereco(pedidoDTO.getEnderecoId()));
        pedido.setStatus(new Status(pedidoDTO.getStatusId()));
        Pedido pedidoUpdated = pedidoRepository.save(pedido);
        return new PedidoDTO(pedidoUpdated);
    }

    @Override
    public void delete(Integer id) {
        pedidoRepository.deleteById(id);
    }
}
