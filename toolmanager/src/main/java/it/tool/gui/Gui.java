package it.tool.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.text.Caret;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import it.tool.json.JSonTraduttore;
import it.tool.json.Tracciati;



public class Gui extends JFrame {

	private static final long serialVersionUID = 1L;

	JTextArea infoText;

	File[] currentFiles = null;

	Tracciati tracciati;

	File file;

	JFileChooser fileChooser = new JFileChooser("C:\\Users\\user\\OneDrive\\Desktop\\Nuova cartella3");    //("~");  

	public Gui(String text){
		super(text);

		//Edit edit = new Edit();

		//Open open = new Open();

		JButton openButton = new JButton("Open");

		// JButton openDirButton = new JButton("Open Directory");

		JButton saveButton = new JButton("Save");

		JButton editButton = new JButton("Edit");

		infoText = new JTextArea();

		openButton.addActionListener(new Open());

		//   openDirButton.addActionListener(new Directory());

		// editButton.addActionListener(Gui.this);

		saveButton.addActionListener(new Save());

		JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 5, 5));

		buttonPanel.add(openButton);

		//      buttonPanel.add(openDirButton);

		buttonPanel.add(editButton);

		buttonPanel.add(saveButton);


		openButton.addActionListener((ActionEvent action)->{

			if (action.getSource() == openButton){

				fileChooser.setMultiSelectionEnabled(true);

				fileChooser.setDialogTitle("Prendi Tracciato/i");

				try {

					fileChooser.setFileFilter(new TxtFileFilter());

					int choose = fileChooser.showOpenDialog(Gui.this);

					if (choose == JFileChooser.APPROVE_OPTION) {

						this.file = fileChooser.getSelectedFile();

						this.tracciati = JSonTraduttore.read(this.file);

						//System.out.println(this.tracciati);

						BufferedReader read = new BufferedReader(new FileReader(this.file));
						
						String line = read.readLine();

						while(line != null) {
							
							//read = new BufferedReader(read);
							
							//line = read.readLine();

							infoText.append(line);
							
							line = read.readLine();
						}
						read.close();
					}

				}

				catch (Exception ex) {}
			}});

		editButton.addActionListener((ActionEvent action)->{

			if (action.getSource() == editButton){

				Edit edit = new Edit(this.file ,this.tracciati);

				edit.container.setLayout(new FlowLayout());
				edit.frame.setBounds(200, 270, 230, 250);
				edit.frame.setLocation(690,325);
				edit.frame.setResizable(false);
				edit.frame.setVisible(true);

			}});

		saveButton.addActionListener((ActionEvent action)->{

			if (action.getSource() == saveButton){

				fileChooser.setDialogTitle("Salva Tracciato/i");  	
				// infoText.setText(infoText.getText() + "Saved: " + file.getName() + "\n");
				try {

					fileChooser.setFileFilter(new TxtFileFilter());
					
					int choose = fileChooser.showSaveDialog(Gui.this);

					if (choose == JFileChooser.APPROVE_OPTION) {

						File f = fileChooser.getSelectedFile();

						//Tracciati tracciati = JSonTraduttore.write(f);
						BufferedWriter write = new BufferedWriter(new FileWriter(f));
						//write.append(tracciati.);
						write.append(infoText.getText());     //+ JSonTraduttore.write(f));       //+ "Saved: " + f.getName() + "\n");
						write.flush();
						write.close();
					}
				} catch (Exception ex) {}

			}});

		JPanel panel = new JPanel(new BorderLayout());

		// JScrollPane scrollPane = new JScrollPane(panel);

		panel.add(infoText, BorderLayout.CENTER);

		panel.add(buttonPanel, BorderLayout.SOUTH );

		this.getContentPane();   ///.add(scrollPane, BorderLayout.SOUTH);

		this.setLocation(500, 250);

		this.setContentPane(panel);

		this.setSize(600, 400);

		this.setResizable(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private class TxtFileFilter extends FileFilter {

		public boolean accept(File file) {

			if (file.isDirectory()) return true;

			String fname = file.getName().toLowerCase();

			return fname.endsWith("json");
		}

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return null;
		}

	}
}
