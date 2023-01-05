package com.example.java_ana_katsitadze.Classes;

import com.example.java_ana_katsitadze.JDBCConfig;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlightsUtil {

    private FlightsUtil(){

    }

    private static final String CREATE_TABLE = "CREATE TABLE FLIGHTS(" +
            "ID INTEGER AUTO_INCREMENT NOT NULL," +
            "DIRECTION VARCHAR(255)," +
            "FLIGHT_DATE DATETIME(YYYY-MM-DD hh:mm:ss)," +
            "PRICE INTEGER," +
            "PLACES INTEGER," +
            "START_CITY VARCHAR(255)," +
            "PRIMARY KEY(ID))";

    public static void createTable() throws SQLException {
        try {
            if(JDBCConfig.TableExists("FLIGHTS")){
                throw new SQLException();
            }else{
                JDBCConfig.getStatement().executeUpdate(CREATE_TABLE);
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static void insert(Flights flight){
        String INSET_TABLE = "INSERT INTO EMPLOYEES(DIRECTION, FLIGHT_DATE, START_CITY,PLACES,PRICE)" +
                "VALUES(" + flight.getDirection() +"," + flight.getFlightDate() +"," + flight.getStartCity() +"," + flight.getPlaces() +"," + flight.getPrice() + ")";

        try{
            JDBCConfig.getStatement().executeUpdate(INSET_TABLE);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    private static List<Flights> selectAllFlights() throws SQLException {
        String select = "SELECT * FROM FLIGHTS";

        List<Flights> flights = new ArrayList<>();

        try{
            ResultSet result = JDBCConfig.getStatement().executeQuery(select);

            while (result.next()){
                Flights flight  = new Flights();
                flight.setId(result.getLong("ID"));
                flight.setFlightDate(result.getDate("FLIGHT_DATE"));
                flight.setPrice(result.getInt("PRICE"));
                flight.setPlaces(result.getInt("PLACES"));
                flight.setDirection(result.getString("DIRECTION"));
                flight.setStartCity(result.getString("START_CITY"));

                flights.add(flight);
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return flights;
    }

    public static Map<String,Integer> GetPricesByCities() throws SQLException {
        List<Flights> flights = selectAllFlights();

        Map<String, Integer> res = flights.stream().collect(Collectors.groupingBy(Flights::getStartCity,Collectors.summingInt(Flights::getPlaces)));

        return res;

    }


}
