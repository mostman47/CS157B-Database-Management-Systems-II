package test;

import generated.Airport.Airport;
import generated.Airport.TableAirport;
import generated.City.Cities;
import generated.City.TableCity;
import generated.Weather.CurrentWeather;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.*;

// Adapted from Pro XML Development with Java Technology
// by Ajay Vohra and Deepak Vohra
// Apress, 2006
public class JAXBUnMarshaller {

    public void unMarshallCity(File xmlDocument) {
        try {
            
            JAXBContext jaxbContext =
                    JAXBContext.newInstance("generated.City");
            Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();

            JAXBElement<Cities> citiesEl =
                    (JAXBElement<Cities>) unMarshaller.unmarshal(xmlDocument);
            Cities cities = citiesEl.getValue();
            List<TableCity> cityList = cities.getTableCity();
            for (TableCity c : cityList) {
                //System.out.println("Country: " + c.getCountry());
                System.out.println("****CITY****");

                System.out.println("City: " + c.getCity());
                System.out.println("********");
            }
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }

    public void unMarshallWeather(File xmlDocument) {
        try {
            JAXBContext jaxbContext =
                    JAXBContext.newInstance("generated.Weather");
            Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();

            JAXBElement<CurrentWeather> currAXBElement =
                    (JAXBElement<CurrentWeather>) unMarshaller.unmarshal(xmlDocument);
            CurrentWeather currentWeather = currAXBElement.getValue();
            System.out.println("****WEATHER****");


            System.out.println("Location: " + currentWeather.getLocation());
            System.out.println("Time: " + currentWeather.getTime());
            System.out.println(currentWeather.getWind());
            System.out.println(currentWeather.getVisibility());
            System.out.println(currentWeather.getSkyConditions());
            System.out.println(currentWeather.getTemperature());
            System.out.println(currentWeather.getDewPoint());
            System.out.println(currentWeather.getRelativeHumidity());
            System.out.println(currentWeather.getPressure());
            System.out.println(currentWeather.getStatus());


            System.out.println("********");

        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }

    public void unMarshallAirport(File xmlDocument) {
        ArrayList t = new ArrayList<String>();

        try {
            JAXBContext jaxbContext =
                    JAXBContext.newInstance("generated.Airport");
            Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();

            JAXBElement<Airport> airportAXBElement =
                    (JAXBElement<Airport>) unMarshaller.unmarshal(xmlDocument);
            Airport airport = airportAXBElement.getValue();
            List<TableAirport> tableAirports = airport.getTableAirport();
            for (TableAirport c : tableAirports) {
                             //   System.out.println(c.getCityOrAirportName());

                if(t.contains(c.getAirportCode()))
                    continue;
                else
                {
                    t.add(c.getAirportCode());
                System.out.println("****AIRPORT****");

                System.out.println(c.getAirportCode());

                System.out.println("Aiport name: " + c.getCityOrAirportName());
                System.out.println("Country: " + c.getCountry());
                System.out.println("GMT: " + c.getGMTOffset());
                //System.out.println(c.getRunwayElevationFeet());
                //System.out.println(c.getRunwayLengthFeet());

                System.out.println("********");
                }
            }
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] argv) {
        File xmlDocument = new File("city.xml");
        JAXBUnMarshaller jaxbUnmarshaller = new JAXBUnMarshaller();
        jaxbUnmarshaller.unMarshallCity(xmlDocument);

        //

        File x = new File("weather.xml");
        jaxbUnmarshaller.unMarshallWeather(x);

        //

        File y = new File("airport.xml");
        new JAXBUnMarshaller().unMarshallAirportWithCity(y,"da");
    }

   
    public void unMarshallAirportWithCity(File xmlDocument, String city) {

        try {
            JAXBContext jaxbContext =
                    JAXBContext.newInstance("generated.Airport");
            Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();

            JAXBElement<Airport> airportAXBElement =
                    (JAXBElement<Airport>) unMarshaller.unmarshal(xmlDocument);
            Airport airport = airportAXBElement.getValue();
            List<TableAirport> tableAirports = airport.getTableAirport();
                            System.out.println("****AIRPORT****");
String s="";
            for (TableAirport c : tableAirports) {
                //System.out.println(c.getCityOrAirportName());
                //System.out.println(city);
                if(c.getCityOrAirportName().toLowerCase().contains(city.toLowerCase()))
                {
                s+=c.getAirportCode()+"\n";

                s+="Aiport name: " + c.getCityOrAirportName()+"\n";
                s+="Country: " + c.getCountry()+"\n";
                s+="GMT: " + c.getGMTOffset()+"\n";
                //System.out.println(c.getRunwayElevationFeet());
                //System.out.println(c.getRunwayLengthFeet());
                break;
                }
                else
                    continue;
            }
            if(s.equals(""))
                System.out.println("Data Not Found");
            else
                System.out.println(s);
                            System.out.println("********");

        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }
}
