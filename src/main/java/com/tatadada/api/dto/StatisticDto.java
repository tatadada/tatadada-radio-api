package com.tatadada.api.dto;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.tatadada.api.entity.Channel;
import com.tatadada.api.entity.Statistic;

import java.util.Collection;
import java.util.Date;

/**
 * Created by mbogheti on 13/09/14.
 */
public class StatisticDto {

    String deviceId;
    String resource;
    Date request_date;
    String useragent;

    public StatisticDto() {
    }

    public StatisticDto(String deviceId, String resource, Date request_date, String useragent) {
        this.deviceId = deviceId;
        this.resource = resource;
        this.request_date = request_date;
        this.useragent = useragent;
    }

    public static StatisticDto fromBean(Statistic statistic) {
        return new StatisticDto(
                statistic.getDeviceId(),
                statistic.getResource(),
                statistic.getRequestDate(),
                statistic.getUseragent()
        );
    }

    public static Collection<StatisticDto> fromBeanCollection(Collection<Statistic> statistics) {
        return Collections2.transform(statistics, new Function<Statistic, StatisticDto>() {
            @Override
            public StatisticDto apply(Statistic statistic) {
                return fromBean(statistic);
            }
        });
    }


    public Channel toBean(ChannelDto channelDto) {
        return new Channel(channelDto.getTitle(),channelDto.getSubtitle(), channelDto.getStreamurl(), channelDto.getResource());
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public Date getRequest_date() {
        return request_date;
    }

    public void setRequest_date(Date request_date) {
        this.request_date = request_date;
    }

    public String getUseragent() {
        return useragent;
    }

    public void setUseragent(String useragent) {
        this.useragent = useragent;
    }
}
