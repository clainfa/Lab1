package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	private List<WordEnhanced> dictionary = new ArrayList<WordEnhanced>();

	public void addWord(String alien, String trans) {
		for (WordEnhanced w : dictionary) {
			if (w.compare(alien)) {
				w.setTranslation(trans);
				return;
			}
		}
		WordEnhanced w = new WordEnhanced(alien, trans);
		dictionary.add(w);
	}

	public String translateWord(String alien) {
		for (WordEnhanced w : dictionary) {
			if (w.compare(alien)) {
				return w.getTranslation();
			}
		}
		return null;
	}

	public String translateWordWildCard(String alienWildCard) {

		// Utilizzo le regual expression di Java.
		// Sostituisco il punto interrogativo con il punto.
		// Il punto indica qualsiasi carattere (posso usare stringa.matches())
		alienWildCard = alienWildCard.replaceAll("\\?", ".");

		int matchCounter = 0;
		StringBuilder sb = new StringBuilder();

		for (WordEnhanced w : dictionary) {
			if (w.compareWild(alienWildCard)) {
				matchCounter++;
				sb.append(w.getTranslation() + "\n");
			}
		}

		if (matchCounter != 0)
			return sb.toString();
		else
			return null;
	}

}
