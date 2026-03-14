package com.example.spring_ai_tutorial.config

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.ai.model
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * OpenAI API 설정
 */
@Configuration
class AnthropicConfig {
    private val logger = KotlinLogging.logger {}

    @Value("\${spring.ai.anthropic.api-key}")
    private lateinit var apiKey: String

    /**
     * OpenAI API 클라이언트 빈 등록
     */
    @Bean
    fun anthropicApi(): Anthropic {
        logger.debug { "Anthropic API 클라이언트 초기화" }
        return Anth.builder()
            .apiKey(apiKey)
            .build()
    }
}