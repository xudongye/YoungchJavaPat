package com.youngch.pat.beyond.hepler;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.IOException;

public class JsonHelper {
    public static String SerializeObject(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        final ObjectWriter writer = mapper.writer();
        try {
            return writer.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static <T> T DeserializeObject(String str, TypeReference typeReference) {
        ObjectMapper mapper = new ObjectMapper();
        final ObjectReader reader = mapper.reader();
        try {
            return (T) mapper.readValue(str, typeReference);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
