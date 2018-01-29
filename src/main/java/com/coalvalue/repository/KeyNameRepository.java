package com.coalvalue.repository;


import com.coalvalue.domain.entity.KeyName;
import com.coalvalue.repository.base.BaseJpaRepository;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface KeyNameRepository extends BaseJpaRepository<KeyName, Integer> {


    KeyName findByDigest(String md5);

    //String findNameByDigest(String digest);

}
