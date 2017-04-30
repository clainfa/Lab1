package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	
	List <Word> dictionary = new ArrayList<Word>();
	
	
	public AlienDictionary() {
		
	}

	public void alienWord (String alienWord, String translation){
		for(Word w : dictionary){
			if(w.compare(alienWord)){
				w.setTranslation(translation);
				return;
			}else{
				Word word = new Word(alienWord, translation);
				dictionary.add(word);
			}
		}
	}
	
	public String traslateWord(String alienWord){
			for(Word w: dictionary){
			if(w.compare(alienWord)){
				return w.getTranslation();
			}
		}
			return null;
	}

}
