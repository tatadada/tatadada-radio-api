package com.tatadada.api.frontend;

import com.google.common.base.Strings;
import com.google.common.net.HttpHeaders;
import com.tatadada.api.dto.ChannelDto;
import com.tatadada.api.entity.Channel;
import com.tatadada.api.entity.Statistic;
import com.tatadada.api.services.ChannelService;
import com.tatadada.api.services.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by mbogheti on 11/07/14.
 */
@RestController
public class ChannelController {

    public static final String RADIORESOURCE = "radioresource";
    public static final String DEVICE_ID = "did";
    @Autowired
    ChannelService channelservice;

    @Autowired
    StatisticService statisticService;

    //remember to manage the url like this because the backward compatibility!
    @RequestMapping(method = RequestMethod.GET, value = "/radio/service/{radioresource}/v1/")
    public
    @ResponseBody
    Collection<ChannelDto> index(
            @PathVariable(RADIORESOURCE) String radioresource,
            @RequestParam(value = DEVICE_ID) String deviceId,
            @RequestHeader(HttpHeaders.USER_AGENT) String userAgent) {

        //TODO filter out the non valid user agents

        final List<Channel> byResource = channelservice.findByResource(radioresource);
        final Collection<ChannelDto> channelDtos = ChannelDto.fromBeanCollection(byResource);

        if(byResource.size()>0) {
            saveStatistic(radioresource, deviceId, userAgent);
        }

        return channelDtos;
    }

    private void saveStatistic(String radioresource, String deviceId, String userAgent) {
        if (!Strings.isNullOrEmpty(deviceId)) {
            Statistic statistic = new Statistic(deviceId, radioresource, new Date(), userAgent);
            statisticService.save(statistic);
        }
    }
}
