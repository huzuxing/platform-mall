package com.cyc.platform.common.analyzer;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.Tokenizer;

/**
 * Created by huzuxing on 2018/6/27.
 */
public class MyIKAnalyzer extends Analyzer {

    private boolean useSmart;

    public boolean isUseSmart() {
        return useSmart;
    }

    public void setUseSmart(boolean useSmart) {
        this.useSmart = useSmart;
    }

    public MyIKAnalyzer() {
        this(false);
    }

    public MyIKAnalyzer(boolean useSmart) {
        this.useSmart = useSmart;
    }

    @Override
    protected TokenStreamComponents createComponents(String s) {

//        Reader reader = null;
//        try {
//            reader = new StringReader(s);
//            Tokenizer ikTokenizer = new MyIKTokenizer(this.isUseSmart());
//            return new Analyzer.TokenStreamComponents(ikTokenizer);
//        } catch (Exception e) {
//            throw e;
//        } finally {
//            IOUtils.closeWhileHandlingException(reader);
//        }

        Tokenizer ikTokenizer = new MyIKTokenizer(this.isUseSmart());
        return new TokenStreamComponents(ikTokenizer);
    }
}
