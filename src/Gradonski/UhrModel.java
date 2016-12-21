package Gradonski;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Die Klasse Model beinhaltet den eigentlichen "Kalender"
 * 
 * @author Gradonski Janusz
 * @version 1.0
 * @date 28.09.2014
 */
public class UhrModel {
	static Calendar time;
	/**
	 * Laut der API wird mit getInstance das ganze Calender-Objekt mit dem richtigen Datum und der
	 * richtiger Uhrzeit "zuruckgeliefert".
	 */
	public UhrModel() {
		time = Calendar.getInstance();
	}

	/*
	 * Hier wird die Zeit zurückgeliefert
	 * 
	 * @return time
	 */
	public Calendar getTime() {
		return time;
	}
	
	/*
	 * Die Uhrzeit wird in hier Aktualisiert
	 * 
	 * @return Aktuelle Uhrzeit
	 */
	public void updateTime(){
		time = new GregorianCalendar();
	}
}
