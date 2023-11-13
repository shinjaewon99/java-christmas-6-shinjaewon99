package christmas.service;

public class BenefitDetails {
    private static final int MINIMUM_ORDER_MONEY = 10_000;
    private static final int BEGIN_DISCOUNT_MONEY = 1_000;
    private static final int INCREASE_DISCOUNT_MONEY = 100;
    private static final int CHRISTMAS_DATE = 25;
    private int dDayDiscount;

    public boolean minimumTotalMoney(int beforeTotalMoney) {
        return beforeTotalMoney >= MINIMUM_ORDER_MONEY;
    }

    public int calculatedDayDiscount(int date) {
        if (date <= CHRISTMAS_DATE) {
            dDayDiscount += BEGIN_DISCOUNT_MONEY + (INCREASE_DISCOUNT_MONEY * (date - 1));
        }
        return dDayDiscount;
    }
}
