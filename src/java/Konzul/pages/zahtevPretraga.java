/*
 * korisnik.java
 * Created 10.6.2012.
 */

package Konzul.pages;


import Konzul.entities.Zahtev;
import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.InjectPage;
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

public class zahtevPretraga {
    @Persist
    @Property
    private Zahtev zahtev;
    @Property
    @Persist
    private Zahtev zahtevGrid;
    @Property
    @Persist
    private Zahtev zah;
    @Inject
    private Session hibernate;

    @InjectComponent
    private Zone forma;

    @Property
    private boolean asoKorisnikExists;
    @InjectPage
    private zahtevDrzavljanstvo pageZahtevDrzavljanstvo;

    
    @CommitAfter
    public Object onActionFromZahtev() {
        Zahtev zah = new Zahtev();

            zah = (Zahtev) hibernate.createCriteria(Zahtev.class)
                    .add(Restrictions.eq("zahtevId", zahtev.getZahtevId()))
                    .add(Restrictions.eq("zahtevDatumRodjenja", zahtev.getZahtevDatumRodjenja()))
                    .list()
                    .get(0);

	pageZahtevDrzavljanstvo.set(zah);
	return pageZahtevDrzavljanstvo;
    }

}
