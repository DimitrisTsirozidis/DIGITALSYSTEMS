package services;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import exception.NewsAPIException;
import model.newsdb.ErrorResult;
import model.newsdb.NewsResult;

public class NewsAPIService {
	private String API_URL, API_KEY;
	private URIBuilder uriBuilder;
	private URI uri;

	public NewsAPIService(String aPI_URL, String aPI_KEY) {
		API_URL = aPI_URL;
		API_KEY = aPI_KEY;
	}

	public String getAPI_URL() {
		return API_URL;
	}

	public void setAPI_URL(String aPI_URL) {
		API_URL = aPI_URL;
	}

	public String getAPI_KEY() {
		return API_KEY;
	}

	public void setAPI_KEY(String aPI_KEY) {
		API_KEY = aPI_KEY;
	}

	// apiKey,q,searchIn = {title,description,content},title,sources,domains,excludeDomains,from,to,language,sortBy = {relevancy, popularity, publishedAt},pageSize,page
	public NewsResult getAPIEverithing( // edo everithing
			String q, // Keyword
			String searchIn, // {title,description,content}
			String title, // title
			ArrayList<String> sources, // Strings comma-seperated
			ArrayList<String> domains, // Strings comma-seperated
			ArrayList<String> excludeDomains, // Strings comma-seperated
			String from, // from date
			String to, // to date
			String language, // {ar,de,en, es,fr,he,it,nl,no,pt,ru,se,ud,zh}
			String sortBy // {relevancy, popularity, publishedAt}
	) throws NewsAPIException {
		try {
			uriBuilder = new URIBuilder(this.API_URL).setPathSegments("v2", "everything");
//	      			https://newsapi.org/v2/everything?q=apple&from=2022-02-04&to=2022-02-04&sortBy=popularity&apiKey=a8c89614f5294f1f8a3ebffea40fc875
// 					SOS Error occurred on API call: The category param is not currently supported on the /everything endpoint.
// 					SOS Error occurred on API call: The country param is not currently supported on the /everything endpoint.
			if (q != null && !q.isBlank()) {
				uriBuilder.addParameter("q", q);
			}
			if (searchIn != null && !searchIn.isBlank()) {
				uriBuilder.addParameter("searchIn", searchIn);
			}
			if (title != null && !title.isBlank()) {
				uriBuilder.addParameter("title", title);
			}
			if (sources != null && sources.size() != 0) {
				String sour = "";
				for (int i=0;i<sources.size();i++) {
					sour +=sources.get(i);
					if(i<sources.size()-1) sour += Character.toString(44);
					// ola ta parakato dokimastikan kai ola dinoun %2C alla to query doylevei opote...
//					if(i<domains.size()-1) sour += Character.toString(44);
//					if(i<domains.size()-1) sour += ",";
//					if(i<domains.size()-1) sour += "\u002C";
//					if(i<domains.size()-1) sour += ',';					
				}	
				uriBuilder.addParameter("sources", sour);
			}
			if (domains != null && domains.size() != 0) {
				String sour = "";
				for (int i=0;i<domains.size();i++) {
					sour +=domains.get(i);
					if(i<domains.size()-1) sour += ',';

				}	
				uriBuilder.addParameter("domains", sour);
			}
			if (excludeDomains != null && excludeDomains.size() != 0) {
				String sour = "";
				for (int i=0;i<excludeDomains.size();i++) {
					sour +=excludeDomains.get(i);
					if(i<excludeDomains.size()-1) sour += Character.toString(44);
				}	
				uriBuilder.addParameter("excludeDomains", sour);
			}

			if (from != null && !from.isBlank()) {
				uriBuilder.addParameter("from", from);
			}
			if (to != null && !to.isBlank()) {
				uriBuilder.addParameter("to", to);
			}
			if (language != null && !language.isBlank()) {
				uriBuilder.addParameter("language", language);
			}
			if (sortBy != null && !sortBy.isBlank()) {
				uriBuilder.addParameter("sortBy", sortBy);
			}
			
		} catch (URISyntaxException e) {
			throw new NewsAPIException("Unable to create request URI!!!", e);
		}

	    return getAPIData();
	}

	// Ftiaxtike gia na gyrizei top_headLines MONO
//	 apiKey country,category,sources,q,pageSize,page
	public NewsResult getAPITopHeadLines( // edo top-headlines
					String q, // Keyword
					String searchIn, // {title,description,content}
					String title, // title
					String country, // country
					String category, // category
					ArrayList<String> sources, // Strings comma-seperated
					ArrayList<String> domains, // Strings comma-seperated
					ArrayList<String> excludeDomains, // Strings comma-seperated
					String from, // from date
					String to, // to date
					String language, // {ar,de,en, es,fr,he,it,nl,no,pt,ru,se,ud,zh}
					String sortBy // {relevancy, popularity, publishedAt}
			) throws NewsAPIException {
				try {
					uriBuilder = new URIBuilder(this.API_URL).setPathSegments("v2", "top-headlines");
					if (q != null && !q.isBlank()) {
						uriBuilder.addParameter("q", q);
					}
					if (searchIn != null && !searchIn.isBlank()) {
						uriBuilder.addParameter("searchIn", searchIn);
					}
					if (title != null && !title.isBlank()) {
						uriBuilder.addParameter("title", title);
					}
					if (country != null && !country.isBlank()) {
						uriBuilder.addParameter("country", country);
					}
					if (category != null && !category.isBlank()) {
						uriBuilder.addParameter("category", category);
					}
					if (sources != null && sources.size() != 0) {
						String sour = "";
						for (int i=0;i<sources.size();i++) {
							sour +=sources.get(i);
							if(i<sources.size()-1) sour += ",";
						}	
						uriBuilder.addParameter("sources", sour);
					}
					if (domains != null && domains.size() != 0) {
						String sour = "";
						for (int i=0;i<domains.size();i++) {
							sour +=domains.get(i);
							if(i<domains.size()-1) sour += Character.toString(44);
						}	
						uriBuilder.addParameter("domains", sour);
					}
					if (excludeDomains != null && excludeDomains.size() != 0) {
						String sour = "";
						for (int i=0;i<excludeDomains.size();i++) {
							sour +=excludeDomains.get(i);
							if(i<excludeDomains.size()-1) sour += Character.toString(44);
						}	
						uriBuilder.addParameter("excludeDomains", sour);
					}

					if (from != null && !from.isBlank()) {
						uriBuilder.addParameter("from", from);
					}
					if (to != null && !to.isBlank()) {
						uriBuilder.addParameter("to", to);
					}
					if (language != null && !language.isBlank()) {
						uriBuilder.addParameter("language", language);
					}
					if (sortBy != null && !sortBy.isBlank()) {
						uriBuilder.addParameter("sortBy", sortBy);
					}
					
				} catch (URISyntaxException e) {
					throw new NewsAPIException("Unable to create request URI!!!", e);
				}

			    return getAPIData();
			}
	public NewsResult getAPIData() throws NewsAPIException {
		uriBuilder.addParameter("apiKey", API_KEY);
        String returnedString = null;
		try {
				uri = uriBuilder.build();
//				System.out.println(uri); // elegxos othotitas
			} catch (URISyntaxException e) {
				throw new NewsAPIException("Unable to build URI!!!", e);
			}
		HttpGet getRequest = new HttpGet(uri);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			CloseableHttpResponse httpResponse = httpClient.execute(getRequest);
			HttpEntity entity = httpResponse.getEntity();
			if (entity != null) {
		           returnedString = EntityUtils.toString(entity);
		           Utils.save5LastQueries(returnedString);   // save 5 last Queries
		        }			
			ObjectMapper mapper = new ObjectMapper();
			if (httpResponse.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				ErrorResult error = mapper.readValue(entity.getContent(), ErrorResult.class);
				if (error.getMessage() != null) {
					throw new NewsAPIException("Error occured on API call: " + error.getMessage());
				}
	
			}
	        return mapper.readValue(returnedString, NewsResult.class);
		} catch (IOException e) {
			throw new NewsAPIException("Error Requesting Data", e);
		}

			}

}

/*
 *************************************************************************************** EVERITHING ****************************************************** apiKey
 * REQUIRED Your API key. Alternatively you can provide this via the X-Api-Key
 * HTTP header.
 * 
 * q Keywords or phrases to search for in the article title and body.
 * 
 * Advanced search is supported here:
 * 
 * Surround phrases with quotes (") for exact match. Prepend words or phrases
 * that must appear with a + symbol. Eg: +bitcoin Prepend words that must not
 * appear with a - symbol. Eg: -bitcoin Alternatively you can use the AND / OR /
 * NOT keywords, and optionally group these with parenthesis. Eg: crypto AND
 * (ethereum OR litecoin) NOT bitcoin. The complete value for q must be
 * URL-encoded. Max length: 500 chars.
 * 
 * searchIn The fields to restrict your q search to.
 * 
 * The possible options are:
 * 
 * title description content Multiple options can be specified by separating
 * them with a comma, for example: title,content.
 * 
 * This parameter is useful if you have an edge case where searching all the
 * fields is not giving the desired outcome, but generally you should not need
 * to set this.
 * 
 * Default: all fields are searched. sources A comma-seperated string of
 * identifiers (maximum 20) for the news sources or blogs you want headlines
 * from. Use the /sources endpoint to locate these programmatically or look at
 * the sources index.
 * 
 * domains A comma-seperated string of domains (eg bbc.co.uk, techcrunch.com,
 * engadget.com) to restrict the search to.
 * 
 * excludeDomains A comma-seperated string of domains (eg bbc.co.uk,
 * techcrunch.com, engadget.com) to remove from the results.
 * 
 * from A date and optional time for the oldest article allowed. This should be
 * in ISO 8601 format (e.g. 2022-02-08 or 2022-02-08T10:26:30)
 * 
 * Default: the oldest according to your plan. to A date and optional time for
 * the newest article allowed. This should be in ISO 8601 format (e.g.
 * 2022-02-08 or 2022-02-08T10:26:30)
 * 
 * Default: the newest according to your plan. language The 2-letter ISO-639-1
 * code of the language you want to get headlines for. Possible options:
 * ardeenesfrheitnlnoptruseudzh.
 * 
 * Default: all languages returned. sortBy The order to sort the articles in.
 * Possible options: relevancy, popularity, publishedAt. relevancy = articles
 * more closely related to q come first. popularity = articles from popular
 * sources and publishers come first. publishedAt = newest articles come first.
 * 
 * Default: publishedAt pageSize int The number of results to return per page.
 * 
 * Default: 100. Maximum: 100. page int Use this to page through the results.
 * 
 * Default: 1. END OF EVERITHING
 * ******************************************************
 *************************************************************************************** 
 * TOP - HEADLINES ****************************************************** apiKey
 * REQUIRED Your API key. Alternatively you can provide this via the X-Api-Key
 * HTTP header.
 * 
 * country The 2-letter ISO 3166-1 code of the country you want to get headlines
 * for. Possible options:
 * aearataubebgbrcachcncocuczdeegfrgbgrhkhuidieilinitjpkrltlvmamxmyngnlnonzphplptrorsrusasesgsiskthtrtwuausveza.
 * Note: you can't mix this param with the sources param.
 * 
 * category The category you want to get headlines for. Possible options:
 * businessentertainmentgeneralhealthsciencesportstechnology. Note: you can't
 * mix this param with the sources param.
 * 
 * sources A comma-seperated string of identifiers for the news sources or blogs
 * you want headlines from. Use the /top-headlines/sources endpoint to locate
 * these programmatically or look at the sources index. Note: you can't mix this
 * param with the country or category params.
 * 
 * q Keywords or a phrase to search for.
 * 
 * pageSize int The number of results to return per page (request). 20 is the
 * default, 100 is the maximum.
 * 
 * page int Use this to page
 * 
 * 

	All articles mentioning Apple from yesterday, sorted by popular publishers first
	https://newsapi.org/v2/everything?q=apple&from=2022-02-04&to=2022-02-04&sortBy=popularity&apiKey=a8c89614f5294f1f8a3ebffea40fc875

	All articles about Tesla from the last month, sorted by recent first
	https://newsapi.org/v2/everything?q=tesla&from=2022-01-05&sortBy=publishedAt&apiKey=a8c89614f5294f1f8a3ebffea40fc875	

	Top business headlines in the US right now
	https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=a8c89614f5294f1f8a3ebffea40fc875
	https://newsapi.org/v2/top-headlines?apiKey=a8c89614f5294f1f8a3ebffea40fc875	

	Top headlines from TechCrunch right now 
	https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=a8c89614f5294f1f8a3ebffea40fc875

	All articles published by the Wall Street Journal in the last 6 months, sorted by recent first
	https://newsapi.org/v2/everything?domains=wsj.com&apiKey=a8c89614f5294f1f8a3ebffea40fc875
 * 
 * [
 * 	{
 *    "source": {"id":"techcrunch","name":"TechCrunch"},
 *    "author":"Romain Dillet,Nariko Mizoguchi",
 *    "title":"アップル、オランダのマッチングアプリの代替決済システム使用に手数料27％を請求へ",
 *    "description":"<a target=\"_blank\" href=\"https://techcrunch.com/2022/01/17/apple-app-store-dutch-antitrust-order/\" rel=\"noopener\">裁判所の命令</a>により、マッチングアプリの開発者はオランダでApple（アップル）のアプリ内課金システムを使用する必要はなくなった。また、これらの課金決済はAppleによって処理されないため、Appleはデジタル購入の際に通常の30％の手数料を取ることはない。しかし、サードパーティの決…",
 *    "url":"https://jp.techcrunch.com/2022/02/05/2022-02-04-apple-to-charge-27-fee-for-dutch-dating-apps-using-alternative-payment-options/",
 *    "urlToImage":"https://jp.techcrunch.com/wp-content/uploads/2022/02/Apple.jpeg?w=1024",
 *    "publishedAt":"2022-02-04T23:30:44Z",
 *    "content":"AppleAppleApple30Apple27\r\nApplesuperlikeboost\r\nAppleApple\r\nApple\r\nACM1\r\nApple50065000\r\nApple24\r\nAppleAppleApp Store327\r\nACMAppleApple27%VAT\r\nApp StoreApple27%\r\nApple\r\n2\r\nAppleAppleAPI\r\nAppleApple\r\nAp… [+60 chars]"
 *   },
 *   {
 *   "source":{"id":"techcrunch","name":"TechCrunch"},
 *   "author":"Alex Wilhelm,Nobuo Takahashi","title":"やった！ついにSnapが黒字に","description":"クラクションを鳴らせ、のぼりを立てろ、パレードをしよう。<a target=\"_blank\" href=\"https://s25.q4cdn.com/442043304/files/doc_financials/2021/q4/Q4'21-Earnings-Release.pdf\" rel=\"noopener\">Snap（スナップ）が黒字になった</a>。\r\n\r\nそれも、調整後EBITDA黒字のことでも、調整後営業利益黒字でも、悪名高き非GAAP純利益黒字でもない。「本物」の黒字だ。\r\n\r\n2021年第4四半期、…","url":"https://jp.techcrunch.com/2022/02/04/2022-02-03-snap-finally-did-it-yall/","urlToImage":"https://jp.techcrunch.com/wp-content/uploads/2022/02/snap-glitch1.jpg?w=1024","publishedAt":"2022-02-04T05:00:18Z","content":"Snap\r\nEBITDAGAAP\r\n20214Snap1342149330002510288000GAAP226026Snap\r\n16320726000\r\nSnap\r\n20214Other IncomeSnap23.5340.90\r\nAppleSnapOK20213AppleJeremi Gorman\r\nAppleATT\r\nMetaSnap\r\nSnap\r\nAmazonPayPalSpotifyN… [+61 chars]"},{"source":{"id":"techcrunch","name":"TechCrunch"},"author":"Kirsten Korosec,Nariko Mizoguchi","title":"Scale AIが人工知能関連で最もホットで新しい合成データゲームに参入","description":"Scale AI（スケールAI）が73億ドル（約8400億円）企業になるまでの道には、画像、テキスト、音声、動画などのリアルデータが敷き詰められていた。現在、その基盤を利用し、AIで最もホットで新しいカテゴリーの1つであるシンセティック（合成）データゲームに参入する。\r\n\r\n同社は米国時間2月2日に、機械学習エンジニアが既存の実世界のデータセットを強化するために使える製品「<a target=\"_blank\" href=\"https://scale.com/blog/scale-synthetic-ea\" rel…","url":"https://jp.techcrunch.com/2022/02/04/2022-02-02-scale-ai-gets-into-the-synthetic-data-game/","urlToImage":"https://jp.techcrunch.com/wp-content/uploads/2022/02/Scale-AI.jpeg?w=1024","publishedAt":"2022-02-04T01:00:01Z","content":"Scale AIAI738400AI1\r\n22Scale Synthetic2NinesApple3DJoel KronanderVivek Raju MuppallaUnity TechnologiesAI\r\nScalee\r\nCEOAlexandr Wang\r\nTechCrunch\r\nScaleTechCrunch1Kodiak RoboticsTractable AIScale\r\n450Sc… [+60 chars]"},{"source":{"id":"techcrunch","name":"TechCrunch"},"author":"Brian Heater,Hirokazu Kusakabe","title":"りんご収穫ロボットを復活させるために、Abundantの新オーナーがエクイティクラウドファンディングを計画","description":"2021年夏、ヘイワードに拠点を置くAbundant Robotics（アバンダント・ロボティクス）は、突然閉鎖してしまった。<a target=\"_blank\" href=\"https://jp.techcrunch.com/2021/12/30/2021-12-27-remembering-the-startups-we-lost-in-2021/\" rel=\"noopener\">多くのスタートアップ企業が失敗</a>しているが、これは難しいことで知られるロボット工学の世界にも当てはまる現象だ。しかし、新型コ…","url":"https://jp.techcrunch.com/2022/02/04/2022-02-02-abundants-new-owner-looks-to-revive-the-apple-picking-robot-through-equity-crowdfunding/","urlToImage":"https://jp.techcrunch.com/wp-content/uploads/2022/02/AR-Prototype-Stills-1-16.jpg?w=1024","publishedAt":"2022-02-04T02:30:22Z","content":"2021Abundant Robotics2\r\n2021\r\nWavemaker LabsMisoFuture Acres202110AbundantTechCrunchFuture AcresWavemaker LabsAbundant\r\nDiligent Robotics CEO\r\nMisoWavemakerCEOBuck JordanAbundanceCEOPiestroMisoWavema… [+196 chars]"},{"source":{"id":"techcrunch","name":"TechCrunch"},"author":"Igor Bonifacic","title":"Apple will reportedly hold its next hardware event in early March","description":"Apple will host its next hardware event sometime on or around March 8th, according to Bloomberg.  At the event, the company will reportedly announce the...","url":"https://techcrunch.com/2022/02/04/apple-will-reportedly-hold-its-next-hardware-event-in-early-march/","urlToImage":"https://s.yimg.com/ny/api/res/1.2/_NaVm4qbvcMZiC38XdG4.Q--/YXBwaWQ9aGlnaGxhbmRlcjt3PTEyMDA7aD04MDA-/https://s.yimg.com/uu/api/res/1.2/i_ffU7Uiu9l4NMsLDMKR4Q--~B/aD0zNDU2O3c9NTE4NDthcHBpZD15dGFjaHlvbg--/https://media.zenfs.com/en/techcrunch_350/9e3498658c064e8f1a82f6cc904ce6bd","publishedAt":"2022-02-04T21:34:47Z","content":"Apple will host its next hardware event sometime on or around March 8th, according to Bloomberg\r\n. At the event, the company will reportedly announce the third-generation iPhone SE\r\n, a refresh of th… [+1159 chars]"},{"source":{"id":"techcrunch","name":"TechCrunch"},"author":"Walter Thompson and Ram Iyer","title":"TechCrunch+ roundup: Stealth recruiting, virtual sales kickoffs, Google Cloud's Q4","description":"Hybrid events won't give teams a chance to bond over karaoke, but with a tight agenda and a compelling theme, you can create a virtual or hybrid SKO that...","url":"https://techcrunch.com/2022/02/04/techcrunch-roundup-stealth-recruiting-virtual-sales-kickoffs-google-clouds-q4/","urlToImage":"https://s.yimg.com/ny/api/res/1.2/skL5QBaLHWgIyvgfBZ5BvA--/YXBwaWQ9aGlnaGxhbmRlcjt3PTEyMDA7aD04NTk-/https://s.yimg.com/uu/api/res/1.2/HqRyJibOqH95xOPYcl2pXw--~B/aD0xMDAyO3c9MTQwMDthcHBpZD15dGFjaHlvbg--/https://media.zenfs.com/en/techcrunch_350/4f01c17425ad924337fa1530182626ec","publishedAt":"2022-02-04T21:16:32Z","content":"Traditionally, companies hold in-person sales kickoffs (SKOs) in January and February to network, educate sales teams about new products and devise strategies for the year ahead.\r\nThese days, the con… [+7709 chars]"},{"source":{"id":"techcrunch","name":"TechCrunch"},"author":"Romain Dillet","title":"Apple to charge 27% fee for Dutch dating apps using alternative payment options","description":"Following a court order, developers working on dating apps don’t have to use Apple’s in-app purchase system in the Netherlands.  If you haven’t kept track of...","url":"https://techcrunch.com/2022/02/04/apple-to-charge-27-fee-for-dutch-dating-apps-using-alternative-payment-options/","urlToImage":"https://s.yimg.com/ny/api/res/1.2/rudHW3pINaM4aRyixu59BA--/YXBwaWQ9aGlnaGxhbmRlcjt3PTEyMDA7aD02NzU-/https://s.yimg.com/uu/api/res/1.2/XK29bBg_mPaty7scm2vBJQ--~B/aD0xODAwO3c9MzIwMDthcHBpZD15dGFjaHlvbg--/https://media.zenfs.com/en/techcrunch_350/0841ebc26a7a038a7e0fe241595cbf44","publishedAt":"2022-02-04T12:13:20Z","content":"Following a court order, developers working on dating apps dont have to use Apples in-app purchase system in the Netherlands. And because those purchases arent handled by Apple, the company doesnt ta… [+3851 chars]"},{"source":{"id":"techcrunch","name":"TechCrunch"},"author":"Alex Wilhelm, Natasha Mascarenhas and Mary Ann Azevedo","title":"Taxing crypto only makes it stronger","description":"Hello and welcome back to Equity, a podcast about the business of startups, where we unpack the numbers and nuance behind the headlines.  Funding rounds from...","url":"https://techcrunch.com/2022/02/04/taxing-crypto-only-makes-it-stronger/","urlToImage":"https://s.yimg.com/ny/api/res/1.2/AsZThDcg3EYKHP137vW10g--/YXBwaWQ9aGlnaGxhbmRlcjt3PTEyMDA7aD02NzU-/https://s.yimg.com/uu/api/res/1.2/hi6fsgrtvOPwrwpKW6S5YQ--~B/aD0xMzg2O3c9MjQ2MzthcHBpZD15dGFjaHlvbg--/https://media.zenfs.com/en/techcrunch_350/a44a902a0d0176d3e4f994004b7979b7","publishedAt":"2022-02-04T15:00:18Z","content":"Hello and welcome back to Equity, a podcast about the business of startups, where we unpack the numbers and nuance behind the headlines.\r\nWe had the full crew aboard today, headed by our killer produ… [+1910 chars]"},{"source":{"id":"techcrunch","name":"TechCrunch"},"author":"Romain Dillet","title":"Apple to charge 27% fee for Dutch dating apps using alternative payment options","description":"Following a court order, developers working on dating apps don’t have to use Apple’s in-app purchase system in the Netherlands. And because those purchases aren’t handled by Apple, the company doesn’t take its usual 30% cut on digital purchases. But developer…","url":"http://techcrunch.com/2022/02/04/apple-to-charge-27-fee-for-dutch-dating-apps-using-alternative-payment-options/","urlToImage":"https://techcrunch.com/wp-content/uploads/2021/04/app-store-2021-pattern-wave-2021.jpg?w=711","publishedAt":"2022-02-04T12:13:20Z","content":"Following a court order, developers working on dating apps dont have to use Apples in-app purchase system in the Netherlands. And because those purchases arent handled by Apple, the company doesnt ta… [+3851 chars]"},{"source":{"id":"techcrunch","name":"TechCrunch"},"author":"Darrell Etherington","title":"Apple will reportedly hold its next hardware event in early March","description":"Apple will host its next hardware event sometime on or around March 8th, according to Bloomberg. The company will reportedly announce the third-generation iPhone SE and a refresh of the 2020 iPad Air.","url":"http://techcrunch.com/2022/02/04/apple-will-reportedly-hold-its-next-hardware-event-in-early-march/","urlToImage":"https://techcrunch.com/wp-content/uploads/2020/04/IMG_9749-2.jpg?w=600","publishedAt":"2022-02-04T21:34:47Z","content":"More posts by this contributor\r\nApple will host its next hardware event sometime on or around March 8th, according to Bloomberg\r\n. At the event, the company will reportedly announce the third-generat… [+1191 chars]"},{"source":{"id":"techcrunch","name":"TechCrunch"},"author":"Natasha Mascarenhas","title":"Taxing crypto only makes it stronger","description":"Hello and welcome back to Equity, a podcast about the business of startups, where we unpack the numbers and nuance behind the headlines. We had the full crew aboard today, headed by our killer production team Grace and Chris, and hosting crew Mary Ann, Natash…","url":"http://techcrunch.com/2022/02/04/taxing-crypto-only-makes-it-stronger/","urlToImage":"https://techcrunch.com/wp-content/uploads/2020/07/equity-podcast-2019-phone.jpg?w=711","publishedAt":"2022-02-04T15:00:18Z","content":"Hello and welcome back to Equity, a podcast about the business of startups, where we unpack the numbers and nuance behind the headlines.\r\nWe had the full crew aboard today, headed by our killer produ… [+1905 chars]"},{"source":{"id":"techcrunch","name":"TechCrunch"},"author":"Aisha Malik","title":"Spotify CEO hints HiFi tier delay is related to licensing issues","description":"Spotify CEO Daniel Ek has hinted that the delay of the streaming service’s HiFi subscription tier is related to licensing issues. Speaking to analysts and investors during Spotify’s quarterly and annual earnings release on Wednesday, Ek stated that the compan…","url":"http://techcrunch.com/2022/02/04/spotify-ceo-hints-hifi-tier-delay-is-related-to-licensing-issues/","urlToImage":"https://techcrunch.com/wp-content/uploads/2019/10/spotify-iphone.jpg?w=711","publishedAt":"2022-02-04T17:06:49Z","content":"Spotify CEO Daniel Ek has hinted that the delay of the streaming service’s HiFi subscription tier is related to licensing issues. Speaking to analysts and investors during Spotify’s quarterly and ann… [+3498 chars]"},{"source":{"id":"techcrunch","name":"TechCrunch"},"author":"Walter Thompson","title":"TechCrunch+ roundup: Stealth recruiting, virtual sales kickoffs, Google Cloud’s Q4","description":"“You’ve got to spend money to make money” is a cliché, but if you’re building a company that hopes to compete in the cloud, it’s just a fact.","url":"http://techcrunch.com/2022/02/04/techcrunch-roundup-stealth-recruiting-virtual-sales-kickoffs-google-clouds-q4/","urlToImage":"https://techcrunch.com/wp-content/uploads/2022/02/GettyImages-1324729821.jpg?w=559","publishedAt":"2022-02-04T21:16:32Z","content":"Traditionally, companies hold in-person sales kickoffs (SKOs) in January and February to network, educate sales teams about new products and devise strategies for the year ahead.\r\nThese days, the con… [+6763 chars]"}]}
 * 
 */
