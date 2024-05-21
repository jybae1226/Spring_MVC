package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {
    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "hello world!";
    }

    @GetMapping("/hello2")
    public String hello2() {
        return "hello";
    }

    @GetMapping("/introduce")
    public String introduce(@RequestParam(name = "name", required = false, defaultValue = "배종연") String name, Model model) {
        model.addAttribute("name", name);
        return "introduce";
    }

    @GetMapping("/json")
    public ResponseEntity<Map<String, Object>> json() {
        Map<String, Object> response = new HashMap<>();
        response.put("name", "배종연");
        response.put("age", 23);
        return ResponseEntity.ok().body(response);
    }
}


