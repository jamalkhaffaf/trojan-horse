package com.roman.numeral.trojanhorse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roman.numeral.trojanhorse.service.NumbersToRomanNumeralsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/NumbersToRomanNumerals")
public class NumbersToRomanNumeralsController {

    @Autowired
    NumbersToRomanNumeralsService service;
    
    @GetMapping("/{number}")
    public ResponseEntity<String> numbersToRomanNumerals(@PathVariable(value = "number", required = true) int number) {
        String result = "";
        
        try {
            result = service.covert(number);
            log.info("action: numbersToRomanNumerals(), message=converting \"{}\" to roman \"{}\"", number, result);
        } catch(IllegalArgumentException ex) {
            log.error("action: numbersToRomanNumerals(), message=exception occured during converting \"{}\". {}", number, ex.getMessage());
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
