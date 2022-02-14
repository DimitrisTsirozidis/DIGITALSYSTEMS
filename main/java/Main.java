import java.util.ArrayList;

import exception.NewsAPIException;
import model.newsdb.NewsResult;
import services.Menu;
import services.Menu.Category;
import services.Menu.Language;
import services.Menu.SearchIn;
import services.Menu.SortBy;
import services.NewsAPIService;
import services.Utils;

public class Main {
	 private static int choice =0;
	 private static int subChoice = 0;	 
	 

	public static void main(String[]  args) {
		 Utils.restore5LastFromDisk(); // Restore last 5 queries and results from disk 
		 NewsAPIService apiS  = new NewsAPIService("https://newsapi.org","a8c89614f5294f1f8a3ebffea40fc875");
		 String q=null,searchIn=null,title=null,from=null,to=null,language=null,sortBy=null,category = null,country=null;
		 ArrayList<String> sources=null,domains=null,excludeDomains=null;
		 
		while(true) {
			choice = Menu.mainMenu();
			if(choice ==1 ) {       // ---------------------------------------------------------------- Main Menu  Top news headlines
				subChoice = Menu.subMenuTop();
				if(subChoice ==1 ) {       // ====================================== Sub Menu Top news headlines no Criteria
					q = Menu.getQ();
					if(q==null) continue;
					sortBy = SortBy.getParameter(); // {relevancy, popularity, publishedAt}
					NewsResult result = null;
					try {
						result = apiS.getAPITopHeadLines(q,searchIn,title,country,category,sources,domains,excludeDomains,from,to,language,sortBy);
					} catch (NewsAPIException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		            Utils.printResults(result);  // Print results
				}
				else if(subChoice ==2 ) {  // ====================================== Sub Menu Top news headlines with criteria
					q = Menu.getQ();
					if(q==null) continue;
					searchIn=SearchIn.getParameter(); // {title,description,content}
					title=null;
					from=Menu.getDate("Start");
					to=Menu.getDate("End");
					System.out.println("Start date = "+from);
					System.out.println("End date = "+to);
					category = Category.getParameter(); // category
					sources = null; // Strings comma-seperated
					domains = null; // Strings comma-seperated
					excludeDomains=null; // Strings comma-seperated
					language = Language.getParameter(); // {ar,de,en, es,fr,he,it,nl,no,pt,ru,se,ud,zh}
					sortBy = SortBy.getParameter(); // {relevancy, popularity, publishedAt}
					NewsResult result = null;
					try {
						
						result = apiS.getAPITopHeadLines(q,searchIn,title,country,category,sources,domains,excludeDomains,from,to,language,sortBy);
					} catch (NewsAPIException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		            Utils.printResults(result);  // Print results					
				}
				else if(choice ==0 ) {     // ====================================== Sub Menu Top news headlines Exit
					break;
				}
			}
			else if(choice ==2 ) {  // --------------------------------------------------------------- Main Menu  News
				subChoice = Menu.subMenuNews();
				if(subChoice ==1 ) {       // ====================================== Sub Menu News
					q = Menu.getQ();
					if(q==null) continue;
					searchIn=SearchIn.getParameter();
					title=null;
					from=Menu.getDate("Start");
					to=Menu.getDate("End");
					language=Language.getParameter();
					sortBy=SortBy.getParameter();
					
					NewsResult result = null;
					try {
						result = apiS.getAPIEverithing(q,searchIn,title,sources,domains,excludeDomains,from,to,language,sortBy);
					} catch (NewsAPIException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		            Utils.printResults(result);  // Print results
				}
				else if(subChoice ==2 ) {  // ====================================== Sub Menu news with criteria
					domains=new ArrayList<String>();
					domains.add("techcrunch.com");
					domains.add("thenextweb.com");
					q = Menu.getQ();
					if(q==null) continue;
					searchIn=SearchIn.getParameter();
					title=null;
					from=Menu.getDate("Start");
					to=Menu.getDate("End");
					language=Language.getParameter();
					sortBy=SortBy.getParameter();
					
					NewsResult result = null;
					try {
						result = apiS.getAPIEverithing(q,searchIn,title,sources,domains,excludeDomains,from,to,language,sortBy);
					} catch (NewsAPIException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		            Utils.printResults(result);  // Print results					
				}
				else if(choice ==0 ) {     // ====================================== Sub Menu news 
					break;
				}
				
			}
			else if(choice ==3 ) { // --------------------------------------------------------------- Main Menu  Save 5 last Queries
				
			}
			else if(choice ==0 ) { // --------------------------------------------------------------- Main Menu Exit
				System.out.println("Thanks for Use\nBye Bye!!!\n");
				break;
			}
		}
	}
}

