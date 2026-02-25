package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GreetingController.class)
class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GreetingService greetingService;

    @Test
    void shouldReturnGreetingFromService() throws Exception {
        when(greetingService.greet("Spring")).thenReturn("Hello, Spring!");

        mockMvc.perform(get("/greet").param("name", "Spring"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, Spring!"));

        verify(greetingService).greet("Spring");
    }

    @Test
    void shouldSupportMissingNameParameter() throws Exception {
        when(greetingService.greet(null)).thenReturn("Hello, World!");

        mockMvc.perform(get("/greet"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, World!"));

        verify(greetingService).greet(null);
    }
}
