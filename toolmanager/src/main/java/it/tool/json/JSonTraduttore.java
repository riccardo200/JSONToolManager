package it.tool.json;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonWriter;

import it.tool.gui.Gui;


public  class JSonTraduttore  {

	static Tracciati tracciati;
	
	static InitTracciato initTracciato;

	public static Tracciati read(File file) {

		System.out.println("READ JSON");

		try {
			
			JSONObject tracciatiobj = getTracciatiObj(file);

			System.out.println(tracciatiobj);

			DateFormat DFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			Tracciati tracciati = new Tracciati( 

				tracciatiobj.get("abiMittente").toString() ,
				tracciatiobj.get("abiDestinatario").toString(),
				DFormat.parse(tracciatiobj.get("dataCaricamento").toString()),
		      //  DFormat.parse(tracciatiobj.get("dataContabile").toString()),
				tracciatiobj.get("idRapporto").toString(),
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
	
	public static Tracciati write( File input , File output ,Tracciati tracciati) {

		System.out.println("WRITE JSON");
		
		try {
			
	     	JSONParser parser = new JSONParser();
	     	
			FileReader reader = new FileReader(input);
			
			Object obj = parser.parse(reader);
			
			JSONObject obj1 = (JSONObject)obj;

	     	String filename = getFileName(tracciati);
	     			
	     	FileWriter fw1 = new FileWriter(filename);
	     	
			FileWriter writer = new FileWriter(output);
			
			JSONObject tracciatiobj = (JSONObject)obj1.get("TracciatoRapporto");
			
			DateFormat DFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			// Create JSON object based on input values
			
			tracciatiobj.put( "abiMittente", tracciati.getAbiMittente() );
				
			tracciatiobj.put( "abiDestinatario", tracciati.getAbiDestinatario() );
	
			tracciatiobj.put( "divisa", tracciati.getDivisa() );
			
			tracciatiobj.put( "dataCaricamento", DFormat.format(tracciati.getDataCaricamento()));
			
			//tracciatiobj.put("dataContabile", DFormat.format(tracciati.getDataContabile()));
	
			tracciatiobj.put( "idRapporto", tracciati.getIdRapporto() );
			
			tracciatiobj.put( "saldoIniziale", tracciati.getSaldoIniziale() );
			
			tracciatiobj.put( "saldoFinale", tracciati.getSaldoFinale() );
			
			obj1.put("TracciatoRapporto", tracciatiobj);
			
			// Write on file object TracciatoRapporto JSON Formatted
			
			//writer.append( "{\"TracciatoRapporto\":{" +  tracciatiobj.toString() + "}}" );

			try {

				writer.write(obj1.toJSONString());
				
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
	
	public static InitTracciato genera(InitTracciato initTracciato) {
		
		System.out.println("CREATE JSON");
		
		
		return initTracciato;
	}

	private static String getFileName(Tracciati tracciati) {
		
		/*String filename = "Tracciati" + "_" + tracciati.getAbiMittente() +     //questo sarà il titolo completo
			"_" + tracciati.getAbiDestinatario() + "_" + tracciati.getIdRapporto() 
			+ tracciati.getDataContabile() + tracciati.getDataCaricamento() + ".json";
		*/
		String filename = "Tracciati" + "_" + tracciati.getAbiMittente() + 
				"_" + tracciati.getAbiDestinatario() + "_" + tracciati.getIdRapporto() + ".json";
		
		return filename;
	
	}
	
	private static JSONObject getTracciatiObj(File file) throws IOException, ParseException {
		
		
		JSONParser parser = new JSONParser();
		
		FileReader reader = new FileReader(file);
		
		Object obj = parser.parse(reader);
		
		JSONObject obj1 = (JSONObject)obj;
		
		JSONObject tracciatiobj = (JSONObject)obj1.get("TracciatoRapporto");
		
		//JSONObject movimentiobj = (JSONObject)obj1.get("movimenti");
		
		return tracciatiobj;

	}
}



