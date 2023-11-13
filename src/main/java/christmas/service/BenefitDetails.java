package christmas.service;

import christmas.menu.OrderType;

public class BenefitDetails {
    private static final int MINIMUM_ORDER_MONEY = 10_000;
    private static final int BEGIN_DISCOUNT_MONEY = 1_000;
    private static final int INCREASE_DISCOUNT_MONEY = 100;
    private static final int CHRISTMAS_DATE = 25;
    private static final int DISCOUNT_MONEY = 2023;
    private static final int SPECIAL_DISCOUNT_MONEY = 1_000;
    private int dDayDiscount;
    private int weekdayDiscount;
    private int weekendDiscount;
    private int specialDiscount;

    public boolean minimumTotalMoney(int beforeTotalMoney) {
        return beforeTotalMoney >= MINIMUM_ORDER_MONEY;
    }

    public int calculatedDayDiscount(int date) {
        if (date <= CHRISTMAS_DATE) {
            dDayDiscount += BEGIN_DISCOUNT_MONEY + (INCREASE_DISCOUNT_MONEY * (date - 1));
        }
        return dDayDiscount;
    }

    public int calculatedWeekdayDiscount(String menu, int count) {
        for (OrderType type : OrderType.values()) {
            if (type.getName().equals(menu) && type.getMenuType().equals("DESSERT")) {
                for (int i = 0; i < count; i++) {
                    weekdayDiscount += DISCOUNT_MONEY;
                }
            }
        }
        return weekdayDiscount;
    }

    public int calculatedWeekendDiscount(String menu, int count) {
        for (OrderType type : OrderType.values()) {
            if (type.getName().equals(menu) && type.getMenuType().equals("MAIN")) {
                for (int i = 0; i < count; i++) {
                    weekendDiscount += DISCOUNT_MONEY;
                }
            }
        }
        return weekendDiscount;
    }

    public int calculateSpecialDiscount(int date) {
        if (date % 7 == 3 || date == CHRISTMAS_DATE) {
            specialDiscount += SPECIAL_DISCOUNT_MONEY;
        }
        return specialDiscount;
    }

    public boolean checkWeekday(int date) {
        return !(date % 7 == 1 || date % 7 == 2);
    }

    public boolean checkWeekend(int date) {
        return date % 7 == 1 || date % 7 == 2;
    }
}
