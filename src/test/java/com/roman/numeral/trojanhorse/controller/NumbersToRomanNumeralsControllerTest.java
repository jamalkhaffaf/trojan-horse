package com.roman.numeral.trojanhorse.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


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
    public void shouldReturnExpectedRomanNumeralTest() throws Exception {
        this.mockMvc.perform(get("/NumbersToRomanNumerals/1")).andDo(print())
        .andExpect(view().name("I"));
    }
}
