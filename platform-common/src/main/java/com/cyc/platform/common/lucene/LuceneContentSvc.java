package com.cyc.platform.common.lucene;

import com.cyc.platform.common.common.Pager;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.lucene.store.Directory;

import java.io.IOException;

public interface LuceneContentSvc<T> {

    public final String ID = "id";

    public final String NAME = "name";

    public final String DESCRIPTION = "description";

    public final String TYPE = "type";

    public final String PROJECT_TYPE = "1";

    public final String API_TYPE = "2";

    public final String PROJECT_ID = "projectId";

    String CONTENT = "content";

    String PROJECT_NAME = "projectName";

    public Integer createIndex(Integer id, Integer startId, Integer max)
            throws IOException, ParseException;

    public Integer createIndex(Integer id, Integer startId, Integer max,
                               Directory dir) throws IOException, ParseException;

    public void createIndex(T content, Directory dir)
            throws IOException;

    public void createIndex(T content) throws IOException;

    public void deleteIndex(T content) throws IOException,
            ParseException;

    public void deleteIndex(Integer id, Directory dir) throws IOException,
            ParseException;

    public void updateIndex(T content) throws IOException,
            ParseException;

    public void updateIndex(T content, Directory dir)
            throws IOException, ParseException;
    Pager search(String q, Integer page, Integer rows) throws ParseException, IOException, InvalidTokenOffsetsException;
}
