package com.codewithflash.restapi.controllers;


import com.codewithflash.restapi.DTO.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeRestController {
    @GetMapping("/hellorest")
    public  Country  helloRest() {
        return Country.of("Egypt", 200);
    }

    @GetMapping("/hellorest2")
    public List<Country> hellorest2 () {
        Country c1 = Country.of("Italy", 400);
        Country c2 = Country.of("Yemen", 4550);
        return List.of(c1,c2);
    }

    @GetMapping("/hellorest3")
    public ResponseEntity<List<Country>> hellorest3() {
        Country c1 = Country.of("England", 7800);
        Country c2 = Country.of("Egypt", 250);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("continent", "Europe")
                .header("capital", "London")
                .body(List.of(c1,c2));
    }

}
