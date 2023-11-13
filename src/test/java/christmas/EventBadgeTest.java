package christmas;

import christmas.service.EventBadge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class EventBadgeTest {
    EventBadge eventBadge = new EventBadge();

    @DisplayName("산타 배지가 부여되는지 확인")
    @ValueSource(ints = {20_000, 50_000, 65_000})
    @ParameterizedTest
    void apply_Santa_Badge(int totalBeforeMoney) {
        assertThat("산타").isEqualTo(eventBadge.calculateEventBadge(totalBeforeMoney));
    }

    @DisplayName("트리 배지가 부여되는지 확인")
    @ValueSource(ints = {10_000, 15_000, 19_999})
    @ParameterizedTest
    void apply_Tree_Badge(int totalBeforeMoney) {
        assertThat("트리").isEqualTo(eventBadge.calculateEventBadge(totalBeforeMoney));
    }

    @DisplayName("별 배지가 부여되는지 확인")
    @ValueSource(ints = {5_000, 6_500, 9_999})
    @ParameterizedTest
    void apply_Star_Badge(int totalBeforeMoney) {
        assertThat("별").isEqualTo(eventBadge.calculateEventBadge(totalBeforeMoney));
    }

    @DisplayName("배지가 없음이 부여되는지 확인")
    @ValueSource(ints = {0, 1_000, 4_999})
    @ParameterizedTest
    void apply_Nothing_Badge(int totalBeforeMoney) {
        assertThat("없음").isEqualTo(eventBadge.calculateEventBadge(totalBeforeMoney));
    }
}
