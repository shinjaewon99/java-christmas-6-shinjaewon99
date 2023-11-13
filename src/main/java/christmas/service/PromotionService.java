package christmas.service;

import christmas.domain.Customer;
import christmas.domain.OrderStore;
import christmas.menu.Order;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;

public class PromotionService {
    private static final int MINIMUM_GIVE_MENU_MONEY = 120_000;
    private static final int CHAMPAGNE_PRICE = 25_000;
    private static final int DISCOUNT_MONEY_NOT_EXIST_NUMBER = 0;
    private static final NumberFormat NUMBER_FORMAT = NumberFormat.getInstance();
    private final OrderStore orderStore = new OrderStore();
    private final BenefitDetails benefitDetails = new BenefitDetails();
    private Customer customer;
    private int beforeTotalMoney;
    private int dDayDiscount;
    private int weekdayDiscount;
    private int weekendDiscount;
    private int specialDiscount;
    private int totalBenefitMoney;

    public void createVisitDate(String inputDate) {
        customer = new Customer(inputDate);
    }

    public void createMenuOrder(String inputMenu) {
        orderStore.createMenuOrder(inputMenu);
    }

    public void checkMinimumTotalMoney() {
        if (isMinimumTotalMoney()) {
            discountStatus();
        }
    }

    private void discountStatus() {
        createdDayDiscount();
        createWeekdayDiscount();
        createWeekendDiscount();
        createSpecialDiscount();
        createTotalBenefitMoney();
    }

    private void createdDayDiscount() {
        dDayDiscount = benefitDetails.calculatedDayDiscount(getVisitDate());
    }

    private void createWeekdayDiscount() {
        if (benefitDetails.checkWeekday(getVisitDate())) {
            for (int i = 0; i < getMenuSize(); i++) {
                weekdayDiscount = benefitDetails.calculatedWeekdayDiscount(getMenuStore().get(i), getMenuCountStore().get(i));
            }
        }
    }

    private void createWeekendDiscount() {
        if (benefitDetails.checkWeekend(getVisitDate())) {
            for (int i = 0; i < getMenuSize(); i++) {
                weekendDiscount = benefitDetails.calculatedWeekendDiscount(getMenuStore().get(i), getMenuCountStore().get(i));
            }
        }
    }

    private void createSpecialDiscount() {
        specialDiscount = benefitDetails.calculateSpecialDiscount(getVisitDate());
    }

    private void createTotalBenefitMoney() {
        if (isBeforeTotalMoney()) {
            totalBenefitMoney = sumTotalBenefitMoney() + CHAMPAGNE_PRICE;
        }
        if (!isBeforeTotalMoney()) {
            totalBenefitMoney = sumTotalBenefitMoney();
        }
    }

    public String createBeforeTotalMoney() {
        for (int i = 0; i < getMenuSize(); i++) {
            beforeTotalMoney += findMenuName(getMenuStore().get(i), getMenuCountStore().get(i));
        }
        return formatDiscount(beforeTotalMoney);
    }

    public boolean isGiveMenu() {
        return beforeTotalMoney >= MINIMUM_GIVE_MENU_MONEY;
    }

    public boolean isMinimumTotalMoney() {
        return benefitDetails.minimumTotalMoney(beforeTotalMoney);
    }

    public int sumTotalBenefitMoney() {
        return totalBenefitMoney = dDayDiscount + weekdayDiscount + weekendDiscount + specialDiscount;
    }

    public boolean isBeforeTotalMoney() {
        return beforeTotalMoney >= MINIMUM_GIVE_MENU_MONEY;
    }

    public String getEventDiscount() {
        return formatDiscount(CHAMPAGNE_PRICE);
    }

    public String getdDayDiscount() {
        return formatDiscount(dDayDiscount);
    }

    public String getWeekdayDiscount() {
        return formatDiscount(weekdayDiscount);
    }

    public String getWeekendDiscount() {
        return formatDiscount(weekendDiscount);
    }

    public String getSpecialDiscount() {
        return formatDiscount(specialDiscount);
    }

    public boolean isdDayDiscountDiscountZero() {
        return isDiscountZero(dDayDiscount);
    }

    public boolean isWeekDayDiscountZero() {
        return isDiscountZero(weekdayDiscount);
    }

    public boolean isWeekendDiscountZero() {
        return isDiscountZero(weekendDiscount);
    }

    public boolean isSpecialDiscountZero() {
        return isDiscountZero(specialDiscount);
    }

    public boolean isTotalBenefitMoneyZero() {
        return isDiscountZero(totalBenefitMoney);
    }

    public int getVisitDate() {
        return customer.getVisitDate();
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

    private boolean isDiscountZero(int discount) {
        return discount != DISCOUNT_MONEY_NOT_EXIST_NUMBER;
    }
}
