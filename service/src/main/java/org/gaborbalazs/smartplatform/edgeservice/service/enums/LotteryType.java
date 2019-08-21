package org.gaborbalazs.smartplatform.edgeservice.service.enums;

import java.util.List;
import java.util.Optional;

public enum LotteryType {
    FIVE_OUT_OF_NINETY("five-out-of-ninety"),
    SIX_OUT_OF_FORTY_FIVE("six-out-of-forty-five"),
    SCANDINAVIAN("scandinavian");

    private String name;

    LotteryType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Optional<LotteryType> fromName(String name) {
        return List.of(LotteryType.values()).stream().filter(lotteryType -> lotteryType.getName().equals(name)).findFirst();
    }
}
