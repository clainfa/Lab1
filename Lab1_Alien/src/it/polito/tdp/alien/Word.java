package it.polito.tdp.alien;

public class Word {
	private String alienWord;
	private String translation;

	public Word() {
		super();
	}

	public Word(String alienWord, String translation) {
		this.alienWord = alienWord;
		this.translation = translation;
	}

	public boolean compare(String alien) {
		if (alien.compareTo(alienWord) == 0)
			return true;
		return false;
	}

	public boolean compareWild(String alienWild) {
		if (alienWord.matches(alienWild))
			return true;
		return false;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String trans) {
		translation = trans;
	}

}
