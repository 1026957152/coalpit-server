package com.coalvalue.repository;

import com.coalvalue.domain.entity.PriceCategory;
import com.coalvalue.repository.base.BaseJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface PriceCategoryRepository extends BaseJpaRepository<PriceCategory, Integer> {


    PriceCategory findById(Integer priceId);

    Page<PriceCategory> findByItemIdAndItemType(Integer id, String text, Pageable pageable);


    List<PriceCategory> findByItemIdAndItemType(Integer id, String text);

    PriceCategory findByItemIdAndItemTypeAndMajor(Integer itemId, String text, boolean b);


    PriceCategory findByNameAndItemIdAndItemTypeAndMajor(String text, Integer id, String text1, boolean b);

    PriceCategory findTop1ByItemIdAndItemTypeAndMajor(Integer id, String text, boolean b);

    List<PriceCategory> findByItemIdAndItemTypeAndStatus(Integer id, String text, String text1);


    List<PriceCategory> findByItemIdAndItemTypeAndStatusOrderByIdAsc(Integer id, String text, String text1);

    List<PriceCategory> findByItemIdAndItemTypeAndStatusOrderBySeqAsc(Integer id, String text, String text1);

    PriceCategory findByItemIdAndItemTypeAndName(Integer id, String text, String text1);
}
