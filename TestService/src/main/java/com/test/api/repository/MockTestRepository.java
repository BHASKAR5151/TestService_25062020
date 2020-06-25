package com.test.api.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.api.entity.MockTestEntity;

public interface MockTestRepository extends MongoRepository<MockTestEntity, Integer>,MockTestCustomRepository {

	public Optional<MockTestEntity> findById(String mockTestId);

	public MockTestEntity save(MockTestEntity entity);
	

}
