package com.roman.numeral.trojanhorse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roman.numeral.trojanhorse.service.NumbersToRomanNumeralsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/numbers/to/roman/numerals")
public class NumbersToRomanNumeralsController {

    @Autowired
    private NumbersToRomanNumeralsService service;

    @GetMapping("/{number}")
    public ResponseEntity<String> convertToRomanNumerals(@PathVariable("number") int number) {
        ResponseEntity<String> response;
        try {
            String result = service.covert(number);
            log.info("Converted number {} to Roman numeral: {}", number, result);
            response = ResponseEntity.ok(result);
        } catch (IllegalArgumentException ex) {
            log.error("Failed to convert number {}. Reason: {}", number, ex.getMessage());
            response = ResponseEntity.badRequest().body(ex.getMessage());
        }
        return response;
    }
}
