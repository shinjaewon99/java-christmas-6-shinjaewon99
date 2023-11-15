package christmas.menu;

public enum OrderType {
    MUSHROOM_SOUP("양송이수프", "APPETIZER"),
    TAPAS("타파스", "APPETIZER"),
    CAESAR_SALAD("시저샐러드", "APPETIZER"),
    T_BONE_STEAK("티본스테이크", "MAIN"),
    BBQ_RIB("바비큐립", "MAIN"),
    SEA_FOOD_PASTA("해산물파스타", "MAIN"),
    CHRISTMAS_PASTA("크리스마스파스타", "MAIN"),
    CHOCO_CAKE("초코케이크", "DESSERT"),
    ICE_CREAM("아이스크림", "DESSERT"),
    ZERO_COKE("제로콜라", "DRINK"),
    RED_WINE("레드와인", "DRINK"),
    CHAMPAGNE("샴페인", "DRINK");
    private final String name;
    private final String menuType;

    OrderType(String name, String menuType) {
        this.name = name;
        this.menuType = menuType;
    }

    public String getName() {
        return name;
    }

    public String getMenuType() {
        return menuType;
    }
}
