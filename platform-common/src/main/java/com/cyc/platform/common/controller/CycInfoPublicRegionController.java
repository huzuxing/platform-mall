package com.cyc.platform.common.controller;


import com.cyc.platform.common.common.Constant;
import com.cyc.platform.common.entity.CycInfoPublicRegion;
import com.cyc.platform.common.service.CycInfoPublicRegionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;



import javax.servlet.http.HttpServletRequest;
import javax.annotation.Resource;
import java.util.concurrent.Callable;



/**
 * Auto Created through python on 2018-09-13, author:111 
 **/

@RestController
@RequestMapping("/api/cycinfopublicregion")
public class CycInfoPublicRegionController {

	/**
 	 * 根据条件获取list列表信息 
 	**/
	@RequestMapping(value = "/findList", method = RequestMethod.POST)
	public WebAsyncTask<String> findList(final CycInfoPublicRegion bean, HttpServletRequest request) {
		Callable callable = () -> {

			return null;
		};
		return new WebAsyncTask<String>(Constant.REQUEST_TIMEOUT_MILLISECOND, callable);
	}
	/**
 	 * 根据条件获取分页数据 
 	**/
	@RequestMapping(value = "/findPage", method = RequestMethod.POST)
	public WebAsyncTask<String> findPage(final  CycInfoPublicRegion bean,Integer page,Integer rows, HttpServletRequest request) {
		Callable callable = () -> {

			return null;
		};
		return new WebAsyncTask<String>(Constant.REQUEST_TIMEOUT_MILLISECOND, callable);
	}
	/**
 	 * 新增数据接口 
 	**/
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public WebAsyncTask<String> add(final CycInfoPublicRegion bean) {
		Callable callable = () -> {

			return null;
		};
		return new WebAsyncTask<String>(Constant.REQUEST_TIMEOUT_MILLISECOND, callable);
	}
	/**
 	 * 更新数据 
 	**/
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public WebAsyncTask<String> update(final CycInfoPublicRegion bean) {
		Callable callable = () -> {

			return null;
		};
		return new WebAsyncTask<String>(Constant.REQUEST_TIMEOUT_MILLISECOND, callable);
	}
	/**
 	 * 根据ID获取数据，需要参数校验 
 	**/
	@RequestMapping(value = "/findById", method = RequestMethod.POST)
	public WebAsyncTask<String> findById(final CycInfoPublicRegion bean) {
		Callable callable = () -> {

			return null;
		};
		return new WebAsyncTask<String>(Constant.REQUEST_TIMEOUT_MILLISECOND, callable);
	}
	/**
 	 * 根据条件删除数据 
 	**/
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public WebAsyncTask<String> delete(final CycInfoPublicRegion bean) {
		Callable callable = () -> {

			return null;
		};
		return new WebAsyncTask<String>(Constant.REQUEST_TIMEOUT_MILLISECOND, callable);
	}
	@Resource
	private CycInfoPublicRegionService cycInfoPublicRegionService;

}