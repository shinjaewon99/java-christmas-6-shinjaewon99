package christmas.view;

public class OutputView {
    private static final String HELLO_RESTAURANT_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String EVENT_PREVIEW_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";

    public void printHello() {
        System.out.println(HELLO_RESTAURANT_MESSAGE);
    }

    public void printEventPreview(int date) {
        System.out.printf(EVENT_PREVIEW_MESSAGE, date);
    }

    public void printExceptionMessage(String message) {
        System.out.println(message);
    }

    public void printEmptyLine() {
        System.out.println();
    }
}
