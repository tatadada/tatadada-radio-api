package com.tatadada.api.frontend;

import com.tatadada.api.dto.ChannelDto;
import com.tatadada.api.entity.Channel;
import com.tatadada.api.services.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

/**
 * Created by mbogheti on 11/07/14.
 */
@RestController
public class ChannelController {

    @Autowired
    ChannelService channelservice;

    //remember to manage the url like this because the backward compatibility!
    @RequestMapping("/radio/service/{radioresource}/v1/")

    public @ResponseBody Collection<ChannelDto> index(@PathVariable("radioresource") String radioresource) {

        final List<Channel> byResource = channelservice.findByResource(radioresource);

        final Collection<ChannelDto> channelDtos = ChannelDto.fromBeanCollection(byResource);

        return channelDtos;
    }
}
