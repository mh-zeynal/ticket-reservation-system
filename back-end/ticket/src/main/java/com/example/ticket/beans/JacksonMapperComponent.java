package com.example.ticket.beans;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component("jackComp")
@Scope("singleton")
public class JacksonMapperComponent implements InitializingBean {

    private ObjectMapper mapper;

    @Override
    public void afterPropertiesSet() throws Exception {
        mapper = new ObjectMapper();
        mapper.registerModule(new JSR310Module());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    public String convertToJson(Object obj) throws JsonProcessingException {
        return mapper.writeValueAsString(obj);
    }

    public <T> T convertToJavaObject(String json, Class<T> tClass) throws JsonProcessingException {
        return (T) mapper.readValue(json, tClass);
    }

    public <T> T convertToJavaObject(byte[] json, Class<T> tClass) throws IOException {
        return (T) mapper.readValue(json, tClass);
    }

}
