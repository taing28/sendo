package com.example.sendo.libs;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

public class InputHelper {
    public static List<String> checkBindingResult(BindingResult bindingResult) {
        List<String> errList = new ArrayList<>();
        for (FieldError err : bindingResult.getFieldErrors()) {
            errList.add("Error at field "+err.getField()+": "+err.getDefaultMessage());
        }
        return errList;
    }
}
