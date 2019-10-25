package dad.javafx.holamundo.fxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

//Tenemos que implementar esta interfaz para que sea inicializable

public class HolaMundoController implements Initializable {
	
	//model
	
	private StringProperty nombre = new SimpleStringProperty();
	private StringProperty saludo = new SimpleStringProperty();
	
	//view
	
	@FXML
	private VBox view;
	
	@FXML
	private TextField nameTxt;
	
	@FXML
	private Label saludoLbl;
	
	@FXML
	private Button helloBt;

	public HolaMundoController() throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/HolaMundoView.fxml"));
		loader.setController(this);  //Este será nuestro controlador
		loader.load();
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		nombre.bind(nameTxt.textProperty());
		
		saludoLbl.textProperty().bind(saludo);

	}
	
	public VBox getView() {
		return view;
	}
	
	@FXML
	private void onSaludarAction(ActionEvent e) {
		saludo.set("¡Hola " + nombre.get() + " !");
	}

}
