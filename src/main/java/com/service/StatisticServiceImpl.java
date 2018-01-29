package com.service;

import com.coalvalue.domain.entity.TimeStatistic;
import com.coalvalue.repository.TimeStatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;


/**
 * Created by silence yuan on 2015/7/13.
 */

@Service("statisticService")
public class StatisticServiceImpl extends BaseServiceImpl implements StatisticService {

    @Autowired
    private TimeStatisticRepository timeStatisticRepository;






    @Override
    public TimeStatistic getCurrentTimeStatistic() {


        LocalDate start = LocalDate.now();
        Date s = Date.from(start.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        TimeStatistic statistic = null;
        List<TimeStatistic> statistics = timeStatisticRepository.findByCreateDateAfter(s);
        if (statistics.size() == 0) {
            statistic = new TimeStatistic();
            statistic.setCount(0);
            statistic.setPriceUpCount(0);
            statistic.setPriceDownCount(0);
            statistic.setInterval("day");
            statistic.setTime(s);

        } else {
            statistic = statistics.get(0);
        }

        statistic = timeStatisticRepository.save(statistic);
        return statistic;

    }


    @Override
    public TimeStatistic getCurrentTimeStatistic(Date date) {

        LocalDate start = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        //LocalDate start = date.get.now();
        Date s = Date.from(start.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        TimeStatistic statistic = null;
        List<TimeStatistic> statistics = timeStatisticRepository.findByCreateDateAfter(s);
        if (statistics.size() == 0) {
            statistic = new TimeStatistic();
            statistic.setCount(0);
            statistic.setPriceUpCount(0);
            statistic.setPriceDownCount(0);
            statistic.setInterval("day");
            statistic.setTime(s);

        } else {
            statistic = statistics.get(0);
        }

        statistic = timeStatisticRepository.save(statistic);
        return statistic;

    }



}
