package it.tool.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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

		container.add(etichetta);    
		container.add(testo);         //abimittente
		container.add(etichetta1);   
		container.add(testo1);        //destinatario
		container.add(etichetta2);  
		container.add(testo2);        //data caricamento
		container.add(etichetta6);   
		container.add(testo6);        //data valuta
		container.add(etichetta3);    
		container.add(testo3);        //conto reciproco
		container.add(etichetta4);    
		container.add(testo4);        //saldo iniziale
		container.add(etichetta5);   
		container.add(testo5);        //saldo finale
		container.add(b3); 
 
		DateFormat DFormat = new SimpleDateFormat("yyyy-MM-dd");
		//testo.setText(tracciati.setAbiMittente(""););
		testo.setText(tracciati.getAbiMittente());
		testo1.setText(tracciati.getAbiDestinatario());
		testo2.setText(DFormat.format(tracciati.getDataCaricamento()));
		//testo2.setText("");
		//testo6.setText(tracciati.getDataContabile().toString());
		testo3.setText(tracciati.getIdRapporto());
		testo4.setText(String.valueOf(tracciati.getSaldoIniziale()));
		testo5.setText(String.valueOf(tracciati.getSaldoFinale()));

		b3.addActionListener((ActionEvent action)->{

			if(action.getSource() == b3) {

				System.out.println("premuto");
			
				try {
					
					file.setWritable(true);
					
					tracciati.setAbiMittente(testo.getText().toString());
					
				    tracciati.setAbiDestinatario(testo1.getText().toString());
				    
					//tracciati.setDataCaricamento(testo2.getText().toString());
					
					//this.tracciati.setDataValuta("");
					
					tracciati.setIdRapporto(testo3.getText().toString());
					
					tracciati.setSaldoIniziale(Double.parseDouble(testo4.getText().toString()));
					
					tracciati.setSaldoFinale(Double.parseDouble(testo5.getText().toString()));
				
					//JSonTraduttore.write(file ,tracciati);
					
					System.out.println("tracciati:" + tracciati);
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				
			}

		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}   
}



