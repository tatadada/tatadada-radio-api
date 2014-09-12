package com.tatadada.api.dto;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.tatadada.api.entity.Channel;

import java.util.Collection;

/**
 * Created by mbogheti on 15/07/14.
 */
public class ChannelDto {


    private String title;
    private String subtitle;
    private String streamurl;
    private String resource;

    public ChannelDto() {
    }

    public ChannelDto(String title, String subtitle, String streamurl, String resource) {
        this.title = title;
        this.subtitle = subtitle;
        this.streamurl = streamurl;
        this.resource = resource;

    }

    public static ChannelDto fromBean(Channel channel) {
        return new ChannelDto(
                channel.getTitle(),
                channel.getSubtitle(),
                channel.getStreamurl(),
                channel.getResource()
        );
    }

    public static Collection<ChannelDto> fromBeanCollection(Collection<Channel> channels) {
        return Collections2.transform(channels, new Function<Channel, ChannelDto>() {
            @Override
            public ChannelDto apply(Channel channel) {
                return fromBean(channel);
            }
        });
    }


    public Channel toBean(ChannelDto channelDto) {
        return new Channel(channelDto.getTitle(),channelDto.getSubtitle(), channelDto.getStreamurl(), channelDto.getResource());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getStreamurl() {
        return streamurl;
    }

    public void setStreamurl(String streamurl) {
        this.streamurl = streamurl;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}
