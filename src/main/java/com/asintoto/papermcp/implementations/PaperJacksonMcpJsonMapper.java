package com.asintoto.papermcp.implementations;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.modelcontextprotocol.json.McpJsonMapper;
import io.modelcontextprotocol.json.TypeRef;

import java.io.IOException;

@SuppressWarnings("all")
public class PaperJacksonMcpJsonMapper implements McpJsonMapper {
    private final ObjectMapper objectMapper;

    public PaperJacksonMcpJsonMapper() {
        this.objectMapper = new ObjectMapper();
    }

    public ObjectMapper getObjectMapper() {
        return this.objectMapper;
    }

    public <T> T readValue(String content, Class<T> type) throws IOException {
        return this.objectMapper.readValue(content, type);
    }

    public <T> T readValue(byte[] content, Class<T> type) throws IOException {
        return this.objectMapper.readValue(content, type);
    }

    public <T> T readValue(String content, TypeRef<T> type) throws IOException {
        JavaType javaType = this.objectMapper.getTypeFactory().constructType(type.getType());
        return this.objectMapper.readValue(content, javaType);
    }

    public <T> T readValue(byte[] content, TypeRef<T> type) throws IOException {
        JavaType javaType = this.objectMapper.getTypeFactory().constructType(type.getType());
        return this.objectMapper.readValue(content, javaType);
    }

    public <T> T convertValue(Object fromValue, Class<T> type) {
        return this.objectMapper.convertValue(fromValue, type);
    }

    public <T> T convertValue(Object fromValue, TypeRef<T> type) {
        JavaType javaType = this.objectMapper.getTypeFactory().constructType(type.getType());
        return this.objectMapper.convertValue(fromValue, javaType);
    }

    public String writeValueAsString(Object value) throws IOException {
        return this.objectMapper.writeValueAsString(value);
    }

    public byte[] writeValueAsBytes(Object value) throws IOException {
        return this.objectMapper.writeValueAsBytes(value);
    }
}
