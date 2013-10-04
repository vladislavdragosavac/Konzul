/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Konzul.components;

import Konzul.entities.Korisnik;
import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

/**
 *
 * @author Mama
 */
public class Navkonzul {
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
