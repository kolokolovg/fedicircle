package org.guyvernk.mastaweb.controllers;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class MastaC2SControlles {

    @GetMapping("/s")
    String ints(){
        return "PUK";
    }
}
