package com.cyc.platform.common.entity;


/**
 * Auto Created through python on 2018-09-13, author:111
 **/

public class CycUser{

	private Integer id;

	/**	会员姓名**/
	private String name;

	/**	用户昵称**/
	private String nickname;

	/**	用户头像**/
	private String thumbImg;

	/**	会员手机号**/
	private Integer phone;

	/**	性别，0-男，1-女**/
	private Integer gender;

	/**	状态,0-启用**/
	private Integer status;

	private Integer timeCreate;

	private Integer timeUpdate;

	public CycUser() {}

	public CycUser(Integer id,String name,String nickname,String thumbImg,Integer phone,Integer gender,Integer status,Integer timeCreate,Integer timeUpdate) {
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.thumbImg = thumbImg;
		this.phone = phone;
		this.gender = gender;
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
	public void setNickname(String nickname) {
		 this.nickname = nickname;
	}
	public String getNickname() {
		 return this.nickname;
	}
	public void setThumbImg(String thumbImg) {
		 this.thumbImg = thumbImg;
	}
	public String getThumbImg() {
		 return this.thumbImg;
	}
	public void setPhone(Integer phone) {
		 this.phone = phone;
	}
	public Integer getPhone() {
		 return this.phone;
	}
	public void setGender(Integer gender) {
		 this.gender = gender;
	}
	public Integer getGender() {
		 return this.gender;
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