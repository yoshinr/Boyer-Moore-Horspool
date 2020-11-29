
public class Tester {

	public static void main(String[] args) {
		// 作成日: 2020/11/29

		String text = "abdabcfefe";
		String pattern = "ef";

		BoyerMooreHorspool searcher = new BoyerMooreHorspool(text, pattern);

		int index = searcher.search();
		if (index >= 0) {
			System.out.println("Found! index: " + index);
		} else {
			System.out.println("Not Found");
		}
		
		// 実行結果
		// Found! index: 7

	}

}
