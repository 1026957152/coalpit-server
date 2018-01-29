package com.coalvalue.service;


import com.coalvalue.domain.entity.QualityInspectionReport;
import com.coalvalue.domain.entity.QualityTestItem;
import com.coalvalue.enumType.QualityIndicatorEnum;
import com.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 * Created by silence yuan on 2015/7/25.
 */
public interface QualityInspectionService extends BaseService {



    QualityInspectionReport queryQualityInpectionReportById(Integer id);




    Page<QualityTestItem> queryQualityTestItems(QualityInspectionReport qualityInspectionReport, Pageable pageable);

    Page<QualityInspectionReport> queryQualityInspectionReportsByCompanyId(Integer companyId, Pageable pageRequest);

    List<QualityTestItem> queryQualityTestItems(QualityInspectionReport qualityInspectionReport);

    QualityTestItem queryQualityTestItemBySymbol(QualityIndicatorEnum qnet, QualityInspectionReport qualityInspectionReport);

    @Transactional
    List<QualityTestItem> queryQualityTestItemBySymbols(List<QualityIndicatorEnum> qnet, QualityInspectionReport qualityInspectionReport);

    String toWxPresentation(QualityInspectionReport qualityInspectionReport);


    Map<String,String> getHomePresentation(QualityInspectionReport qualityIndex);



    List<Map<String, Object>> getHomePresentationDisplay(QualityInspectionReport qualityIndex);

    Map getQualityPresentationDetail(QualityInspectionReport qualityIndex);

    List<Map> getByCompanyId(Integer id);

    List getGradle(Integer id);

    List<Map<String, Object>> getHomePresentation(Integer qualityReportId);


}
