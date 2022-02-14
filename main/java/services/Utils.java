package services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.newsdb.Article;
import model.newsdb.NewsResult;

public class Utils {

	public static final int DEFAULT_PAGE_SIZE = 100;
	public static final int DEFAULT_PAGE = 1;

	private static final File file1 = new File("savedLast5Queries.dis"); // Ek tou Dimitrios tsirozidIS
	private static final File file2 = new File("saved5Last5Results.dis"); // Ek tou Dimitrios tsirozidIS

	public static ArrayList<String> sources = new ArrayList<String>();

	public static ArrayList<String> last5Queries = new ArrayList<String>();
	public static ArrayList<NewsResult> last5Results = new ArrayList<NewsResult>(5);

	public static void printResults(NewsResult result) {
		int i = 1;
		System.out.println(
				"\n***************************************************** RESULT ************************************************************\n");
		System.out.println("Status " + result.getStatus());
		System.out.println("Total Results " + result.getTotalResults());

		for (Article a : result.getArticles()) {
			System.out.println("\n-------------------------------------------------- Article " + i++
					+ " -------------------------------------------\n");

			System.out.println("id.......... : " + (a.getSource().getId() != null ? a.getSource().getId() : " -- "));
			System.out
					.println("Name........ : " + (a.getSource().getName() != null ? a.getSource().getName() : " -- "));
			System.out.println("Author...... : " + (a.getAuthor() != null ? a.getAuthor() : " -- "));
			System.out.println("Title....... : " + (a.getTitle() != null ? a.getTitle() : " -- "));
			System.out.println("Description. : " + (a.getDescription() != null ? a.getDescription() : " -- "));
			System.out.println("URL......... : " + (a.getUrl() != null ? a.getUrl() : " -- "));
			System.out.println("Image URL... : " + (a.getUrlToImage() != null ? a.getUrlToImage() : " -- "));
			System.out.println("Published At : " + (a.getPublishedAt() != null ? a.getPublishedAt() : " -- "));
			System.out.println("Content..... : " + (a.getContent() != null ? a.getContent() : " -- "));

		}

		System.out.println(
				"\n************************************************************************************************************************\n");
		
		save5LastResults(result);
	}

	public static void save5LastQueries(String query) {
		if (last5Queries.size() < 4)
			last5Queries.add(query);
		else {
			last5Queries.remove(0); // Xou to paliotero
			last5Queries.add(query); // Ntou to kainourgio
		}
	}

	private static void save5LastResults(NewsResult result) {
		if (last5Results.size() < 4)
			last5Results.add(result);
		else {
			last5Results.remove(0); // Xou to paliotero
			last5Results.add(result); // Ntou to kainourgio
		}
	}

	public static void writeToDisk() {
		try {
			FileOutputStream fOStream1 = new FileOutputStream(file1);
			FileOutputStream fOStream2 = new FileOutputStream(file2);
			try {
				ObjectOutputStream out = new ObjectOutputStream(fOStream1);
				out.writeObject(last5Queries);
				out.close();
				fOStream1.close();
				System.out.println("last 5 queries has been written");

				ObjectOutputStream out2 = new ObjectOutputStream(fOStream2);
				out2.writeObject(last5Results);
				out2.close();
				fOStream2.close();
				System.out.println("last 5 Results has been written");

			} catch (IOException e1) {
				e1.printStackTrace();
			}

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public static void restore5LastFromDisk() {
		if (file1.exists() && !file1.isDirectory()) {
			last5Queries.clear();
			try {
				FileInputStream fIStream1 = new FileInputStream(file1);
				ObjectInputStream input1 = new ObjectInputStream(fIStream1);
				last5Queries = (ArrayList<String>) input1.readObject();
				input1.close();
				fIStream1.close();
				System.out.println("last 5 queries Read successfully from Disk!!!");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (file2.exists() && !file2.isDirectory()) {
			last5Results.clear();
			try {

				FileInputStream fIStream2 = new FileInputStream(file2);
				ObjectInputStream input2 = new ObjectInputStream(fIStream2);
				last5Results = (ArrayList<NewsResult>) input2.readObject();
				input2.close();
				fIStream2.close();
				System.out.println("last 5 Results Read successfully from Disk!!!");

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public static void display5LastQueries() {
		int i = 1;
		if(last5Queries.size()>0) {
		System.out.println("---------------------------------------------------------------");
		for (String q : last5Queries) {
			System.out.println("\t" + i + " -- " + q);
			i++;
		}
		System.out.println("---------------------------------------------------------------");
		System.out.println("Please select a Query with order number ");
		}
		else {
			System.out.println("Nothing save yet!!!");
			return;
		}
		int ans = 6;
		do {
			String sans = Menu.sc.nextLine();
			try {
				ans = Integer.parseInt(sans);
			} catch (NumberFormatException e) {
				System.out.println("Give only 0 to 5 NUMBERS !!!");
				ans = 6;
			}
		} while (ans < 0 || ans > 5);
        if(ans>=0 && ans<=5 && last5Results.size()>0)
		printResults(last5Results.get(ans));
	}

//	public static ArrayList<String> readParametersForEverethingQuery(){
//		ArrayList<Object> parameters  = new ArrayList<Object>();
////		for(int i =0 ; i<10; i++) parameters.add(null); // 4,5, 6 eiNA aRRAY lIST cancel 
//		System.out.println("Please Enter the keyword (cancel for cancel this job)");
//		
//	
//		do {
//			q = Menu.sc.nextLine();
//			if(q.toLowerCase().equals("cansel")) return null;
//		}while(!q.equals(""));
//		
//		
//		
//		/*
//		1. String q, // Keyword
//		2. String searchIn, // {title,description,content}
//		3. String title, // title
//		4. ArrayList<String> sources, // Strings comma-seperated
//		5. ArrayList<String> domains, // Strings comma-seperated
//		6. ArrayList<String> excludeDomains, // Strings comma-seperated
//		7. String from, // from date
//		8. String to, // to date
//		9. String language, // {ar,de,en, es,fr,he,it,nl,no,pt,ru,se,ud,zh}
//		10.String sortBy // {relevancy, popularity, publishedAt}
//		*/
//		
//		
//		return null;
//	}

}
