package org.gaborbalazs.smartplatform.edgeservice.web.editor;

import java.beans.PropertyEditorSupport;

import org.gaborbalazs.smartplatform.edgeservice.common.enums.LotteryType;

public class LotteryTypeEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        LotteryType lotteryType = LotteryType.fromPathVariableName(text)
                .orElseThrow(() -> new IllegalArgumentException("Path variable cannot be converted to LotteryType: " + text));
        setValue(lotteryType);
    }
}
