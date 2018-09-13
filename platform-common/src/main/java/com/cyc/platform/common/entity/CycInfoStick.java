package com.cyc.platform.common.entity;


/**
 * Auto Created through python on 2018-09-13, author:111
 **/

public class CycInfoStick{

	private Integer id;

	/**	名称**/
	private String name;

	/**	排序**/
	private Integer sort;

	/**	区域发布费用**/
	private Double fee;

	/**	置顶天数**/
	private Integer days;

	private Integer timeCreate;

	private Integer timeUpdate;

	public CycInfoStick() {}

	public CycInfoStick(Integer id,String name,Integer sort,Double fee,Integer days,Integer timeCreate,Integer timeUpdate) {
		this.id = id;
		this.name = name;
		this.sort = sort;
		this.fee = fee;
		this.days = days;
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
	public void setFee(Double fee) {
		 this.fee = fee;
	}
	public Double getFee() {
		 return this.fee;
	}
	public void setDays(Integer days) {
		 this.days = days;
	}
	public Integer getDays() {
		 return this.days;
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