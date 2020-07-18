package com.test.api.query_builder;


import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.StringUtils;

public class MockTestQueryBuilder {
	private static final Logger LOG = LoggerFactory.getLogger(MockTestQueryBuilder.class);

	private Query query;
	private boolean validQuery;

	public MockTestQueryBuilder() {
		this.query = new Query();
	}

	public Optional<Query> build() {
		if (validQuery) {
			return Optional.ofNullable(query);
		}
		return Optional.empty();
	}

	public MockTestQueryBuilder withMockTestId(String mockTestId) {
		validQuery=true;
		 if(!StringUtils.isEmpty(mockTestId)){
	            validQuery = true;
	            LOG.info("Mock test id search request.So adding it to mongo query");
	            query.addCriteria(Criteria.where("mockTestId").is(mockTestId));
	        }
	        return this;
	}

	public MockTestQueryBuilder withMockName(String mockName) {
		validQuery=true;
		 if(!StringUtils.isEmpty(mockName)){
	            validQuery = true;
	            LOG.info("Mock  Name is  search request.So adding it to mongo query");
	            query.addCriteria(Criteria.where("mockName").is(mockName));
	        }
	        return this;
	}

}
