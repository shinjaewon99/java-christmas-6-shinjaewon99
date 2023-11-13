package christmas.service;

public class BenefitDetails {
    private static final int MINIMUM_ORDER_MONEY = 10_000;

    public boolean minimumTotalMoney(int beforeTotalMoney) {
        return beforeTotalMoney >= MINIMUM_ORDER_MONEY;
    }
}
