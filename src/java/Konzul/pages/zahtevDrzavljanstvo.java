/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Konzul.pages;

/**
 *
 * @author Mama
 */

  /*
 * popunjavanjeZahteva.java
 * Created 10.6.2012.
 */




import Konzul.entities.Drzava;
import Konzul.entities.Korisnik;
import Konzul.entities.Licnistatus;
import Konzul.entities.Status;
import Konzul.entities.TipKorisnika;
import Konzul.entities.Zahtev;
import Konzul.services.ProtectedPage;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
public class zahtevDrzavljanstvo {



    @Persist
    @Property
    private Zahtev zahtev;
    @Persist
    @Property
    private Zahtev zahtev1;
    @Property
    @Persist
    private Zahtev zahtevGrid;
    @Property
    @Persist
    private Zahtev zah;
    @Inject
    private Session hibernate;
    @ApplicationState
    @Property
    private Korisnik asoKorisnik;
    @Property
    private boolean asoKorisnikExists;
    @InjectComponent
    private Zone forma;
    @ApplicationState
    @Property
    private Zahtev asoDrzava;
    @Property
    private boolean asoZahtevExists;
    @Property
    @Persist
    private String info;
    @InjectComponent
    private Zone formZone;

    /**
     * metoda onActionFromzahtev snima zahtev i daje informaciju o broju zahteva
     * @return formZone
     */
    @CommitAfter
    public Object onActionFromZahtev() {
        Zahtev zah = new Zahtev();
 
            zah.setZahtevDatum(zahtev.getZahtevDatum());
            zah.setZahtevIme(zahtev.getZahtevIme());
            zah.setZahtevImeMajke(zahtev.getZahtevImeMajke());
            zah.setZahtevImeOca(zahtev.getZahtevImeOca());
            zah.setZahtevPrezime(zahtev.getZahtevPrezime());
            zah.setZahtevBracniDrug(zahtev.getZahtevBracniDrug());
            zah.setZahtevDatumRodjenja(zahtev.getZahtevDatumRodjenja());
            zah.setZahtevDevojackoPrezimeMajke(zahtev.getZahtevDevojackoPrezimeMajke());
            zah.setZahtevDrzavaIseljenjaId(zahtev.getZahtevDrzavaIseljenjaId());
            zah.setZahtevDrzavaRodjenjaId(zahtev.getZahtevDrzavaRodjenjaId());
            zah.setZahtevLicniStatusId(zahtev.getZahtevLicniStatusId());
            zah.setZahtevMaterijalnoStanje(zahtev.getZahtevMaterijalnoStanje());
            zah.setZahtevMestoNastanjenja(zahtev.getZahtevMestoNastanjenja());
            zah.setZahtevMestoRodjenja(zahtev.getZahtevMestoRodjenja());
            zah.setZahtevOsudjivan(zahtev.getZahtevOsudjivan());
            zah.setZahtevSkolskaSprema(zahtev.getZahtevSkolskaSprema());
            zah.setZahtevStaraoc(zahtev.getZahtevStaraoc());
            zah.setZahtevStatusId(zahtev.getZahtevStatusId());
            zah.setZahtevStranoDrzavljanstvoId(zahtev.getZahtevStranoDrzavljanstvoId());
            zah.setZahtevVO(zahtev.getZahtevVO());
            zah.setZahtevZanimanje(zahtev.getZahtevZanimanje());
            zah.setZahtevZaposlenje(zahtev.getZahtevZaposlenje());

            
            if (asoKorisnikExists){
                      zah.setZahtevKorisnikId(asoKorisnik);
            }            
            else
            {
 
                List listaRezultata = hibernate.createCriteria(Korisnik.class)
                .add(Restrictions.eq("korisnikRola",TipKorisnika.USER))
                .list();
                if(listaRezultata.size() > 0){
                Korisnik temp = (Korisnik) listaRezultata.get(0);
                zah.setZahtevKorisnikId(temp);
            }}
                      
     
            hibernate.save(zah);

        zahtev = new Zahtev();
        info= "Postovani, " +zah.getZahtevPrezime() + ", podneli ste zahtev pod brojem: "+zah.getZahtevId()+", uz ovaj broj i vaše prezime u svakom trenutku možete proveriti status vaseg zahteva u postupku obrade.";
        zah=new Zahtev();
        
        return formZone;
    }
 
    /**
     * metoda getDrzavaList vraca listu drzava
     * @return
     */
    public List<Drzava> getDrzavaList() {
        return hibernate.createCriteria(Drzava.class).list();
    }

    /**
     * metoda getStatusList vraca listu statusa
     * @return
     */
    public List<Status> getStatusList() {
        return hibernate.createCriteria(Status.class).list();
    }
    public List<Status> getLicniStatusList() {
        return hibernate.createCriteria(Licnistatus.class).list();
    }
}
  

