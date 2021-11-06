package it.tool.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import it.tool.json.InitTracciato;
import it.tool.json.JSonTraduttore;


public class Create implements ActionListener {
	
	InitTracciato tracciato;
	
	File file;
	
	JFrame frame = new JFrame("GENERATOR");
	Container container = frame.getContentPane();
	JPanel panel = new JPanel();
	JTextField mittente = new JTextField("",10);
	JTextField destinatario = new JTextField("",10);
	JTextField caricamento = new JTextField("",10);
	JTextField contoReciproco = new JTextField("",10);
	JTextField saldoInit = new JTextField("",10);
	JTextField nMovimenti = new JTextField("",10);
	JTextField nTracciati = new JTextField("",10);
	JLabel etMittente= new JLabel("abiMittente          ");
	JLabel etDestinatario = new JLabel("abiDestinatario   ");
	JLabel etCaricamento = new JLabel("dataCaricamento");
	JLabel etReciproco = new JLabel("contoReciproco ");
	JLabel etSaldoInit = new JLabel("saldoIniziale       ");
	JLabel etNMovimenti = new JLabel("numeroMovimenti         ");
	JLabel etNtracciati = new JLabel("numeroTracciati           ");
	JButton b = new JButton("GENERA-JSON");
	
	
	public Create (File file , InitTracciato tracciato) {
		
		container.add(etMittente);
		container.add(mittente);
		container.add(etDestinatario);
		container.add(destinatario);
		container.add(etCaricamento);
		container.add(caricamento);
		container.add(etReciproco);
		container.add(contoReciproco);
		container.add(etSaldoInit);
		container.add(saldoInit);
		container.add(etNMovimenti);
		container.add(nMovimenti);
		container.add(etNtracciati);
		container.add(nTracciati);
		container.add(b);
		
		DateFormat DFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		b.addActionListener((ActionEvent action)->{
			
			if(action.getSource()== b) {
				
				System.out.println("premuto");
				
				JSonTraduttore.generate(tracciato);
				
				try {
					
					file.setWritable(true);
					
	
				}catch(Exception e) {
					
					
					e.printStackTrace();
				}
			}});
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
