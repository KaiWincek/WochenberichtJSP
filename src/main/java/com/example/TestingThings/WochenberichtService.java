package com.example.TestingThings;

import org.postgresql.ds.PGSimpleDataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WochenberichtService {
    private PGSimpleDataSource ds = new PGSimpleDataSource();

    public WochenberichtService(String serverName, String databaseName, String username, String password) {
        this.ds.setServerName("ec2-79-125-30-28.eu-west-1.compute.amazonaws.com");
        this.ds.setDatabaseName("d6a8uvcrgp0lku");
        this.ds.setUser("quoxsuorlxrlrb");
        this.ds.setPassword("e54031954da3a68126e4f6bea216e2ff6cdf90bee0abb3945643c4154d1c9fce");
    }

    public List<Wochenbericht> getBerichte() {
        List<Wochenbericht> wochenberichte = new ArrayList<>();
        Statement myStatement;
        ResultSet myResult;

        try {
            String sql = "SELECT * FROM \"Berichte\" ORDER BY date";
            myStatement = ds.getConnection().createStatement();
            myResult = myStatement.executeQuery(sql);

            while(myResult.next()){
                wochenberichte.add(createWochenberichtFromDB(myResult));
            }
        } catch (Exception exc){
            exc.printStackTrace();
        }
        return wochenberichte;
    }

    public Wochenbericht getBerichtByDate(String date){
        ResultSet myResult;

        try {
            String sql = "SELECT * FROM \"Berichte\" WHERE date = ?";
            PreparedStatement statement = ds.getConnection().prepareStatement(sql);
            statement.setString(1, date);
            myResult = statement.executeQuery();

            while(myResult.next()){
                return createWochenberichtFromDB(myResult);
            }
        } catch (Exception exc){
            exc.printStackTrace();
        }
        return null;
    }

    public void addBericht(Wochenbericht wochenbericht){
        try {
            String sql = "INSERT INTO \"Berichte\" (\"date\", \"monday\", \"mondayHours\", \"tuesday\", \"tuesdayHours\", \"wednesday\", \"wednesdayHours\", \"thursday\", \"thursdayHours\", \"friday\", \"fridayHours\")"
                       + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = ds.getConnection().prepareStatement(sql);

            statement.setString(1, wochenbericht.getDate());
            statement.setString(2, wochenbericht.getMonday());
            statement.setString(3, wochenbericht.getMondayHours());
            statement.setString(4, wochenbericht.getTuesday());
            statement.setString(5, wochenbericht.getTuesdayHours());
            statement.setString(6, wochenbericht.getWednesday());
            statement.setString(7, wochenbericht.getWednesdayHours());
            statement.setString(8, wochenbericht.getThursday());
            statement.setString(9, wochenbericht.getThursdayHours());
            statement.setString(10, wochenbericht.getFriday());
            statement.setString(11, wochenbericht.getFridayHours());
            statement.execute();
        } catch (Exception exc){
            exc.printStackTrace();
        }
    }

    public void removeBerichtByDate(String date){
        Statement myStatement;
        try {
            String sql = "DELETE FROM \"Berichte\" WHERE date = \'" + date + "\'";
            myStatement = ds.getConnection().createStatement();
            myStatement.execute(sql);
        } catch (Exception exc){
            exc.printStackTrace();
        }
    }

    private Wochenbericht createWochenberichtFromDB(ResultSet myResult) throws SQLException {
        String date = myResult.getString("date");
        String monday = myResult.getString("monday");
        String mondayHours = myResult.getString("mondayHours");
        String tuesday = myResult.getString("tuesday");
        String tuesdayHours = myResult.getString("tuesdayHours");
        String wednesday = myResult.getString("wednesday");
        String wednesdayHours = myResult.getString("wednesdayHours");
        String thursday = myResult.getString("thursday");
        String thursdayHours = myResult.getString("thursdayHours");
        String friday = myResult.getString("friday");
        String fridayHours = myResult.getString("fridayHours");

        Wochenbericht tempWochenbericht = new Wochenbericht(date, monday, tuesday, wednesday, thursday, friday, mondayHours, tuesdayHours, wednesdayHours, thursdayHours, fridayHours);
        return tempWochenbericht;
    }
}
