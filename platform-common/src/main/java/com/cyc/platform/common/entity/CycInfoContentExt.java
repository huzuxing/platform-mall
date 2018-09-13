package com.cyc.platform.common.entity;


/**
 * Auto Created through python on 2018-09-13, author:111
 **/

public class CycInfoContentExt{

	private Integer id;

	/**	信息ID**/
	private Integer infoId;

	/**	浏览次数**/
	private Integer viewCount;

	/**	点赞次数**/
	private Integer praiseCount;

	/**	转发次数**/
	private Integer forwardCount;

	/**	收藏次数**/
	private Integer collectCount;

	public CycInfoContentExt() {}

	public CycInfoContentExt(Integer id,Integer infoId,Integer viewCount,Integer praiseCount,Integer forwardCount,Integer collectCount) {
		this.id = id;
		this.infoId = infoId;
		this.viewCount = viewCount;
		this.praiseCount = praiseCount;
		this.forwardCount = forwardCount;
		this.collectCount = collectCount;
	}
	public void setId(Integer id) {
		 this.id = id;
	}
	public Integer getId() {
		 return this.id;
	}
	public void setInfoId(Integer infoId) {
		 this.infoId = infoId;
	}
	public Integer getInfoId() {
		 return this.infoId;
	}
	public void setViewCount(Integer viewCount) {
		 this.viewCount = viewCount;
	}
	public Integer getViewCount() {
		 return this.viewCount;
	}
	public void setPraiseCount(Integer praiseCount) {
		 this.praiseCount = praiseCount;
	}
	public Integer getPraiseCount() {
		 return this.praiseCount;
	}
	public void setForwardCount(Integer forwardCount) {
		 this.forwardCount = forwardCount;
	}
	public Integer getForwardCount() {
		 return this.forwardCount;
	}
	public void setCollectCount(Integer collectCount) {
		 this.collectCount = collectCount;
	}
	public Integer getCollectCount() {
		 return this.collectCount;
	}
}