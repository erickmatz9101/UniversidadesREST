package com.ibm.academia.apirest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restapi")
public class PrimerRestControl
{
    @GetMapping
    public String holaMundo(){
        return "Hola mundo API";
    }

}
