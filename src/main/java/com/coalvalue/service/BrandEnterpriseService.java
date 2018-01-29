package com.coalvalue.service;

import com.coalvalue.domain.BrandEnterprise;
import com.coalvalue.domain.OperationResult;

import com.coalvalue.enumType.BrandEnterpriseFeatureEnum;
import com.coalvalue.enumType.BrandEnterpriseStatusEnum;
import com.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 * Created by silence yuan on 2015/7/25.
 */
public interface BrandEnterpriseService extends BaseService {


    List<BrandEnterprise> getAll();


    List<BrandEnterprise> getEnterpriseByFeature(BrandEnterpriseFeatureEnum 广告);


    BrandEnterprise getEnterpriseByFeature(Integer id, BrandEnterpriseFeatureEnum yulinmeiIndex);

    List<BrandEnterprise> getEnterpriseByFeatureAndStatus(BrandEnterpriseFeatureEnum topicAreaColpitHengshan, BrandEnterpriseStatusEnum release);

    Map queryEnterpriseByFeature(BrandEnterpriseFeatureEnum brandEnterpriseFeatureEnum, Pageable pageable);

    Page<Map> queryEnterpriseByFeaturePage(BrandEnterpriseFeatureEnum brandEnterpriseFeatureEnum, Pageable pageable);


    @Transactional
    OperationResult addToFeature(Integer companyId, BrandEnterpriseFeatureEnum brandEnterpriseFeatureEnum);

    OperationResult deleteFeature(Integer companyId, BrandEnterpriseFeatureEnum brandEnterpriseFeatureEnum);

    List<BrandEnterprise> getEnterpriseByCompany(Integer id);

    Page<BrandEnterprise> getEnterpriseByFeature(BrandEnterpriseFeatureEnum 广告, Pageable pageable);

}
