package christmas.view;

public class OutputView {
    private static final String HELLO_RESTAURANT_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String EVENT_PREVIEW_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";
    private static final String ORDER_MENU_MESSAGE = "<주문 메뉴>";
    private static final String ORDER_MENU_DETAIL_MESSAGE = "%s %d개\n";
    private static final String BEFORE_DISCOUNT_TOTAL_MONEY_MESSAGE = "<할인 전 총주문 금액> \n%s원\n";
    private static final String GIVE_MENU_MESSAGE = "<증정 메뉴>";
    private static final String GIVE_CHAMPAGNE = "샴페인 1개";
    private static final String NOTHING_MESSAGE = "없음\n";
    private static final String TOTAL_BENEFIT_MESSAGE = "<혜택 내역>";
    private static final String D_DAY_DISCOUNT_MESSAGE = "크리스마스 디데이 할인 : -%s원\n";
    private static final String WEEKDAY_DISCOUNT_MESSAGE = "평일 할인 : -%s원\n";
    private static final String WEEKEND_DISCOUNT_MESSAGE = "주말 할인 : -%s원\n";
    private static final String SPECIAL_DISCOUNT_MESSAGE = "특별 할인 : -%s원\n";
    private static final String GIVE_EVENT_DISCOUNT_MESSAGE = "증정 이벤트 : -%s원\n";
    private static final String TOTAL_BENEFIT_MONEY_POSITIVE = "<총혜택 금액> \n-%s원\n";
    private static final String TOTAL_BENEFIT_MONEY_DETAILS_ZERO = "<총혜택 금액> \n%s원\n";
    private static final String AFTER_DISCOUNT_TOTAL_MONEY_MESSAGE = "<할인 후 예상 결제 금액> \n%s원\n";
    private static final String EVENT_BADGE_MESSAGE = "<12월 이벤트 배지>\n%s";

    public void printHelloRestaurantOpen() {
        System.out.println(HELLO_RESTAURANT_MESSAGE);
    }

    public void printEventPreview(int date) {
        System.out.printf(EVENT_PREVIEW_MESSAGE, date);
    }

    public void printOrderMenu() {
        printEmptyLine();
        System.out.println(ORDER_MENU_MESSAGE);
    }

    public void printOrderMenuDetails(String menu, int count) {
        System.out.printf(ORDER_MENU_DETAIL_MESSAGE, menu, count);
    }

    public void printBeforeDiscount(String money) {
        printEmptyLine();
        System.out.printf(BEFORE_DISCOUNT_TOTAL_MONEY_MESSAGE, money);
    }

    public void printGiveMenu(boolean isGiveChampagne) {
        printEmptyLine();
        System.out.println(GIVE_MENU_MESSAGE);
        if (isGiveChampagne) {
            System.out.println(GIVE_CHAMPAGNE);
        }
        if (!isGiveChampagne) {
            System.out.println(NOTHING_MESSAGE);
        }
    }

    public void printTotalBenefit(boolean isBenefit) {
        printEmptyLine();
        System.out.println(TOTAL_BENEFIT_MESSAGE);

        if (!isBenefit) {
            System.out.println(NOTHING_MESSAGE);
        }
    }

    public void printdDayDiscount(boolean isdDayDiscountZero, String dDayDiscount) {
        if (isdDayDiscountZero) {
            System.out.printf(D_DAY_DISCOUNT_MESSAGE, dDayDiscount);
        }
    }

    public void printWeekdayDiscount(boolean isWeekDayDiscountZero, String weekdayDiscount) {
        if (isWeekDayDiscountZero) {
            System.out.printf(WEEKDAY_DISCOUNT_MESSAGE, weekdayDiscount);
        }
    }

    public void printWeekendDiscount(boolean isWeekendDiscountZero, String weekdayDiscount) {
        if (isWeekendDiscountZero) {
            System.out.printf(WEEKEND_DISCOUNT_MESSAGE, weekdayDiscount);
        }
    }

    public void printSpecialDiscount(boolean isSpecialDiscountZero, String specialDiscount) {
        if (isSpecialDiscountZero) {
            System.out.printf(SPECIAL_DISCOUNT_MESSAGE, specialDiscount);
        }
    }

    public void printEventDiscount(boolean isBeforeTotalMoney, String event) {
        if (isBeforeTotalMoney) {
            System.out.printf(GIVE_EVENT_DISCOUNT_MESSAGE, event);
        }
    }

    public void printTotalBenefitMoney(boolean isTotalBenefitMoneyZero, String totalBenefitMoney) {
        printEmptyLine();
        if (isTotalBenefitMoneyZero) {
            System.out.printf(TOTAL_BENEFIT_MONEY_POSITIVE, totalBenefitMoney);
        }
        if (!isTotalBenefitMoneyZero) {
            System.out.printf(TOTAL_BENEFIT_MONEY_DETAILS_ZERO, totalBenefitMoney);
        }
    }

    public void printAfterDiscount(String afterDiscountTotalMoney) {
        printEmptyLine();
        System.out.printf(AFTER_DISCOUNT_TOTAL_MONEY_MESSAGE, afterDiscountTotalMoney);
    }

    public void printEventBadge(String eventBadge) {
        printEmptyLine();
        System.out.printf(EVENT_BADGE_MESSAGE, eventBadge);
    }

    public void printExceptionMessage(String message) {
        System.out.println(message);
    }

    public void printEmptyLine() {
        System.out.println();
    }
}
