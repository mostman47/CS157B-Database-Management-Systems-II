/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WeatherAirport;

import Air.Airport;
import Wea.GlobalWeather;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author mr.nam
 */
@WebService(serviceName = "WeatherAirportWS")
@Stateless()
public class WeatherAirportWS {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/www.webservicex.net/airport.asmx.wsdl")
    private Airport service_1;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/www.webservicex.net/globalweather.asmx.wsdl")
    private GlobalWeather service;

    /**
     * Web service operation
     */
    @WebMethod(operationName = "CitiesOfCountry")
    public String CitiesOfCountry(@WebParam(name = "country") String country) {
        //TODO write your implementation code here:
        return getCitiesByCountry(country);
    }

    private String getCitiesByCountry(java.lang.String countryName) {
        Wea.GlobalWeatherSoap port = service.getGlobalWeatherSoap12();
        return port.getCitiesByCountry(countryName);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GetWeatherOfCity")
    public String GetWeatherOfCity(@WebParam(name = "country") String country,
            @WebParam(name = "city") String city) {
        //TODO write your implementation code here:
        return getWeather(city, country);
    }

    private String getWeather(java.lang.String cityName, java.lang.String countryName) {
        Wea.GlobalWeatherSoap port = service.getGlobalWeatherSoap12();
        return port.getWeather(cityName, countryName);
    }

    private String getAirportInformationByCountry(java.lang.String country) {
        Air.AirportSoap port = service_1.getAirportSoap12();
        return port.getAirportInformationByCountry(country);
    }

    private String getAirportInformationByCityOrAirportName(java.lang.String cityOrAirportName) {
        Air.AirportSoap port = service_1.getAirportSoap12();
        return port.getAirportInformationByCityOrAirportName(cityOrAirportName);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAirportInfoByCountry")
    public String getAirportInfoByCountry(@WebParam(name = "country") String country) {
        //TODO write your implementation code here:
        return getAirportInformationByCountry(country);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAirportInfoByCity")
    public String getAirportInfoByCity(@WebParam(name = "City") String City) {
        //TODO write your implementation code here:
        return getAirportInformationByCityOrAirportName(City);
    }

    private String getAirportInformationByAirportCode(java.lang.String airportCode) {
        Air.AirportSoap port = service_1.getAirportSoap12();
        return port.getAirportInformationByAirportCode(airportCode);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAirportInfoByAirportCode")
    public String getAirportInfoByAirportCode(@WebParam(name = "airport code") String aiportCode) {
        //TODO write your implementation code here:
        return getAirportInformationByAirportCode(aiportCode);
    }

    
    /**
     * This is a sample web service operation
     */
}
