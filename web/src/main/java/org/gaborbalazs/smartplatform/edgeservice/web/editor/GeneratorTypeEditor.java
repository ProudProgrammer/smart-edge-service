package org.gaborbalazs.smartplatform.edgeservice.web.editor;

import java.beans.PropertyEditorSupport;

import org.gaborbalazs.smartplatform.edgeservice.service.enums.GeneratorType;

public class GeneratorTypeEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        GeneratorType generatorType = GeneratorType.fromValue(text).orElseThrow(() -> new IllegalArgumentException("Request param cannot be converted to GeneratorType: " + text));
        setValue(generatorType);
    }
}
