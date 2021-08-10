package it.tool.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.json.simple.JSONObject;
import org.w3c.dom.Text;

import it.tool.json.JSonTraduttore;
import it.tool.json.Tracciati;

public class Edit implements ActionListener {

	//File f = fileChooser.getSelectedFile();

	Tracciati tracciati;

	File file;

	JFrame frame = new JFrame("JSON");
	Container container = frame.getContentPane();
	JPanel panel = new JPanel();
	JTextField testo = new JTextField("",10);
	JTextField testo1 = new JTextField("",10);
	JTextField testo2 = new JTextField("",10);
	JTextField testo3 = new JTextField("",10);
	JTextField testo4 = new JTextField("",10);
	JTextField testo5 = new JTextField("",10);
	JTextField testo6 = new JTextField("",10);
	JLabel etichetta = new JLabel("abiMittente          ");
	JLabel etichetta1 = new JLabel("abiDestinatario   ");
	JLabel etichetta2 = new JLabel("dataCaricamento");
	JLabel etichetta3 = new JLabel("contoReciproco ");
	JLabel etichetta4 = new JLabel("saldoIniziale       ");
	JLabel etichetta5 = new JLabel("saldoFinale         ");
	JLabel etichetta6 = new JLabel("dataValuta           ");
	JButton b3 = new JButton("ESEGUI");

	public Edit(File file , Tracciati tracciati) {

		container.add(etichetta);    //abimittente
		container.add(testo);
		container.add(etichetta1);   //destinatario
		container.add(testo1);
		container.add(etichetta2);  //data caricamento
		container.add(testo2);
		container.add(etichetta6);   //data valuta
		container.add(testo6);
		container.add(etichetta3);    //conto reciproco
		container.add(testo3);
		container.add(etichetta4);    //saldo inizial
		container.add(testo4);
		container.add(etichetta5);    //saldo final
		container.add(testo5);
		container.add(b3); 

		//testo.setText(tracciati.setAbiMittente(""););
		testo.setText(tracciati.getAbiMittente());
		testo1.setText(tracciati.getAbiDestinatario());
		//testo2.setText(tracciati.getDataCaricamento().toString());
		testo2.setText("");
		// testo6.setText(tracciati.getDataValuta().toString());
		testo3.setText(tracciati.getContoReciproco());
		testo4.setText(String.valueOf(tracciati.getSaldoIniziale()));
		testo5.setText(String.valueOf(tracciati.getSaldoFinale()));

		b3.addActionListener((ActionEvent action)->{

			if(action.getSource() == b3) {

				//JSonTraduttore.write(file);
				System.out.println("premuto");
                
				//testo.setText(null);
				try {
					
					JSonTraduttore.write(file, tracciati);
					
					file.setWritable(true);
					
					tracciati.setAbiMittente(testo.getName());
				    tracciati.setAbiDestinatario(testo1.toString());
					//tracciati.setDataCaricamento(testo2.toString());
					//this.tracciati.setDataValuta(null);
					tracciati.setContoReciproco(testo3.toString());
					//tracciati.setSaldoIniziale(Double.parseDouble(text));
					//tracciati.setSaldoFinale(Double.parseDouble(text));
					//File f = fileChooser.getSelectedFile();
					//this.tracciati = JSonTraduttore.write(null);
                    
					JSONObject tracciatiObject = new JSONObject();
					
					//tracciatiObject.writeJSONString(tracciatiObject, JSonTraduttore.write(file, tracciati));
					//JSonTraduttore.write(file, tracciati);
					tracciatiObject.put("abiMittente", testo);
					tracciatiObject.put("abiDestinatario", testo1);
					//JSonTraduttore.write(file, tracciati).setAbiMittente(testo.toString());
					
					System.out.println("entrato");

					
					
					
					

				} catch (Exception e) {
					
					e.printStackTrace();
				}
				
				//JSONObject tracciatiObject = new JSONObject();

			     // this.tracciati.put("abiMittente", tracciati.setAbiMittente(testo.toString()));
		
			     // tracciatiObject.put("abiMittente", tracciati.setAbiMittente(testo.toString()));
                 // tracciatiObject.put(file, tracciati);
			}

		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}   
}



