package com.tatadada.api.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by mbogheti on 13/07/14.
 */
public interface ChannelRepository  extends CrudRepository<Channel, Long> {
        List<Channel> findByResource(String resource);
}
