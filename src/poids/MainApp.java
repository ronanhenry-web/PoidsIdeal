package poids;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
public class MainApp extends Application {
private Stage primaryStage;
private AnchorPane rootLayout;
/**
* Constructor
*/
public MainApp() {
}
@Override
public void start(Stage primaryStage) {
this.primaryStage = primaryStage;
this.primaryStage.setTitle("Poids idéal (formule de Monnerot-Dumaine)");
initRootLayout();
}
/**
* Initializes the root layout.
*/
public void initRootLayout() {
try {
// Load root layout from fxml file.
FXMLLoader loader = new FXMLLoader();
loader.setLocation(MainApp.class.getResource("vue/VuePoidsMD.fxml"));
rootLayout = (AnchorPane) loader.load();
// Show the scene containing the root layout.
Scene scene = new Scene(rootLayout);
primaryStage.setScene(scene);
primaryStage.show();
} catch (IOException e) {
e.printStackTrace();
}
}
public static void main(String[] args) {
launch(args);
}
}
