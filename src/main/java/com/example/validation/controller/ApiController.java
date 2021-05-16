package com.example.validation.controller;


import com.example.validation.dto.TestDto;
import com.example.validation.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {

/*    @PostMapping("/user")
    public UserDto user(@RequestBody UserDto user){
        System.out.println("user :" + user);
        return user;
    } */

/*    @PostMapping("/user")
    public ResponseEntity user(@Valid @RequestBody UserDto user, BindingResult bindingResult){
        System.out.println("user :" + user);

        if (user.getPhoneNumber() == "xxx-xxxx-xxxx") {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
        }

        if (user.getAge() >= 90) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
        }
        return ResponseEntity.ok(user);
    }*/

    @PostMapping("/user")
    public ResponseEntity user(@Valid @RequestBody UserDto user, BindingResult bindingResult) {


        if (bindingResult.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            bindingResult.getAllErrors().forEach(objectError -> {

                FieldError field = (FieldError) objectError;
                String message = objectError.getDefaultMessage();

                System.out.println("field :" + field.getField());
                System.out.println("message :" + message);

                sb.append("field :" + field.getField());
                sb.append("message :" + message);

            });

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
        }   // logic
        return ResponseEntity.ok(user);
    }


    @GetMapping("testGet")
    public TestDto get(@RequestParam(required = false) String name, @RequestParam(required = false) Integer age) {
        TestDto testDto = new TestDto();
        testDto.setName(name);
        testDto.setAge(age);

        int a = 10 +age;
        return testDto;
    }


    @PostMapping("/testPost")
    public TestDto post(@Valid @RequestBody TestDto testDto) {
        System.out.println(testDto);
        return testDto;
    }
}
