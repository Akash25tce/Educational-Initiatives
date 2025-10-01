package com.patterns.behavioral.strategy;
public class StrategyDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.checkout(100, new CreditCardPayment("1234-5678-9012-3456"));
        cart.checkout(50, new PayPalPayment("user@example.com"));
    }
}