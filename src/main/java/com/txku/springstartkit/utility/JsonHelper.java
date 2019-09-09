package com.txku.springstartkit.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class JsonHelper {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonHelper.class);

    public static <T> T parse(String jsonString, Class<T> type) throws IOException {
        return OBJECT_MAPPER.readValue(jsonString, type);
    }

    public static <T> T parse(String jsonString, TypeReference<T> type) throws IOException {
        return OBJECT_MAPPER.readValue(jsonString, type);
    }

    public static String stringify(Object object) {
        try {
            return OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }
}
