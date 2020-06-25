package com.test.api.repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import com.test.api.entity.MockTestEntity;
import com.test.api.query_builder.MockTestQueryBuilder;

public class MockTestCustomRepositoryImpl implements MockTestCustomRepository {

	private static final Logger LOG = LoggerFactory.getLogger(MockTestCustomRepositoryImpl.class);

	@Autowired
	MongoTemplate template;

	@Override
	public List<MockTestEntity> searchMock(String mockTestId, String mockName) {
		List<MockTestEntity> list = Collections.emptyList();
		LOG.info("Custom Repository");
		Optional<Query> query=buildPersonSearchQuery(mockTestId,mockName);
		list = template.find(query.get().limit(200), MockTestEntity.class);
		return list;
	}
	
	private Optional<Query> buildPersonSearchQuery(String mockTestId, String mockName) {
        return new MockTestQueryBuilder()
                .withMockTestId(mockTestId)
                .withMockName(mockName)
                .build();
    }

}
