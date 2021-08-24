package it.tool.json;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JFileChooser;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonWriter;

import it.tool.gui.Gui;


public  class JSonTraduttore  {


	//static //public JSonTraduttore() {}

	static Tracciati tracciati;

	public static Tracciati read(File file) {

		System.out.println("READ JSON");

		try {

			JSONParser parser = new JSONParser();
			
			FileReader reader = new FileReader(file);
			
			Object obj = parser.parse(reader);
			
			JSONObject obj1 = (JSONObject)obj;
			
			JSONObject tracciatiobj = (JSONObject)obj1.get("TracciatoRapporto");

			System.out.println(tracciatiobj);

			DateFormat DFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			//String cro = tracciatiobj.get("cro") == null ? tracciatiobj.get("cro").toString() : "";			
			
			Tracciati tracciati = new Tracciati( 

				tracciatiobj.get("abiMittente").toString() ,
				tracciatiobj.get("abiDestinatario").toString(),
				DFormat.parse(tracciatiobj.get("dataCaricamento").toString()),
				// DateFormat DFormat = new SimpleDateFormat("yy/ MM/ dd"),
				//new Date(tracciatiobj.get("dataValuta").toString()),
				tracciatiobj.get("idRapporto").toString(),
				//tracciatiobj.get("note").toString(),
				Double.parseDouble(tracciatiobj.get("saldoIniziale").toString()),
				Double.parseDouble(tracciatiobj.get("saldoFinale").toString()),
				tracciatiobj.get("divisa").toString()
			);

			return tracciati;

		}catch(Exception e) {

			e.printStackTrace();
			System.out.println("Problema lettura file");
		}
		return null;


	}
	
	public static Tracciati write( File file ,Tracciati tracciati) {

		System.out.println("WRITE JSON");
		
		try {

	     	JSONParser parser = new JSONParser();
	     	
	     	String filename = getFileName(tracciati);
	     			
	     	FileWriter fw1 = new FileWriter(filename);
	     	
			FileWriter writer = new FileWriter(file , true);
			
			JSONObject tracciatiobj = new JSONObject();
			
			// Create JSON object based on input values
				
			tracciatiobj.put( "abiMittente", tracciati.getAbiMittente() );
				
			tracciatiobj.put( "abiDestinatario", tracciati.getAbiDestinatario() );
	
			tracciatiobj.put( "divisa", tracciati.getDivisa() );
			
			//tracciatiobj.put( "dataCaricamento", tracciati.getDataCaricamento() );
	
			tracciatiobj.put( "idRapporto", tracciati.getIdRapporto() );
			
			tracciatiobj.put( "saldoIniziale", tracciati.getSaldoIniziale() );
			
			tracciatiobj.put( "saldoFinale", tracciati.getSaldoFinale() );
			
			tracciatiobj.put( "caricamenti", "" );
			
			
			// Write on file object TracciatoRapporto JSON Formatted
			
			writer.append( "{\"TracciatoRapporto\":{" +  tracciatiobj.toString() + "}}" );

			try {

				writer.write(tracciatiobj.toJSONString());
				
				writer.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}catch(Exception e) {

			e.printStackTrace();
			System.out.println("Problema scrittura FILE" + e);
		}

		return tracciati;


	}

	private static String getFileName(Tracciati tracciati) {
		
		String filename = "Tracciati" + "_" + tracciati.getAbiMittente() + 
			"_" + tracciati.getAbiDestinatario()  + ".json";
		
		// qui i sorting e l'algoritmo che decide il nome file
		
		return filename;
	
	}
}



