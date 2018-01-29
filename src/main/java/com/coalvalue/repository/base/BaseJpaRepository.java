package com.coalvalue.repository.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Peter Xu on 1/9/2015.
 */
@NoRepositoryBean
public interface BaseJpaRepository<T, ID extends Serializable>
        extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

    Object findOne(String namedNativeQuery, Map bindings);

    List findAll(String namedNativeQuery, Map bindings, Integer count);

    List findTop(String namedNativeQuery, Map bindings, Integer count);

    List findAll(String namedNativeQuery, Map bindings);

    Page findAll(String namedNativeQuery, Map bindings, Pageable pageable);

    long count(String namedNativeQuery, Map bindings);

    public Object findView(Specification spec, Class domainClass);

    public Page findView(Specification spec, Pageable pageable, Class domainClass);


    List findViewList(Specification spec, Sort sort, Class domainClass);



}
