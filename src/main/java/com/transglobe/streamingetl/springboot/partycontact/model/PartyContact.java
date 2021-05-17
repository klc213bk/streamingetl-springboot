package com.transglobe.streamingetl.springboot.partycontact.model;

public class PartyContact {
	
	private Integer roleType;
	
	private Long listId;
	
	private Long policyId;
	
	private String name;
	
	private String certiCode;
	
	private String mobileTel;
	
	private String email;
	
	private Long addressId;
	
	private String address1;

	public PartyContact(Integer roleType, Long listId, Long policyId, String name, String certiCode, String mobileTel
			, String email, Long addressId, String address1) {
		this.roleType = roleType;
		this.listId = listId;
		this.policyId = policyId;
		this.name = name;
		this.certiCode = certiCode;
		this.mobileTel = mobileTel;
		this.email = email;
		this.addressId = addressId;
		this.address1 = address1;
	}
	public Integer getRoleType() {
		return roleType;
	}

	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}

	public Long getListId() {
		return listId;
	}

	public void setListId(Long listId) {
		this.listId = listId;
	}

	public Long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCertiCode() {
		return certiCode;
	}

	public void setCertiCode(String certiCode) {
		this.certiCode = certiCode;
	}

	public String getMobileTel() {
		return mobileTel;
	}

	public void setMobileTel(String mobileTel) {
		this.mobileTel = mobileTel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	
	
}
