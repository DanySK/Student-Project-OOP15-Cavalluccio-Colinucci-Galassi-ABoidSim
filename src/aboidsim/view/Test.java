package aboidsim.view;

import java.util.Arrays;
import java.util.List;

import javafx.application.Application;

/**
 * test class for the elements of the interface.
 *
 */
public class Test /* extends Application */ {

	/**
	 *
	 * */
	public static void main(final String[] args) {
		// MainWindow ciao = new MainWindow(Arrays.asList("ciao", "hello",
		// "yo"), Arrays.asList("dell", "hp", "asus"));
		// window.show();
		final List<String> lista = Arrays.asList("ciao", "hello", "yo");
		MainWindow.setBoids(lista);
		MainWindow.setRules(lista);
		Application.launch(MainWindow.class);
		// System.out.println(System.getProperty("user.dir") +
		// System.getProperty("file.separator") + "res"
		// + System.getProperty("file.separator") + "boids" +
		// System.getProperty("file.separator")
		// + "herbivore0.png");
		// System.getProperty("user.dir"));

	}

	/**
	 * lo far� successivamente.
	 */
	// public void start(final Stage stage) throws Exception {
	// stage.setTitle("Test");
	//
	// final List<String> parole = Arrays.asList("Sony", "Xiaomi", "Huawei");
	// // stage.setScene(new SceltaRegole(parole));
	//
	// // stage.setScene(new BoidSelection(Arrays.asList("ciao", "come",
	// "va")));
	// // stage.setScene(new SceltaRegole(parole));
	// stage.show();
	// }

}
