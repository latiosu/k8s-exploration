package com.wiseservice.rate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@EnableScheduling
public class RateController {

  RestClient restClient = RestClient.create("https://api.wise.com");

  @Value("${wise-token}")
  private String wiseToken;
  
  @GetMapping("/rate")
  @Scheduled(fixedRate = 5000)
  public String exchangeRate() {
    String response = restClient.get()
      .uri("/v1/rates")
      .header("Authorization", "Bearer " + wiseToken)
      .retrieve()
      .body(String.class);
    System.out.println  (response);
    return response;
  }

}