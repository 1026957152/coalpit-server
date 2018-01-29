package com.coalvalue.repository;


import com.coalvalue.domain.BrandEnterprise;
import com.coalvalue.repository.base.BaseJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface BrandEnterpriseRepository extends BaseJpaRepository<BrandEnterprise, Integer> {


    List<BrandEnterprise> findAllByOrderByIndexAsc();

    List<BrandEnterprise> findByStatusOrderByIndexAsc(String brandEnterpriseStatusRelease);



    List<BrandEnterprise> findByFeature(String text);



    List<BrandEnterprise> findByFeatureAndStatus(String text, String text1);

    List<BrandEnterprise> findByFeatureAndStatusOrderByIndexAsc(String text, String text1);


    Page<BrandEnterprise> findByFeature(String text, Pageable pageable);


    BrandEnterprise findByItemIdAndFeature(Integer id, String text);

    List<BrandEnterprise> findByItemId(Integer id);

}
