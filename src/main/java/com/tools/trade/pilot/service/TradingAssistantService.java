package com.tools.trade.pilot.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.stereotype.Service;

@Service
public class TradingAssistantService {

    private final ChatClient chatClient;
    private final SyncMcpToolCallbackProvider toolCallbackProvider;

    public TradingAssistantService(ChatClient.Builder builder,
            SyncMcpToolCallbackProvider toolCallbackProvider) {
        this.chatClient = builder.build();
        this.toolCallbackProvider = toolCallbackProvider;
    }

    public String ask(final String query) {
        return chatClient.prompt()
                .system("""
                            You are a trading assistant.
                            For any market data, index value, price, or quote,
                            you MUST call an MCP tool.
                            Never answer from memory.
                        """)
                .user(query)
                .toolCallbacks(toolCallbackProvider.getToolCallbacks())
                .call()
                .content();
    }
}
