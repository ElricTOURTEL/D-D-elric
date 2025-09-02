package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class DbQuery {
    private final String URL = "jdbc:mysql://localhost:3306/dungeondragon";
    private final String USER = "root";
    private final String  PASSWORD = "user";
    public void getHeroes(){
        String query = "SELECT * FROM `Character`";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                // Exemple : récupération des colonnes
                int id = rs.getInt("idCharacter");
                String type = rs.getString("Type");
                String name = rs.getString("Name");
                int lifepoints = rs.getInt("Lifepoints");
                int strength = rs.getInt("Strength");
                String offensiveequipment = rs.getString("OffensiveEquipment");
                String defensiveequipment = rs.getString("DefensiveEquipment");


                System.out.printf("ID: %d est un %s appelé %s. Il a %d points de vie et %d de force, il est equipé de %s et de %s\n", id, type, name, lifepoints, strength, offensiveequipment, defensiveequipment);
            }

        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
    }
    public void createHeroes(){
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);){


        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
    }
}
