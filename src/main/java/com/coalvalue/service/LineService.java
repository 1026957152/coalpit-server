package com.coalvalue.service;

import com.coalvalue.domain.OperationResult;
import com.coalvalue.domain.entity.Line;
import com.coalvalue.dto.LineDto;
import com.coalvalue.web.valid.LineCreateForm;
import com.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

//import org.springframework.security.core.Authentication;

/**
 * Created by silence yuan on 2015/6/28.
 */
public interface LineService extends BaseService {



    Page<Line> queryStations(Integer userId, Pageable pageable);


    @Transactional
    Line create(LineCreateForm lineCreateForm);

    @Transactional
    Line edit(LineCreateForm locationCreateForm);

    OperationResult valid(LineCreateForm locationCreateForm);

    List<Line> getLines();

    Page<Map> getMapPaged(LineDto lineDto, Pageable pageable);
}
