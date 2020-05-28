package com.bioskop.db;

import com.bioskop.model.Film;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBHelper {

    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    private static final String DB_URL = "jdbc:mysql://localhost/bioskop";

    private static Connection connection = null;

    public static void insertFilm(String naziv, int godina, String opis, String slika, String trejler) {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            connection.setAutoCommit(false);

            String query = "INSERT INTO film (FILM_ID, FILM_NAZIV, FILM_GODINA, FILM_OPIS, FILM_SLIKA, FIRMA_TREJLER VALUES (NULL, ?, ?, ?, ?, ?);";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, naziv);
                statement.setInt(2, godina);
                statement.setString(3, opis);
                statement.setString(4, slika);
                statement.setString(5, trejler);
                statement.executeUpdate();
                connection.commit();
                statement.close();
            } catch (SQLException ex) {
                connection.rollback();
            }

            connection.close();
        } catch (SQLException ex) {
        }
    }

    public static List<Film> findAllFilm() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            connection.setAutoCommit(false);

            String query = "SELECT * FROM film;";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                List<Film> filmovi = new ArrayList<>();
                ResultSet rezultat = statement.executeQuery();
                while (rezultat.next()) {
                    Film film = new Film();
                    film.setId(rezultat.getInt(1));
                    film.setNaziv(rezultat.getString(2));
                    film.setGodina(rezultat.getInt(3));
                    film.setOpis(rezultat.getString(4));
                    film.setSlika(rezultat.getString(5));
                    film.setTrejler(rezultat.getString(6));
                    filmovi.add(film);
                }
                connection.commit();
                statement.close();
                return filmovi;
            } catch (SQLException ex) {
                connection.rollback();
            }

            connection.close();
        } catch (SQLException ex) {
        }
        return null;
    }

    public static List<Film> findByNameFilm(String q) {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            connection.setAutoCommit(false);

            String query = "SELECT * FROM film WHERE FILM_NAZIV LIKE '%?%' OR FILM_OPIS LIKE '%?%'";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                List<Film> filmovi = new ArrayList<>();
                statement.setString(1, q);
                statement.setString(2, q);
                ResultSet rezultat = statement.executeQuery();
                while (rezultat.next()) {
                    Film film = new Film();
                    film.setId(rezultat.getInt(1));
                    film.setNaziv(rezultat.getString(2));
                    film.setGodina(rezultat.getInt(3));
                    film.setOpis(rezultat.getString(4));
                    film.setSlika(rezultat.getString(5));
                    film.setTrejler(rezultat.getString(6));
                    filmovi.add(film);
                }
                connection.commit();
                statement.close();
                return filmovi;
            } catch (SQLException ex) {
                connection.rollback();
            }

            connection.close();
        } catch (SQLException ex) {
        }
        return null;
    }
}
