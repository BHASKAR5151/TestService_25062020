package com.test.api.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

@Validated
public class MockTestModel {

	String id;
	@NotBlank(message = "Mock test id should not be null or empty")
	String mockTestId;
	@NotNull
	@Size(min = 5, message = "It should not be more then 5 charactor")
	String mockName;
	@Size(min = 20, message = "It should be minimum length 20")
	String mockAddress;
	@Size(max = 10)
	String mockPhone;
	@Email
	String mockEmail;

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

	public String getMockEmail() {
		return mockEmail;
	}

	public void setMockEmail(String mockEmail) {
		this.mockEmail = mockEmail;
	}
}
