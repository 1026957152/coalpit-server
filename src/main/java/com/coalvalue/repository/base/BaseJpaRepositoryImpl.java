package com.coalvalue.repository.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.query.QueryUtils;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by Peter Xu on 1/9/2015.
 */
public class BaseJpaRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
        implements BaseJpaRepository<T, ID> {

    private EntityManager em;
    public BaseJpaRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }
    public BaseJpaRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.em = em;
    }

    @Override
    public Object findOne(String namedNativeQuery, Map bindings) {
        Query query = em.createNamedQuery(namedNativeQuery);
        bindings.forEach((x,y) -> query.setParameter((String)x, y));
        query.setMaxResults(1);
        return query.getSingleResult();
    }

    @Override
    public List findAll(String namedNativeQuery, Map bindings,Integer count) {
        Query query = em.createNamedQuery(namedNativeQuery);
        if(bindings != null) {
            bindings.forEach((x,y) -> query.setParameter((String)x, y));
        }
        query.setMaxResults(count);
        return query.getResultList();
    }

    @Override
    public List findTop(String namedNativeQuery, Map bindings,Integer count) {
        Query query = em.createNamedQuery(namedNativeQuery);
        if(bindings != null) {
            bindings.forEach((x,y) -> query.setParameter((String)x, y));
        }
        query.setMaxResults(count);
        return query.getResultList();
    }


    @Override
    public List findAll(String namedNativeQuery, Map bindings) {
        Query query = em.createNamedQuery(namedNativeQuery);
        bindings.forEach((x,y) -> query.setParameter((String)x, y));
        return query.getResultList();
    }

    @Override
    public Page findAll(String namedNativeQuery, Map bindings, Pageable pageable) {
        Query query = em.createNamedQuery(namedNativeQuery);
        bindings.forEach((x,y) -> query.setParameter((String)x, y));

        query.setFirstResult(pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());

        long total = count(namedNativeQuery + "Count", bindings);

        List content = total > pageable.getOffset() ? query.getResultList() : Collections.emptyList();

        return new PageImpl(content, pageable, total);
    }

    @Override
    public long count(String namedNativeQuery, Map bindings) {
        return (long) findOne(namedNativeQuery, bindings);
    }

    @Override
    public Page findView(Specification spec, Pageable pageable, Class domainClass) {
        TypedQuery tq = createTypedQuery(domainClass, spec, pageable);

        Page page = null;
        if (pageable == null){
            page = new PageImpl(tq.getResultList());
        } else {
            tq.setFirstResult(pageable.getOffset());
            tq.setMaxResults(pageable.getPageSize());



            Long total = getCountQuery(domainClass, spec).getSingleResult();
           //         em.createQuery(getCountQuery(domainClass, spec), Long.class)
             //       .getSingleResult();

                    //QueryUtils.executeCountQuery(getCountQuery(domainClass, spec));
            List content = total > pageable.getOffset() ? tq.getResultList() : Collections.emptyList();

            page = new PageImpl(content, pageable, total);
        }
        return page;
    }

    @Override
    public Object findView(Specification spec, Class domainClass){
        TypedQuery tq = createTypedQuery(domainClass, spec);
        return tq.getSingleResult();
    }

    @Override
    public List findViewList(Specification spec,Sort sort, Class domainClass){
        TypedQuery tq = createTypedQuery(domainClass, spec,sort);

        return tq.getResultList();
    }

    private TypedQuery createTypedQuery(Class domainClass, Specification spec) {
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
        return em.createQuery(query);
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

    private TypedQuery createTypedQuery(Class domainClass, Specification spec, Sort sort) {
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
        if (sort != null) {
            query.orderBy(QueryUtils.toOrders(sort, root, builder));
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
}
