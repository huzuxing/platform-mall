package com.cyc.platform.common.entity;


/**
 * Auto Created through python on 2018-09-13, author:111
 **/

public class CycComment{

	private Integer id;

	/**	评论主题ID**/
	private Integer topicId;

	/**	主题类型**/
	private Integer topicType;

	/**	评论内容**/
	private String content;

	/**	评论者ID**/
	private Integer fromUid;

	/**	冗余用户昵称**/
	private String nickname;

	/**	冗余用户头像**/
	private String thumbImg;

	/**	评论被点赞次数**/
	private Integer praiseCount;

	/**	评论被回复次数**/
	private Integer replyCount;

	/**	排序**/
	private Integer sort;

	/**	是否置顶0-否，1-是**/
	private Integer isTop;

	/**	是否热评0-否，1-是**/
	private Integer isHot;

	/**	状态**/
	private Integer status;

	/**	创建时间**/
	private Integer timeCreate;

	private Integer timeUpdate;

	public CycComment() {}

	public CycComment(Integer id,Integer topicId,Integer topicType,String content,Integer fromUid,String nickname,String thumbImg,Integer praiseCount,Integer replyCount,Integer sort,Integer isTop,Integer isHot,Integer status,Integer timeCreate,Integer timeUpdate) {
		this.id = id;
		this.topicId = topicId;
		this.topicType = topicType;
		this.content = content;
		this.fromUid = fromUid;
		this.nickname = nickname;
		this.thumbImg = thumbImg;
		this.praiseCount = praiseCount;
		this.replyCount = replyCount;
		this.sort = sort;
		this.isTop = isTop;
		this.isHot = isHot;
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
	public void setTopicId(Integer topicId) {
		 this.topicId = topicId;
	}
	public Integer getTopicId() {
		 return this.topicId;
	}
	public void setTopicType(Integer topicType) {
		 this.topicType = topicType;
	}
	public Integer getTopicType() {
		 return this.topicType;
	}
	public void setContent(String content) {
		 this.content = content;
	}
	public String getContent() {
		 return this.content;
	}
	public void setFromUid(Integer fromUid) {
		 this.fromUid = fromUid;
	}
	public Integer getFromUid() {
		 return this.fromUid;
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
	public void setPraiseCount(Integer praiseCount) {
		 this.praiseCount = praiseCount;
	}
	public Integer getPraiseCount() {
		 return this.praiseCount;
	}
	public void setReplyCount(Integer replyCount) {
		 this.replyCount = replyCount;
	}
	public Integer getReplyCount() {
		 return this.replyCount;
	}
	public void setSort(Integer sort) {
		 this.sort = sort;
	}
	public Integer getSort() {
		 return this.sort;
	}
	public void setIsTop(Integer isTop) {
		 this.isTop = isTop;
	}
	public Integer getIsTop() {
		 return this.isTop;
	}
	public void setIsHot(Integer isHot) {
		 this.isHot = isHot;
	}
	public Integer getIsHot() {
		 return this.isHot;
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