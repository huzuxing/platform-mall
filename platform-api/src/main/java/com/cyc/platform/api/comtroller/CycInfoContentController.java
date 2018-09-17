package com.cyc.platform.api.comtroller;


import com.cyc.platform.common.common.Constant;
import com.cyc.platform.common.common.Tips;
import com.cyc.platform.common.entity.CycInfoContacts;
import com.cyc.platform.common.entity.CycInfoContent;
import com.cyc.platform.common.entity.CycInfoStick;
import com.cyc.platform.common.response.ResponseListRet;
import com.cyc.platform.common.response.RetEntity;
import com.cyc.platform.common.service.CycInfoContentService;
import com.cyc.platform.common.utils.GsonUtils;
import com.cyc.platform.common.utils.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.Callable;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/

@RestController
@RequestMapping("/api/cycinfocontent")
public class CycInfoContentController {

	/**
 	 * 根据条件获取list列表信息 
 	**/
	@RequestMapping(value = "/findList", method = RequestMethod.POST)
	@ResponseBody
	public WebAsyncTask<String> findList(final CycInfoContent bean, HttpServletRequest request) {
		Callable callable = () -> {

			return null;
		};
		return new WebAsyncTask<String>(Constant.REQUEST_TIMEOUT_MILLISECOND, callable);
	}
	/**
 	 * 根据条件获取分页数据 
 	**/
	@RequestMapping(value = "/findPage", method = RequestMethod.POST)
	@ResponseBody
	public WebAsyncTask<String> findPage(final  CycInfoContent bean,Integer page,Integer rows, HttpServletRequest request) {
		Callable callable = () -> {
			List<CycInfoContent> list = cycInfoContentService.findPage(bean, page, rows);
			RetEntity retEntity = new ResponseListRet<CycInfoContent>(Tips.SUCCESS1.getCode(),
					Tips.SUCCESS1.getDesc(), list);
			return GsonUtils.toGsonExcludeFields(retEntity);
		};
		return new WebAsyncTask<String>(Constant.REQUEST_TIMEOUT_MILLISECOND, callable);
	}
	/**
 	 * 新增数据接口 
 	**/
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public WebAsyncTask<String> add(final CycInfoContent bean, CycInfoContacts contacts, String[] pictures) {
		Callable callable = () -> {
			RetEntity retEntity = null;
			if (null == bean || null == contacts || StringUtils.isNullOrEmpty(bean.getContent(), contacts.getAddress(),
					contacts.getName(), contacts.getCity(), contacts.getProvince(), contacts.getDistrict(),
					contacts.getContact()) || null == bean.getChannelId() || null == bean.getUserId()) {
				retEntity = new RetEntity(Tips.ERROR202.getCode(), Tips.ERROR202.getDesc());
				return GsonUtils.toGsonExcludeFields(retEntity);
			}
			CycInfoContent entity = cycInfoContentService.add(bean, contacts, pictures);
			if (null == entity) {
				retEntity = new RetEntity(Tips.ERROR101.getCode(), Tips.ERROR101.getDesc());
				return GsonUtils.toGsonExcludeFields(retEntity);
			}
			retEntity = new RetEntity(Tips.SUCCESS1.getCode(), Tips.SUCCESS1.getDesc());
			return GsonUtils.toGsonExcludeFields(retEntity);
		};
		return new WebAsyncTask<String>(Constant.REQUEST_TIMEOUT_MILLISECOND, callable);
	}
	/**
 	 * 更新数据 
 	**/
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public WebAsyncTask<String> update(final CycInfoContent bean) {
		Callable callable = () -> {

			return null;
		};
		return new WebAsyncTask<String>(Constant.REQUEST_TIMEOUT_MILLISECOND, callable);
	}
	/**
 	 * 根据ID获取数据，需要参数校验 
 	**/
	@RequestMapping(value = "/findById", method = RequestMethod.POST)
	public WebAsyncTask<String> findById(final CycInfoContent bean) {
		Callable callable = () -> {

			return null;
		};
		return new WebAsyncTask<String>(Constant.REQUEST_TIMEOUT_MILLISECOND, callable);
	}
	/**
 	 * 根据条件删除数据 
 	**/
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public WebAsyncTask<String> delete(final CycInfoContent bean) {
		Callable callable = () -> {

			return null;
		};
		return new WebAsyncTask<String>(Constant.REQUEST_TIMEOUT_MILLISECOND, callable);
	}
	@Resource
	private CycInfoContentService cycInfoContentService;

}