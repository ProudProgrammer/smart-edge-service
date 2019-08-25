package org.gaborbalazs.smartplatform.edgeservice.web.converter;

import java.beans.PropertyEditorSupport;

import org.gaborbalazs.smartplatform.lotteryservice.client.enums.LotteryType;

public class LotteryTypeConverter extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        LotteryType lotteryType = LotteryType.fromPathVariableName(text)
                .orElseThrow(() -> new IllegalArgumentException("Path variable cannot be converted to LotteryType: " + text));
        setValue(lotteryType);
    }
}
