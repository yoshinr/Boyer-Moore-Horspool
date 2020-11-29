import java.util.Map;
import java.util.HashMap;

public class BoyerMooreHorspool {

	private char[] text, pat;
	// 文字とそれに対応する移動できる文字数を持つ。
	private Map<Character, Integer> skipTable = new HashMap<>();

	public BoyerMooreHorspool(char[] text, char[] pattern) {
		setText(text);
		setPattern(pattern);
	}

	public BoyerMooreHorspool(String text, String pattern) {
		setText(text);
		setPattern(pattern);
	}

	public void setText(char[] text) {
		if (text.length == 0) throw new IllegalArgumentException("textが0文字です。");
		this.text = text;
	}

	public void setText(String text) {
		setText(text.toCharArray());
	}

	public void setPattern(char[] pattern) {
		if (pattern.length == 0) throw new IllegalArgumentException("patternが0文字です。");
		this.pat = pattern;
		makeSkipTable();
	}

	public void setPattern(String pattern) {
		setPattern(pattern.toCharArray());
	}

	public String getText() {
		return text.toString();
	}

	public String getPattern() {
		return pat.toString();
	}

	// ずらす量を表すテーブルを作る。
	protected void makeSkipTable() {
		skipTable.clear();
		for (int i = 0; i < pat.length - 1; i++) {
			skipTable.put(pat[i], pat.length - i - 1);
		}
	}

	// パターンが見つからない場合は-1を返す。
	public int search() {
		int lastIndexOfText = pat.length - 1;
		while (lastIndexOfText < text.length) {
			int textI = lastIndexOfText;
			int patI = pat.length - 1;
			while (text[textI] == pat[patI]) {
				if (patI == 0) return textI; // パッターンに一致する部分が見つかったので、見つかった位置の添字を返す。
				textI--;
				patI--;
			}
			lastIndexOfText += skipTable.getOrDefault(text[lastIndexOfText], pat.length);
		}
		return -1; // 見つからなかった。
	}

}
