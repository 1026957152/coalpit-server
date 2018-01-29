package com.coalvalue.repository;

import com.coalvalue.domain.entity.Inventory;
import com.coalvalue.repository.base.BaseJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface InventoryRepository extends BaseJpaRepository<Inventory, Integer> {


    Page<Inventory> findByCompanyId(Integer id, Pageable pageable);

    Inventory findByStorageIdAndItemIdAndItemType(Integer id, Integer productId, String text);

    List<Inventory> findByItemIdAndItemType(Integer id, String text);

    Inventory findById(Integer inventoryId);

    List<Inventory> findByStorageIdAndItemType(Integer id, String text);

    List<Inventory> findByItemIdAndItemTypeAndStatus(Integer id, String text, String text1);

    Page<Inventory> findByItemIdAndItemType(Integer id, String text, Pageable pageable);

}
