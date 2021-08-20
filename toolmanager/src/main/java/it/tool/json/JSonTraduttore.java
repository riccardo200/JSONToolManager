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

			Tracciati tracciati = new Tracciati( 

					tracciatiobj.get("abiMittente").toString() ,
					tracciatiobj.get("abiDestinatario").toString(),
					DFormat.parse(tracciatiobj.get("dataCaricamento").toString()),
					// DateFormat DFormat = new SimpleDateFormat("yy/ MM/ dd"),
					//new Date(tracciatiobj.get("dataValuta").toString()),
					tracciatiobj.get("idRapporto").toString(),
					//tracciatiobj.get("note").toString(),
					Double.parseDouble(tracciatiobj.get("saldoIniziale").toString()),
					Double.parseDouble(tracciatiobj.get("saldoFinale").toString())

					);

			return tracciati;

		}catch(Exception e) {

			e.printStackTrace();
			System.out.println("Problema lettura file");
		}
		return null;


	}
	public static Tracciati write(File file , Tracciati tracciati) {

		System.out.println("WRITE JSON");

		try {

	     	JSONParser parser = new JSONParser();
	     	
			FileWriter writer = new FileWriter(file , true);

			//Object object = (tracciati)obj;

			//Object obj =  parser.parse(tracciati.toString());         //(Object)tracciati;

			Object obj = (Object)tracciati;
			
			JSONObject tracciatiobj = (JSONObject)obj;
			
			//JSONObject tracciatiobj = (JSONObject)((HashMap) obj).get("TracciatoRapporto");
			
		    //obj = parser.parse(writer.toString());
			
			obj = (JSONObject) parser.parse(new InputStreamReader(new FileInputStream(file)));

			writer.append(tracciatiobj.toString());


			try {

				writer.write(tracciatiobj.toJSONString());
				
				writer.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return tracciati; 

		}catch(Exception e) {

			e.printStackTrace();
			System.out.println("Problema scrittura FILE" + e);
		}
		//return JSonTraduttore.write(file) ;
		//return write(file);
		return tracciati;


	}

}



