package poids.vue;

import java.text.DecimalFormat;

import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import poids.modele.Poids;

public class ControleurPoids {
	@FXML
	private Slider slidCirconf;
	@FXML
	private Label lCirconf;
	@FXML
	private Spinner<Integer> spinTaille;
	@FXML
	private Label lPoids;
	private Poids poids;
	
	/**
	* Le constructeur est appelé avant la méthode initialize()
	*
	*/
	public ControleurPoids() {
	}
	/**
	* Initialise le controleur. Cette méthode est automatiquement appelée
	* dès que le fichier fxml est chargé.
	*/
	@FXML
	private void initialize() {
	// Initialise les données au démarrage.
	float circonference = 18.2f;
	int taille = 160;
	poids = new Poids(circonference, taille);
	// Ecouteur sur le slider pour modifier le label quand la circonference change et recalcul du poids.
	slidCirconf.valueProperty().addListener((observable, oldValue, newValue) -> circonfChanged(newValue));
	// Ecouteur sur le spinner pour modifier la taille et refaire le calcul du poids.
	spinTaille.valueProperty().addListener((observable, oldValue, newValue) -> tailleChanged(newValue));
	// Initialise les composants de la vue
	slidCirconf.setValue(circonference);
	SpinnerValueFactory<Integer> svf = new SpinnerValueFactory.IntegerSpinnerValueFactory(150, 220, taille);
	spinTaille.setValueFactory(svf);
	lCirconf.setText(String.valueOf(circonference));
	calculEtAffichage();
	}
	/**
	* Est exécutée pour calculer et afficher le poids.
	*
	*/
	private void calculEtAffichage() {
	lPoids.setText(poids.toString());
	}
	/**
	* Est exécutée lors du déplacement du Spinner pour la taille.
	*
	* @param newTaille
	*/
	public void tailleChanged(int newTaille) {
	// on indique au modèle que la taille vient de changer
	poids.setTaille(newTaille);
	// on recalcule le poids idéal qui s’affiche dans le composant
	calculEtAffichage();
	}
	/**
	* Est exécutée lors du déplacement du Slider pour la circonférence du poignet.
	*
	* @param newCirconf
	*/
	public void circonfChanged(Number newCirconf) {
	final DecimalFormat df1 = new DecimalFormat("00.0");
	poids.setCirconference(newCirconf.floatValue());
	lCirconf.setText(df1.format(newCirconf.floatValue()));
	calculEtAffichage();
	}
	/**
	* Ferme l'application.
	*/
	@FXML
	private void handleExit() {
	System.exit(0);
	}
}