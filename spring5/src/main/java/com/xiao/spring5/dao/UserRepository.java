package com.xiao.spring5.dao;

import com.xiao.spring5.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.concurrent.Future;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    /**
     * 根据方法名解析sql不一定需要@QUERY
     * @param name
     * @return
     */
    @Async
    Future<UserEntity> findAllByName(String name);
}
