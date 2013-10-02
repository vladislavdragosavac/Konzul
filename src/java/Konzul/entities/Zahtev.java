/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Konzul.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mama
 */
@Entity
@Table(name = "zahtev")

public class Zahtev implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ZahtevId")
    private Integer zahtevId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ZahtevDatum")
    @Temporal(TemporalType.DATE)
    private Date zahtevDatum;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "ZahtevIme")
    private String zahtevIme;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "ZahtevPrezime")
    private String zahtevPrezime;
    @Lob
    @Size(max = 65535)
    @Column(name = "ZahtevImeOca")
    private String zahtevImeOca;
    @Lob
    @Size(max = 65535)
    @Column(name = "ZahtevImeMajke")
    private String zahtevImeMajke;
    @Lob
    @Size(max = 65535)
    @Column(name = "ZahtevDevojackoPrezimeMajke")
    private String zahtevDevojackoPrezimeMajke;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ZahtevDatumRodjenja")
    @Temporal(TemporalType.DATE)
    private Date zahtevDatumRodjenja;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "ZahtevMestoRodjenja")
    private String zahtevMestoRodjenja;
    @Lob
    @Size(max = 65535)
    @Column(name = "ZahtevZanimanje")
    private String zahtevZanimanje;
    @Lob
    @Size(max = 65535)
    @Column(name = "ZahtevSkolskaSprema")
    private String zahtevSkolskaSprema;
    @Lob
    @Size(max = 65535)
    @Column(name = "ZahtevMestoNastanjenja")
    private String zahtevMestoNastanjenja;
    @Lob
    @Size(max = 65535)
    @Column(name = "ZahtevVO")
    private String zahtevVO;
    @Lob
    @Size(max = 65535)
    @Column(name = "ZahtevZaposlenje")
    private String zahtevZaposlenje;
    @Lob
    @Size(max = 65535)
    @Column(name = "ZahtevMaterijalnoStanje")
    private String zahtevMaterijalnoStanje;
    @Lob
    @Size(max = 65535)
    @Column(name = "ZahtevBracniDrug")
    private String zahtevBracniDrug;
    @Lob
    @Size(max = 65535)
    @Column(name = "ZahtevOsudjivan")
    private String zahtevOsudjivan;
    @Lob
    @Size(max = 65535)
    @Column(name = "ZahtevStaraoc")
    private String zahtevStaraoc;
    @JoinColumn(name = "ZahtevStranoDrzavljanstvoId", referencedColumnName = "DrzavaId")
    @ManyToOne
    private Drzava zahtevStranoDrzavljanstvoId;
    @JoinColumn(name = "ZahtevLicniStatusId", referencedColumnName = "LicniStatusId")
    @ManyToOne
    private Licnistatus zahtevLicniStatusId;
    @JoinColumn(name = "ZahtevKorisnikId", referencedColumnName = "KorisnikId")
    @ManyToOne(optional = false)
    private Korisnik zahtevKorisnikId;
    @JoinColumn(name = "ZahtevDrzavaRodjenjaId", referencedColumnName = "DrzavaId")
    @ManyToOne
    private Drzava zahtevDrzavaRodjenjaId;
    @JoinColumn(name = "ZahtevDrzavaIseljenjaId", referencedColumnName = "DrzavaId")
    @ManyToOne
    private Drzava zahtevDrzavaIseljenjaId;
    @JoinColumn(name = "ZahtevStatusId", referencedColumnName = "StatusId")
    @ManyToOne(optional = false)
    private Status zahtevStatusId;

    public Zahtev() {
    }



    public Integer getZahtevId() {
        return zahtevId;
    }

    public void setZahtevId(Integer zahtevId) {
        this.zahtevId = zahtevId;
    }

    public Date getZahtevDatum() {
        return zahtevDatum;
    }

    public void setZahtevDatum(Date zahtevDatum) {
        this.zahtevDatum = zahtevDatum;
    }

    public String getZahtevIme() {
        return zahtevIme;
    }

    public void setZahtevIme(String zahtevIme) {
        this.zahtevIme = zahtevIme;
    }

    public String getZahtevPrezime() {
        return zahtevPrezime;
    }

    public void setZahtevPrezime(String zahtevPrezime) {
        this.zahtevPrezime = zahtevPrezime;
    }

    public String getZahtevImeOca() {
        return zahtevImeOca;
    }

    public void setZahtevImeOca(String zahtevImeOca) {
        this.zahtevImeOca = zahtevImeOca;
    }

    public String getZahtevImeMajke() {
        return zahtevImeMajke;
    }

    public void setZahtevImeMajke(String zahtevImeMajke) {
        this.zahtevImeMajke = zahtevImeMajke;
    }

    public String getZahtevDevojackoPrezimeMajke() {
        return zahtevDevojackoPrezimeMajke;
    }

    public void setZahtevDevojackoPrezimeMajke(String zahtevDevojackoPrezimeMajke) {
        this.zahtevDevojackoPrezimeMajke = zahtevDevojackoPrezimeMajke;
    }

    public Date getZahtevDatumRodjenja() {
        return zahtevDatumRodjenja;
    }

    public void setZahtevDatumRodjenja(Date zahtevDatumRodjenja) {
        this.zahtevDatumRodjenja = zahtevDatumRodjenja;
    }

    public String getZahtevMestoRodjenja() {
        return zahtevMestoRodjenja;
    }

    public void setZahtevMestoRodjenja(String zahtevMestoRodjenja) {
        this.zahtevMestoRodjenja = zahtevMestoRodjenja;
    }

    public String getZahtevZanimanje() {
        return zahtevZanimanje;
    }

    public void setZahtevZanimanje(String zahtevZanimanje) {
        this.zahtevZanimanje = zahtevZanimanje;
    }

    public String getZahtevSkolskaSprema() {
        return zahtevSkolskaSprema;
    }

    public void setZahtevSkolskaSprema(String zahtevSkolskaSprema) {
        this.zahtevSkolskaSprema = zahtevSkolskaSprema;
    }

    public String getZahtevMestoNastanjenja() {
        return zahtevMestoNastanjenja;
    }

    public void setZahtevMestoNastanjenja(String zahtevMestoNastanjenja) {
        this.zahtevMestoNastanjenja = zahtevMestoNastanjenja;
    }

    public String getZahtevVO() {
        return zahtevVO;
    }

    public void setZahtevVO(String zahtevVO) {
        this.zahtevVO = zahtevVO;
    }

    public String getZahtevZaposlenje() {
        return zahtevZaposlenje;
    }

    public void setZahtevZaposlenje(String zahtevZaposlenje) {
        this.zahtevZaposlenje = zahtevZaposlenje;
    }

    public String getZahtevMaterijalnoStanje() {
        return zahtevMaterijalnoStanje;
    }

    public void setZahtevMaterijalnoStanje(String zahtevMaterijalnoStanje) {
        this.zahtevMaterijalnoStanje = zahtevMaterijalnoStanje;
    }

    public String getZahtevBracniDrug() {
        return zahtevBracniDrug;
    }

    public void setZahtevBracniDrug(String zahtevBracniDrug) {
        this.zahtevBracniDrug = zahtevBracniDrug;
    }

    public String getZahtevOsudjivan() {
        return zahtevOsudjivan;
    }

    public void setZahtevOsudjivan(String zahtevOsudjivan) {
        this.zahtevOsudjivan = zahtevOsudjivan;
    }

    public String getZahtevStaraoc() {
        return zahtevStaraoc;
    }

    public void setZahtevStaraoc(String zahtevStaraoc) {
        this.zahtevStaraoc = zahtevStaraoc;
    }

    public Drzava getZahtevStranoDrzavljanstvoId() {
        return zahtevStranoDrzavljanstvoId;
    }

    public void setZahtevStranoDrzavljanstvoId(Drzava zahtevStranoDrzavljanstvoId) {
        this.zahtevStranoDrzavljanstvoId = zahtevStranoDrzavljanstvoId;
    }

    public Licnistatus getZahtevLicniStatusId() {
        return zahtevLicniStatusId;
    }

    public void setZahtevLicniStatusId(Licnistatus zahtevLicniStatusId) {
        this.zahtevLicniStatusId = zahtevLicniStatusId;
    }

    public Korisnik getZahtevKorisnikId() {
        return zahtevKorisnikId;
    }

    public void setZahtevKorisnikId(Korisnik zahtevKorisnikId) {
        this.zahtevKorisnikId = zahtevKorisnikId;
    }

    public Drzava getZahtevDrzavaRodjenjaId() {
        return zahtevDrzavaRodjenjaId;
    }

    public void setZahtevDrzavaRodjenjaId(Drzava zahtevDrzavaRodjenjaId) {
        this.zahtevDrzavaRodjenjaId = zahtevDrzavaRodjenjaId;
    }

    public Drzava getZahtevDrzavaIseljenjaId() {
        return zahtevDrzavaIseljenjaId;
    }

    public void setZahtevDrzavaIseljenjaId(Drzava zahtevDrzavaIseljenjaId) {
        this.zahtevDrzavaIseljenjaId = zahtevDrzavaIseljenjaId;
    }

    public Status getZahtevStatusId() {
        return zahtevStatusId;
    }

    public void setZahtevStatusId(Status zahtevStatusId) {
        this.zahtevStatusId = zahtevStatusId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zahtevId != null ? zahtevId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zahtev)) {
            return false;
        }
        Zahtev other = (Zahtev) object;
        if ((this.zahtevId == null && other.zahtevId != null) || (this.zahtevId != null && !this.zahtevId.equals(other.zahtevId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Konzul.entities.Zahtev[ zahtevId=" + zahtevId + " ]";
    }
    
}
