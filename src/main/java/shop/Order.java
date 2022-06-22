package shop;

import java.util.List;

public class Order {
    private int number;
    private Client client;
    private List<Integer> basket;

    public Order(int number, Client client) {
        this.number = number;
        this.client = client;
    }

    public void setBasket(List<Integer> basket) {
        this.basket = basket;
    }

    public List<Integer> getBasket() {
        return basket;
    }

    public Client getClient() {
        return client;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Order{" +
                "number=" + number +
                ", client=" + client +
                ", basket=" + basket +
                '}';
    }
}
