package com.cyc.platform.common.entity;


/**
 * Auto Created through python on 2018-09-13, author:111
 **/

public class CycAnnouncementPosition {

	private Integer id;

	/**	公告位置名称**/
	private String name;

	/**	排序**/
	private Integer sort;

	/**	状态**/
	private Integer status;

	/**	创建时间**/
	private Integer timeCreate;

	private Integer timeUpdate;

	public CycAnnouncementPosition() {}

	public CycAnnouncementPosition(Integer id, String name, Integer sort, Integer status, Integer timeCreate, Integer timeUpdate) {
		this.id = id;
		this.name = name;
		this.sort = sort;
		this.status = status;
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
	public void setStatus(Integer status) {
		 this.status = status;
	}
	public Integer getStatus() {
		 return this.status;
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