package com.test.api.repository;

import java.util.List;

import com.test.api.entity.MockTestEntity;

public interface MockTestCustomRepository {

	public List<MockTestEntity> searchMock(String mockTestId, String mockName);
}
