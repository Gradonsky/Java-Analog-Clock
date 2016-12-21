package Gradonski;

/**

 * @author Gradonski Janusz
 * @version 1.0
 * @date 28.09.2014
 */
public class UhrControl extends Thread implements Runnable {
	
	private Uhr umain;
	private UhrModel um;
	private UhrView uv;
	
/**
 * Konstruktor der Klasse Control	
 */
	public UhrControl(){
		um = new UhrModel();
		uv = new UhrView(um, this);
		umain = new Uhr(uv);
	}

	 /**
	  * Hier werden die Threadsanweisungen eingeschrieben.
	  * In diesem Fall handelt es sich um die genaue Anzeige der Uhrzeit.
	  */
	public void run(){
		/**
		 * Eine Endloschleife (while-true).
		 * Sie wartet 100 Millisekunden und dann wird die Zeit aktualisiert.
		 */
		while(true){
			try {
				Thread.sleep(100);
				um.updateTime();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
