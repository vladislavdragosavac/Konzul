/*
 * Drzava.java
 * Created 11.06.2012.
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
import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;

/**
 * @author Vladislav Dragosavac
 */
@Entity
@Table(name = "drzava")
public class Drzava implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "DrzavaID")
    private Integer drzavaId;
    @Lob
    @Column(name = "DrzavaNaziv")
    private String naziv;
 
    /**
     * Prazan konstruktor klase Drzava
     */
    public Drzava() {
    }


    /**
     * geter za podatak drzavaId
     * @return drzavaId
     */
    @NonVisual
    public Integer getDrzavaId() {
        return drzavaId;
    }

    /**
     * seter za podatak drzavaId
     * @param drzavaId to set
     */
    public void setDrzavaId(Integer drzavaId) {
        this.drzavaId = drzavaId;
    }

    /**
     * geter za podatak naziv
     * @return naziv
     */
    @Validate("required")
    public String getDrzavaNaziv() {
        return naziv;
    }

    /**
     * seter za podatak naziv
     * @param naziv
     */
    public void setDrzavaNaziv(String naziv) {
        this.naziv = naziv;
    }

  
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (drzavaId != null ? drzavaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Drzava)) {
            return false;
        }
        Drzava other = (Drzava) object;
        if ((this.drzavaId == null && other.drzavaId != null) || (this.drzavaId != null && !this.drzavaId.equals(other.drzavaId))) {
            return false;
        }
        return true;
    }

    // implementacija toString prikaza
    @Override
    public String toString() {
        return "=" + drzavaId + ".";
    }

}
