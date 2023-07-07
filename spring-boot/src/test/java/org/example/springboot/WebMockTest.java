package org.example.springboot;

import org.example.springboot.configs.WebSecurityConfig;
import org.example.springboot.controllers.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HomeController.class)
@Import(WebSecurityConfig.class)
public class WebMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HomeController service;

    @Test
    public void greetingShouldReturnMessageFromService() throws Exception {
        when(service.helloWordList()).thenReturn(List.of("Hello", "World"));
        this.mockMvc.perform(get("/list")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("[\"Hello\",\"World\"]")));
    }
}
