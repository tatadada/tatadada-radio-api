package com.tatadada.api.services.impl;

import com.tatadada.api.entity.Statistic;
import com.tatadada.api.model.StatisticRepository;
import com.tatadada.api.services.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by mbogheti on 13/09/14.
 */

@Service
@Transactional
public class StatisticServiceImpl implements StatisticService{

    @Autowired
    private StatisticRepository statisticRepository;

    @Override
    public Statistic save(Statistic statistic) {
        return statisticRepository.save(statistic);
    }
}
