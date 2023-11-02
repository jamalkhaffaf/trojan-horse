package com.roman.numeral.trojanhorse.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.roman.numeral.trojanhorse.service.NumbersToRomanNumeralsService;

@SpringBootTest
@AutoConfigureMockMvc
public class NumbersToRomanNumeralsControllerTest {

    @InjectMocks
    NumbersToRomanNumeralsController suit;

    @MockBean
    NumbersToRomanNumeralsService service;

    @Autowired
	private MockMvc mockMvc;

    @Test
    public void shouldReturn404WhenSendEmptyInputTest() throws Exception {
        this.mockMvc.perform(get("/NumbersToRomanNumerals/")).andDo(print())
        .andExpect(status().is(404));
    }

    @Test
    public void shouldReturn4xxWhenSendBadInputTest() throws Exception {
        String error = this.mockMvc.perform(get("/NumbersToRomanNumerals/A")).andDo(print())
        .andExpect(status().is4xxClientError()).andReturn().getResolvedException().getMessage();
        
        assertEquals("Failed to convert value of type 'java.lang.String'" + 
        " to required type 'int'; For input string: \"A\"", error);
    }

    @Test
    public void shouldReturnExpectedRomanNumeralTest() throws Exception {
        when(service.covert(1)).thenReturn("I");

        this.mockMvc.perform(get("/NumbersToRomanNumerals/1")).andDo(print())
        .andExpect(status().is2xxSuccessful())
        .andExpect(content().string("I"));
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionForOverThreeThousandLimitTest() throws Exception {
        when(service.covert(4000))
        .thenThrow(new IllegalArgumentException("Only Numbers Greater Than 0 And Less Than 3001 Are Accepted!"));

        this.mockMvc.perform(get("/NumbersToRomanNumerals/4000")).andDo(print())
        .andExpect(status().is4xxClientError())
        .andExpect(content().string("Only Numbers Greater Than 0 And Less Than 3001 Are Accepted!"));
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionForLessThanOneLimitTest() throws Exception {
        when(service.covert(0))
        .thenThrow(new IllegalArgumentException("Only Numbers Greater Than 0 And Less Than 3001 Are Accepted!"));

        this.mockMvc.perform(get("/NumbersToRomanNumerals/0")).andDo(print())
        .andExpect(status().is4xxClientError())
        .andExpect(content().string("Only Numbers Greater Than 0 And Less Than 3001 Are Accepted!"));
    }
}
