package com.github.jinbeomdev.Luceneexample;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class FlightIndexReader {

  private static final String path = new File("src/main/resources").getAbsolutePath();

  private static final String INDEX_PATH = path + "/index/flight-index";

  private static Analyzer analyzer = new StandardAnalyzer();

  private Directory directory;

  private DirectoryReader ireader;

  private IndexSearcher isearcher;

  FlightIndexReader() {
    try {
      directory = FSDirectory.open(Paths.get(INDEX_PATH));
      ireader = DirectoryReader.open(directory);
      isearcher = new IndexSearcher(ireader);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  public ScoreDoc[] search(String column, String text) {
    try {
      QueryParser parser = new QueryParser(column, analyzer);
      Query query = parser.parse(text);
      return isearcher.search(query, 10).scoreDocs;
    } catch (ParseException ex) {
      ex.printStackTrace();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return null;
  }

  public Document getDoc(int doc) {
    try {
      return isearcher.doc(doc);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return null;
  }
}
