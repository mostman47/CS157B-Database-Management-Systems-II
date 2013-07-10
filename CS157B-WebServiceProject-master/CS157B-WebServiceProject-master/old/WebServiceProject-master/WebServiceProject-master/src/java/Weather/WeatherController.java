/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Weather;

import TempConvert.TempConvertor;
import com.cdyne.ws.weatherws.ArrayOfForecast;
import com.cdyne.ws.weatherws.ArrayOfWeatherDescription;
import com.cdyne.ws.weatherws.Forecast;
import com.cdyne.ws.weatherws.ForecastReturn;
import com.cdyne.ws.weatherws.WeatherDescription;
import com.cdyne.ws.weatherws.WeatherReturn;

/**
 *
 * @author mr.nam
 */
public class WeatherController {

    public String getWeatherDescription() {
        String s = "";
        s += "\t\tWEATHER DESCRIPTION\n";
        ArrayOfWeatherDescription awd = getWeatherInformation();
        for (WeatherDescription wd : awd.getWeatherDescription()) {
            s += "   -" + wd.getDescription() + "\n";
        }
        return s;
    }

    private static ForecastReturn getCityForecastByZIP(java.lang.String zip) {
        com.cdyne.ws.weatherws.Weather service = new com.cdyne.ws.weatherws.Weather();
        com.cdyne.ws.weatherws.WeatherSoap port = service.getWeatherSoap12();
        return port.getCityForecastByZIP(zip);
    }

    private static WeatherReturn getCityWeatherByZIP(java.lang.String zip) {
        com.cdyne.ws.weatherws.Weather service = new com.cdyne.ws.weatherws.Weather();
        com.cdyne.ws.weatherws.WeatherSoap port = service.getWeatherSoap12();
        return port.getCityWeatherByZIP(zip);
    }

    private static ArrayOfWeatherDescription getWeatherInformation() {
        com.cdyne.ws.weatherws.Weather service = new com.cdyne.ws.weatherws.Weather();
        com.cdyne.ws.weatherws.WeatherSoap port = service.getWeatherSoap12();
        return port.getWeatherInformation();
    }

    public String searchByZIP(String zip, TempConvertor tempConvertor, boolean isF) {
        String s = "";
        s += "\n\tCity weather for ZIP code " + zip + "\n";
        WeatherReturn wr = getCityWeatherByZIP(zip);
        s += "  -City:        " + wr.getCity() + "\n";
        s += "  -State:       " + wr.getState() + "\n";
        s += "  -Description: " + wr.getDescription() + "\n";
        s += "  -Temperature: " + wr.getTemperature() + "\n";

        s += "\n\tForecast:" + "\n";

        ForecastReturn fr = getCityForecastByZIP(zip);
        ArrayOfForecast aof = fr.getForecastResult();
        for (Forecast f : aof.getForecast()) {
            //System.out.println(f.getTemperatures().getMorningLow() + "----");
            //System.out.println(tempConvertor.FtoC(f.getTemperatures().getMorningLow()) + "----");

            s += "\n";
            s += "    " + f.getDate().toString() + "\n";
            s += "  -Description:    " + f.getDesciption() + "\n";
            s += "  -Low temp:       ";
            if (isF) {
                s += f.getTemperatures().getMorningLow() + "Fah\n";
            } else {
                s += tempConvertor.FtoC(f.getTemperatures().getMorningLow()) + "Cel\n";
            }
            s += "  -High temp:      ";
            if (isF) {
                s += f.getTemperatures().getDaytimeHigh() + "Fah\n";
            } else {
                s += tempConvertor.FtoC(f.getTemperatures().getDaytimeHigh()) + "Cel\n";
            }
            s += "  -Chance of rain: "
                    + f.getProbabilityOfPrecipiation().getDaytime()
                    + "%\n";
        }
        return s;
    }
}
