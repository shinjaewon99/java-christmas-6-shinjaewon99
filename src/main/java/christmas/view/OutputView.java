package christmas.view;

public class OutputView {
    private static final String HELLO_RESTAURANT_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String EVENT_PREVIEW_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";
    private static final String ORDER_MENU_MESSAGE = "<주문 메뉴>";
    private static final String ORDER_MENU_DETAIL_MESSAGE = "%s %d개\n";
    private static final String BEFORE_DISCOUNT_TOTAL_MONEY_MESSAGE = "<할인 전 총주문 금액> \n%s원\n";
    private static final String GIVE_MENU_MESSAGE = "<증정 메뉴>";
    private static final String GIVE_CHAMPAGNE = "샴페인 1개";
    private static final String GIVE_NOTHING = "없음";

    public void printHello() {
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

    public void printGiveMenu(boolean isGive) {
        printEmptyLine();
        System.out.println(GIVE_MENU_MESSAGE);
        if(isGive){
            System.out.println(GIVE_CHAMPAGNE);
        }
        if(!isGive){
            System.out.println(GIVE_NOTHING);
        }
    }

    public void printExceptionMessage(String message) {
        System.out.println(message);
    }

    public void printEmptyLine() {
        System.out.println();
    }
}
