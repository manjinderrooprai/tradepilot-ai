package com.tools.trade.pilot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tools.trade.pilot.service.TradingAssistantService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/ai")
@Tag(name = "AI Trading Assistant", description = "Spring AI + MCP + Qwen APIs")
public class AiController {

    private final TradingAssistantService tradingAssistantService;

    public AiController(TradingAssistantService tradingAssistantService) {
        this.tradingAssistantService = tradingAssistantService;
    }

    @Operation(summary = "Ask trading-related questions", description = "Uses Qwen LLM with MCP tools (Zerodha Kite) for live market data")
    @GetMapping("/ask")
    public String ask(@RequestParam(required = true) String query) {
        return tradingAssistantService.ask(query);
    }
}
