package com.cyc.platform.common.entity;


import com.google.gson.annotations.Expose;

/**
 * Auto Created through python on 2018-09-13, author:111
 **/

public class CycInfoChannel {

	@Expose()
	private Integer id;

	/**	父级ID**/
	@Expose()
	private Integer parentId;

	/**	分类名称**/
	@Expose()
	private String name;

	/**	排序**/
	private Integer sort;

	private Integer timeCreate;

	private Integer timeUpdate;

	public CycInfoChannel() {}

	public CycInfoChannel(Integer id, Integer parentId, String name, Integer sort, Integer timeCreate, Integer timeUpdate) {
		this.id = id;
		this.parentId = parentId;
		this.name = name;
		this.sort = sort;
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

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
}