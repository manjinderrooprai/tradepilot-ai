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

    public String ask(final String question) {
        return chatClient.prompt()
                .system("""
                            You are a trading assistant.
                            You must use MCP tools for live market data.
                            Never assume prices.
                        """)
                .user(question)
                .toolCallbacks(toolCallbackProvider.getToolCallbacks())
                .call()
                .content();
    }
}
