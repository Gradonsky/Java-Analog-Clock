package Gradonski;
import javax.swing.JFrame;
/**
 * In dieser Klasse wird das ganze gestartet..
 * Die Größe des Fensters angepasst usw.
 * 
 * @author Gradonski Janusz
 * @version 1.0
 * @date 29.09.2014
 */

public class Uhr extends JFrame{
	/**
	 * Main-Methode
	 * @param args
	 */
	public static void main(String[] args) {
		new UhrControl().start();
	}
	/*
	 * Der Konstruktor der Klasse View.
	 */
	public Uhr(UhrView uv){
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setTitle("Au03 Analoge Uhr Gradonski");

		/**
		 * So groß wird das Fenster
		 */
		setSize(290,350);
		
		/**
		 * Das vergrößern von dem Fenseter wird gesperrt.
		 */
		setResizable(false);
		
		/**
		 * setLocatonRelativeTo(null) - Das Frame erscheint mitte von dem Bildschirm.
		 */
		setLocationRelativeTo(null);
		
		/**
		 * Die Uhr wird gezeichnet.
		 */
		this.add(uv);
		setVisible(true);
	}
}
