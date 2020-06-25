package com.test.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.api.exception.MockTestObjectNotFoundException;
import com.test.api.model.MockTestModel;
import com.test.api.service.MockTestService;

import io.swagger.annotations.ApiOperation;

@RestController
@Validated
@RequestMapping("/mockController")
public class MockTestController {

	@Autowired(required = true)
	MockTestService testService;

	@ApiOperation("Update the MockTest object")
	@PostMapping("/mockTest")
	ResponseEntity<MockTestModel> _UpdateMockTest(@RequestBody MockTestModel model)
			throws MockTestObjectNotFoundException {
		MockTestModel model1 = testService._updateMock(model);
		System.out.println("product Details" + model1);
		return new ResponseEntity<MockTestModel>(model1, HttpStatus.OK);
	}

	@ApiOperation("Save the MockTest object")
	@PostMapping("/mockSave")
	ResponseEntity<MockTestModel> _SaveMockTest(@Valid @RequestBody MockTestModel model)
			throws MockTestObjectNotFoundException {
		testService._persistMock(model);
		return new ResponseEntity<MockTestModel>(HttpStatus.CREATED);
	}
	
	@ApiOperation("Search the MockTest object")
	@GetMapping("/mockSearch/{mockName}/mock/{mockTestId}")
	ResponseEntity<List<MockTestModel>> _SearchMockTest(@PathVariable String mockName,@PathVariable String mockTestId)
			throws MockTestObjectNotFoundException {
		List<MockTestModel> mockList=testService._searchMock(mockTestId,mockName);
		return new ResponseEntity<List<MockTestModel>>(mockList,HttpStatus.OK);
	}

}