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

import java.io.*;
import java.nio.file.Paths;
import java.util.StringTokenizer;

public class FlightIndexWriter {

  private static final String path = new File("src/main/resources").getAbsolutePath();
  private static final String INDEX_PATH = path + "/index/flight-index";
  private static final String SOURCE_PATH = path + "/data/2008.csv";

  private static Analyzer analyzer = new StandardAnalyzer();

  private static IndexWriterConfig config = new IndexWriterConfig(analyzer);

  private Directory directory;

  private IndexWriter iwriter;

  FlightIndexWriter() {
    try {
      directory = FSDirectory.open(Paths.get(INDEX_PATH));
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

  public void index() {
    try {
      BufferedReader br = new BufferedReader(new FileReader(SOURCE_PATH));
      iwriter.deleteAll();

      FlightInfo info = new FlightInfo();
      String line;
      while ((line = br.readLine()) != null) {
        StringTokenizer st = new StringTokenizer(line, ",");
        info.setYear(st.nextToken());
        info.setMonth(st.nextToken());
        st.nextToken();
        st.nextToken();
        st.nextToken();
        st.nextToken();
        st.nextToken();
        st.nextToken();
        info.setUniqueCarrier(st.nextToken());
        st.nextToken();
        st.nextToken();
        st.nextToken();
        st.nextToken();
        st.nextToken();
        info.setArrDelay(st.nextToken());
        info.setDepDelay(st.nextToken());
        info.setOrigin(st.nextToken());
        info.setDest(st.nextToken());
        info.setDistance(st.nextToken());
        iwriter.addDocument(createDoc(info));
      }

      iwriter.commit();
      iwriter.close();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
