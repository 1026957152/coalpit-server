package com.coalvalue.service;

import com.coalvalue.configuration.CommonConstant;
import com.coalvalue.domain.entity.Company;
import com.coalvalue.repository.CompanyRepository;
import com.service.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.query.QueryUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.springframework.security.core.Authentication;

/**
 * Created by silence yuan on 2015/6/28.
 */
@Service("companyService")
//@Transactional(readOnly = true)
public class CompanyServiceImpl extends BaseServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private QualityInspectionService qualityInspectionService;


    @Autowired
    private InventoryService inventoryService;


    @Autowired
    private ProductService productService;

    @Autowired
    private DeliveryAddressService deliveryAddressService;


    private static final Logger logger = LoggerFactory.getLogger(CompanyServiceImpl.class);





    @Override
    public Page<com.coalvalue.domain.entity.Company> queryPrivateCompanies(Integer userId, Pageable pageable) {
        return null;
    }

    @Override
    public Page<com.coalvalue.domain.entity.Company> queryAllCompanies(Integer userId, Pageable pageable) {
        return null;
    }







    @Override
    public Map verifyCompanyIsPublic(Integer companyId) {
        Map ret = new HashMap<String, String>();

        ret.put("STATUS", true);
        try {
            com.coalvalue.domain.entity.Company company = companyRepository.findOne(companyId);

        } catch (Exception e) {
            ret.put("STATUS", false);
            ret.put("MESSAGE", e.getMessage());
        }
        return ret;

    }

    @Override
    public Map changeCompanyIsPublic(Integer companyId) {

        Map ret = new HashMap<String, String>();

        ret.put("STATUS", true);
        try {
            com.coalvalue.domain.entity.Company company = companyRepository.findOne(companyId);
            if(company.isOpen())
                company.setOpen(false);
            else
                company.setOpen(true);

            companyRepository.save(company);
        } catch (Exception e) {
            ret.put("STATUS", false);
            ret.put("MESSAGE", e.getMessage());
        }
        return ret;


    }



    @Override
    public Map approveCompany(Integer companyId) {
        Map data = new HashMap();
        data.put("status", true);
        try {

            com.coalvalue.domain.entity.Company company = companyRepository.findOne(companyId);
            if(company.getStatus() != CommonConstant.COMPANY_PENDINGAPPROVAL)
            {
                company.setStatus( CommonConstant.COMPANY_APPROVED);

                companyRepository.save(company);
            }
        } catch (Exception e) {
            data.put("status", false);
            data.put("message", "系统异常！");
        }
        return data;
    }



    @Override
    public Map submitForApproval(Integer companyId) {
        Map data = new HashMap();
        data.put("status", true);
        try {

            com.coalvalue.domain.entity.Company company = companyRepository.findOne(companyId);
            if(company.getStatus() != CommonConstant.COMPANY_APPROVED)
            {
                company.setStatus( CommonConstant.COMPANY_PENDINGAPPROVAL);

                companyRepository.save(company);
            }
        } catch (Exception e) {
            data.put("status", false);
            data.put("message", "系统异常！");
        }
        return data;
    }


    @Override
    public Page<com.coalvalue.domain.entity.Company> queryAprovedCompanies(Pageable pageable) {
        return null;
    }

    @Override
    public Page<Company> queryCompaniesInPending(Pageable pageable) {
        return null;
    }

    @Override
    public Page<com.coalvalue.domain.entity.Company> queryCompaniesByCompanyAddress(Pageable pageable) {
        return null;
    }

    @Override
    @Transactional
    public com.coalvalue.domain.entity.Company createCompany(com.coalvalue.domain.entity.Company company) {
        return companyRepository.save(company);
    }

    @Override
    public List<Company> quereyBrandCompanies() {
        return null;
    }

    @Override
    public Map licenceBrand(Integer companyId) {

        Map data = new HashMap();
        data.put("status", true);

        com.coalvalue.domain.entity.Company company = companyRepository.findOne(companyId);

        data.put("status", true);
        try {

            if(company.getStatus().equals(CommonConstant.COMPANY_APPROVED) ) {
                company.setStatus(CommonConstant.COMPANY_VERIFICATION_BRAND);
                companyRepository.save(company)   ;

            }
        } catch (Exception e) {
            data.put("status", false);
            data.put("message", "系统异常！");
        }
        return data;

    }




    @Override
    public List<Company> queryLogisticCompanForSearchCondition() {
        List<Company> logisticsCompanies = new ArrayList<Company>();

        Company c1 = new Company();
        c1.setCompanyName("search大安物流公司");
        Company c2 =  new Company();
        c2.setCompanyName("search财源物流公司");
        logisticsCompanies.add(c1);
        logisticsCompanies.add(c2);

        return logisticsCompanies;
    }

    @Override
    public Company findCustomerBySystemId(Integer companyId) {
        return companyRepository.findOne(companyId);
    }





    @Override
    @Transactional
    public Company changeCompanyName(Company company, String companyName) {

        company.setCompanyName(companyName);
        return companyRepository.save(company);

    }

    @Override
    public Company getById(Integer warehouseId) {
        return companyRepository.findOne(warehouseId);
    }




    @Override
    public boolean validateCooperationRelationShip(Integer currentCompanyId, Integer logisticsCompanyId) {
        return true;
        //TODO 没有实现，需要实现
    }

    @Override
    public Company sellerCompanyExist(Integer id) {
        return  companyRepository.getSellerCompanyById(id);
    }



    @Override
    public Page<Company> querySellerCompanies(Pageable pageable) {
        return companyRepository.findByCompanyType("seller", pageable);
    }


    @Override
    public List<Company> searchCompanyByCompanyName(String companyName) {


          //      Long total = QueryUtils.executeCountQuery(getCountQuery(Company, spec));

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Company.class);
        Root root = query.from(Company.class);
        Predicate  predicate = builder.like(root.<Integer>get("companyName"), "%" + companyName + "%");
     //   query.orderBy(QueryUtils.toOrders(pageable.getSort(), root, builder));
        query.where(predicate);

        TypedQuery tq = em.createQuery(query);

        //tq.setFirstResult(0);
      //  tq.setMaxResults(2);


        return  tq.getResultList();
    }

    @Override
    public List<Company> queryByCompanyName(String companyName) {
        Specification<Company> specification = (root, query, cb) -> {
            List<Predicate> predicateList = new ArrayList<Predicate>();
            if (companyName != null) {
                Predicate predicate =
                        cb.like(root.<String>get("companyName"), "%"+companyName+"%");
                predicateList.add(predicate);
            }

            return cb.and(predicateList.toArray(new Predicate[0]));
        };
        return  companyRepository.findByCompanyNameLike("%"+companyName+"%");


    }

    @Override
    public List<Company> queryCompanies() {


        return companyRepository.findAll();
    }


    private TypedQuery createTypedQuery(Class domainClass, Specification spec, Pageable pageable) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(domainClass);

        Root root = query.from(domainClass);
        if (spec != null){
            Predicate predicate = spec.toPredicate(root, query, builder);
            if (predicate != null) {
                query.where(predicate);
            }
        }
        query.select(root);
        if (pageable!= null && pageable.getSort() != null) {
            query.orderBy(QueryUtils.toOrders(pageable.getSort(), root, builder));
        }
        return em.createQuery(query);
    }
    private TypedQuery<Long> getCountQuery(Class domainClass, Specification spec) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Long> query = builder.createQuery(Long.class);

        Root root = query.from(domainClass);
        if (spec != null){
            Predicate predicate = spec.toPredicate(root, query, builder);
            if (predicate != null) {
                query.where(predicate);
            }
        }
        if (query.isDistinct()) {
            query.select(builder.countDistinct(root));
        } else {
            query.select(builder.count(root));
        }

        return em.createQuery(query);
    }




    @Override
    public Company getCompanyById(Integer companyId) {

        return companyRepository.findById(companyId);
    }


    @Override
    public Company queryCompanyByName(String qrscene_) {

return null;
    }





    @Override
    public Page<Company> getInspectionOrganizations(Pageable pageable) {
        return  companyRepository.findByCompanyType(CommonConstant.COMPANY_TYPE_INSPECTION,pageable);

    }












}
