package org.gaborbalazs.smartplatform.edgeservice.web.editor;

import org.gaborbalazs.smartplatform.edgeservice.service.enums.GeneratorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyEditorSupport;

public class GeneratorTypeEditor extends PropertyEditorSupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(GeneratorTypeEditor.class);

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        GeneratorType generatorType = GeneratorType.fromValue(text).orElseThrow(() -> {
            String msg = "Request param cannot be converted to GeneratorType: " + text;
            LOGGER.error(msg);
            return new IllegalArgumentException(msg);
        });
        setValue(generatorType);
    }
}
