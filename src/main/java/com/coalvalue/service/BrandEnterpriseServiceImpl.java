package com.coalvalue.service;


import com.coalvalue.domain.BrandEnterprise;
import com.coalvalue.domain.OperationResult;

import com.coalvalue.domain.entity.Company;
import com.coalvalue.enumType.BrandEnterpriseFeatureEnum;
import com.coalvalue.enumType.BrandEnterpriseStatusEnum;


import com.coalvalue.enumType.ResourceType;
import com.coalvalue.repository.BrandEnterpriseRepository;
import com.coalvalue.repository.CompanyRepository;


import com.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("brandEnterpriseService")
public class BrandEnterpriseServiceImpl extends BaseServiceImpl implements BrandEnterpriseService {


    @Autowired
    private BrandEnterpriseRepository brandEnterpriseRepository;



    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<BrandEnterprise> getAll() {
        return brandEnterpriseRepository.findAll();
    }





    @Override
    public List<BrandEnterprise> getEnterpriseByFeature(BrandEnterpriseFeatureEnum feature) {

        return brandEnterpriseRepository.findByFeature(feature.getText());
    }



    @Override
    public BrandEnterprise getEnterpriseByFeature(Integer id, BrandEnterpriseFeatureEnum yulinmeiIndex) {

        return brandEnterpriseRepository.findByItemIdAndFeature(id, yulinmeiIndex.getText());
    }

    @Override
    public List<BrandEnterprise> getEnterpriseByFeatureAndStatus(BrandEnterpriseFeatureEnum feature, BrandEnterpriseStatusEnum release) {
        return brandEnterpriseRepository.findByFeatureAndStatus(feature.getText(), release.getText());
    }

    @Override
    public Map queryEnterpriseByFeature(BrandEnterpriseFeatureEnum brandEnterpriseFeatureEnum, Pageable pageable) {


        Page<BrandEnterprise> page = brandEnterpriseRepository.findByFeature(brandEnterpriseFeatureEnum.getText(), pageable);

        Map<String,Object> objectMap = new HashMap<>();
        objectMap.put("totalElements",page.getTotalElements());
        objectMap.put("totalPages",page.getTotalPages());
        objectMap.put("hasNext",page.hasNext());


        objectMap.put("totalElements",page.getTotalElements());
        objectMap.put("content",getContent(page, true));


        return objectMap;

    }
    @Override
    public Page<Map> queryEnterpriseByFeaturePage(BrandEnterpriseFeatureEnum brandEnterpriseFeatureEnum, Pageable pageable) {


        Page<BrandEnterprise> page = brandEnterpriseRepository.findByFeature(brandEnterpriseFeatureEnum.getText(), pageable);



        final Page<Map> page_ = new PageImpl<Map>(getContent(page,true),pageable,page.getTotalElements());
        return page_;

    }
    @Override
    @Transactional
    public OperationResult addToFeature(Integer companyId, BrandEnterpriseFeatureEnum brandEnterpriseFeatureEnum) {

        OperationResult operationResult = new OperationResult();
        BrandEnterprise brandEnterprise = new BrandEnterprise();
        brandEnterprise.setItemId(companyId);

        brandEnterprise.setItemType(ResourceType.COMPANY.getText());
        brandEnterprise.setFeature(brandEnterpriseFeatureEnum.getText());
        brandEnterpriseRepository.save(brandEnterprise);

        operationResult.setSuccess(true);
        return operationResult;
    }

    @Override
    public OperationResult deleteFeature(Integer companyId, BrandEnterpriseFeatureEnum brandEnterpriseFeatureEnum) {
        OperationResult operationResult = new OperationResult();

        BrandEnterprise brandEnterprise = brandEnterpriseRepository.findByItemIdAndFeature(companyId,brandEnterpriseFeatureEnum.getText());
        if(brandEnterprise != null){
            brandEnterpriseRepository.delete(brandEnterprise);
            operationResult.setSuccess(true);
        }else{
            operationResult.setSuccess(false);
            operationResult.setErrorMessage(companyId +" 没有" + brandEnterpriseFeatureEnum.getDisplayText() +" 特征");
        }


        return operationResult;
    }

    @Override
    public List<BrandEnterprise> getEnterpriseByCompany(Integer id) {

        List<BrandEnterprise> list = brandEnterpriseRepository.findByItemId(id);

        return list;
    }

    @Override
    public Page<BrandEnterprise> getEnterpriseByFeature(BrandEnterpriseFeatureEnum 广告, Pageable pageable) {
        return brandEnterpriseRepository.findByFeature(广告.getText(), pageable);

    }

    private List<Map> getContent(Page<BrandEnterprise> result, boolean isMoobile){
        List<Map> content = new LinkedList<>();
        for(BrandEnterprise teamDeal :result){
            Company person = companyRepository.findById(teamDeal.getId());

            Map map = new HashMap<>();

            map.put("id", person.getId());
            map.put("name", person.getCompanyName());
           // map.put("type", CooperationTypeEnum.fromString(person.getCompanyType()).getDisplayText());
            map.put("status",person.getStatus());


            map.put("avatarUrl", person.getLogoImage());


            if(isMoobile){
                String url =   "";//linkTo(methodOn(MobileCompanyController.class).company(person.getId(), null, null)).withSelfRel().getHref();
                map.put("url",url);
            }else {
/*                String productSourceUrl =   "";//linkTo(methodOn(CompanyZoneController.class).companyDtl(productRcompany.getId(),null,null)).withSelfRel().getHref();
                map.put("productSourceUrl", productSourceUrl);
                String productUrl =   "";//linkTo(methodOn(HomePromotionController.class).promotionDtl(product.getId(),null,null)).withSelfRel().getHref();
                map.put("productUrl",productUrl);
                String companyUrl =   "";//linkTo(methodOn(CompanyZoneController.class).companyDtl(company.getId(), null, null)).withSelfRel().getHref();
                map.put("companyUrl", companyUrl);*/
                //    String url =   "";//linkTo(methodOn(TeamPurchasingController.class).teamPurchasing_details(teamDeal.getId(), null, null)).withSelfRel().getHref();
                //   map.put("url",url);
            }

            content.add(map);
        }


        return content;
    }


    public List<BrandEnterprise> findAll() {
        return brandEnterpriseRepository.findAll(sortByIdAsc());
    }

    private Sort sortByIdAsc() {
        return new Sort(Sort.Direction.ASC, "id");
    }
}
