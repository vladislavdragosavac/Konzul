/**
 * Korisnik.java
 * Created 10.06.2012
 */

package Konzul.entities;


import javax.persistence.*;
import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;


/**
 * @author Vladislav Dragosavac
 */
@Entity
public class Korisnik {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "KORISNIKID")
    private Long korisnikId;
    @Basic(optional = false)
    @Column(name = "KORISNIKIME")
    private String korisnikIme;
    @Basic(optional = false)
    @Column(name = "KORISNIKPREZIME")
    private String korisnikPrezime;
    @Basic(optional = false)
    @Column(name = "KORISNIKPRISTUPNOIME")
    private String korisnikPristupnoIme;
    @Basic(optional = false)
    @Column(name = "KORISNIKLOZINKA")
    private String korisnikLozinka;
    @Basic(optional = false)
    @Column(name = "KORISNIKROLA")
    @Enumerated(EnumType.STRING)
    private TipKorisnika korisnikRola;





    /**
     * Prazan konstuktor
     */
    public Korisnik() {
    }

    /**
     * geter za podatak KorisnikId
     * @return
     */
    @NonVisual
    public Long getKorisnikId() {
        return korisnikId;
    }


    /**
     * seter za podatak korisnikId
     * @param korisnikId
     */
    public void setKorisnikId(Long korisnikId) {
        this.korisnikId = korisnikId;
    }

    /**
     * geter za podatak korisnikIme
     * @return
     */
    @Validate("required,minlength=4,maxlength=25")
    public String getKorisnikIme() {
        return korisnikIme;
    }


    /**
     * seter za podatak korisnikIme
     * @param korisnikIme
     */
    public void setKorisnikIme(String korisnikIme) {
        this.korisnikIme = korisnikIme;
    }

    /**
     * geter za podatak korisnikPrezime
     * @return
     */
    @Validate("required,minlength=4,maxlength=25")
    public String getKorisnikPrezime() {
        return korisnikPrezime;
    }


    /**
     * seter za podatak korisnikPrezime
     * @param korisnikPrezime
     */
    public void setKorisnikPrezime(String korisnikPrezime) {
        this.korisnikPrezime = korisnikPrezime;
    }

    /**
     * geter za podatak korisnikPristupnoIme
     * @return
     */
    @Validate("required,minlength=4,maxlength=25")
    public String getKorisnikPristupnoIme() {
        return korisnikPristupnoIme;
    }

 
    /**
     * seter za podatak korisnikPristupnoIme
     * @param korisnikPristupnoIme
     */
    public void setKorisnikPristupnoIme(String korisnikPristupnoIme) {
        this.korisnikPristupnoIme = korisnikPristupnoIme;
    }

    /**
     * geter za podatak korisnikLozinka
     * @return
     */
    @Validate("required,minlength=4,maxlength=8")
    public String getKorisnikLozinka() {
        return korisnikLozinka;
    }

    /**
     * seter za podatak korisnikLozinka
     * @param korisnikLozinka
     */
    public void setKorisnikLozinka(String korisnikLozinka) {
        this.korisnikLozinka = korisnikLozinka;
    }


    /**
     * geter za podatak korisnikRola
     * @return
     */
    @Validate("required")
    public TipKorisnika getKorisnikRola() {
        return korisnikRola;
    }


    /**
     * seter za podatakKorisnikRola
     * @param korisnikRola
     */
    public void setKorisnikRola(TipKorisnika korisnikRola) {
        this.korisnikRola = korisnikRola;
    }




    @Override
    public int hashCode() {
        int hash = 0;
        hash += (korisnikId != null ? korisnikId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Korisnik)) {
            return false;
        }
        Korisnik other = (Korisnik) object;
        if ((this.korisnikId == null && other.korisnikId != null) || (this.korisnikId != null && !this.korisnikId.equals(other.korisnikId))) {
            return false;
        }
        return true;
    }

    /**
     * implementacija toString prikaza
     * @return
     */
    @Override
    public String toString() {
        return "korisnik: " + korisnikId + " ime: " +korisnikIme;
    }
}
