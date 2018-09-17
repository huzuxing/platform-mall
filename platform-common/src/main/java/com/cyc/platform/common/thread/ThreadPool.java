/**   
 * Copyright © 2017 Digisky. All rights reserved.
 * TODO
 * @author: melody.xu   
 * @date: Jun 21, 2017 1:25:23 PM 
 * @version: V1.0   
 */
package com.cyc.platform.common.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/** 
 * TODO
 * @author: melody.xu
 * @date: Jun 21, 2017 1:25:23 PM  
 */
public class ThreadPool {

	private static final Logger logger = LoggerFactory.getLogger(ThreadPool.class);

	private static final String TAG = ThreadPool.class.getName();

	private static ThreadPoolExecutor threadPool = null;
	/** The total size of the thread pool */
	private final static int threadPoolSize = 50;
	/** The maximum idle time when a thread did not perform a task */
	private final static long threadIdleSecondTime = 5;
	/** 
	 * The size of the thread pool queue. Consider the task execution must be set to 'wait for timeout',
	 *  so the parameters do not have to set too much.
	 */
	private final static int queueSize = 10000;

	/** 
	 * Initialize the thread pool, when the number of threads is less than or equal to threadPoolSize, 
	 * the thread task will not enter the queue.
	 * Only when the number of tasks in the thread pool is greater than threadPoolSize, if there are other tasks that need to be executed at this time, 
	 * then the task will enter the queue and wait for the idle thread to be executed.
	 */
	public static synchronized void init() {
		if (threadPool == null) {
			threadPool = new ThreadPoolExecutor(threadPoolSize, threadPoolSize, threadIdleSecondTime, TimeUnit.SECONDS,
					new ArrayBlockingQueue<Runnable>(queueSize));
		}
	}
	/**
	 * Close the thread pool, and release the occupied resources.
	 */
	public static synchronized void destroy() {
		if (threadPool != null)
			threadPool.shutdown();
	}
	/**
	 * Perform a normal thread task
	 * @param runnable
	 * @throws Exception
	 */
	public static void taskExecute(Runnable runnable) {
		try {
			if (threadPool == null)
				init();
			threadPool.execute(runnable);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("", e);
		}
	}
	/**
	 * Perform a callbackable thread task
	 * @param future 'Object' is a parameter type that requires a callback, such as a JSONObject type parameter, 
	 * or a common type of argument (eg int, long, float, boolean, String, etc.)
	 */
	public static void taskExecute(FutureTask<Object> future) {
		if (threadPool == null)
			init();
		threadPool.submit(future);
	}
}
