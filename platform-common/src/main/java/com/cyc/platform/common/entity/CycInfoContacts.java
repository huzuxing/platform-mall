package com.cyc.platform.common.entity;


/**
 * Auto Created through python on 2018-09-13, author:111
 **/

public class CycInfoContacts{

	private Integer id;

	/**	姓名**/
	private String name;

	/**	排序**/
	private Integer sort;

	/**	联系方式**/
	private String contact;

	/**	省份**/
	private String province;

	/**	城市**/
	private String city;

	/**	区**/
	private String district;

	/**	详细地址**/
	private String address;

	private Integer timeCreate;

	private Integer timeUpdate;

	public CycInfoContacts() {}

	public CycInfoContacts(Integer id,String name,Integer sort,String contact,String province,String city,String district,String address,Integer timeCreate,Integer timeUpdate) {
		this.id = id;
		this.name = name;
		this.sort = sort;
		this.contact = contact;
		this.province = province;
		this.city = city;
		this.district = district;
		this.address = address;
		this.timeCreate = timeCreate;
		this.timeUpdate = timeUpdate;
	}
	public void setId(Integer id) {
		 this.id = id;
	}
	public Integer getId() {
		 return this.id;
	}
	public void setName(String name) {
		 this.name = name;
	}
	public String getName() {
		 return this.name;
	}
	public void setSort(Integer sort) {
		 this.sort = sort;
	}
	public Integer getSort() {
		 return this.sort;
	}
	public void setContact(String contact) {
		 this.contact = contact;
	}
	public String getContact() {
		 return this.contact;
	}
	public void setProvince(String province) {
		 this.province = province;
	}
	public String getProvince() {
		 return this.province;
	}
	public void setCity(String city) {
		 this.city = city;
	}
	public String getCity() {
		 return this.city;
	}
	public void setDistrict(String district) {
		 this.district = district;
	}
	public String getDistrict() {
		 return this.district;
	}
	public void setAddress(String address) {
		 this.address = address;
	}
	public String getAddress() {
		 return this.address;
	}
	public void setTimeCreate(Integer timeCreate) {
		 this.timeCreate = timeCreate;
	}
	public Integer getTimeCreate() {
		 return this.timeCreate;
	}
	public void setTimeUpdate(Integer timeUpdate) {
		 this.timeUpdate = timeUpdate;
	}
	public Integer getTimeUpdate() {
		 return this.timeUpdate;
	}
}