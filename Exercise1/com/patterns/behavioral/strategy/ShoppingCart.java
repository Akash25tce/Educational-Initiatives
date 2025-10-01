package com.patterns.behavioral.strategy;
public class ShoppingCart {
    public void checkout(int amount, PaymentStrategy paymentMethod) {
        paymentMethod.pay(amount);
    }
}