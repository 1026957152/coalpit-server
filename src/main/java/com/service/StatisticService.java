package com.service;

import com.coalvalue.domain.entity.TimeStatistic;

import java.util.Date;

/**
 * Created by silence yuan on 2015/7/13.
 */


/*
 在数据库中建立统计的数据，每个用户，不同角色， 会有不同记录数据

 买家，卖家类型的 记录数据
 物流信息部的记录数据
 管理层的数据记录

 分为三种类型的数据记录

 第一种(buyer_seller_statistics：需要记录的数据有：
 第二种（logistis_statistics）：需要记录的数据有：
 第三种(admin_statistics)：需要记录的数据有：



  */
public interface StatisticService {



    TimeStatistic getCurrentTimeStatistic();


    TimeStatistic getCurrentTimeStatistic(Date date);
}