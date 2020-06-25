package com.test.api.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.api.entity.MockTestEntity;
import com.test.api.exception.MockTestObjectNotFoundException;
import com.test.api.model.MockTestModel;
import com.test.api.repository.MockTestRepository;

@Service
public class MockTestService {

	@Autowired
	MockTestRepository repository;

	@Autowired
	ModelMapper mapper;

	public void _persistMock(MockTestModel model) throws MockTestObjectNotFoundException {
		MockTestEntity ent = mapper.map(model, MockTestEntity.class);
		Optional<MockTestEntity> mockEntity = Optional.of(ent);
		repository.save(mockEntity.get());
	}

	public MockTestModel _updateMock(MockTestModel model) throws MockTestObjectNotFoundException {
		Optional<MockTestEntity> entity = repository.findById(model.getId());
		MockTestEntity ent = mapper.map(model, MockTestEntity.class);
		Optional<MockTestEntity> mockEntity = Optional.of(ent);
		entity.orElseThrow(() -> new MockTestObjectNotFoundException("Object does not find for your given ID"));
		if (entity.isPresent()) {
			mockEntity.get().setId(entity.get().getId());
		}
		return mapper.map(repository.save(mockEntity.get()), MockTestModel.class);

	}

	public List<MockTestModel> _searchMock(String mockTestId, String mockName) throws MockTestObjectNotFoundException {
		List<MockTestEntity> ls = Collections.emptyList();
		ls = repository.searchMock(mockTestId, mockName);
		return ls.stream().map((MockTestEntity m1)->mapper.map(m1, MockTestModel.class)).collect(Collectors.toList());
	}
}
