/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TempConvert;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author mr.nam
 */
public class TempConvertor {

    private DecimalFormat twoDForm = new DecimalFormat("#.##");

    private static String celsiusToFahrenheit(java.lang.String celsius) {
        org.tempuri.TempConvert service = new org.tempuri.TempConvert();
        org.tempuri.TempConvertSoap port = service.getTempConvertSoap12();
        return port.celsiusToFahrenheit(celsius);
    }

    private static String fahrenheitToCelsius(java.lang.String fahrenheit) {
        org.tempuri.TempConvert service = new org.tempuri.TempConvert();
        org.tempuri.TempConvertSoap port = service.getTempConvertSoap12();
        return port.fahrenheitToCelsius(fahrenheit);
    }

    public String CtoF(String temp) {
        if(!"".equals(temp.trim()))
        {        
        double n = Double.parseDouble(celsiusToFahrenheit(temp).trim());
        return Double.valueOf(twoDForm.format(n)) + "";
        }
        return "";
    }

    public String FtoC(String temp) {
        if(!"".equals(temp.trim()))
        {        
        double n = Double.parseDouble(fahrenheitToCelsius(temp).trim());
        return Double.valueOf(twoDForm.format(n)) + "";
        }
        return "";
    }
}
