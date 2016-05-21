package it.polito.tdp.bar;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.bar.model.BarModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class BarController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnStart;

    @FXML
    private TextArea txtResult;

    private BarModel m;
    
    public void setModel(BarModel m){
    	this.m = m;
    }
    
    @FXML
    void doStart(ActionEvent event) {
    	m.simulate();
    	txtResult.setText(String.format("Clienti ricevuti: %d\nClienti soddisfatti: %d\nClienti insoddisfatti: %d", m.getStat().getCustomers(), m.getStat().getSatisfied(), m.getStat().getUnsatisfied()));
    	return;
    }

    @FXML
    void initialize() {
        assert btnStart != null : "fx:id=\"btnStart\" was not injected: check your FXML file 'Bar.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Bar.fxml'.";

    }
}
