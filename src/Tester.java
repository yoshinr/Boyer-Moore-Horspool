
public class Tester {
	
	public static void main(String[] args) {
		String text = "abdabcfefe";
		String pattern = "abc";
		
		BoyerMooreHorspool searcher = new BoyerMooreHorspool(text, pattern);
		int index = searcher.search();
		
		if (index > 0) {
			System.out.println("Found at index: " + index);
		} else {
			System.out.println("Not Found");
		}
	}
	
}
