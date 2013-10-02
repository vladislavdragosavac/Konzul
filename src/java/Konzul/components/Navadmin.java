/*
 * Navadmin.java
 * Created 10.06.2012
 */
package Konzul.components;

import Konzul.entities.Korisnik;
import Konzul.entities.Status;
import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * @author Vladislav Dragosavac
 */
public class Navadmin {

     @Inject
    private Session hibernate;
    @ApplicationState
    @Property
    private Korisnik asoKorisnik;
    @Property
    private boolean asoKorisnikExists;

    /**
     * metoda onActionFromLogout
     * @return null
     */
    public Object onActionFromLogout() {
        asoKorisnik = null;
        return null;
    }

}
