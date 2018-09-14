package com.cyc.platform.api.comtroller;


import com.cyc.platform.common.common.Constant;
import com.cyc.platform.common.common.Tips;
import com.cyc.platform.common.entity.CycInfoPublicRegion;
import com.cyc.platform.common.entity.CycInfoStick;
import com.cyc.platform.common.response.ResponseListRet;
import com.cyc.platform.common.response.RetEntity;
import com.cyc.platform.common.service.CycInfoStickService;
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
@RequestMapping("/api/cycinfostick")
public class CycInfoStickController {

	/**
 	 * 根据条件获取list列表信息 
 	**/
	@RequestMapping(value = "/findList", method = RequestMethod.POST)
	public WebAsyncTask<String> findList(final CycInfoStick bean, HttpServletRequest request) {
		Callable callable = () -> {
			List<CycInfoStick> list = cycInfoStickService.findList(null);
			RetEntity retEntity = new ResponseListRet<CycInfoStick>(Tips.SUCCESS1.getCode(),
					Tips.SUCCESS1.getDesc(), list);
			return GsonUtils.toGsonExcludeFields(retEntity);
		};
		return new WebAsyncTask<String>(Constant.REQUEST_TIMEOUT_MILLISECOND, callable);
	}
	/**
 	 * 根据条件获取分页数据 
 	**/
	@RequestMapping(value = "/findPage", method = RequestMethod.POST)
	public WebAsyncTask<String> findPage(final  CycInfoStick bean,Integer page,Integer rows, HttpServletRequest request) {
		Callable callable = () -> {

			return null;
		};
		return new WebAsyncTask<String>(Constant.REQUEST_TIMEOUT_MILLISECOND, callable);
	}
	/**
 	 * 新增数据接口 
 	**/
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public WebAsyncTask<String> add(final CycInfoStick bean) {
		Callable callable = () -> {

			return null;
		};
		return new WebAsyncTask<String>(Constant.REQUEST_TIMEOUT_MILLISECOND, callable);
	}
	/**
 	 * 更新数据 
 	**/
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public WebAsyncTask<String> update(final CycInfoStick bean) {
		Callable callable = () -> {

			return null;
		};
		return new WebAsyncTask<String>(Constant.REQUEST_TIMEOUT_MILLISECOND, callable);
	}
	/**
 	 * 根据ID获取数据，需要参数校验 
 	**/
	@RequestMapping(value = "/findById", method = RequestMethod.POST)
	public WebAsyncTask<String> findById(final CycInfoStick bean) {
		Callable callable = () -> {

			return null;
		};
		return new WebAsyncTask<String>(Constant.REQUEST_TIMEOUT_MILLISECOND, callable);
	}
	/**
 	 * 根据条件删除数据 
 	**/
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public WebAsyncTask<String> delete(final CycInfoStick bean) {
		Callable callable = () -> {

			return null;
		};
		return new WebAsyncTask<String>(Constant.REQUEST_TIMEOUT_MILLISECOND, callable);
	}
	@Resource
	private CycInfoStickService cycInfoStickService;

}