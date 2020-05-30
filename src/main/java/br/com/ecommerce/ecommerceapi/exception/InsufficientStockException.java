package br.com.ecommerce.ecommerceapi.exception;

public class InsufficientStockException extends Throwable {
    public InsufficientStockException(String message) {
        super(message);
    }
}
