package christmas.service;

import christmas.domain.Customer;
import christmas.domain.OrderStore;

public class PromotionService {
    private final OrderStore orderStore = new OrderStore();
    private Customer customer;

    public void createVisitDate(String inputDate) {
        customer = new Customer(inputDate);
    }

    public void createMenuOrder(String inputMenu) {
        orderStore.createMenuOrder(inputMenu);
    }
}
