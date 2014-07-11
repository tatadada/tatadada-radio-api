package com.tatadada.api.frontend;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mbogheti on 11/07/14.
 */
@RestController
public class ChannelController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
