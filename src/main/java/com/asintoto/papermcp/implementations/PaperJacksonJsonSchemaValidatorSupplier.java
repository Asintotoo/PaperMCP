package com.asintoto.papermcp.implementations;

import io.modelcontextprotocol.json.schema.JsonSchemaValidator;
import io.modelcontextprotocol.json.schema.JsonSchemaValidatorSupplier;
import io.modelcontextprotocol.json.schema.jackson.DefaultJsonSchemaValidator;

public class PaperJacksonJsonSchemaValidatorSupplier implements JsonSchemaValidatorSupplier {
    public PaperJacksonJsonSchemaValidatorSupplier() {
    }

    public JsonSchemaValidator get() {
        return new DefaultJsonSchemaValidator();
    }
}
