package org.gaborbalazs.smartplatform.edgeservice.integrationtest.framework;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Assertions;
import org.springframework.stereotype.Component;

import com.google.common.io.Resources;

@Component
public class JsonResourceProvider {

    private static final String UNKNOWN_RESOURCE = "Unknown resource: ";

    /**
     * Get json file content.
     *
     * @param resourceFilePath the resource file path
     * @return the file content
     */
    public String getJsonContent(final String resourceFilePath) {
        String result;
        try {
            result = Resources.toString(Resources.getResource(resourceFilePath), StandardCharsets.UTF_8);
        } catch (IOException | IllegalArgumentException e) {
            Assertions.fail(UNKNOWN_RESOURCE + resourceFilePath);
            throw new IllegalStateException(UNKNOWN_RESOURCE + resourceFilePath, e);
        }
        return result;
    }
}
