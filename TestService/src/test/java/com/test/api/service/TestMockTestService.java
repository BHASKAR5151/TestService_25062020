package com.test.api.service;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.test.api.entity.MockTestEntity;
import com.test.api.exception.MockTestObjectNotFoundException;
import com.test.api.model.MockTestModel;
import com.test.api.repository.MockTestRepository;

@ExtendWith(MockitoExtension.class)
public class TestMockTestService {
	@Mock
	MockTestRepository repository;

	@Mock
	ModelMapper mapper;

	@InjectMocks
	MockTestService service;

	MockTestModel model;
	MockTestEntity entity;

	@BeforeEach
	public void setUp() {
		model = new MockTestModel();
		model.setId("5eeddc8af48f0e32e969ccda");
		model.setMockName("DBR");
		model.setMockAddress("ANdhra");
		model.setMockPhone("123456");
		model.setMockTestId("DBR1234");

		entity = new MockTestEntity();
		model.setId("5eeddc8af48f0e32e969ccda");
		entity.setMockName("DBR");
		entity.setMockAddress("ANdhra");
		entity.setMockPhone("123456");
		entity.setMockTestId("DBR1234");
	}

	@Test
	public void test_updateMock() throws MockTestObjectNotFoundException {

		Optional<MockTestEntity> response = Optional.of(entity);
		when(repository.findById(model.getId())).thenReturn(response);
		when(mapper.map(model, MockTestEntity.class)).thenReturn(entity);
		when(mapper.map(repository.save(entity), MockTestModel.class)).thenReturn(model);
		MockTestModel actualResponse = service._updateMock(model);
		Assertions.assertNotNull(actualResponse);
		Assertions.assertEquals("ANdhra", actualResponse.getMockAddress());
		Assertions.assertEquals("5eeddc8af48f0e32e969ccda", actualResponse.getId());
	}

	@Test
	public void test_updateMockWhenException() throws MockTestObjectNotFoundException {
		when(mapper.map(model, MockTestEntity.class)).thenReturn(entity);
		 Assertions.assertThrows(MockTestObjectNotFoundException.class, () -> {
			 service._updateMock(model);
		    });
		
		 
		 
		
	}

}
