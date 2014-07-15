package com.tatadada.api.services.impl;

import com.tatadada.api.entity.Channel;
import com.tatadada.api.model.ChannelRepository;
import com.tatadada.api.services.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by mbogheti on 15/07/14.
 */

// Probably is clean but ... wtf 200 classes in order to do ONE fricking query !?!

@Service
@Transactional
public class ChannelServiceImpl implements ChannelService {

    @Autowired
    private ChannelRepository channelRepository;

    @Override
    public List<Channel> findByResource(String resource) {
        return channelRepository.findByResource(resource);
    }

}
