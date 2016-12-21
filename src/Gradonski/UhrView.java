package Gradonski;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JPanel;

/**
 * Die View-Klasse der Aufgabe
 * In Dieser Klasse wird die eigentliche Uhr gezeichnet.
 * 
 * @author Gradonski Janusz
 * @version 1.0
 * @date 29.09.2014
 */

public class UhrView extends JPanel{
	
	private Calendar time = new GregorianCalendar();
	private UhrModel um;
	private Date dt = new Date();
	private MoonCalculation mc =  new MoonCalculation();
	private int hour;
	private int minute;
	private int second;
	private int fenster;
	private int mondPhaseInt;
	/**
	 * Der Konstruktor der Klasse View.
	 * @param um
	 * @param uc
	 */
	public UhrView(UhrModel um, UhrControl uc){		
		this.setLayout(new BorderLayout());
		this.um = um;
	}
	
	/*
	 * 
	 * @see javax.swing.JComponent#paint(java.awt.Graphics)
	 */
	public void paint(Graphics g) {
		
		/*
		 *  
		 */
		 hour = um.getTime().get(Calendar.HOUR_OF_DAY);
		 minute = um.getTime().get(Calendar.MINUTE);
		 second = um.getTime().get(Calendar.SECOND);
		 mondPhaseInt = mc.moonPhase(dt.getYear(), dt.getMonth(), dt.getDay());
		fenster = Math.min(getWidth()/2, getHeight()/2);
		
		//Entfernen des alten Rechtecks, damit die aktuelle Uhrzeit
		//angezeigt werden kann.
		g.clearRect(0, 0, getWidth(), getHeight());
		
		
		/**
		 * Das Aktuelle datum wird herausgelesen aus Date.getDate() , von einem
		 * Integer in ein String umkonvertiert mit der Methode (Integer.toString)
		 * und dann auf die Position x=170 , y = 130 gezeichnet.
		 * 
		 * drawRect(168,117,17,15) - 
		 * Dies Zeichnet um das Datum ein Viereck.
		 */
		
		g.drawRect(188, 137,17, 17);
		g.drawString(Integer.toString(dt.getDate()),190,150);
		
		
		/**
		 * Die Mondphasen werden gezeichnet.
		 * Die Graphiken befinden sich im /src/Gradonski/images
		 * Wenn die Images nicht zu finden sind wird anstatt 
		 * die Exception IOException gefangen und
		 * ein Fehler "Image not Found" angezeigt und die jeweilige
		 * Mondphase als Text angegeben.
		 */
		
		try {
			g.drawImage(mc.phaseIcon(mondPhaseInt),50,155,null);
			g.drawString(mc.phaseName(mondPhaseInt),100,180);
		} catch (IOException e) {
			g.drawString("Image not Found!",50,155);
			g.drawString("Mondphase als Text:", 50, 175);
			g.drawString(mc.phaseName(mondPhaseInt),50,190);
		}
		
		/**
		 * Dies Zeichnet das Ring das sich in der mitte von der Uhr befindet.
		 */
		g.drawOval(fenster-4,fenster-5,7,7);
		
		/**
		 * Der Minutenzeiger wird mit drawLine gezeichnet.
		 */
		g.drawLine(
        		fenster,
        		fenster,
        		(int)((fenster-45)*Math.cos(Math.toRadians(minute*6-90)))+fenster,
        		(int)((fenster-45)*Math.sin(Math.toRadians(minute*6-90)))+fenster
				);
        
        
		/**
		 * Der Stundenzeiger wird ebenfalls mit drawLine gezeichnet.
		 */
        	g.drawLine(
        		fenster,
        		fenster,
        		(int)((fenster-70)*Math.cos(Math.toRadians(hour%12*30-90)))+fenster,
        		(int)((fenster-70)*Math.sin(Math.toRadians(hour%12*30-90)))+fenster
        			);
        
        
        
        
        /**
         * Sekundenzeiger Farbe:Grau
         */
        g.setColor(new Color(170,170,170));
			g.drawLine(
        		fenster,
        		fenster,
        		(int)((fenster-30)*Math.cos(Math.toRadians(second*6-90)))+fenster,
        		(int)((fenster-30)*Math.sin(Math.toRadians(second*6-90)))+fenster
        		
					);
	       /**
	        * Die Minutenanzeige wird gezeichnet (Striche rundherum um die Uhr)
	        */
	      for(int i = 0;i < 60;i++){
	        	g.drawLine(
	        			fenster+(int)((fenster-2)* Math.cos(Math.toRadians(6*i))),
	        			fenster+(int)((fenster-2)* Math.sin(Math.toRadians(6*i))),
	            		fenster+(int)((fenster)*Math.cos(Math.toRadians(6*i))),
	            		fenster+(int)((fenster)*Math.sin(Math.toRadians(6*i)))
	        			);
	        }
        /**
         * Stundenstriche
         */
        for(int i = 0;i < 12;i++){
        	g.setColor(Color.BLACK);
        	g.drawLine(
        			fenster+(int)((fenster-10)* Math.cos(Math.toRadians(i*30))),
        			fenster+(int)((fenster-10)* Math.sin(Math.toRadians(i*30))),
            		(int)((fenster)*Math.cos(Math.toRadians(i*30)))+fenster,
            		(int)((fenster)*Math.sin(Math.toRadians(i*30)))+fenster
        			);
        }
        /**
         * Text Unten
         */
        g.drawString("Au03 - Analoge Uhr Gradonski Janusz - 4CHITM", 5, 310);
		repaint();
	}
}
