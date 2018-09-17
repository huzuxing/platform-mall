package com.cyc.platform.common.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class LuceneUtils {
    private static Logger log = LoggerFactory.getLogger(LuceneUtils.class);

    private static final LuceneManager luceneManager = LuceneManager
            .getInstance();

    public static Analyzer analyzer = new StandardAnalyzer();

    /**
     * 默认查询 5 条
     */
    private static Integer DEFAULT_COUNT = 5;

    /**
     * 打开索引目录
     *
     * @param path
     * @return
     */
    public static Directory getDirectory(String path) {
        Directory dir = null;
        try {
            dir = FSDirectory.open(Paths.get(path));
//			/**
//			 * isLocked() 方法内部会试图获取Lock，如果获取到Lock，则关闭它，否则return false,表示 目录没有被锁
//			 */
//			IndexWriter.isLocked(dir);
        } catch (IOException e) {
            log.error("open index directory failed", e);
            return null;
        }
        return dir;
    }

    /**
     * 关闭索引目录，并销毁
     *
     * @param dir
     * @throws IOException
     */
    public static void closeDirectory(Directory dir) throws IOException {
        if (null != dir) {
            dir.close();
            dir = null;
        }
    }

    /**
     * 获取IndexWriterConfig
     *
     * @param analyzer
     * @return
     */
    public static IndexWriterConfig getIndexWriterConfig(Analyzer analyzer) {
        return luceneManager.getIndexWriterConfig(analyzer);
    }

    /**
     * 获取默认的analyzer为参数的IndexWriterConfig
     *
     * @return
     */
    public static IndexWriterConfig getIndexWriterConfig() {
        return luceneManager.getIndexWriterConfig(analyzer);
    }

    /**
     * 获取IndexWriter
     *
     * @param dir
     * @param config
     * @return
     */
    public static IndexWriter getIndexWriter(Directory dir,
                                             IndexWriterConfig config) {
        return luceneManager.getIndexWriter(dir, config);
    }

    /**
     * 获取IndexReader，并开启近实时索引
     *
     * @param dir
     * @param enableNRTReader
     * @return
     */
    public static IndexReader getIndexReader(Directory dir,
                                             boolean enableNRTReader) {
        return luceneManager.getIndexReader(dir, enableNRTReader);
    }

    /**
     * 获取IndexReader 默认不开启近实时索引
     *
     * @param dir
     * @return
     */
    public static IndexReader getIndexReader(Directory dir) {
        return getIndexReader(dir, false);
    }

    /**
     * 获取IndexSearcher
     *
     * @param reader
     * @param executor 提供多线程查询索引
     * @return
     */
    public static IndexSearcher getIndexSearcher(IndexReader reader,
                                                 ExecutorService executor) {
        return luceneManager.getIndexSearcher(reader, executor);
    }

    /**
     * 获取IndexSearcher,不支持多线程查询
     *
     * @param reader
     * @return
     */
    public static IndexSearcher getIndexSearcher(IndexReader reader) {
        return luceneManager.getIndexSearcher(reader);
    }

    /**
     * 创建QueryParser
     *
     * @param field
     * @param analyzer
     * @return
     */
    public static QueryParser createQueryParser(String field, Analyzer analyzer) {
        return new QueryParser(field, analyzer);
    }

    /**
     * 关闭IndexReader
     *
     * @param reader
     */
    public static void closeIndexReader(IndexReader reader) {
        if (null != reader) {
            try {
                reader.close();
                reader = null;
            } catch (IOException e) {
                log.error("closing IndexReader failed:" + e.getMessage());
                return;
            }
        }
    }

    /**
     * 关闭IndexWriter
     *
     * @param writer
     */
    public static void closeIndexWriter(IndexWriter writer) {
        if (null != writer) {
            try {
                writer.commit();
                writer.close();
            } catch (IOException e) {
                log.error("closing IndexWriter failed:" + e.getMessage());
            }
        }
    }

    /**
     * 关闭IndexReader 和 IndexWriter
     *
     * @param reader
     * @param writer
     */
    public static void closeReaderAndWriter(IndexReader reader,
                                            IndexWriter writer) {
        closeIndexReader(reader);
        closeIndexWriter(writer);
    }

    /**
     * 删除索引，但是得调用者自己在调用处关闭 IndexWriter
     *
     * @param writer
     * @param field
     * @param value
     */
    public static void deleteIndex(IndexWriter writer, String field,
                                   String value) {
        deleteIndex(writer, new Term[]{new Term(field, value)});
    }

    /**
     * 根据terms 删除索引，调用者需要自己关闭IndexWriter
     *
     * @param writer
     * @param terms
     */
    public static void deleteIndex(IndexWriter writer, Term... terms) {
        try {
            writer.deleteDocuments(terms);
        } catch (IOException e) {
            log.error("delete index failed{argument{terms}}:" + e.getMessage());
            return;
        }
    }

    /**
     * 根据Queries 删除索引，但调用者自己关闭IndexWriter
     *
     * @param writer
     * @param query
     */
    public static void deleteIndex(IndexWriter writer, Query query) {
        deleteIndex(writer, query);
    }

    /**
     * 根据Query[] 删除索引，但是调用者需自己关闭IndexWriter
     *
     * @param writer
     * @param queries
     */
    public static void deleteIndex(IndexWriter writer, Query... queries) {
        try {
            writer.deleteDocuments(queries);
        } catch (IOException e) {
            log.error("delete index { argument{queries}} failed:"
                    + e.getMessage());
            return;
        }
    }

    /**
     * 删除所有索引，调用者需要自己关闭IndexWriter
     *
     * @param writer
     */
    public static void deleteAllIndex(IndexWriter writer) {
        try {
            writer.deleteAll();
        } catch (IOException e) {
            log.error("delete all index failed:" + e.getMessage());
        }
    }

    /**
     * 更新索引
     *
     * @param writer
     * @param term
     * @param doc
     */
    public static void updateIndex(IndexWriter writer, Term term, Document doc) {
        try {
            writer.updateDocument(term, doc);
        } catch (IOException e) {
            log.error("update index failed{arguments{term,doc}}:"
                    + e.getMessage());
            return;
        }
    }

    /**
     * 更新索引文档
     *
     * @param writer
     * @param field
     * @param value
     * @param doc
     */
    public static void updateIndex(IndexWriter writer, String field,
                                   String value, Document doc) {
        updateIndex(writer, new Term(field, value), doc);
    }

    /**
     * 索引文档查询
     *
     * @param searcher
     * @param query
     * @return
     */
    public static List<Document> query(IndexSearcher searcher, Query query) {
        TopDocs topDocs = null;
        try {
            // 查询指定条数数据
            topDocs = searcher.search(query, DEFAULT_COUNT);
        } catch (IOException e) {
            log.error("searching index failed:" + e.getMessage());
            return null;
        }
        ScoreDoc[] scores = topDocs.scoreDocs;
        int len = scores.length;
        if (len < 0) {
            return Collections.emptyList();
        }
        List<Document> docList = new ArrayList<Document>();
        // 将查询得到的Document装载进list，这里须将try-catch放在for循环外边，放在里面不符合规范
        try {
            for (int i = 0; i < len; i++) {
                Document doc = searcher.doc(scores[i].doc);
                docList.add(doc);
            }
        } catch (IOException e) {
            log.error("loading Document into List failed:" + e.getMessage());
            return null;
        }
        return docList;
    }

    /**
     * 获取索引文档的总数【注意：IndexWriter需要调用者自己关闭】
     *
     * @param reader
     * @return
     */
    public static Integer getIndexTotalCount(IndexReader reader) {
        return reader.numDocs();
    }

    /**
     * 获取索引的最大文档数Id【调用者自己关闭IndexWriter】
     *
     * @param reader
     * @return
     */
    public static Integer getMaxDocId(IndexReader reader) {
        return reader.maxDoc();
    }

    /**
     * 返回已经删除，但尚未做提交操作的文档数【调用者自己关闭IndexWriter】
     *
     * @param reader
     * @return
     */
    public static Integer getDeletedDocNum(IndexReader reader) {
        /** 最大文档数 减去 实际文档数 即是已经删除但未提交的文档数 **/
        return getMaxDocId(reader) - getIndexTotalCount(reader);
    }

    /**
     * 查询符合条件的指定条数的索引数据
     *
     * @param searcher
     * @param query
     * @param count
     * @return
     */
    public static Integer getSearchTotalCount(IndexSearcher searcher,
                                              Query query, Integer count) {
        TopDocs pageDoc = null;
        if (null == count) {
            /** 当指定的count为null时，默认查询5条数据 **/
            count = DEFAULT_COUNT;
        }
        try {
            pageDoc = searcher.search(query, count);
            if (null == pageDoc || null == pageDoc.scoreDocs
                    || 0 == pageDoc.scoreDocs.length) {
                return 0;
            }
        } catch (IOException e) {
            log.error("count for the conditional search failed:"
                    + e.getMessage());
            return 0;
        }
        return pageDoc.scoreDocs.length;
    }

    /**
     * 判断索引目录是否存在
     *
     * @param dir
     * @return
     * @throws IOException
     */
    public static boolean isIndexExist(Directory dir) throws IOException {
        return DirectoryReader.indexExists(dir);
    }
}
