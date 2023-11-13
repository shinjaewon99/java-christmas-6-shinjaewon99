package christmas.service;

import christmas.domain.Customer;
import christmas.domain.OrderStore;
import christmas.menu.Order;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;

public class PromotionService {
    private static final NumberFormat NUMBER_FORMAT = NumberFormat.getInstance();
    private final OrderStore orderStore = new OrderStore();
    private final BenefitDetails benefitDetails = new BenefitDetails();

    private Customer customer;
    private int beforeTotalMoney;

    public void createVisitDate(String inputDate) {
        customer = new Customer(inputDate);
    }

    public void createMenuOrder(String inputMenu) {
        orderStore.createMenuOrder(inputMenu);
    }

    public void checkMinimumTotalMoney() {
        if (isMinimumTotalMoney()) {

        }
    }

    public boolean isMinimumTotalMoney() {
        return benefitDetails.minimumTotalMoney(beforeTotalMoney);
    }

    public String createBeforeTotalMoney() {
        for (int i = 0; i < getMenuSize(); i++) {
            beforeTotalMoney += findMenuName(getMenuStore().get(i), getMenuCountStore().get(i));
        }
        return formatDiscount(beforeTotalMoney);
    }

    public int getMenuSize() {
        return getMenuCountStore().size();
    }

    public List<String> getMenuStore() {
        return orderStore.getMenuStore();
    }

    public List<Integer> getMenuCountStore() {
        return orderStore.getMenuCountStore();
    }

    private int findMenuName(String menu, int count) {
        return Arrays.stream(Order.values())
                .filter(order -> order.getName().equals(menu))
                .mapToInt(order -> order.getPrice() * count)
                .sum();
    }

    private String formatDiscount(int discount) {
        return NUMBER_FORMAT.format(discount);
    }
}
