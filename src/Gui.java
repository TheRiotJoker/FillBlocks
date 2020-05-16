import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Choice;
public class Gui extends JFrame {
	private Steuerung strg;
	private JTextField[] vektor1TextFeld = new JTextField[3];
	private JTextField[] vektor2TextFeld = new JTextField[3];
	private JLabel vektor1Beschriftung;
	private JLabel vektor2Beschriftung;
	private JButton kreuzProdukt;
	private JButton summe;
	private JButton differenz;
	private JButton skalarProdukt;
	private JButton laengeBerechnen;
	private Choice laengeWahl;
	private JButton winkelBerechnen;
	private JButton gleich;
	private JLabel loesungsVektorLabel;
	private Choice differenzWahl;
	private VektorenDaten vDaten;
	public Gui() {
		vDaten = new VektorenDaten();
		int x = 10;
		int y = 30;
		setSize(400,400);
		setTitle("Vektoren Rechner");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		strg = new Steuerung(this);
		for(int i = 0; i < vektor1TextFeld.length; i++) {
			vektor1TextFeld[i] = new JTextField();
			vektor1TextFeld[i].setEditable(true);
			vektor1TextFeld[i].setBounds(x,y,70,30);
			y += 60;
			add(vektor1TextFeld[i]);
			
		}
		x += 80;
		y = 30;
		for(int i = 0; i < vektor1TextFeld.length; i++) {
			vektor2TextFeld[i] = new JTextField();
			vektor2TextFeld[i].setEditable(true);
			vektor2TextFeld[i].setBounds(x,y,70,30);
			y = y+60; 
			add(vektor2TextFeld[i]);
		}
		vektor2Beschriftung = new JLabel("Vektor 2");
		vektor1Beschriftung = new JLabel("Vektor 1");
		vektor1Beschriftung.setBounds(10,15,70,10);
		vektor2Beschriftung.setBounds(90,15,70,10);
		add(vektor1Beschriftung);
		add(vektor2Beschriftung);
		
		winkelBerechnen = new JButton("Winkel");
		winkelBerechnen.setBounds(200,320,180,40);
		add(winkelBerechnen);
		winkelBerechnen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String loesungsText = "";
				if(konvertiereVektore()) {
					loesungsText = Double.toString(strg.winkelBerechnen(vDaten.gibRechnenVektor1(), vDaten.gibRechnenVektor2()));
					loesungsVektorLabel.setText("α = "+loesungsText+"°");
				}
				
			}
			
		});
		
		laengeWahl = new Choice();
		laengeWahl.add("Vektor 1");
		laengeWahl.add("Vektor 2");
		add(laengeWahl);
		laengeWahl.setBounds(200,290,180,40);
		
		
		laengeBerechnen = new JButton("Länge");
		laengeBerechnen.setBounds(200,245,180,40);
		add(laengeBerechnen);
		laengeBerechnen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String loesungsText = "";
				if(konvertiereVektore(laengeWahl.getSelectedItem())) {
					if(laengeWahl.getSelectedItem().contentEquals("Vektor 1")) {
						loesungsText = Double.toString(strg.vektorLaenge(vDaten.gibRechnenVektor1()));
					} else {
						loesungsText = Double.toString(strg.vektorLaenge(vDaten.gibRechnenVektor2()));
					}
					loesungsVektorLabel.setText("l = √"+loesungsText);
					gleich.setEnabled(true);	
				}
				
			}
			
		});
		
		skalarProdukt = new JButton("Skalarprodukt");
		skalarProdukt.setBounds(200,195,180,40);
		add(skalarProdukt);
		skalarProdukt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String loesungsText = "";
				if(konvertiereVektore()) {
					loesungsText = Integer.toString(strg.skalarProduktBerechnen(vDaten.gibRechnenVektor1(), vDaten.gibRechnenVektor2()));
					loesungsVektorLabel.setText("p = "+loesungsText);	
				}
				
			}
			
		});
		
		
		differenz = new JButton("Differenz");
		add(differenz);
		differenz.setBounds(200,120,180,40);
		differenz.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String loesungsText = "";
				if(konvertiereVektore()) {
					loesungsText = strg.differenzBerechnen(differenzWahl.getSelectedItem(), vDaten.gibRechnenVektor1(), vDaten.gibRechnenVektor2()).stringVektor();
					loesungsVektorLabel.setText("a(->) = "+loesungsText);	
				}
				
			}
			
		});
		
		
		summe = new JButton("Summe");
		summe.setBounds(200,70,180,40);
		add(summe);
		summe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String loesungsText = "";
				if(konvertiereVektore()) {
					loesungsText = strg.summeBerechnen(vDaten.gibRechnenVektor1(), vDaten.gibRechnenVektor2()).stringVektor();
					loesungsVektorLabel.setText("a(->) = "+loesungsText);	
				}
				
			}
		});
		
		
		kreuzProdukt = new JButton("Kreuzprodukt");
		add(kreuzProdukt);
		kreuzProdukt.setBounds(200,20,180,40);
		kreuzProdukt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String loesungsText ="";
				if(konvertiereVektore()) {
					loesungsText = strg.kreuzproduktBerechnen(vDaten.gibRechnenVektor1(), vDaten.gibRechnenVektor2()).stringVektor();
					loesungsVektorLabel.setText("a(->) = "+loesungsText);	
				}
				
			}
			
		});
		
		
		differenzWahl = new Choice();
		differenzWahl.setBounds(200,165,180,40);
		differenzWahl.add("Vektor 1 - Vektor 2");
		differenzWahl.add("Vektor 2 - Vektor 1");
		add(differenzWahl);
		
		
		loesungsVektorLabel = new JLabel();
		loesungsVektorLabel.setOpaque(true);
		loesungsVektorLabel.setBackground(Color.gray);
		loesungsVektorLabel.setForeground(Color.white);
		loesungsVektorLabel.setFont(new Font("Helvetica", Font.BOLD, 20));
		loesungsVektorLabel.setBounds(10,200,175,75);
		add(loesungsVektorLabel);
		
		gleich = new JButton("≈");
		gleich.setFont(new Font("Helvetica", Font.BOLD, 20));
		gleich.setBounds(10,285,175,30);
		add(gleich);
		gleich.setEnabled(false);
		gleich.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String l = new String("");
				l = Double.toString(strg.vektorLaengeWurzel());
				loesungsVektorLabel.setText("l ≈ "+l);
				gleich.setEnabled(false);
				
			}
			
		});
		setVisible(true);
	}
	private boolean konvertiereVektore() {
		int x1 = 0;
		int x2 = 0;
		int x3 = 0;
		boolean passed = true;
		try {
			x1 = Integer.parseInt(vektor1TextFeld[0].getText());
			x2 = Integer.parseInt(vektor1TextFeld[1].getText());
			x3 = Integer.parseInt(vektor1TextFeld[2].getText());
		} catch(NumberFormatException e) {
			loesungsVektorLabel.setText("Falsche Eingabe");
			passed = false;
		}
		vDaten.setzeRechnenVektor1(x1, x2, x3);
		try {
			x1 = Integer.parseInt(vektor2TextFeld[0].getText());
			x2 = Integer.parseInt(vektor2TextFeld[1].getText());
			x3 = Integer.parseInt(vektor2TextFeld[2].getText());
		} catch(NumberFormatException e) {
			loesungsVektorLabel.setText("Falsche Eingabe");
			passed = false;
		}
		vDaten.setzeRechnenVektor2(x1, x2, x3);	
		return passed;
		
	}
	private boolean konvertiereVektore(String vektor) {
		int x1 = 0;
		int x2 = 0;
		int x3 = 0;
		boolean passed = true;
		if(vektor.contentEquals("Vektor 1")) {
			try {
				x1 = Integer.parseInt(vektor1TextFeld[0].getText());
				x2 = Integer.parseInt(vektor1TextFeld[1].getText());
				x3 = Integer.parseInt(vektor1TextFeld[2].getText());
			} catch(NumberFormatException e) {
				loesungsVektorLabel.setText("Falsche Eingabe");
				passed = false;
			}			
			vDaten.setzeRechnenVektor1(x1, x2, x3);	
		} else {
			try {
				x1 = Integer.parseInt(vektor2TextFeld[0].getText());
				x2 = Integer.parseInt(vektor2TextFeld[1].getText());
				x3 = Integer.parseInt(vektor2TextFeld[2].getText());
			} catch(NumberFormatException e) {
				loesungsVektorLabel.setText("Falsche Eingabe");
				passed = false;
			}
			vDaten.setzeRechnenVektor2(x1, x2, x3);	
		}
		return passed;
		
	}
	public static void main(String[] args) {
		Gui gui = new Gui();
	}
	public void zeigeLoesungsVektorAn(String text) {
		loesungsVektorLabel.setText(text);
	}
}
