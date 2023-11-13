package christmas.service;

import christmas.menu.OrderType;

public class BenefitDetails {
    private static final int MINIMUM_ORDER_MONEY = 10_000;
    private static final int BEGIN_DISCOUNT_MONEY = 1_000;
    private static final int INCREASE_DISCOUNT_MONEY = 100;
    private static final int BASE_DAY = 1;
    private static final int CHRISTMAS_DATE = 25;
    private static final int DISCOUNT_MONEY = 2023;
    private static final int SPECIAL_DISCOUNT_MONEY = 1_000;
    private static final int ONE_WEEK = 7;
    private static final int WEEKEND_FRIDAY_NUMBER = 1;
    private static final int WEEKEND_SATURDAY_NUMBER = 2;
    private static final int BADGE_LOCATION_NUMBER = 3;
    private static final int MINIMUM_SANTA_BADGE_NUMBER = 20_000;
    private static final int MINIMUM_TREE_BADGE_NUMBER = 10_000;
    private static final int MINIMUM_START_BADGE_NUMBER = 5_000;
    private static final String MENU_TYPE_DESSERT = "DESSERT";
    private static final String MENU_TYPE_MAIN = "MAIN";
    private static final String SANTA_BADGE = "산타";
    private static final String TREE_BADGE = "트리";
    private static final String START_BADGE = "별";
    private static final String NOTHING_BADGE = "없음";

    private int dDayDiscount;
    private int weekdayDiscount;
    private int weekendDiscount;
    private int specialDiscount;
    private String eventBadge;

    public boolean minimumTotalMoney(int beforeTotalMoney) {
        return beforeTotalMoney >= MINIMUM_ORDER_MONEY;
    }

    public int calculatedDayDiscount(int date) {
        if (date <= CHRISTMAS_DATE) {
            dDayDiscount += BEGIN_DISCOUNT_MONEY + (INCREASE_DISCOUNT_MONEY * (date - BASE_DAY));
        }
        return dDayDiscount;
    }

    public int calculatedWeekdayDiscount(String menu, int count) {
        for (OrderType type : OrderType.values()) {
            if (type.getName().equals(menu) && type.getMenuType().equals(MENU_TYPE_DESSERT)) {
                weekdayDiscountLoop(count);
            }
        }
        return weekdayDiscount;
    }


    public int calculatedWeekendDiscount(String menu, int count) {
        for (OrderType type : OrderType.values()) {
            if (type.getName().equals(menu) && type.getMenuType().equals(MENU_TYPE_MAIN)) {
                weekendDiscountLoop(count);
            }
        }
        return weekendDiscount;
    }

    public int calculateSpecialDiscount(int date) {
        if (date % ONE_WEEK == BADGE_LOCATION_NUMBER || date == CHRISTMAS_DATE) {
            specialDiscount += SPECIAL_DISCOUNT_MONEY;
        }
        return specialDiscount;
    }

    public String calculateEventBadge(int totalBenefitMoney) {
        if (totalBenefitMoney >= MINIMUM_SANTA_BADGE_NUMBER) {
            eventBadge = SANTA_BADGE;
        }
        if (totalBenefitMoney >= MINIMUM_TREE_BADGE_NUMBER && totalBenefitMoney < MINIMUM_SANTA_BADGE_NUMBER) {
            eventBadge = TREE_BADGE;
        }
        if (totalBenefitMoney >= MINIMUM_START_BADGE_NUMBER && totalBenefitMoney < MINIMUM_TREE_BADGE_NUMBER) {
            eventBadge = START_BADGE;
        }
        if (totalBenefitMoney < MINIMUM_START_BADGE_NUMBER) {
            eventBadge = NOTHING_BADGE;
        }
        return eventBadge;
    }

    public boolean checkWeekday(int date) {
        return !(date % ONE_WEEK == WEEKEND_FRIDAY_NUMBER || date % ONE_WEEK == WEEKEND_SATURDAY_NUMBER);
    }

    public boolean checkWeekend(int date) {
        return date % ONE_WEEK == WEEKEND_FRIDAY_NUMBER || date % ONE_WEEK == WEEKEND_SATURDAY_NUMBER;
    }

    private void weekdayDiscountLoop(int count) {
        for (int i = 0; i < count; i++) {
            weekdayDiscount += DISCOUNT_MONEY;
        }
    }

    private void weekendDiscountLoop(int count) {
        for (int i = 0; i < count; i++) {
            weekendDiscount += DISCOUNT_MONEY;
        }
    }
}
