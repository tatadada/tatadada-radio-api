package com.tatadada.api.services;

import com.tatadada.api.entity.Channel;

import java.util.List;

/**
 * Created by mbogheti on 15/07/14.
 */
public interface ChannelService {
    List<Channel> findByResource(String resource);
}
