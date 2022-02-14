package news;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import exception.NewsAPIException;
import model.newsdb.NewsResult;
import services.NewsAPIService;
import services.Utils;

public class APITest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testApiResult() throws NewsAPIException {

		NewsAPIService apiS = new NewsAPIService("https://newsapi.org", "a8c89614f5294f1f8a3ebffea40fc875");
		String q = null, searchIn = null, title = null, from = null, to = null, language = null, sortBy = null,
				category = null, country = null;
		ArrayList<String> sources = null, domains = null, excludeDomains = null;
		q = "apple";
		from = "2022-02-04";
		to = "2022-02-04";
		sortBy = "popularity";
		
		NewsResult result = apiS.getAPITopHeadLines(q, searchIn, title, country, category, sources, domains,
				excludeDomains, from, to, language, sortBy);
		assertFalse(result == null);
		Utils.printResults(result);

	}

}
