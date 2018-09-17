package com.cyc.platform.common.lucene;

import com.cyc.platform.common.analyzer.MyIKAnalyzer;
import com.cyc.platform.common.utils.StringUtils;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.store.Directory;

import java.io.IOException;


public class LuceneTest
{
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException, ParseException, InvalidTokenOffsetsException {
//		String text = "Lucene 胡祖兴 是 一个医生，但那是不可能的，没有医院要他";
//		String text1 = "Lucene 胡祖兴 是 一个医生，afe efafefe但那是不可能的，没有医院要他";
		MyIKAnalyzer analyzer = new MyIKAnalyzer();
		Directory doc = LuceneUtils.getDirectory("E:\\lucene");
//		IndexWriterConfig config = LuceneUtils.getIndexWriterConfig(analyzer);
//		IndexWriter writer = LuceneUtils.getIndexWriter(doc, config);
//		Document docc = new Document();
//		docc.add(new Field("id", String.valueOf(12), TextField.TYPE_STORED));
//		docc.add(new Field("textname", text, TextField.TYPE_STORED));
//		docc.add(new Field("textname1", text1, TextField.TYPE_STORED));
//		writer.addDocument(docc);
//
//		Document docc1 = new Document();
//		docc1.add(new Field("projectId", String.valueOf(13), TextField.TYPE_STORED));
//		docc1.add(new Field("textname", text, TextField.TYPE_STORED));
//		writer.addDocument(docc1);
//		LuceneUtils.closeIndexWriter(writer);
		
		//search
		IndexReader reader = LuceneUtils.getIndexReader(doc);
		System.out.println("count = " + reader.numDocs() + ", max = " + reader.maxDoc());
		IndexSearcher searcher = LuceneUtils.getIndexSearcher(reader);
		QueryParser parser = new QueryParser("description", analyzer);
		//Query q = parser.parse("信息");
		final BooleanClause.Occur[] QUERY_FLAGS = {
				BooleanClause.Occur.SHOULD, BooleanClause.Occur.SHOULD};


		Query q = MultiFieldQueryParser.parse("信息", new String[]{"name", "description"}, QUERY_FLAGS, analyzer);
		BooleanQuery bq = new BooleanQuery.Builder().add(q, BooleanClause.Occur.MUST).build();
		ScoreDoc[] hits = searcher.search(bq, 1000, new Sort()).scoreDocs;
		//TopDocs tops = searcher.search(q, 10);
		//System.out.println("总记录数：" + tops.totalHits + "==" + hits.length);

		QueryScorer scorer = new QueryScorer(q);
		Fragmenter fragmenter = new SimpleSpanFragmenter(scorer);
		SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter("<b><font color='red'>","</font></b>");
		Highlighter highlighter = new Highlighter(simpleHTMLFormatter, scorer);
		highlighter.setTextFragmenter(fragmenter);


 		for (int i = 0; i < hits.length ; i++)
 		{
 			Document hitDoc = searcher.doc(hits[i].doc);
			System.out.println(StringUtils.isNullOrEmpty(hitDoc.get("projectId")) ? hitDoc.get("id") : hitDoc.get("projectId"));
			System.out.println(hitDoc.get("description"));
			System.out.println(hitDoc.get("name"));
			String textf = hitDoc.get("description");
			String name = hitDoc.get("name");
			//TokenStream tokenStream=analyzer.tokenStream("description", new StringReader(textf));
			//TokenStream nameStream=analyzer.tokenStream("name", new StringReader(name));
			System.out.println(highlighter.getBestFragment(analyzer,"description", textf));
			System.out.println(highlighter.getBestFragment(analyzer,"name", name));
			//System.out.println(highlighter.getBestFragment(nameStream, name));
 		}
 		//reader.close();
 		//doc.close();
 		
	}
}
