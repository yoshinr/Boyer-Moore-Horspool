import java.util.Map;
import java.util.HashMap;

public class BoyerMooreHorspool {
	
	private char[] text, pat;
	// 文字とそれに対応する移動できる文字数を持つ。
	private Map<Character, Integer> skipTable = new HashMap<>();
	
	public BoyerMooreHorspool(String text, String pattern) {
		this.text = text.toCharArray();
		this.pat = pattern.toCharArray();
		makeSkipTable();
	}
	
	// ずらす量を表すテーブルを作る。
	private void makeSkipTable() {
		for (int i = 0; i < pat.length - 1; i++) {
			this.skipTable.put(pat[i], pat.length - i - 1);
		}
	}
	
	// パターンが見つからない場合は-1を返す。
	public int search() {
		int lastIndexOfText = pat.length - 1;
		while (lastIndexOfText < text.length) {
			int textI = lastIndexOfText;
			int patI = pat.length - 1;
			while(text[textI] == pat[patI]) {
				if (patI == 0) return textI; // パッターンに一致する部分が見つかったので、見つかった位置の添字を返す。
				textI--;
				patI--;
			}
			lastIndexOfText += skipTable.getOrDefault(text[lastIndexOfText], pat.length);
		}
		return -1; // 見つからなかった。
	}
	
}
