/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author mr.nam
 */
public class Test {

    public static void main(String[] args) throws FileNotFoundException {
        //getCity();
        // getWeather();
        // getAirportbyCountry();
        // getAirportbyCity();
        //getAirportAndWeather();
        System.out.println("DA NANG".toLowerCase().contains("da nang".toLowerCase()));
        String _COMMAND = "*********COMMAND*******\n"
                + "1: Search City by Country\n"
                + "2: Search Weather of City\n"
                + "3: Search Airport of Country\n"
                + "4: Search Airport of City\n"
                + "5: Search Weather of Airport\n"
                + "6: quit\n"
                + "*********************\n";
        System.out.println(_COMMAND);
        String command = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (!command.equals("6")) {
            try {
                System.out.print("?");
                command = br.readLine();
                switch (command) {
                    case "1":
                        System.out.println("1: Search City by Country");

                        getCity();
                        break;
                    case "2":
                        System.out.println("2: Search Weather of City");
                        getWeather();
                        break;
                    case "3":
                        System.out.println("3: Search Airport of Country");
                        getAirportbyCountry();
                        break;
                    case "4":
                        System.out.println("4: Search Airport of City");
                        getAirportbyCity();
                        break;
                    case "5":
                        System.out.println("5: Search Weather of Airport");
                        getAirportAndWeather();
                        break;
                    default:
                        System.out.println(_COMMAND);
                }
            } catch (IOException ioe) {
                System.out.println("IO error trying to read your name!");
                System.exit(1);
            }
        }
    }

    private static void getCity() {
        System.out.print("Enter Country: ");

        String country = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            country = br.readLine();
            System.out.println("=================RESULT=================");

        } catch (IOException ioe) {
            System.out.println("IO error trying to read your name!");
            System.exit(1);
        }
        new TestCity().getCity(country);
    }

    private static void getWeather() throws FileNotFoundException {
        String country = "";
        String city = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter Country: ");

            country = br.readLine();
            System.out.print("Enter City: ");

            city = br.readLine();
            System.out.println("=================RESULT=================");

        } catch (IOException ioe) {
            System.out.println("IO error trying to read your name!");
            System.exit(1);
        }
        new TestWeather().getWeather(country, city);
    }

    private static void getAirportbyCountry() throws FileNotFoundException {
        System.out.print("Enter Country: ");
        String country = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            country = br.readLine();
            System.out.println("=================RESULT=================");

        } catch (IOException ioe) {
            System.out.println("IO error trying to read your name!");
            System.exit(1);
        }
        new TestAirport().getAirportByCountry(country);
    }

    private static void getAirportbyCity() throws FileNotFoundException {
        System.out.print("Enter City: ");
        String city = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            city = br.readLine();
            System.out.println("=================RESULT=================");

        } catch (IOException ioe) {
            System.out.println("IO error trying to read your name!");
            System.exit(1);
        }
        new TestAirport().getAirportByCity(city);
    }

    private static void getAirportAndWeather() throws FileNotFoundException {
        String country = "";
        String city = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            
            System.out.print("Enter Country: ");
            country = br.readLine();
            System.out.print("Enter City: ");

            city = br.readLine();
                        System.out.println("=================RESULT=================");

        } catch (IOException ioe) {
            System.out.println("IO error trying to read your name!");
            System.exit(1);
        }
        new TestAirport().getAirportByCountryAndCity(country,city);
        new TestWeather().getWeather(country, city);
    }
}
