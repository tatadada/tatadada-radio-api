package com.tatadada.api.model;

import com.tatadada.api.entity.Statistic;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by mbogheti on 13/09/14.
 */
public interface StatisticRepository extends CrudRepository<Statistic, Long> {

}
