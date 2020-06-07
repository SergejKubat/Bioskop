package com.bioskop.db;

import com.bioskop.model.Bioskop;
import com.bioskop.model.Film;
import com.bioskop.model.Grad;
import com.bioskop.model.Klub;
import com.bioskop.model.Korisnik;
import com.bioskop.utils.HashUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
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

            String query = "INSERT INTO film (FILM_ID, FILM_NAZIV, FILM_GODINA, FILM_OPIS, FILM_SLIKA, FIRMA_TREJLER) VALUES (NULL, ?, ?, ?, ?, ?);";

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
    
    public static void uclanjenje(int korisnikId, int klubId, Date datum) {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            connection.setAutoCommit(false);

            String query = "INSERT INTO korisnik_klub (KK_ID, KORISNIK_ID, KLUB_ID, KK_DATUM_UCLANJENJA) VALUES (NULL, ?, ?, ?);";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, korisnikId);
                statement.setInt(2, klubId);
                statement.setDate(3, datum);
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

    public static Film findFilmById(int id) {

        Film film = new Film();

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            connection.setAutoCommit(false);

            String query = "SELECT * FROM film WHERE film.FILM_ID = ?";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                ResultSet rezultat = statement.executeQuery();
                while (rezultat.next()) {
                    film.setId(rezultat.getInt(1));
                    film.setNaziv(rezultat.getString(2));
                    film.setGodina(rezultat.getInt(3));
                    film.setOpis(rezultat.getString(4));
                    film.setSlika(rezultat.getString(5));
                    film.setTrejler(rezultat.getString(6));
                }
                connection.commit();
                statement.close();
                return film;
            } catch (SQLException ex) {
                connection.rollback();
            }

            connection.close();
        } catch (SQLException ex) {
        }
        return null;
    }
    
    public static Klub findKlubById(int id) {
        Klub klub = new Klub();

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            connection.setAutoCommit(false);

            String query = "SELECT * FROM klub WHERE klub.KLUB_ID = ?";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                ResultSet rezultat = statement.executeQuery();
                while (rezultat.next()) {
                    klub.setKLUB_ID(rezultat.getInt(1));
                    klub.setKLUB_NAZIV(rezultat.getString(2));
                    klub.setKLUB_POGODNOSTI(rezultat.getString(3));
                    klub.setKLUB_CLANARINA(rezultat.getInt(4));
                    klub.setSLIKA_KLUBA(rezultat.getString(5));
                }
                connection.commit();
                statement.close();
                return klub;
            } catch (SQLException ex) {
                connection.rollback();
            }

            connection.close();
        } catch (SQLException ex) {
        }
        return null;
    }

    public static Korisnik signIn(String email, String password) {

        Korisnik k = null;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            connection.setAutoCommit(false);

            String query = "SELECT * FROM korisnik WHERE korisnik.KORISNIK_EMAIL = ? AND korisnik.KORISNIK_LOZINKA = ?";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, email);
                statement.setString(2, HashUtil.getSHA(password));
                ResultSet rezultat = statement.executeQuery();
                if (rezultat.next()) {
                    k = new Korisnik(rezultat.getInt(1), rezultat.getInt(2), rezultat.getString(3), rezultat.getString(4), rezultat.getString(5), rezultat.getString(6),
                            rezultat.getInt(7), rezultat.getString(8));
                }
                connection.commit();
                statement.close();
                return k;
            } catch (SQLException ex) {
                connection.rollback();
            }

            connection.close();
        } catch (SQLException ex) {
        }
        return k;
    }

    public static boolean signUp(String ime, String prezime, String email, String brojTelefona, String lozinka) {

        boolean success = false;

        if (checkEmail(email)) {
            return success;
        }

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            connection.setAutoCommit(false);

            String query = "INSERT INTO korisnik(KORISNIK_ID, ROLA_ID, KORISNIK_IME, KORISNIK_PREZIME, KORISNIK_EMAIL, KORISNIK_BR_TEL, KORISNIK_POENI, KORISNIK_LOZINKA) "
                    + "VALUES (NULL, 1, ?, ?, ?, ?, 0, ?)";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, ime);
                statement.setString(2, prezime);
                statement.setString(3, email);
                statement.setString(4, brojTelefona);
                statement.setString(5, HashUtil.getSHA(lozinka));
                statement.executeUpdate();
                connection.commit();
                statement.close();
                return !success;
            } catch (SQLException ex) {
                connection.rollback();
            }

            connection.close();
        } catch (SQLException ex) {
        }

        return success;
    }

    private static boolean checkEmail(String email) {

        boolean exist = false;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            connection.setAutoCommit(false);

            String query = "SELECT * FROM korisnik WHERE korisnik.KORISNIK_EMAIL = ?";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, email);
                ResultSet rezultat = statement.executeQuery();
                if (rezultat.next()) {
                    exist = true;
                }
                connection.commit();
                statement.close();
                return exist;
            } catch (SQLException ex) {
                connection.rollback();
            }

            connection.close();
        } catch (SQLException ex) {
        }
        return exist;

    }

    public static List<Klub> findAllKlub() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            connection.setAutoCommit(false);

            String query = "SELECT * FROM klub;";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                List<Klub> klubovi = new ArrayList<>();
                ResultSet rezultat = statement.executeQuery();
                while (rezultat.next()) {
                    Klub klub = new Klub();
                    klub.setKLUB_ID(rezultat.getInt(1));
                    klub.setKLUB_NAZIV(rezultat.getString(2));
                    klub.setKLUB_POGODNOSTI(rezultat.getString(3));
                    klub.setKLUB_CLANARINA(rezultat.getFloat(4));
                    klub.setSLIKA_KLUBA(rezultat.getString(5));

                    klubovi.add(klub);
                }
                connection.commit();
                statement.close();
                return klubovi;
            } catch (SQLException ex) {
                connection.rollback();
            }

            connection.close();
        } catch (SQLException ex) {
        }
        return null;
    }

    public static List<Grad> findAllGrad() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            connection.setAutoCommit(false);

            String query = "SELECT * FROM grad;";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                List<Grad> gradovi = new ArrayList<>();
                ResultSet rezultat = statement.executeQuery();
                while (rezultat.next()) {
                    Grad grad = new Grad();
                    grad.setGRAD_ID(rezultat.getInt(1));
                    grad.setGRAD_IME(rezultat.getString(2));
                    gradovi.add(grad);
                }
                connection.commit();
                statement.close();
                return gradovi;
            } catch (SQLException ex) {
                connection.rollback();
            }

            connection.close();
        } catch (SQLException ex) {
        }
        return null;
    }

    public static List<Bioskop> findBioskopByGradId(int gradId) {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            connection.setAutoCommit(false);

            String query = "SELECT * FROM bioskop WHERE bioskop.GRAD_ID = ?;";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, gradId);
                List<Bioskop> bioskopi = new ArrayList<>();
                ResultSet rezultat = statement.executeQuery();
                while (rezultat.next()) {
                    Bioskop bioskop = new Bioskop();
                    bioskop.setBIOSKOP_ID(rezultat.getInt(1));
                    bioskop.setGRAD_ID(rezultat.getInt(2));
                    bioskop.setBIOSKOP_NAZIV(rezultat.getString(3));
                    bioskop.setBIOSKOP_ADRESA(rezultat.getString(4));
                    bioskop.setBIOSKOP_BR_TEL(rezultat.getString(5));
                    bioskopi.add(bioskop);
                }
                connection.commit();
                statement.close();
                return bioskopi;
            } catch (SQLException ex) {
                connection.rollback();
            }

            connection.close();
        } catch (SQLException ex) {
        }
        return null;
    }
}
