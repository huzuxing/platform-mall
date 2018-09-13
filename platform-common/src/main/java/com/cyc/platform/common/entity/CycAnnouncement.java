package com.cyc.platform.common.entity;


/**
 * Auto Created through python on 2018-09-13, author:111
 **/

public class CycAnnouncement {

	private Integer id;


	/**	公告位置ID**/
	private Integer positionId;

	/**	公告标题**/
	private String title;

	/**	内容**/
	private String content;

	/**	排序**/
	private Integer sort;

	/**	状态**/
	private Integer status;

	/**	创建时间**/
	private Integer timeCreate;

	private Integer timeUpdate;

	public CycAnnouncement() {}

	public CycAnnouncement(Integer id,Integer positionId, String title, String content, Integer sort, Integer status, Integer timeCreate, Integer timeUpdate) {
		this.id = id;
		this.positionId = positionId;
		this.title = title;
		this.content = content;
		this.sort = sort;
		this.status = status;
		this.timeCreate = timeCreate;
		this.timeUpdate = timeUpdate;
	}
	public void setId(Integer id) {
		 this.id = id;
	}

	public Integer getPositionId() {
		return positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	public Integer getId() {
		 return this.id;
	}
	public void setTitle(String title) {
		 this.title = title;
	}
	public String getTitle() {
		 return this.title;
	}
	public void setContent(String content) {
		 this.content = content;
	}
	public String getContent() {
		 return this.content;
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