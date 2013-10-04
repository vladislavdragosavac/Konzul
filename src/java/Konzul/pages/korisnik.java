/*
 * korisnik.java
 * Created 10.6.2012.
 */

package Konzul.pages;

import Konzul.entities.Korisnik;
import Konzul.entities.TipKorisnika;
import Konzul.services.ProtectedPage;
import java.util.List;
import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * @author Vladislav Dragosavac
 */

public class korisnik {
    @Persist
    @Property
    private Korisnik korisnik;
    @Property
    @Persist
    private Korisnik korisnikGrid;
    @Property
    @Persist
    private Korisnik kor;
    @Inject
    private Session hibernate;
    @InjectComponent
    private Zone lista;
    @InjectComponent
    private Zone forma;
    @ApplicationState
    @Property
    private Korisnik asoKorisnik;
    @Property
    private boolean asoKorisnikExists;


    /**
     * metoda onActionFromKorisnik dodavanje ili azuriranje korisnika
     * @return
     */
    @CommitAfter
    public Object onActionFromKorisnik() {
        Korisnik kor = new Korisnik();
        if (korisnik.getKorisnikId() == null) {
            kor.setKorisnikIme(korisnik.getKorisnikIme());
            kor.setKorisnikPrezime(korisnik.getKorisnikPrezime());
            kor.setKorisnikPristupnoIme(korisnik.getKorisnikPristupnoIme());
            kor.setKorisnikLozinka(korisnik.getKorisnikLozinka());
            kor.setKorisnikRola(korisnik.getKorisnikRola());
            hibernate.save(kor);
        } else {
            kor = (Korisnik) hibernate.createCriteria(Korisnik.class).add(Restrictions.eq("id", korisnik.getKorisnikId())).list().get(0);
            kor.setKorisnikIme(korisnik.getKorisnikIme());
            kor.setKorisnikPrezime(korisnik.getKorisnikPrezime());
            kor.setKorisnikPristupnoIme(korisnik.getKorisnikPristupnoIme());
            kor.setKorisnikLozinka(korisnik.getKorisnikLozinka());
            kor.setKorisnikRola(korisnik.getKorisnikRola());
            hibernate.update(kor);
        }
        korisnik = new Korisnik();
        return lista;
    }

    /**
     * metoda getKorisnici
     * @return List
     */
    public List<Korisnik> getKorisnici() {
        return hibernate.createCriteria(Korisnik.class).list();
    }

    /**
     * Metoda ucitavanje korisnika
     * @param username
     * @return
     */
    public Zone onActionFromKor(String username) {
        Korisnik kor = (Korisnik) hibernate.createCriteria(Korisnik.class).add(Restrictions.eq("korisnikPristupnoIme", username)).list().get(0);
        korisnik = new Korisnik();
        korisnik.setKorisnikIme(kor.getKorisnikIme());
        korisnik.setKorisnikPrezime(kor.getKorisnikPrezime());
        korisnik.setKorisnikPristupnoIme(kor.getKorisnikPristupnoIme());
        korisnik.setKorisnikLozinka(kor.getKorisnikLozinka());
        korisnik.setKorisnikRola(kor.getKorisnikRola());
        korisnik.setKorisnikId(kor.getKorisnikId());
        return forma;
    }

    @CommitAfter
    public Zone onActionFromDelete(String username) {
        Korisnik kor = (Korisnik) hibernate.createCriteria(Korisnik.class).add(Restrictions.eq("korisnikPristupnoIme", username)).list().get(0);
        hibernate.delete(kor);
        return lista;
    }
    
}
