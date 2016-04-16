package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class WordEnhanced extends Word {
	private String alienWord;
	private List<String> translations = new ArrayList<String>();

	public WordEnhanced(String alienWord, String translation) {
		this.alienWord = alienWord;
		translations.add(translation);
	}

	public boolean compareWild(String alienWild) {
		if (alienWord.matches(alienWild))
			return true;
		return false;
	}

	@Override
	public boolean compare(String alienInput) {
		if (alienWord.compareTo(alienInput) == 0) {
			return true;
		}
		return false;
	}

	@Override
	public String getTranslation() {
		String s = "";
		for (String a : translations) {
			s += a + "\n";
		}
		return s;
	}

	@Override
	public void setTranslation(String translation) {

		if (!translations.contains(translation)) {
			translations.add(translation);
		}
	}

	public String getAlien() {
		return alienWord;
	}

}
