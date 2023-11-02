package com.roman.numeral.trojanhorse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roman.numeral.trojanhorse.service.NumbersToRomanNumeralsService;

@RestController
@RequestMapping("/NumbersToRomanNumerals")
public class NumbersToRomanNumeralsController {

    @Autowired
    NumbersToRomanNumeralsService service;
    
    @GetMapping("/{number}")
    public String numbersToRomanNumerals(@PathVariable(value = "number", required = true) String number) {
        return "";
    }
}
