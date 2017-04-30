package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	private AlienDictionary alienDictionary = new AlienDictionary();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtWord;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doReset(ActionEvent event) {
    	txtWord.clear();
    	txtResult.clear();

    }

    @FXML
    void doTranslate(ActionEvent event) {
    	txtResult.clear();
    	String riga = txtWord.getText().toLowerCase();
    	if(riga==null || riga.length() ==0){
    		txtResult.setText("Inserire una o due parola.");
    		return;
    	}
    	StringTokenizer st = new StringTokenizer(riga, " ");
    	String alienWord = st.nextToken();
    	if(st.hasMoreTokens()){
    		String traslation = st.nextToken();
    		if(!alienWord.matches("[a-zA-Z]*")|| !traslation.matches("[a-zA-Z]*")){
    			txtResult.setText("Inserire solo caratteri alfabetici");
    			return;
    		}
    		alienDictionary.alienWord(alienWord, traslation);
    		txtResult.setText("La parola è: "+alienWord+"\nla cui traduzione è: "+traslation);
    	}else{
    		//vedo se la parola è corretta
    		if(!alienWord.matches("[a-zA-Z]*")){
    			txtResult.setText("Inserire solo caratteri alfabetici");
    		}
    		String translation = alienDictionary.traslateWord(alienWord);
    		if(translation==null || translation.length()==0){
    			txtResult.setText("La parola cercata non esiste nel dizionario");
    		}
    		alienDictionary.alienWord(alienWord, translation);
    	}
  }

    @FXML
    void initialize() {
        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";

    }
}

