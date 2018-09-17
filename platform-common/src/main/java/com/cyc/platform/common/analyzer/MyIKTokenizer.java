package com.cyc.platform.common.analyzer;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;

/**
 * Created by huzuxing on 2018/6/27.
 */
public class MyIKTokenizer extends Tokenizer {

    private IKSegmenter ikSegmenter;

    private final CharTermAttribute charTermAttribute;

    private final OffsetAttribute offsetAttribute;

    private final TypeAttribute typeAttribute;

    private int endPosition;

    public MyIKTokenizer() {
        this(false);
    }

    public MyIKTokenizer(boolean useSmart) {
        super();
        offsetAttribute = addAttribute(OffsetAttribute.class);
        charTermAttribute = addAttribute(CharTermAttribute.class);
        typeAttribute = addAttribute(TypeAttribute.class);
        ikSegmenter = new IKSegmenter(input, useSmart);
    }

    @Override
    public boolean incrementToken() throws IOException {
        clearAttributes();
        Lexeme nextLexeme = ikSegmenter.next();
        if (null != nextLexeme) {
            charTermAttribute.append(nextLexeme.getLexemeText());
            charTermAttribute.setLength(nextLexeme.getLength());
            offsetAttribute.setOffset(nextLexeme.getBeginPosition(), nextLexeme.getEndPosition());
            endPosition = nextLexeme.getEndPosition();
            typeAttribute.setType(nextLexeme.getLexemeTypeString());
            return true;
        }
        return false;
    }

    @Override
    public void reset() throws IOException {
        super.reset();
        ikSegmenter.reset(input);
    }

    @Override
    public void end() throws IOException {
        super.end();
        int finalOffSet = correctOffset(this.endPosition);
        offsetAttribute.setOffset(finalOffSet, finalOffSet);
    }
}
