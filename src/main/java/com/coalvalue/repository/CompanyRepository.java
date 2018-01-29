package com.coalvalue.repository;


import com.coalvalue.domain.entity.Company;
import com.coalvalue.repository.base.BaseJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Peter Xu on 01/10/2015.
 */
public interface CompanyRepository extends BaseJpaRepository<Company, Integer> {

    public Company findByCompanyName(String companyName);

    @Query("select c from Company c where c.id = :companyId")
    public Company queryCompanyByCompanyId(@Param("companyId") Integer companyId);





    @Query("select count(*) from Company c")
    public int countOfCompanies();


    @Query("select count(*) from Company c where c.status = 'Pending'")
    public int countOfCompaniesPending();

    @Query("select count(*) from Company c where c.companyType='seller'")
    public int countOfSupplyCompanies();

    @Query("select count(*) from Company c where  c.companyType='buyer'")
    public int countOfDemanderCompanies();

    @Query("select count(*) from Company c where  c.companyType='logistics'")
    public int countOfLogisticsCompanies();


    @Query("select count(*) from Company c where  c.companyType='warehouse'")
    public int countOfWarehouseCompanies();

    @Query("select count(*) from Company c where  c.companyType='inspection'")
    public int countOfInspectionCompanies();






    @Query("select c from Company c where c.id = :companyId and c.companyType = 'seller'")
    Company getSellerCompanyById(@Param("companyId") Integer companyId);


    Page<Company> findByCompanyType(String seller, Pageable pageable);


    @Query("select c.companyNo from Company c where c.id = :companyId")
    String getNoById(@Param("companyId") Integer companyId);

    List<Company> findByCompanyNameLike(String companyName);

    @Query("select c.companyName from Company c where c.id = :companyId")
    String findCompanyNameById(@Param("companyId") Integer companyId);



    String findCompanyNoByCompanyNo(String s);


    Page<Company> findAllByIdNotIn(Integer companyId, Pageable pageable);

    Company findById(Integer companyId);




    Long countByCompanyType(String text);


    List<Company> findByCompanyType(String text);


    Long countByCompanyTypeAndDistrictIdIn(String text, List<Integer> oreIds);





    List<Company> findByCompanyTypeAndBusinessStatus(String text, String text1);

    Page<Company> findByDistrictId(Integer id, Pageable pageRequest);

    Page<Company> findByDistrictIdIn(List<Integer> ids, Pageable pageRequest);


    List<Company> findByCompanyTypeIn(List<String> distinct);


    //List<Company> findByCompanyTypeInAndBeAllowed(List<String> distinct, String text);

    List<Company> findByCompanyTypeInAndAllowedThing(List<String> distinct, String text);

    List<Company> findByCompanyTypeAndBusinessStatusAndDistrictIdIn(String text, String text1, List<Integer> districts);

    List<Company> findByCompanyTypeAndBusinessStatusAndDistrictId(String text, String text1, Integer id);



}
