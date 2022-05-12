package com.ibm.academia.apirest.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restapi")
public class PrimerRestControl
{
    Logger logger  = LoggerFactory.getLogger(PrimerRestControl.class);//refiere al nombre de la clase el parametro

    @GetMapping
    public String holaMundo(){
        logger.trace("tarec log");
        logger.debug("debug log");
        logger.info("info log");
        logger.warn("warning log");
        logger.error("error log");
        return "Hola mundo API";
    }

}
