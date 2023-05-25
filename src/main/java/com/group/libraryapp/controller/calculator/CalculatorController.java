package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.dto.calculator.CalculatorRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @GetMapping("/add")
    public int addTwoNumber(@RequestParam("number1") int number1, @RequestParam("number2") int number2 ){
        return number1 + number2;
    }
    @GetMapping("/add2")
    public int addTwoNumber2(CalculatorRequest request){
        return request.getNumber1() + request.getNumber2();
    }

    @PostMapping("/multiply")
    public int multiplyTwoNumbers(@RequestBody CalculatorRequest request){
        return request.getNumber1() * request.getNumber2();
    }


}
