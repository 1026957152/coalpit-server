package com.coalvalue.repository;


import com.coalvalue.domain.entity.QualityInspectionReport;
import com.coalvalue.repository.base.BaseJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface QualityInspectionReportRepository extends BaseJpaRepository<QualityInspectionReport, Integer> {



    Page<QualityInspectionReport> findByCompanyId(Integer companyId, Pageable pageRequest);


    QualityInspectionReport findById(Integer id);

    List<QualityInspectionReport> findByCompanyId(Integer id);
}
