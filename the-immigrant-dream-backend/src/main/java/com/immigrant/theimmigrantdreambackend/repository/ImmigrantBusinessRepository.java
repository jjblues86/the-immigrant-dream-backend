package com.immigrant.theimmigrantdreambackend.repository;

import com.immigrant.theimmigrantdreambackend.entity.ImmigrantBusiness;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableScan
public interface ImmigrantBusinessRepository extends CrudRepository<ImmigrantBusiness, String> {
}
