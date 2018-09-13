package com.cyc.platform.common.entity;


/**
 * Auto Created through python on 2018-09-13, author:111
 **/

public class CycInfoContent{

	private Integer id;

	/**	标题**/
	private String title;

	/**	简短标题**/
	private String shortTitle;

	/**	描述**/
	private String description;

	/**	内容**/
	private String content;

	/**	排序**/
	private Integer sort;

	/**	是否置顶，0-否，1-是**/
	private Integer isSticked;

	/**	状态**/
	private Integer status;

	private Integer timeCreate;

	private Integer timePublish;

	private Integer timeUpdate;

	public CycInfoContent() {}

	public CycInfoContent(Integer id,String title,String shortTitle,
						  String description,String content,Integer sort,Integer isSticked,
						  Integer status,Integer timeCreate,Integer timePublish,Integer timeUpdate) {
		this.id = id;
		this.title = title;
		this.shortTitle = shortTitle;
		this.description = description;
		this.content = content;
		this.sort = sort;
		this.isSticked = isSticked;
		this.status = status;
		this.timeCreate = timeCreate;
		this.timePublish = timePublish;
		this.timeUpdate = timeUpdate;
	}
	public void setId(Integer id) {
		 this.id = id;
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
	public void setShortTitle(String shortTitle) {
		 this.shortTitle = shortTitle;
	}
	public String getShortTitle() {
		 return this.shortTitle;
	}
	public void setDescription(String description) {
		 this.description = description;
	}
	public String getDescription() {
		 return this.description;
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
	public void setIsSticked(Integer isSticked) {
		 this.isSticked = isSticked;
	}
	public Integer getIsSticked() {
		 return this.isSticked;
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
	public void setTimePublish(Integer timePublish) {
		 this.timePublish = timePublish;
	}
	public Integer getTimePublish() {
		 return this.timePublish;
	}
	public void setTimeUpdate(Integer timeUpdate) {
		 this.timeUpdate = timeUpdate;
	}
	public Integer getTimeUpdate() {
		 return this.timeUpdate;
	}
}