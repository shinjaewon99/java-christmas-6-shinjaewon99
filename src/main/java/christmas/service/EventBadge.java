package christmas.service;

public class EventBadge {
    private static final int MINIMUM_SANTA_BADGE_NUMBER = 20_000;
    private static final int MINIMUM_TREE_BADGE_NUMBER = 10_000;
    private static final int MINIMUM_START_BADGE_NUMBER = 5_000;
    private static final String SANTA_BADGE = "산타";
    private static final String TREE_BADGE = "트리";
    private static final String START_BADGE = "별";
    private static final String NOTHING_BADGE = "없음";

    public String calculateEventBadge(int totalBenefitMoney) {
        if (totalBenefitMoney >= MINIMUM_SANTA_BADGE_NUMBER) {
            return SANTA_BADGE;
        }
        if (totalBenefitMoney >= MINIMUM_TREE_BADGE_NUMBER) {
            return TREE_BADGE;
        }
        if (totalBenefitMoney >= MINIMUM_START_BADGE_NUMBER) {
            return START_BADGE;
        }
        return NOTHING_BADGE;
    }
}
