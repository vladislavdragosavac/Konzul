/*
 * korisnik.java
 * Created 10.6.2012.
 */

package Konzul.pages;

import Konzul.entities.Drzava;
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
@ProtectedPage(getRole=TipKorisnika.ADMIN)
public class drzava {
    @Persist
    @Property
    private Drzava drzava;
    @Property
    @Persist
    private Drzava drzavaGrid;
    @Property
    @Persist
    private Drzava drz;
    @Inject
    private Session hibernate;
    @InjectComponent
    private Zone lista;
    @InjectComponent
    private Zone forma;
    @ApplicationState
    @Property
    private Korisnik asoDrzava;
    @Property
    private boolean asoDrzavaExists;

    /**
     * metoda onActionFromKorisnik dodavanje ili azuriranje korisnika
     * @return
     */
    @CommitAfter
    public Object onActionFromDrzava() {
        Drzava drz = new Drzava();
        if (drzava.getDrzavaId() == null) {
            drz.setDrzavaNaziv(drzava.getDrzavaNaziv());
            hibernate.save(drz);
        } else {
            drz = (Drzava) hibernate.createCriteria(Drzava.class).add(Restrictions.eq("id", drzava.getDrzavaId())).list().get(0);
            drz.setDrzavaNaziv(drzava.getDrzavaNaziv());
             hibernate.update(drz);
        }
        drzava = new Drzava();
        return lista;
    }

    /**
     * metoda getKorisnici
     * @return List
     */
    public List<Drzava> getDrzave() {
        return hibernate.createCriteria(Drzava.class).list();
    }

    /**
     * Metoda ucitavanje korisnika
     * @param username
     * @return
     */
    public Zone onActionFromDrz(String naziv) {
        Drzava drz = (Drzava) hibernate.createCriteria(Drzava.class).add(Restrictions.eq("naziv", naziv)).list().get(0);
        drzava = new Drzava();
        drzava.setDrzavaNaziv(drz.getDrzavaNaziv());
        drzava.setDrzavaId(drz.getDrzavaId());
        return forma;
    }

    /**
     * Metoda onActionFromDelete akcija na komandu delete
     * @param username
     * @return
     */
    @CommitAfter
    public Zone onActionFromDelete(String naziv) {
        Drzava drz = (Drzava) hibernate.createCriteria(Drzava.class).add(Restrictions.eq("naziv", naziv)).list().get(0);
        hibernate.delete(drz);
        return lista;
    }

}
