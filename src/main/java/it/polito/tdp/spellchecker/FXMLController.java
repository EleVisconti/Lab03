package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {
	
	List <String> inputTextList = new ArrayList <String>();

	private Dictionary model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label errorsTxt;

    @FXML
    private ComboBox<String> language;

    @FXML
    private TextArea paroleErrate;

    @FXML
    private TextArea testoUtente;

    @FXML
    private Label timeTxt;

    @FXML
    void doClearText(ActionEvent event) {
       model.getDictionary().clear();
       errorsTxt.setText("Errors contained");
       paroleErrate.clear();
       testoUtente.clear();
       timeTxt.setText("Time");
       inputTextList.clear();
       model.setNumErrori(0);
    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    float start = System.currentTimeMillis();
    if (language.getValue()==null) {
    	paroleErrate.setText("you must insert a language!");
    	return;}
     model.loadDictionary(language.getValue());
     String txtUtente= testoUtente.getText();
     txtUtente.replace("“[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
     String array[] = txtUtente.split(" ");
     for(String s : array)
    	 inputTextList.add(s);
     String stampa="";
     for(RichWord s : model.spellChecktext(inputTextList)) {
    	 if(stampa.equals(""))
    		 stampa+=s.getParola();
    	 else
    		 stampa+="\n"+s.getParola();
     } 
     float end = System.currentTimeMillis();
     paroleErrate.setText(stampa);
     timeTxt.setText("Spell check completed in "+Float.toString(end-start)+" seconds");
     errorsTxt.setText("The text contains "+Integer.toString(model.getNumErrori())+" errors");
     
    }

    @FXML
    void initialize() {
        assert errorsTxt != null : "fx:id=\"errorsTxt\" was not injected: check your FXML file 'Scene.fxml'.";
        assert language != null : "fx:id=\"language\" was not injected: check your FXML file 'Scene.fxml'.";
        assert paroleErrate != null : "fx:id=\"paroleErrate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert testoUtente != null : "fx:id=\"testoUtente\" was not injected: check your FXML file 'Scene.fxml'.";
        assert timeTxt != null : "fx:id=\"timeTxt\" was not injected: check your FXML file 'Scene.fxml'.";
 
        language.getItems().clear();
		language.getItems().add("English");
		language.getItems().add("Italian");
    }
    
    public void setModel(Dictionary model) {
		this.model=model;
		
	}

}

