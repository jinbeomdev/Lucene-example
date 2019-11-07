package com.github.jinbeomdev.Luceneexample;

	import org.apache.lucene.search.ScoreDoc;
	import org.junit.jupiter.api.Test;
	import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LuceneExampleApplicationTests {

	@Test
	void contextLoads() {

	}

	@Test
	void 인덱싱() {
		FlightIndexWriter flightIndexWriter = new FlightIndexWriter();
		flightIndexWriter.index();
	}

	@Test
	void 검색() {
		FlightIndexReader flightIndexReader = new FlightIndexReader();
		ScoreDoc[] scoreDocs = flightIndexReader.search("Dest", "TPA");
		for (ScoreDoc scoreDoc : scoreDocs) {
			System.out.println(flightIndexReader.getDoc(scoreDoc.doc));
		}
	}
}
