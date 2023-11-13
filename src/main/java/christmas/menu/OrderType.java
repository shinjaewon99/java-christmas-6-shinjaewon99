package christmas.menu;

public enum OrderType {
    APPETIZER_FIRST("양송이수프", "APPETIZER"),
    APPETIZER_SECOND("타파스", "APPETIZER"),
    APPETIZER_THIRD("시저샐러드", "APPETIZER"),
    MAIN_FIRST("티본스테이크", "MAIN"),
    MAIN_SECOND("바비큐립", "MAIN"),
    MAIN_THIRD("해산물파스타", "MAIN"),
    MAIN_FOURTH("크리스마스파스타", "MAIN"),
    DESSERT_FIRST("초코케이크", "DESSERT"),
    DESSERT_SECOND("아이스크림", "DESSERT"),
    DRINK_FIRST("제로콜라", "DRINK"),
    DRINK_SECOND("레드와인", "DRINK"),
    DRINK_THIRD("샴페인", "DRINK");
    private final String name;
    private final String menuType;

    OrderType(String name, String menuTye) {
        this.name = name;
        this.menuType = menuTye;
    }

    public String getName() {
        return name;
    }

    public String getMenuType() {
        return menuType;
    }
}
