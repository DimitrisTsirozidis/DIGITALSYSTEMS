package services;

import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Menu {

	public static Scanner sc = new Scanner(System.in);
	public static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("uuuu-MM-dd", Locale.US)
		    .withResolverStyle(ResolverStyle.STRICT);


	// apo edo diavasa kai to ekana https://www.javatpoint.com/enum-in-java
	public enum SearchIn {
		title("0"), description("1"), content("2"), All("3");
		private String value;
	    private SearchIn(String value) {
	    	this.value = value;
	    }
	    public static List<String> validValues() {
	    	ArrayList<String> ret = new ArrayList<String>();
	    	for(SearchIn s : SearchIn.values()) {
	    		ret.add(s.value);
	    	}
	    	return ret;
	    }
	    public static int size() { return 4;}
	    
	    public static String returnedValue (String value) {
	    	String ret = null;
	    	switch (value){
	    		case "0":
	    			ret = "title";
	    			break;
	    		case "1":
	    			ret = "description";
	    			break;
	    		case "2":
	    			ret = "content";
	    			break;
	    		case "3":
	    			ret = null;
	    			break;	    			
	    	}
	    	return ret;
	    }
		public static String getParameter() {
			System.out.println(" ------- Please select Search Parameter -------- ");
			for (SearchIn s : SearchIn.values())  
				System.out.println(s.value +" --> "+s);  
			String ans = "";
			do {
				System.out.println("Please select Search parameter by Ordinal (0,1..)");
				ans = sc.nextLine();
			} while (!SearchIn.validValues().contains(ans));
			
		    return SearchIn.returnedValue(ans);
		}	    
	    
	}

	public static enum SortBy {
		relevancy("0"), popularity("1"), publishedAt("2"), Unsorted("3");
		private String value;
	    private SortBy(String value) {
	    	this.value = value;
	    }
	    public static List<String> validValues() {
	    	ArrayList<String> ret = new ArrayList<String>();
	    	for(SortBy s : SortBy.values()) {
	    		ret.add(s.value);
	    	}
	    	return ret;
	    }
	    
	    public static int size() { return 4;}
	    
	    public static String returnedValue (String value) {
	    	String ret = null;
	    	switch (value){
	    		case "0":
	    			ret = "relevancy";
	    			break;
	    		case "1":
	    			ret = "popularity";
	    			break;
	    		case "2":
	    			ret = "publishedAt";
	    			break;
	    		case "3":
	    			ret = null;
	    			break;	    			
	    	}
	    	return ret;
	    }	
		public static String getParameter() {
			System.out.println(" ------- Please select Sort Method -------- ");
			for (SortBy s : SortBy.values())  
				System.out.println(s.value +" --> "+s);  
			String ans = "";
			do {
				System.out.println("Please select Sort Method by Ordinal (0,1..)");
				ans = sc.nextLine();
			} while (!SortBy.validValues().contains(ans));
			
		    return SortBy.returnedValue(ans);
		}	    
	}


	public static enum Language {
		ar("0"), de("1"), en("2"), es("3"), fr("4"), he("5"), it("6"), nl("7"), no("8"), pt("9"), ru("10"), se("11"), ud("12"), zh("13"),Default("14");
		private String value;
	    private Language(String value) {
	    	this.value = value;
	    }
	    public static List<String> validValues() {
	    	ArrayList<String> ret = new ArrayList<String>();
	    	for(Language s : Language.values()) {
	    		ret.add(s.value);
	    	}
	    	return ret;
	    }
	    public static int size() { return 15;}
	    
	    public static String returnedValue (String value) {
	    	String ret = null;
	    	switch (value){
	    		case "0":
	    			ret = "ar";
	    			break;
	    		case "1":
	    			ret = "de";
	    			break;
	    		case "2":
	    			ret = "en";
	    			break;
	    		case "3":
	    			ret = "es";
	    			break;
	    		case "4":
	    			ret = "fr";
	    			break;
	    		case "5":
	    			ret = "he";
	    			break;
	    		case "6":
	    			ret = "it";
	    			break;
	    		case "7":
	    			ret = "nl";
	    			break;
	    		case "8":
	    			ret = "no";
	    			break;
	    		case "9":
	    			ret = "pt";
	    			break;
	    		case "10":
	    			ret = "ru";
	    			break;
	    		case "11":
	    			ret = "se";
	    			break;
	    		case "12":
	    			ret = "ud";
	    			break;
	    		case "13":
	    			ret = "zh";
	    			break;
	    		case "14":
	    			ret = null;
	    			break;
	    	}
	    	return ret;
	    }
		public static String getParameter() {
			System.out.println(" ------- Please select display language -------- ");
			for (Language s : Language.values())  
				System.out.println(s.value +" --> "+s);  
			String ans = "2";
			do {
				System.out.println("Please select Language by Ordinal (0,1..)");
				ans = sc.nextLine();
			} while (!Language.validValues().contains(ans));
			
		    return Language.returnedValue(ans);
		}
	    
	}

	public static enum Category {
		entertainment("0"), general("1"), health("2"), science("3"), sports("4"), technology("5"),All("6");
		private String value;
	    private Category(String value) {
	    	this.value = value;
	    }
	    public static List<String> validValues() {
	    	ArrayList<String> ret = new ArrayList<String>();
	    	for(Category s : Category.values()) {
	    		ret.add(s.value);
	    	}
	    	return ret;
	    }
	    
	    public static int size() { return 7;}
	    
	    public static String returnedValue (String value) {
	    	String ret = null;
	    	switch (value){
	    		case "0":
	    			ret = "entertainment";
	    			break;
	    		case "1":
	    			ret = "general";
	    			break;
	    		case "2":
	    			ret = "health";
	    			break;
	    		case "3":
	    			ret = "science";
	    			break;
	    		case "4":
	    			ret = "sports";
	    			break;
	    		case "5":
	    			ret = "technology";
	    			break;
	    		case "6":
	    			ret = null;
	    			break;	    			
	    	}
	    	return ret;
	    }		
		public static String getParameter() {
			System.out.println(" ------- Please select display Category -------- ");
			for (Category s : Category.values())  
				System.out.println(s.value +" --> "+s);  
			String ans = "";
			do {
				System.out.println("Please select Category by Ordinal (0,1..)");
				ans = sc.nextLine();
			} while (!Category.validValues().contains(ans));
			
		    return Category.returnedValue(ans);
		}
	    
	    
	    
	}

	public static enum Country {
		ae(), ar, at, au, be, bg, br, ca, ch, cn, co, cu, cz, de, eg, fr, gb, gr, hk, hu, id, ie, il, in, it, jp, kr, lt,
		lv, ma, mx, my, ng, nl, no, nz, ph, pl, pt, ro, rs, ru, sa, se, sg, si, sk, th, tr, tw, ua, us, ve, za
	}
	
	
	
	
	public static int mainMenu() {
		int ans = 4;
		do {
			System.out.println("|================================|");
			System.out.println("|            Main Menu           |");
			System.out.println("|--------------------------------|");
			System.out.println("|   1. Top news headlines        |");
			System.out.println("|   2. News                      |");
			System.out.println("|   3. Save 5 last Queries       |");
			System.out.println("|   0. Exit                      |");
			System.out.println("|--------------------------------|");
			System.out.println("|   Your Choice --> ");
			String sans = sc.nextLine();
			try {
				ans = Integer.parseInt(sans);
			} catch (NumberFormatException e) {
				System.out.println("Give only 0 to 3 NUMBERS !!!");
				ans = 4;
			}
		} while (ans < 0 || ans > 3);
		return ans;
	}

	public static int subMenuNews() {
		int ans = 3;
		do {
			System.out.println("\t|================================|");
			System.out.println("\t|             News               |");
			System.out.println("\t|--------------------------------|");
			System.out.println("\t|   1. Search By Criteria        |");
			System.out.println("\t|   2. From Search History       |");
			System.out.println("\t|   0. Exit                      |");
			System.out.println("\t|--------------------------------|");
			System.out.println("\t|   Your Choice --> ");
			String sans = sc.nextLine();
			try {
				ans = Integer.parseInt(sans);
			} catch (NumberFormatException e) {
				System.out.println("Give only 0 to 5 NUMBERS !!!");
				ans = 3;
			}
		} while (ans < 0 || ans > 3);
		return ans;
	}
	
	public static int subMenuTop() {
		int ans = 3;
		do {
			System.out.println("\t|================================|");
			System.out.println("\t|       Top news headlines       |");
			System.out.println("\t|--------------------------------|");
			System.out.println("\t|   1. Select All                |");
			System.out.println("\t|   2. specific category/country |");
			System.out.println("\t|   0. Exit                      |");
			System.out.println("\t|--------------------------------|");
			System.out.println("\t|   Your Choice --> ");
			String sans = sc.nextLine();
			try {
				ans = Integer.parseInt(sans);
			} catch (NumberFormatException e) {
				System.out.println("Give only 0 to 5 NUMBERS !!!");
				ans = 3;
			}
		} while (ans < 0 || ans > 3);
		return ans;
	}
	
	public static String getQ() {
		String ans = "" ;
		do {
			System.out.println("Please type your Query Word\n(for example : apple,  Type cancel for cancel)");	
			ans = sc.nextLine();
			if(ans.toLowerCase().equals("cancel")) return null;
		} while (ans.isBlank());
		return ans.toLowerCase();
	}
	
	
	public static String getDate(String startOrEnd) {
		String ans = "" ;
		do {
			if(startOrEnd.equals("Start")) System.out.println("Please type your Query Start date in USA format(YYYY-MM-DD)");	
			else if(startOrEnd.equals("End")) System.out.println("Please type your Query End date in USA format(YYYY-MM-DD)");
			System.out.println("(for example : 2022-20-31 Type cancel for cancel) ");
			ans = sc.nextLine();
			if(ans.toLowerCase().equals("cancel")) return null;
		} while (ans.isBlank() || !isValid(ans.toLowerCase()));
		return ans.toLowerCase();
	}
	
	
	public static boolean isValid(String d) {
		try {
			dateFormatter.parse(d);
		} catch (DateTimeParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Wrong date format.");
			return false;
		}
		return true;
	}
	

	public static boolean validTime(String t) {
		try {
			LocalTime.parse(t);
		} catch (DateTimeException e) {
			return false;
		}
		return true;
	}
	
	
	
	
	
	
}
