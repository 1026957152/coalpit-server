package com.coalvalue.service;

import com.coalvalue.domain.OperationResult;
import com.coalvalue.domain.entity.Company;
import com.coalvalue.domain.entity.PriceCategory;
import com.coalvalue.domain.entity.Product;
import com.coalvalue.domain.entity.QualityInspectionReport;
import com.coalvalue.enumType.CoalSupplyStatusEnum;
import com.coalvalue.enumType.EventEnum;
import com.coalvalue.enumType.PriceCategoryStatusEnum;
import com.coalvalue.enumType.PriceCategoryTypeEnum;
import com.domain.entity.User;
import com.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

//import org.springframework.security.core.Authentication;

/**
 * Created by zohu on 3/20/2015.
 */
public interface ProductService extends BaseService {




    Product getById(Integer productId);



    void sendMessage(EventEnum changePricePromotion, Product product, User user, Object o);


    PriceCategory getDefaultPriceCategory(Product coalSupply);

    PriceCategory createPriceCategory(PriceCategoryTypeEnum priceCategoryTypeEnum, Product product);



    Company getCompanyForProduct(Integer productId);


    List<PriceCategory> getPriceCategory(Product product);





    PriceCategory getPriceCategoryById(Integer productId);


    List<Product> queryProductsByCompany(Company company, CoalSupplyStatusEnum released);

    Page<Product> queryProductsByCompany(Company company, CoalSupplyStatusEnum released, Pageable pageRequest);


    List<PriceCategory> getPriceCategory(Product product, PriceCategoryStatusEnum open);

    List<Map<String,Object>> getPriceCategoryMap(Product product);

    List<Product> getProductByCompanyId(Integer id);

    List<Product> getAllForInprocessCompany(List<Company> companies, CoalSupplyStatusEnum released);


    List<Product> getProductByCompanyId(Integer companyId, CoalSupplyStatusEnum released);

    List<PriceCategory> getPriceCategoryByProductId(Integer productId, PriceCategoryStatusEnum open);


    OperationResult changeQualityReport(Product product, QualityInspectionReport qualityInspectionReport, User user);


    List<Product> getProductByCompanyId(Integer id, List<CoalSupplyStatusEnum> supplyStatusEnums);

    PriceCategory getPriceCategory(Product product, PriceCategoryTypeEnum exMinePrice);




    void updatePriceCategory(PriceCategory priceCategory);



}
