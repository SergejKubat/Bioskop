package com.bioskop.controller;

import com.bioskop.db.DBHelper;
import com.bioskop.utils.Validation;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet extends HttpServlet {

    /* Kada korisnik pita server za podatke */
    /* resources/img/film1.jpg */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String putanja = request.getServletPath();

        if (putanja.equals("/prijava")) {
            // TODO: Napisati kod za prijavu
        } else if (putanja.equals("/registracija")) {
            // TODO: Napisati kod za registraciju
        } else if (putanja.equals("/pretraga")) {
            String q = (String) request.getAttribute("search");
            System.out.println("Query:" + q);
            request.setAttribute("filmovi", DBHelper.findByNameFilm(q));
        } else if (putanja.equals("/nalog")) {
            // TODO: Napisati kod za nalog
        } else if (putanja.equals("/rezervacija")) {
            // TODO: Napisati kod za rezervacija
        } else if (putanja.equals("/film")) {
            // TODO: Napisati kod za film
        } else if (putanja.equals("/klubovi")) {
            // TODO: Napisati kod za klubove
        }

        String adresa = "/WEB-INF/view/" + putanja + ".jsp";
        try {
            request.getRequestDispatcher(adresa).forward(request, response);
        } catch (IOException | ServletException ex) {
            System.out.println(ex.toString());
        }
    }

    /* Kada korisnik salje podatke serveru */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String putanja = request.getServletPath();

        if (putanja.equals("/prijava")) {
            String email = (String) request.getAttribute("email");
            String password = (String) request.getAttribute("password");
            boolean isValid = Validation.proveriEmail(email) && Validation.proveriLozinku(password);
            if (isValid) {
                // metoda iz baze
            } else {
                // redirekcija
            }
        } else if (putanja.equals("/registracija")) {
            // TODO: Napisati kod za registraciju
        } else if (putanja.equals("/rezervisi")) {
            // TODO: Napisati kod za rezervaciju
        } else if (putanja.equals("/uclanjenje")) {
            // TODO: Napisati kod za uclanjenje
        }
    }

}
