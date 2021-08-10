package it.tool.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;


public class Directory implements ActionListener {
	
	Gui gui ;
	
	JTextArea infoText;


        public void actionPerformed(ActionEvent event){

            JFileChooser fileChooser = new JFileChooser("~");

            fileChooser.setMultiSelectionEnabled(false);
            
            fileChooser.setCurrentDirectory(new File("C:\\Users\\user\\OneDrive\\Desktop"));

            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            
            fileChooser.setDialogTitle("Scegli una Directory");

            int choose = fileChooser.showOpenDialog(fileChooser);        //(Gui.this);

            if(choose == JFileChooser.APPROVE_OPTION) {

                File directory = fileChooser.getSelectedFile();

                infoText.setText(infoText.getText() + "Selected directory: " + directory.getName() + "\n");

            }
        }
			
	}

