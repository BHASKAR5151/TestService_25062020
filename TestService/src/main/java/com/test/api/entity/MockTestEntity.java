package com.test.api.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "MOCK-TEST")
public class MockTestEntity {

	@Id
	String id;
	@Field
	String mockTestId;
	@Field
	String mockName;
	@Field
	String mockAddress;
	@Field
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
