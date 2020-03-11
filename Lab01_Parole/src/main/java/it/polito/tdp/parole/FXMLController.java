package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Parole parole;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextField txtTempo;
    
    @FXML
    private TextArea txtResult;

    @FXML
    private Button btmCancella;
    
    @FXML
    private Button btnReset;

    @FXML
    void doInsert(ActionEvent event) {
    	long tempoiniziale = System.nanoTime();
    	String p = txtParola.getText();
    	if(p.length()==0)
    		return;
    	txtResult.clear();
    	if(parole.parolaCorretta(p)==false)
    		txtResult.appendText("La parola inserita non è nel formato corretto! Riprova");
    	else
    	{
    		parole.addParola(p);
    		for(String s : parole.getElenco())
        		txtResult.appendText(s+"\n");
    	}
    	txtParola.clear();
    	long tempofinale = System.nanoTime();
    	String tempo = String.valueOf(tempofinale-tempoiniziale);
    	txtTempo.setText(tempo);
    	//non trovo errore inserimento ?????zzz
    }

    @FXML
    void doReset(ActionEvent event) {
    	long tempoiniziale = System.nanoTime();
    	parole.reset();
    	txtResult.clear();
    	long tempofinale = System.nanoTime();
    	String tempo = String.valueOf(tempofinale-tempoiniziale);
    	txtTempo.setText(tempo);
    }
    
    @FXML
    void doDelete(ActionEvent event) {
    	long tempoiniziale = System.nanoTime();
    	String p = txtResult.getSelectedText();
    	parole.deleteParola(p);
    	txtResult.clear();
    	for(String s :  parole.getElenco())
    		txtResult.appendText(s+"\n");
    	long tempofinale = System.nanoTime();
    	String tempo = String.valueOf(tempofinale-tempoiniziale);
    	txtTempo.setText(tempo);
    	
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btmCancella != null : "fx:id=\"btmCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTempo != null : "fx:id=\"txtTempo\" was not injected: check your FXML file 'Scene.fxml'.";
        
        parole = new Parole();
    }
}