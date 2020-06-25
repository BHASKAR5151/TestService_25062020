package com.test.api.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;


@Validated
public class MockTestModel {

	String id;
	@NotBlank(message ="Mock test id should not be null or empty")
	String mockTestId;
	@Size(min = 5, max = 20)
	String mockName;
	String mockAddress;
	String mockPhone;
	
	public String getMockTestId() {
		return mockTestId;
	}
	public void setMockTestId(String mockTestId) {
		this.mockTestId = mockTestId;
	}
	public String getMockName() {
		return mockName;
	}
	public void setMockName(String mockName) {
		this.mockName = mockName;
	}
	public String getMockAddress() {
		return mockAddress;
	}
	public void setMockAddress(String mockAddress) {
		this.mockAddress = mockAddress;
	}
	public String getMockPhone() {
		return mockPhone;
	}
	public void setMockPhone(String mockPhone) {
		this.mockPhone = mockPhone;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
