package com.cyc.platform.common.entity;


import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Auto Created through python on 2018-09-13, author:111
 **/

public class CycInfoContent{

	@Expose
	private Integer id;

	/**	标题**/
	@Expose
	private String title;

	/**	简短标题**/
	@Expose
	private String shortTitle;

	/**	描述**/
	@Expose
	private String description;

	/**	内容**/
	@Expose
	private String content;

	/**	排序**/
	private Integer sort;

	/**	联系人ID**/
	@Expose
	private Integer contactId;


	/**	栏目ID**/
	@Expose
	private Integer channelId;

	/**	发布者ID**/
	@Expose
	private Integer userId;

	/**	是否置顶，0-否，1-是**/
	@Expose
	private Integer isSticked;

	/**	状态**/
	private Integer status;

	private Integer timeCreate;

	@Expose
	private Integer timePublish;

	private Integer timeUpdate;

	@Expose()
	private List<CycInfoPicture> pictures;

	@Expose()
	private CycInfoContacts contact;

	public CycInfoContent() {}

	public CycInfoContent(Integer id,String title,String shortTitle,
						  String description,String content,Integer sort,Integer isSticked,
						  Integer status,Integer timeCreate,
						  Integer timePublish,Integer timeUpdate, Integer contactId,
						  Integer channelId, List<CycInfoPicture> pictures, Integer userId,
						  CycInfoContacts contact) {
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
		this.contactId = contactId;
		this.channelId = channelId;
		this.pictures = pictures;
		this.userId = userId;
		this.contact = contact;
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

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	public List<CycInfoPicture> getPictures() {
		return pictures;
	}

	public void setPictures(List<CycInfoPicture> pictures) {
		this.pictures = pictures;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public CycInfoContacts getContact() {
		return contact;
	}

	public void setContact(CycInfoContacts contact) {
		this.contact = contact;
	}
}