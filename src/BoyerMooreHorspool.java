import java.util.*;


public class BoyerMooreHorspool {
	
	private String text, pat;
	
	public BoyerMooreHorspool(String text, String pattern) {
		this.text = text;
		this.pat = pattern;
	}
	
	public BoyerMooreHorspool(CharSequence text) {
		text.toString().toCharArray();
		
	}
	
	
	public BoyerMooreHorspool(String text) {
		this(text, "");
	}
	
	// ずらす量を表すテーブルを作る
	private static Map<Character, Integer> makeSkipTable(char[] pat) {
		Map<Character, Integer> skipTable = new HashMap<>();
		for (int i = 0; i < pat.length - 1; i++) {
			skipTable.put(pat[i], pat.length - i - 1);
		}
		return skipTable;
	}
	

	public int search() {
		return match(this.text, this.pat);
	}
	// パターンが見つからない場合は-1を返す。
	public static int match(String texta, String pattern) {
		char[] text = texta.toCharArray();
		char[] pat = pattern.toCharArray();
		Map<Character, Integer> skipTable = makeSkipTable(pat);
		if (pat.length == 0) {
			throw new IllegalStateException("patternが設定されていないか文字数が0です。");
		}
		
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
	
	public int indexOf(String pattern) {
		this.pat = pattern;
		return search();
	}
	
	
	
}
