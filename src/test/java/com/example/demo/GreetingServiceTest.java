package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GreetingServiceTest {

    private final GreetingService greetingService = new GreetingService();

    @Test
    void shouldReturnDefaultGreetingWhenNameIsNull() {
        assertThat(greetingService.greet(null)).isEqualTo("Hello, World!");
    }

    @Test
    void shouldReturnDefaultGreetingWhenNameIsBlank() {
        assertThat(greetingService.greet("   ")).isEqualTo("Hello, World!");
    }

    @Test
    void shouldTrimNameAndReturnPersonalizedGreeting() {
        assertThat(greetingService.greet("  Java  ")).isEqualTo("Hello, Java!");
    }
}
