

package Konzul.pages;

import Konzul.entities.Zahtev;
import java.util.List;
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

public class zahtevLista {

    @Property
    @Persist
    private zahtevLista zahtevGrid;
    @Property
    @Persist
    private zahtevLista zah;
    @Inject
    private Session hibernate;
    @InjectComponent
    private Zone lista;

    @ApplicationState
    @Property
    private zahtevDrzavljanstvo asoZahtev;
    @Property
    private boolean asoZahtevExists;
    @InjectPage
    private zahtevDrzavljanstvo zahtevDrzavljanstvo;



    public List<Zahtev> getZahtevi() {
        return hibernate.createCriteria(Zahtev.class).list();
    }


    public void onActionFromZah(Integer id) {
        Zahtev zah = (Zahtev) hibernate.createCriteria(Zahtev.class).add(Restrictions.eq("zahtevId", id)).list().get(0);
        
        zahtevDrzavljanstvo.set(zah);
      // return zahtevDrzavljanstvo;
    }

    @CommitAfter
    public Zone onActionFromDelete(Integer id) {
        Zahtev zah = (Zahtev) hibernate.createCriteria(Zahtev.class).add(Restrictions.eq("zahtevId", id)).list().get(0);
        hibernate.delete(zah);
        return lista;
    }
    
}
