package com.asintoto.papermcp.implementations;

import io.modelcontextprotocol.json.McpJsonMapper;
import io.modelcontextprotocol.json.McpJsonMapperSupplier;

public class PaperJacksonMcpJsonMapperSupplier implements McpJsonMapperSupplier {
    @Override
    public McpJsonMapper get() {
        return new PaperJacksonMcpJsonMapper();
    }
}
