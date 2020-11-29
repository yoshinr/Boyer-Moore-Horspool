
public class Tester {
	public static void main(String[] args) {
		String text = "abdabcfefe";
		String pattern = "abc";
		BoyerMooreHorspool bmh = new BoyerMooreHorspool(text, pattern);
		System.out.println(bmh.search());
		System.out.println(bmh.indexOf("da"));
	}
}
