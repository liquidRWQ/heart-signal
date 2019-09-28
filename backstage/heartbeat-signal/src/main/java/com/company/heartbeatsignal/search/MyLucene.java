package com.company.heartbeatsignal.search;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.NIOFSDirectory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Liquid
 * @类名： MyLucene
 * @描述：
 * @date 2019/6/10
 */
public class MyLucene {

    public static String searchByIndex(String keyword, int pageSize) throws IOException, ParseException {

        Analyzer analyzer = new StandardAnalyzer();
        Directory indexDir = NIOFSDirectory.open(new File("D:\\lucene\\index").toPath());

        IndexReader indexReader = StandardDirectoryReader.open(indexDir);

        IndexSearcher indexSearcher = new IndexSearcher(indexReader);

        Query query = new TermQuery(new Term("name", "apache"));

        Query pointRangeQuery = LongPoint.newRangeQuery("size", 100L, 1000L);

        BooleanQuery booleanQuery = new BooleanQuery.Builder().add(query, BooleanClause.Occur.MUST).add(pointRangeQuery, BooleanClause.Occur.MUST).build();

        String[] fields = {"name", "content"};
        String[] querys = {"apache","java"};
        Query parse = MultiFieldQueryParser.parse(querys, fields, analyzer);

        TopDocs search = indexSearcher.search(parse, pageSize);

        System.out.println("search = " + search.totalHits);

        ScoreDoc[] scoreDocs = search.scoreDocs;

        for (ScoreDoc scoreDoc : scoreDocs) {
            int docId = scoreDoc.doc;
            Document document = indexReader.document(docId);
            System.out.println("name = " + document.get("name"));
            System.out.println("size = " + Long.parseLong(document.get("size")));
        }

        return null;

    }

    public static String indexByLucene(String keyword) throws IOException {

        List<Document> documents = new ArrayList<>();

        File fileDir = new File("D:\\lucene\\searchsource");

        for (File file : Objects.requireNonNull(fileDir.listFiles())) {
            String name = file.getName();
            String content = FileUtils.readFileToString(file, "UTF-8");
            Long size = FileUtils.sizeOf(file);
            Document document = new Document();

            Field nameField = new TextField("name", name, Field.Store.YES);
            Field contentField = new TextField("content", content, Field.Store.YES);
            Field sizeField = new LongPoint("size", size);
            StoredField sizeField2 = new StoredField("size", size);

            document.add(nameField);
            document.add(contentField);
            document.add(sizeField);
            document.add(sizeField2);
            documents.add(document);

        }

        Analyzer analyzer = new StandardAnalyzer();

        File index = new File("D:\\lucene\\index");

        Directory indexDir = NIOFSDirectory.open(index.toPath());

        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);

        IndexWriter indexWriter = new IndexWriter(indexDir, indexWriterConfig);

        for (Document document : documents) {
            indexWriter.addDocument(document);
        }

        indexWriter.commit();

        indexWriter.close();

        return null;
    }

    public static void main(String[] args) throws IOException, ParseException {
//        indexByLucene("");
        searchByIndex("", 5);
    }
}
