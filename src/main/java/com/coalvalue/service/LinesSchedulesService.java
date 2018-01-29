package com.coalvalue.service;

import com.coalvalue.domain.OperationResult;
import com.coalvalue.domain.ScheduleLinesSchedules;
import com.coalvalue.web.valid.LinesSchedulesCreateForm;
import com.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

//import org.springframework.security.core.Authentication;

/**
 * Created by silence yuan on 2015/6/28.
 */
public interface LinesSchedulesService extends BaseService {



    Page<ScheduleLinesSchedules> queryStations(Integer userId, Pageable pageable);


    @Transactional
    ScheduleLinesSchedules create(LinesSchedulesCreateForm lineCreateForm);

    @Transactional
    ScheduleLinesSchedules edit(LinesSchedulesCreateForm locationCreateForm);

    OperationResult valid(LinesSchedulesCreateForm locationCreateForm);

}
