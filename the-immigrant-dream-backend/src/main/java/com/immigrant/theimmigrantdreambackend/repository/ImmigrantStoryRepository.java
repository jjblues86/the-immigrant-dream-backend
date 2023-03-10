package com.immigrant.theimmigrantdreambackend.repository;

import com.immigrant.theimmigrantdreambackend.entity.ImmigrantStory;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableScan
public interface ImmigrantStoryRepository extends CrudRepository<ImmigrantStory, String> {
}
