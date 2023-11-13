package christmas.menu;

public enum Order {
    APPETIZER_FIRST("양송이수프", 6_000),
    APPETIZER_SECOND("타파스", 5_500),
    APPETIZER_THIRD("시저샐러드", 8_000),
    MAIN_FIRST("티본스테이크", 55_000),
    MAIN_SECOND("바비큐립", 54_000),
    MAIN_THIRD("해산물파스타", 35_000),
    MAIN_FOURTH("크리스마스파스타", 25_000),
    DESSERT_FIRST("초코케이크", 15_000),
    DESSERT_SECOND("아이스크림", 5_000),
    DRINK_FIRST("제로콜라", 3_000),
    DRINK_SECOND("레드와인", 60_000),
    DRINK_THIRD("샴페인", 25_000);
    private final String name;
    private final int price;

    Order(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
