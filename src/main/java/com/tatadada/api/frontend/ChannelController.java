package com.tatadada.api.frontend;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mbogheti on 11/07/14.
 */
@RestController
public class ChannelController {

    //remember to manage the url like this because the backward compatibility!
    @RequestMapping("/radio/service/{radioresource}/v1/")
    public String index(@PathVariable("radioresource") String radioresource) {
        return "Greetings from Spring Boot! " + radioresource;
    }
}
