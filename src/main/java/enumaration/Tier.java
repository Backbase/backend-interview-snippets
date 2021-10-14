package enumaration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Tier {
    BASIC(1, true),
    SILVER(1.4, true),
    GOLD(2, true),
    PLATINUM(2.5, true),
    DIAMOND(3.2, true),
    EXCLUSIVE(0, false);

    private final double promotionFactor;
    private final boolean isPromotable;
}
