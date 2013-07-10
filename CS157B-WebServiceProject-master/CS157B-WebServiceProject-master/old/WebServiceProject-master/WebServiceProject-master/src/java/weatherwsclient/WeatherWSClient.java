/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherwsclient;

import com.cdyne.ws.weatherws.*;

/**
 *
 * @author Ronald Mak
 */
public class WeatherWSClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Weather descriptions:");
        ArrayOfWeatherDescription awd = getWeatherInformation();
        for (WeatherDescription wd : awd.getWeatherDescription()) {
            System.out.println("  " + wd.getDescription());
        }
        
        String zipCode = "95192";
        System.out.printf("\nCity weather for ZIP code %s\n", zipCode);
        WeatherReturn wr = getCityWeatherByZIP(zipCode);
        System.out.println("  City:        " + wr.getCity());
        System.out.println("  State:       " + wr.getState());
        System.out.println("  Description: " + wr.getDescription());
        System.out.println("  Temperature: " + wr.getTemperature());

        System.out.println();
        System.out.println("Forecast:");
        
        ForecastReturn fr = getCityForecastByZIP(zipCode);
        ArrayOfForecast aof = fr.getForecastResult();
        for (Forecast f : aof.getForecast()) {
            System.out.println();
            System.out.println("  " + f.getDate().toString());
            System.out.println("    Description:    " + f.getDesciption());
            System.out.println("    Low temp:       " + 
                               f.getTemperatures().getMorningLow());
            System.out.println("    High temp:      " + 
                               f.getTemperatures().getDaytimeHigh());
            System.out.println("    Chance of rain: " + 
                               f.getProbabilityOfPrecipiation().getDaytime() +
                               "%");
        }
    }

    private static ArrayOfWeatherDescription getWeatherInformation() {
        com.cdyne.ws.weatherws.Weather service = new com.cdyne.ws.weatherws.Weather();
        com.cdyne.ws.weatherws.WeatherSoap port = service.getWeatherSoap12();
        return port.getWeatherInformation();
    }

    private static WeatherReturn getCityWeatherByZIP(java.lang.String zip) {
        com.cdyne.ws.weatherws.Weather service = new com.cdyne.ws.weatherws.Weather();
        com.cdyne.ws.weatherws.WeatherSoap port = service.getWeatherSoap12();
        return port.getCityWeatherByZIP(zip);
    }

    private static ForecastReturn getCityForecastByZIP(java.lang.String zip) {
        com.cdyne.ws.weatherws.Weather service = new com.cdyne.ws.weatherws.Weather();
        com.cdyne.ws.weatherws.WeatherSoap port = service.getWeatherSoap12();
        return port.getCityForecastByZIP(zip);
    }
}
