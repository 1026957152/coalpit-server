package com.coalvalue.repository;

import com.coalvalue.domain.entity.StorageSpace;
import com.coalvalue.repository.base.BaseJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface StorageSpaceRepository extends BaseJpaRepository<StorageSpace, Integer> {


    Page<StorageSpace> findByCompanyId(Integer companyId, Pageable pageable);

    List<StorageSpace> findByCompanyId(Integer id);

    Page<StorageSpace> findById(Integer associatedStorageId, Pageable pageable);

    Page<StorageSpace> findByCompanyIdIn(List<Integer> collaboratorIds, Pageable pageable);

    List<StorageSpace> findByCompanyIdIn(List<Integer> collaboratorIds);


    Page<StorageSpace> findByAssociatedStorageId(Integer id, Pageable pageable);

    List<StorageSpace> findByStatus(String text);

    StorageSpace findTop1ByOrderByPendingCountDesc();

    List<StorageSpace> findByAssociatedStorageId(Integer id);

    StorageSpace findById(Integer storageId);


    StorageSpace findByCompanyIdAndMajor(Integer company, boolean b);

    StorageSpace findByCompanyIdAndAssociatedStorageId(Integer companyId, Integer id);

    Page<StorageSpace> findByCompanyIdAndType(Integer companyId, String text, Pageable pageable);

    Page<StorageSpace> findByCompanyIdAndTypeNot(Integer companyId, String text, Pageable pageable);

    List<StorageSpace> findByCompanyIdAndTypeNot(Integer id, String text);
}
