package com.github.jinbeomdev.Luceneexample;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Paths;

public class FlightIndexWriter {

  private static final String PATH = System.getProperty("user.dir") + "/tmp/flight-index";

  private static Analyzer analyzer = new StandardAnalyzer();

  private static IndexWriterConfig config = new IndexWriterConfig(analyzer);

  private Directory directory;

  private IndexWriter iwriter;

  FlightIndexWriter() {
    try {
      directory = FSDirectory.open(Paths.get(PATH));
      iwriter = new IndexWriter(directory, config);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  public Document createDoc(FlightInfo info) {
    Document doc = new Document();
    doc.add(new Field("Year", info.getYear(), TextField.TYPE_STORED));
    doc.add(new Field("Month", info.getMonth(), TextField.TYPE_STORED));
    doc.add(new Field("UniqueCarrier", info.getUniqueCarrier(), TextField.TYPE_STORED));
    doc.add(new Field("ArrDelay", info.getArrDelay(), TextField.TYPE_STORED));
    doc.add(new Field("DepDelay", info.getDepDelay(), TextField.TYPE_STORED));
    doc.add(new Field("Origin", info.getOrigin(), TextField.TYPE_STORED));
    doc.add(new Field("Dest", info.getDest(), TextField.TYPE_STORED));
    doc.add(new Field("Distance", info.getDistance(), TextField.TYPE_STORED));
    return doc;
  }

  public void index(FlightInfo info) {
    try {
      iwriter.addDocument(createDoc(info));
      iwriter.close();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
