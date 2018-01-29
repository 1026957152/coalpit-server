package com.coalvalue.repository;

import com.coalvalue.domain.entity.QualityTestItem;
import com.coalvalue.repository.base.BaseJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface QualityTestItemRepository extends BaseJpaRepository<QualityTestItem, Integer> {




    Page<QualityTestItem> findByInspectionReportId(Integer id, Pageable pageable);

    List<QualityTestItem> findByInspectionReportId(Integer id);

    QualityTestItem findByInspectionReportIdAndSymbol(Integer id, String symbol);

    List<QualityTestItem> findByInspectionReportIdAndSymbolIn(Integer id, List<String> symbols);







}
