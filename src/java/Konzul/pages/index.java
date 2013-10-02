/*
 * index.java
 * Created 10.06.2012.
 */

package Konzul.pages;

import Konzul.entities.Korisnik;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * @author Vladislav Dragosavac
 */
public class index {
    @Persist
    @Property
    private Korisnik login;
    @InjectPage
    private index home;
    @ApplicationState
    @Property
    private Korisnik asoKorisnik;
    @Property
    private boolean asoKorisnikExists;

    @Inject
    private Session hibernate;


    /**
     * metoda onActionFromLogin
     * @return home
     */
    public Object onActionFromLogin(){
        List listaRezultata = hibernate.createCriteria(Korisnik.class).add(Restrictions.eq("korisnikIme", login.getKorisnikPristupnoIme())).add(Restrictions.eq("korisnikPass", login.getKorisnikLozinka())).list();
        if(listaRezultata.size() > 0){
            Korisnik temp = (Korisnik) listaRezultata.get(0);
            asoKorisnik = temp;
        }
        return home;
    }

    /**
     * metoda getDatum
     * @return
     */
    public String getDatum(){
    Format f = new SimpleDateFormat("dd.MM.yyyy");
    return f.format(new Date());
    }









}

