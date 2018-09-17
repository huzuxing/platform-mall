package com.cyc.platform.common.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.Directory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LuceneManager
{
	private static final Logger log = LoggerFactory
			.getLogger(LuceneManager.class);

	private volatile static LuceneManager singleton = null;

	private volatile static IndexWriter indexWriter = null;

	private volatile static IndexReader indexReader = null;

	private volatile static IndexSearcher indexSearcher = null;

	private volatile static IndexWriterConfig config = null;

	private final Lock writerLock = new ReentrantLock();

	public LuceneManager()
	{
	}

	/**
	 * 获取LuceneManager 单例
	 * 
	 * @return
	 */
	public static LuceneManager getInstance()
	{
		if (null == singleton)
		{
			synchronized (LuceneManager.class)
			{
				singleton = new LuceneManager();
			}
		}
		return singleton;
	}

	/**
	 * 获取索引创建器 IndexWriter 单例对象
	 * 
	 * @param dir
	 * @param config
	 * @return
	 */
	public IndexWriter getIndexWriter(Directory dir, IndexWriterConfig config)
	{
		if (null == dir)
		{
			throw new IllegalArgumentException("Directory can not be null");
		}
		if (null == config)
		{
			throw new IllegalArgumentException(
					"IndexWriterConfig can not be null");
		}

		try
		{
			writerLock.lock();
			if (null == indexWriter)
			{
				// 若索引目录被锁，直接抛出异常
//				if (IndexWriter.isLocked(dir))
//				{
//					throw new LockObtainFailedException(
//							"Directory has been locked");
//				}
				indexWriter = new IndexWriter(dir, config);
			}
		}
		catch (IOException e)
		{
			log.error("creation IndexWriter failed:%s" + e.getMessage());
			return null;
		}
		finally
		{
			// 最后释放锁资源
			writerLock.unlock();
		}
		return indexWriter;
	}

	/**
	 * 获取索引读取器 IndexReader 单例对象
	 * 
	 * @param dir
	 * @param enableNRTReader
	 * @return
	 * @throws IOException
	 */
	public IndexReader getIndexReader(Directory dir, boolean enableNRTReader)
	{
		if (null == dir)
		{
			throw new IllegalArgumentException(
					"getIndexReader:Directory can not be null");
		}
		try
		{
			if (null == indexReader)
			{
				indexReader = DirectoryReader.open(dir);
			}
			else
			{
				if (enableNRTReader && indexReader instanceof DirectoryReader)
				{
					// 开启近实时Reader，能立即查看到动态添加|删除的索引变换
					indexReader = DirectoryReader
							.openIfChanged((DirectoryReader) indexReader);
				}
			}
		}
		catch (IOException e)
		{
			log.error("getIndexReader failed");
			return null;
		}
		return indexReader;
	}

	/**
	 * 获取IndexReader单例对象，默认不开启近实时索引
	 * 
	 * @param dir
	 * @return
	 */
	public IndexReader getIndexReader(Directory dir)
	{
		return getIndexReader(dir, false);
	}

	/**
	 * 获取索引查询器，
	 * 
	 * @param reader
	 *            索引文件读取
	 * @param executor
	 *            开启多线程查询
	 * @return
	 */
	public IndexSearcher getIndexSearcher(IndexReader reader,
			ExecutorService executor)
	{
		if (null == reader)
		{
			throw new IllegalArgumentException(
					"getIndexSearcher:IndexReader can not be null");
		}
		if (null == indexSearcher)
		{
			indexSearcher = new IndexSearcher(reader);
		}
		return indexSearcher;
	}

	/**
	 * 获取索引查询器
	 * 
	 * @param reader
	 * @return 默认不开启多线程查询
	 */
	public IndexSearcher getIndexSearcher(IndexReader reader)
	{
		return getIndexSearcher(reader, null);
	}

	/**
	 * 获取IndexWriterConfig
	 * 
	 * @param analyzer
	 * @return
	 */
	public IndexWriterConfig getIndexWriterConfig(Analyzer analyzer)
	{
		if (null == analyzer)
		{
			throw new IllegalArgumentException(
					"Analyzer can not be null in getIndexWriterConfig():");
		}
		if (null == config)
		{
			//config = new IndexWriterConfig(Version.LUCENE_7_3_1, analyzer);
			config = new IndexWriterConfig(analyzer);
		}
		return config;
	}

	/**
	 * tracks changes to a delegated IndexWriter, used by
	 * ControlledRealTimeReopenThread to ensure specific changes are visible.
	 * Create this class (passing your IndexWriter), and then pass this class to
	 * ControlledRealTimeReopenThread. Be sure to make all changes via the
	 * TrackingIndexWriter, otherwise ControlledRealTimeReopenThread won't know
	 * about the changes
	 * 
	 * @param writer
	 * @return
	 */
//	public TrackingIndexWriter getTrackingIndexWriter(IndexWriter writer)
//	{
//		return new TrackingIndexWriter(writer);
//	}
}
