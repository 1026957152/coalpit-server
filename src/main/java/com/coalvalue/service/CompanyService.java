package com.coalvalue.service;

import com.coalvalue.domain.entity.Company;
import com.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

//import org.springframework.security.core.Authentication;

/**
 * Created by silence yuan on 2015/6/28.
 */
public interface CompanyService extends BaseService {





    public Page<Company> queryPrivateCompanies(Integer userId, Pageable pageable);

    public Page<Company> queryAllCompanies(Integer userId, Pageable pageable);






    public Map verifyCompanyIsPublic(Integer companyId);




    public Map changeCompanyIsPublic(Integer companyId);


    Map approveCompany(Integer companyId);

    public Map submitForApproval(Integer companyId);



    public Page<com.coalvalue.domain.entity.Company> queryAprovedCompanies(Pageable pageable);


    public Page<com.coalvalue.domain.entity.Company> queryCompaniesInPending(Pageable pageable);



    public Page<com.coalvalue.domain.entity.Company> queryCompaniesByCompanyAddress(Pageable pageable);


    com.coalvalue.domain.entity.Company createCompany(com.coalvalue.domain.entity.Company company);


    public List<com.coalvalue.domain.entity.Company> quereyBrandCompanies();

    public Map licenceBrand(Integer companyId);



    public List<Company> queryLogisticCompanForSearchCondition();


    Company findCustomerBySystemId(Integer companyId);




    boolean validateCooperationRelationShip(Integer currentCompanyId, Integer logisticsCompanyId);

    Company sellerCompanyExist(Integer id);


    Page<Company> querySellerCompanies(Pageable pageable);



    List<Company> searchCompanyByCompanyName(String companyName);

    List<Company> queryByCompanyName(String companyName);

    Object queryCompanies();


    Company changeCompanyName(Company company, String companyName);

    Company getById(Integer warehouseId);



    Company getCompanyById(Integer companyId);

    //FavoriteItem followCompany(Company company, User user, String favoriteLevelOne);

    Company queryCompanyByName(String qrscene_);




    Page<Company> getInspectionOrganizations(Pageable pageable);







}
