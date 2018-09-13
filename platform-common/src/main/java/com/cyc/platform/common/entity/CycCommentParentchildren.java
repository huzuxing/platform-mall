package com.cyc.platform.common.entity;


/**
 * Auto Created through python on 2018-09-13, author:111
 **/

public class CycCommentParentchildren{

	private Integer id;

	/**	父级ID**/
	private Integer parentId;

	/**	子级ID**/
	private Integer childId;

	public CycCommentParentchildren() {}

	public CycCommentParentchildren(Integer id,Integer parentId,Integer childId) {
		this.id = id;
		this.parentId = parentId;
		this.childId = childId;
	}
	public void setId(Integer id) {
		 this.id = id;
	}
	public Integer getId() {
		 return this.id;
	}
	public void setParentId(Integer parentId) {
		 this.parentId = parentId;
	}
	public Integer getParentId() {
		 return this.parentId;
	}
	public void setChildId(Integer childId) {
		 this.childId = childId;
	}
	public Integer getChildId() {
		 return this.childId;
	}
}