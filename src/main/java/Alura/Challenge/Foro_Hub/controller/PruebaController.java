package Alura.Challenge.Foro_Hub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prueba")
public class PruebaController {

    @GetMapping
    public String prueba() {
        return "Prueba de primer endpoint";
    }
}
