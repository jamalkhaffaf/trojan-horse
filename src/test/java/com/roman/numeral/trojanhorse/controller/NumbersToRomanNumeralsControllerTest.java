package com.roman.numeral.trojanhorse.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Objects;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

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
        this.mockMvc.perform(get("/NumbersToRomanNumerals/1")).andDo(print())
        .andExpect(view().name("I"));
    }
}
