package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mr.nam
 */
public class TestCity {

    public String getCity(String country) {
        
        String s = "";
        s = citiesOfCountry(country);
        if(s.contains("Data Not Found"))
        {
            System.out.println("Data Not Found");
            return null;
        }
        s = s.replaceAll("<NewDataSet", "<Cities xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
        s = s.replaceAll("</NewDataSet", "</Cities");

        s = s.replaceAll("<Table>", "<TableCity>");
        s = s.replaceAll("</Table>", "</TableCity>");

        if (!s.startsWith("<?xml")) {
            s = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + s;
        }
        try {
            // Create file 
            FileWriter fstream = new FileWriter("city.xml");
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(s);
            //Close the output stream
            out.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
        File xx = new File("city.xml");
        JAXBUnMarshaller jaxbUnmarshaller = new JAXBUnMarshaller();
        jaxbUnmarshaller.unMarshallCity(xx);
        return null;
    }

    private static String citiesOfCountry(java.lang.String country) {
        weatherairport.WeatherAirportWS_Service service = new weatherairport.WeatherAirportWS_Service();
        weatherairport.WeatherAirportWS port = service.getWeatherAirportWSPort();
        return port.citiesOfCountry(country);
    }
    public static void main(String[] args) {
        System.out.println(citiesOfCountry("viet nam"));
    }
}
