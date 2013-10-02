/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Konzul.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mama
 */
@Entity
@Table(name = "licnistatus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Licnistatus.findAll", query = "SELECT l FROM Licnistatus l"),
    @NamedQuery(name = "Licnistatus.findByLicniStatusId", query = "SELECT l FROM Licnistatus l WHERE l.licniStatusId = :licniStatusId")})
public class Licnistatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LicniStatusId")
    private Integer licniStatusId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "LicniStatusOpis")
    private String licniStatusOpis;
    @OneToMany(mappedBy = "zahtevLicniStatusId")
    private Collection<Zahtev> zahtevCollection;

    public Licnistatus() {
    }

    public Licnistatus(Integer licniStatusId) {
        this.licniStatusId = licniStatusId;
    }

    public Licnistatus(Integer licniStatusId, String licniStatusOpis) {
        this.licniStatusId = licniStatusId;
        this.licniStatusOpis = licniStatusOpis;
    }

    public Integer getLicniStatusId() {
        return licniStatusId;
    }

    public void setLicniStatusId(Integer licniStatusId) {
        this.licniStatusId = licniStatusId;
    }

    public String getLicniStatusOpis() {
        return licniStatusOpis;
    }

    public void setLicniStatusOpis(String licniStatusOpis) {
        this.licniStatusOpis = licniStatusOpis;
    }

    @XmlTransient
    public Collection<Zahtev> getZahtevCollection() {
        return zahtevCollection;
    }

    public void setZahtevCollection(Collection<Zahtev> zahtevCollection) {
        this.zahtevCollection = zahtevCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (licniStatusId != null ? licniStatusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Licnistatus)) {
            return false;
        }
        Licnistatus other = (Licnistatus) object;
        if ((this.licniStatusId == null && other.licniStatusId != null) || (this.licniStatusId != null && !this.licniStatusId.equals(other.licniStatusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Konzul.entities.Licnistatus[ licniStatusId=" + licniStatusId + " ]";
    }
    
}
