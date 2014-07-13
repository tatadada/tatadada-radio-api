package com.tatadada.api.frontend;

import com.tatadada.api.model.Channel;
import com.tatadada.api.model.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by mbogheti on 11/07/14.
 */
@RestController
public class ChannelController {

    @Autowired
    ChannelRepository channelRepository;

    //remember to manage the url like this because the backward compatibility!
    @RequestMapping("/radio/service/{radioresource}/v1/")
    public String index(@PathVariable("radioresource") String radioresource) {

        final List<Channel> byResource = channelRepository.findByResource(radioresource);

        return "Greetings from Spring Boot! " + byResource;
    }
}
