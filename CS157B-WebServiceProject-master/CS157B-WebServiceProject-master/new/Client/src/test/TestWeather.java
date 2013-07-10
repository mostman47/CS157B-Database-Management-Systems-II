package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mr.nam
 */
public class TestWeather {
    public String getWeather(String country, String city) throws FileNotFoundException {
        
        String s = getWeatherOfCity(country, city);
      if(s.contains("Data Not Found"))
        {
            System.out.println("Data Not Found");
            return null;
        }
        s = s.replace("utf-16", "UTF-8");
        s = s.replace("UTF-16", "UTF-8");
    if(!s.startsWith("<?xml")) 
            s = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + s;

         try{
  // Create file 
  FileWriter fstream = new FileWriter("weather.xml");
  BufferedWriter out = new BufferedWriter(fstream);
  out.write(s);
  //Close the output stream
  out.close();
  }catch (Exception e){//Catch exception if any
  System.err.println("Error: " + e.getMessage());
  }
         File xx = new File("weather.xml");
    JAXBUnMarshaller jaxbUnmarshaller = new JAXBUnMarshaller();
    jaxbUnmarshaller.unMarshallWeather(xx);
        return null;
    }

    private static String getWeatherOfCity(java.lang.String country, java.lang.String city) {
        weatherairport.WeatherAirportWS_Service service = new weatherairport.WeatherAirportWS_Service();
        weatherairport.WeatherAirportWS port = service.getWeatherAirportWSPort();
        return port.getWeatherOfCity(country, city);
    }
   
    
}
