package com.cyc.platform.common.lucene;

import com.cyc.platform.common.analyzer.MyIKAnalyzer;
import com.cyc.platform.common.common.Pager;
import com.cyc.platform.common.entity.CycInfoContent;
import com.cyc.platform.common.thread.ThreadPool;
import com.cyc.platform.common.utils.StringUtils;
import com.google.gson.JsonObject;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.*;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.store.Directory;
import org.pegdown.PegDownProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service("luceneContentSvc")
public class LuceneContentSvcImpl implements LuceneContentSvc<CycInfoContent> {

    private final static Logger logger = LoggerFactory.getLogger(LuceneContentSvcImpl.class);

    public final ReentrantLock reentrantLock = new ReentrantLock();

    final BooleanClause.Occur[] QUERY_FLAGS = {
            BooleanClause.Occur.SHOULD, BooleanClause.Occur.SHOULD};
    final String[] QUERY_FIELD = {"name", "content"};

    @Value("${lucene_path}")
    private String lucenePath;
//
//    @Value("${html_lighter_prefix}")
//    private String lighterPrefix;
//
//    @Value("${html_lighter_sufix}")
//    private String lighterSufix;

    @Override
    public Integer createIndex(Integer id, Integer startId, Integer max) throws IOException, ParseException {
        return null;
    }

    @Override
    public Integer createIndex(Integer id, Integer startId, Integer max, Directory dir) throws IOException, ParseException {
        return null;
    }

    @Override
    public void createIndex(CycInfoContent content, Directory dir) throws IOException {
        if (null == content || null == dir) {
            logger.info("no content to index, or Directory is invalide");
            return ;
        }
        ThreadPool.taskExecute(() -> {
            IndexWriter indexWriter = null;
            try {
                indexWriter = new IndexWriter(dir, new IndexWriterConfig(new MyIKAnalyzer()));
                indexWriter.addDocument(createDocument(content));
            } catch (IOException e) {
                logger.error("", e);
            } finally {
                LuceneUtils.closeIndexWriter(indexWriter);
            }
        });
    }

    private Document createDocument(CycInfoContent content) {
        Document doc = new Document();
//        Project project = new Project();
//        project.setId(content.getProjectId());
//        project = projectService.findById(project);
//        if (null != content.getId()) {
//            doc.add(new Field(ID, String.valueOf(content.getId()), TextField.TYPE_STORED));
//        }
//        if (!StringUtils.isNullOrEmpty(content.getApiName())) {
//            doc.add(new Field(NAME, content.getApiName(), TextField.TYPE_STORED));
//        }
//        String info = "";
//        if (!StringUtils.isNullOrEmpty(content.getApiInfo())) {
//            info = info + content.getApiInfo();
//            //doc.add(new Field(DESCRIPTION, content.getApiInfo(), TextField.TYPE_STORED));
//        }
//        if (!StringUtils.isNullOrEmpty(content.getApiContent())) {
//            info = info + " " + content.getApiContent();
//           // doc.add(new Field(CONTENT, content.getApiContent(), TextField.TYPE_STORED));
//        }
//        if (!StringUtils.isNullOrEmpty(info)) {
//
//            if (Constant.CONTENT_TYPE_MARKDOWN == content.getContentType()) {
//                PegDownProcessor pdp = new PegDownProcessor(Integer.MAX_VALUE);
//                info = pdp.markdownToHtml(info);
//            }
//            String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式
//            String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式
//            String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式
//            String regMd = "[\\\\\\`\\*\\_\\[\\]\\#\\+\\-\\!\\>\\|\\:]";// 定义特殊字符
//            Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE);
//            Matcher m_script=p_script.matcher(info);
//            info=m_script.replaceAll(" "); //过滤script标签
//
//            Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE);
//            Matcher m_style=p_style.matcher(info);
//            info=m_style.replaceAll(" "); //过滤style标签
//
//            Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);
//            Matcher m_html=p_html.matcher(info);
//            info=m_html.replaceAll(" "); //过滤html标签
//
//            Pattern p_md=Pattern.compile(regMd,Pattern.CASE_INSENSITIVE);
//            Matcher m_md=p_md.matcher(info);
//            info=m_md.replaceAll(" "); //过滤html标签
//
//            doc.add(new Field(CONTENT, info, TextField.TYPE_STORED));
//        }
//        if (null != project && !StringUtils.isNullOrEmpty(project.getProjectName())) {
//            doc.add(new Field(PROJECT_NAME, project.getProjectName(), TextField.TYPE_STORED));
//        }
        return doc;
    }

    @Override
    public void createIndex(CycInfoContent content) throws IOException {
        if (null == content) {
            logger.info("no content to index");
            return ;
        }

        Directory directory = LuceneUtils.getDirectory(lucenePath);

        createIndex(content, directory);
    }

    @Override
    public void deleteIndex(CycInfoContent content) throws IOException, ParseException {
        if (null == content) {
            logger.info("no content index doc to delete");
            return ;
        }
        Directory directory = LuceneUtils.getDirectory(lucenePath);
        deleteIndex(content.getId(), directory);
    }

    @Override
    public void deleteIndex(Integer id, Directory dir) throws IOException, ParseException {
        if (null == id || null == dir) {
            logger.info("index id can not be null, or Director is invalide");
            return ;
        }
        ThreadPool.taskExecute(() -> {
            IndexWriter indexWriter = null;
            try {
                indexWriter = new IndexWriter(dir, new IndexWriterConfig(new MyIKAnalyzer()));
                LuceneUtils.deleteIndex(indexWriter, new Term(ID, String.valueOf(id)));
            } catch (IOException e) {
                logger.error("", e);
            } finally {
                LuceneUtils.closeIndexWriter(indexWriter);
            }
        });
    }

    @Override
    public void updateIndex(CycInfoContent content) throws IOException, ParseException {

        if (null == content) {
            logger.info("no content to index");
            return ;
        }
        Directory directory = LuceneUtils.getDirectory(lucenePath);
        updateIndex(content, directory);
    }

    @Override
    public void updateIndex(CycInfoContent content, Directory dir) throws IOException, ParseException {
        if (null == content || null == dir) {
            logger.info("no content to update for index, or Director is invalide");
            return ;
        }
        /**
         * 这里用reentrantLock作同步 处理，此处启用线程去处理索引文件，避免同步代码效率低下，同时引入了同步问题
         * 如果不加锁：线程1的indexWriter还未处理完，未来得及释放索引文件锁，线程2已经开始获取Lucene索引文件锁，
         * 此时会报错：
         *org.apache.lucene.store.LockObtainFailedException: Lock held by this virtual machine: E:\lucene\write.lock
         *
         * 为什么不能在方法上加 synchronized 关键字？
         * synchronized 锁住当前对象，而这里使用的是lamda 表达式，不属于当前对象的范围，是另一个线程类
         */
        ThreadPool.taskExecute(() -> {
            IndexWriter indexWriter = null;
            try {
                boolean indexDocExist = LuceneUtils.isIndexExist(dir);
                reentrantLock.lock();
                indexWriter = new IndexWriter(dir, new IndexWriterConfig(new MyIKAnalyzer()));
                if (indexDocExist) {
                    LuceneUtils.deleteIndex(indexWriter, new Term(ID, String.valueOf(content.getId())));
                }
                indexWriter.addDocument(createDocument(content));
            } catch (IOException e) {
                logger.error("", e);
            }finally {
                LuceneUtils.closeIndexWriter(indexWriter);
                if (reentrantLock.isLocked()) {
                    reentrantLock.unlock();
                }
            }
        });
    }

    @Override
    public Pager search(String q, Integer page, Integer rows) throws ParseException, IOException, InvalidTokenOffsetsException {

        page = null == page || page <= 0 ? 1 : page;
        rows = null == rows || rows <= 0 ? 30 : rows;

        MyIKAnalyzer analyzer = new MyIKAnalyzer();
        Directory doc = LuceneUtils.getDirectory(lucenePath);
        IndexReader reader = LuceneUtils.getIndexReader(doc);
        IndexReader rtcReader = LuceneUtils.getIndexReader(doc, true);
        if (null != rtcReader) {
            LuceneUtils.closeIndexReader(reader);
            reader = rtcReader;
        }
        IndexSearcher searcher = LuceneUtils.getIndexSearcher(reader);

        Query query = MultiFieldQueryParser.parse(q, QUERY_FIELD, QUERY_FLAGS, analyzer);

        BooleanQuery bq = new BooleanQuery.Builder().add(query, BooleanClause.Occur.MUST).build();
        Integer max = reader.maxDoc();
        ScoreDoc[] hits = null;
        if (null != searcher) {
            hits = searcher.search(bq, max, new Sort()).scoreDocs;
        }
        List<JsonObject> searchResults = null;
        int len = 0;
        if (null != hits) {
            QueryScorer scorer = new QueryScorer(query);
            Fragmenter fragmenter = new SimpleSpanFragmenter(scorer);
           // SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter(lighterPrefix, lighterSufix);
            //Highlighter highlighter = new Highlighter(simpleHTMLFormatter, scorer);
            //highlighter.setTextFragmenter(fragmenter);
            searchResults = new ArrayList<>();
            max = hits.length;
            len = page * rows;
            if (len > max)
                len = max;
            for (int i = (page - 1) * rows; i < len; i++) {
                Document document = searcher.doc(hits[i].doc);
                Integer id = null;
                String name = null;
                String content = null;
                if (null != document) {
                    String idStr = document.get("id");
                    id = StringUtils.isNullOrEmpty(idStr) ? id : Integer.valueOf(idStr);
                    name = document.get(NAME);
//                    String lighterName = StringUtils.isNullOrEmpty(name) ? name :
//                            highlighter.getBestFragment(analyzer, NAME, name);
//                    name = StringUtils.isNullOrEmpty(lighterName) ? name : lighterName;
//                    content = document.get(CONTENT);
//                    String lighterContent = StringUtils.isNullOrEmpty(content) ? content :
//                            highlighter.getBestFragment(analyzer, CONTENT, content);
//                    content = StringUtils.isNullOrEmpty(lighterContent) ? content : lighterContent;
//                    String projectName = document.get(PROJECT_NAME);
//                    JsonObject object = new JsonObject();
//                    object.addProperty(ID, id);
//                    object.addProperty(NAME, name);
//                    object.addProperty(PROJECT_NAME, projectName);
//                    object.addProperty(CONTENT, content);
//                    searchResults.add(object);
                }
            }
        }
        Pager<JsonObject> pager = new Pager<>();
        pager.setPageNo(page);
        pager.setPageSize(rows);
        pager.setTotalCount(max);
        pager.setResults(searchResults);
        return pager;
    }
}
