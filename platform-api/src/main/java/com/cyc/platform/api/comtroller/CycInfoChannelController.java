package com.cyc.platform.api.comtroller;


import com.cyc.platform.common.common.Constant;
import com.cyc.platform.common.common.Tips;
import com.cyc.platform.common.entity.CycInfoChannel;
import com.cyc.platform.common.entity.CycInfoPublicRegion;
import com.cyc.platform.common.response.ResponseListRet;
import com.cyc.platform.common.response.RetEntity;
import com.cyc.platform.common.service.CycInfoChannelService;
import com.cyc.platform.common.utils.GsonUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@RequestMapping("/api/cycinfochannel")
public class CycInfoChannelController {

	/**
 	 * 根据条件获取list列表信息 
 	**/
	@RequestMapping(value = "/findList", method = RequestMethod.POST)
	public WebAsyncTask<String> findList(final CycInfoChannel bean, HttpServletRequest request) {
		Callable callable = () -> {
			List<CycInfoChannel> list = cycInfoChannelService.findList(null);
			RetEntity retEntity = new ResponseListRet<CycInfoChannel>(Tips.SUCCESS1.getCode(),
					Tips.SUCCESS1.getDesc(), list);
			return GsonUtils.toGsonExcludeFields(retEntity);
		};
		return new WebAsyncTask<String>(Constant.REQUEST_TIMEOUT_MILLISECOND, callable);
	}
	/**
 	 * 根据条件获取分页数据 
 	**/
	@RequestMapping(value = "/findPage", method = RequestMethod.POST)
	public WebAsyncTask<String> findPage(final CycInfoChannel bean, Integer page, Integer rows, HttpServletRequest request) {
		Callable callable = () -> {

			return null;
		};
		return new WebAsyncTask<String>(Constant.REQUEST_TIMEOUT_MILLISECOND, callable);
	}
	/**
 	 * 新增数据接口 
 	**/
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public WebAsyncTask<String> add(final CycInfoChannel bean) {
		Callable callable = () -> {

			return null;
		};
		return new WebAsyncTask<String>(Constant.REQUEST_TIMEOUT_MILLISECOND, callable);
	}
	/**
 	 * 更新数据 
 	**/
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public WebAsyncTask<String> update(final CycInfoChannel bean) {
		Callable callable = () -> {

			return null;
		};
		return new WebAsyncTask<String>(Constant.REQUEST_TIMEOUT_MILLISECOND, callable);
	}
	/**
 	 * 根据ID获取数据，需要参数校验 
 	**/
	@RequestMapping(value = "/findById", method = RequestMethod.POST)
	public WebAsyncTask<String> findById(final CycInfoChannel bean) {
		Callable callable = () -> {

			return null;
		};
		return new WebAsyncTask<String>(Constant.REQUEST_TIMEOUT_MILLISECOND, callable);
	}
	/**
 	 * 根据条件删除数据 
 	**/
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public WebAsyncTask<String> delete(final CycInfoChannel bean) {
		Callable callable = () -> {

			return null;
		};
		return new WebAsyncTask<String>(Constant.REQUEST_TIMEOUT_MILLISECOND, callable);
	}
	@Resource
	private CycInfoChannelService cycInfoChannelService;

}