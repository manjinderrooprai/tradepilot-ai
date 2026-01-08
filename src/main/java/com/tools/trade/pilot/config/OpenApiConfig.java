package com.tools.trade.pilot.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Tradepilot AI API",
        version = "v0",
        description = """
            An AI-powered trading assistant built with Spring AI, MCP, and Qwen, integrating Zerodha Kite for real-time market intelligence and decision support.
            """,
        contact = @Contact(
            name = "Manjinder Singh Rooprai",
            url = "https://github.com/manjinderrooprai/tradepilot-ai"
        ),
        license = @License(
            name = "Apache 2.0",
            url = "https://www.apache.org/licenses/LICENSE-2.0"
        )
    )
)
public class OpenApiConfig {
}
