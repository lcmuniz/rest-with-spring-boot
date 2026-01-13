package com.lcmuniz.rest_with_spring_boot.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class GenderSerialize extends JsonSerializer<String> {
    @Override
    public void serialize(String string, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String result = string.equals("FEMALE") ? "F" : "M";
        jsonGenerator.writeString(result);
    }
}
