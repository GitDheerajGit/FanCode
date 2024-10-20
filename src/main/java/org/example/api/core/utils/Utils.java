package org.example.api.core.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Utils {
    /**
     *
     * @param object
     * @return
     */
    public static String convertObjectToJson(Object object) {
        String jsonString = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            jsonString = objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
