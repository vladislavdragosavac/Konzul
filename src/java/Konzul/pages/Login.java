/**
 * Login.java
 * Created 10.06.2012.
 */

package Konzul.pages;

import Konzul.entities.Korisnik;
import java.util.List;
import java.util.Locale;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PersistentLocale;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * @author Vladislav Dragosavac
 */
// Da bi aktivirali pristup web stranici samo preko HTTPS, aktivirati anotaciju @Secure
// @Secure
public class Login {
    @Persist
    @Property
    private Korisnik login;
    @InjectPage
    private Login prijava;
    @InjectPage
    private index home;
    @ApplicationState
    @Property
    private Korisnik asoKorisnik;
    @Property
    private boolean asoKorisnikExists;
    @Inject
    private Session hibernate;
    @Inject
    private PersistentLocale persistentLocale;

    /**
     * Metoda onActionFromLogin
     * @return home page
     */
   public Object onActionFromLogin(){
        List listaRezultata = hibernate.createCriteria(Korisnik.class)
                .add(Restrictions.eq("korisnikPristupnoIme", login.getKorisnikPristupnoIme()))
                .add(Restrictions.eq("korisnikLozinka", login.getKorisnikLozinka()))
                .list();
        if(listaRezultata.size() > 0){
            Korisnik temp = (Korisnik) listaRezultata.get(0);
            asoKorisnik = temp;

            persistentLocale.set(new Locale("sr"));
         //   info= "Unesite vaše login podatke";
            return home;
        } else {
         // sledeci red je removan kao mera zastite od brutal force napada
         //   info= "Autentikacija nije uspela, pokušajte ponovo." ;
            return home;
        }

    }

}