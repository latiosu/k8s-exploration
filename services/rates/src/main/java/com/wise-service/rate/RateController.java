package com.test.rate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateController {

  @GetMapping("/rate")
  public String index() {
    return "Greetings from Spring Boot!";
  }

}