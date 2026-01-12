package com.lcmuniz.rest_with_spring_boot.controllers;

import com.lcmuniz.rest_with_spring_boot.math.Calculator;
import com.lcmuniz.rest_with_spring_boot.utils.NumberUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    private Calculator calc = new Calculator();

    @GetMapping("/sum/{a}/{b}")
    public Double sum(@PathVariable String a, @PathVariable String b) {
        if (NumberUtils.isNotNumeric(a) || NumberUtils.isNotNumeric(b)) throw new UnsupportedOperationException("Please set only numeric values!");
        return calc.sum(NumberUtils.convertToDouble(a), NumberUtils.convertToDouble(b));
    }

    @GetMapping("/subtract/{a}/{b}")
    public Double subtract(@PathVariable String a, @PathVariable String b) {
        if (NumberUtils.isNotNumeric(a) || NumberUtils.isNotNumeric(b)) throw new UnsupportedOperationException("Please set only numeric values!");
        return calc.subtract(NumberUtils.convertToDouble(a), NumberUtils.convertToDouble(b));
    }

    @GetMapping("/multiply/{a}/{b}")
    public Double multiply(@PathVariable String a, @PathVariable String b) {
        if (NumberUtils.isNotNumeric(a) || NumberUtils.isNotNumeric(b)) throw new UnsupportedOperationException("Please set only numeric values!");
        return calc.multiply(NumberUtils.convertToDouble(a), NumberUtils.convertToDouble(b));
    }

    @GetMapping("/divide/{a}/{b}")
    public Double divide(@PathVariable String a, @PathVariable String b) {
        if (NumberUtils.isNotNumeric(a) || NumberUtils.isNotNumeric(b)) throw new UnsupportedOperationException("Please set only numeric values!");
        return calc.divide(NumberUtils.convertToDouble(a), NumberUtils.convertToDouble(b));
    }

    @GetMapping("/avg/{a}/{b}")
    public Double avg(@PathVariable String a, @PathVariable String b) {
        if (NumberUtils.isNotNumeric(a) || NumberUtils.isNotNumeric(b)) throw new UnsupportedOperationException("Please set only numeric values!");
        return calc.avg(NumberUtils.convertToDouble(a), NumberUtils.convertToDouble(b));
    }

    @GetMapping("/sqrt/{a}")
    public Double sqrt(@PathVariable String a) {
        if (NumberUtils.isNotNumeric(a)) throw new UnsupportedOperationException("Please set a numeric value!");
        Double n = NumberUtils.convertToDouble(a);
        return calc.sqrt(n);
    }

}
