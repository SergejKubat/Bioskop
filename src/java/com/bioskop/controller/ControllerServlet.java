package com.bioskop.controller;

import com.bioskop.db.DBHelper;
import com.bioskop.model.Korisnik;
import com.bioskop.utils.Validation;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControllerServlet extends HttpServlet {

    /* Kada korisnik pita server za podatke */
 /* resources/img/film1.jpg */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String putanja = request.getServletPath();
        HttpSession sesija = request.getSession();
        List<String> stilovi = new ArrayList<>();
        Korisnik user = (Korisnik) sesija.getAttribute("korisnik");

        if (putanja.equals("/prijava")) {
            // TODO: Napisati kod za prijavu
        } else if (putanja.equals("/registracija")) {
            // TODO: Napisati kod za registraciju
        } else if (putanja.equals("/pretraga")) {
            String q = (String) request.getParameter("search");
            request.setAttribute("filmovi", DBHelper.findAllFilm().stream().filter(e -> e.getNaziv().toLowerCase().contains(q.toLowerCase())).collect(Collectors.toList()));
        } else if (putanja.equals("/nalog")) {
            request.setAttribute("korisnik", user);
        } else if (putanja.equals("/rezervacija")) {
            // TODO: Napisati kod za rezervacija
        } else if (putanja.equals("/film")) {
            Integer id = Integer.parseInt((String) request.getParameter("id"));
            request.setAttribute("film", DBHelper.findFilmById(id));
            stilovi.add("shop-item");
            
        } else if (putanja.equals("/klubovi")) {
            request.setAttribute("klubovi", DBHelper.findAllKlub());
        } else if (putanja.equals("/grad")) {
            Integer id = Integer.parseInt((String) request.getParameter("id"));
            request.setAttribute("bioskopi", DBHelper.findBioskopByGradId(id));
        } else if (putanja.equals("/odjava")) {
            if (user != null) {
                sesija.removeAttribute("korisnik");
                sesija.invalidate();
                user = null;
            }
            putanja = "/prijava";
        } else if (putanja.equals("/clanstvo")) {
            if (user != null) {
                int id = Integer.parseInt((String) request.getParameter("id"));
                request.setAttribute("klub", DBHelper.findKlubById(id));
            }
            else {
                putanja = "/prijava";
            }
        }
        
        request.setAttribute("stilovi", stilovi);
        request.setAttribute("gradovi", DBHelper.findAllGrad());
        request.setAttribute("korisnik", user);

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
        HttpSession sesija = request.getSession();

        if (putanja.equals("/prijava")) {
            String poruka = "";
            
            String email = (String) request.getParameter("email");
            String password = (String) request.getParameter("password");
            
            System.out.println("Email:" + email);
            System.out.println("Password:" + password);
            boolean isValid = Validation.proveriEmail(email) && Validation.proveriLozinku(password);
            if (isValid) {
                Korisnik user = DBHelper.signIn(email, password);
                if (user != null) {
                    sesija.setAttribute("korisnik", user);
                    putanja = "/nalog";
                }
                else {
                    poruka = "Prijava nije uspešna!";
                }
            } else {
                poruka = "Podaci su u pogrešnom formatu!";
            }
            request.setAttribute("poruka", poruka);
        } else if (putanja.equals("/registracija")) {
            String poruka;

            String ime = (String) request.getParameter("ime");
            String prezime = (String) request.getParameter("prezime");
            String email = (String) request.getParameter("email");
            String brt = (String) request.getParameter("brt");
            String lozinka = (String) request.getParameter("lozinka");

            boolean isValid = Validation.proveriIme(ime) && Validation.proveriIme(prezime) && Validation.proveriEmail(email) && Validation.proveriBroj(brt)
                    && Validation.proveriLozinku(lozinka);
            if (isValid) {
                if (DBHelper.signUp(ime, prezime, email, brt, lozinka)) {
                    poruka = "Uspešno ste se registrovali!";
                } else {
                    poruka = "Email već postoji!";
                }
            } else {
                poruka = "Podaci koje ste uneli nisu u validnom formatu!";
            }
            request.setAttribute("poruka", poruka);
        } else if (putanja.equals("/rezervisi")) {
            // TODO: Napisati kod za rezervaciju
        } else if (putanja.equals("/uclanjenje")) {
            int korisnikId = Integer.parseInt((String) request.getParameter("korisnikId"));
            int klubId = Integer.parseInt((String) request.getParameter("klubId"));
            Date datum = new Date(System.currentTimeMillis());
            DBHelper.uclanjenje(korisnikId, klubId, datum);
            putanja = "/nalog";
        }

        String adresa = "/WEB-INF/view/" + putanja + ".jsp";
        try {
            request.getRequestDispatcher(adresa).forward(request, response);
        } catch (IOException | ServletException ex) {
            System.out.println(ex.toString());
        }
    }

}
