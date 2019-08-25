package org.gaborbalazs.smartplatform.edgeservice.service.enums;

import java.util.List;
import java.util.Optional;

public enum LotteryType {
    FIVE_OUT_OF_NINETY("five-out-of-ninety"),
    SIX_OUT_OF_FORTY_FIVE("six-out-of-forty-five"),
    SCANDINAVIAN("scandinavian");

    private final String pathVariableName;

    LotteryType(String pathVariableName) {
        this.pathVariableName = pathVariableName;
    }

    public String getPathVariableName() {
        return pathVariableName;
    }

    public static Optional<LotteryType> fromPathVariableName(String pathVariableName) {
        return List.of(LotteryType.values()).stream().filter(lotteryType -> lotteryType.getPathVariableName().equals(pathVariableName)).findFirst();
    }
}
