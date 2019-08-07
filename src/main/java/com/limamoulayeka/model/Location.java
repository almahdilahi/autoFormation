/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.limamoulayeka.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
 * @author HP
 */
@Entity
@Table(name = "location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l")
    , @NamedQuery(name = "Location.findByIdl", query = "SELECT l FROM Location l WHERE l.idl = :idl")
    , @NamedQuery(name = "Location.findByDate", query = "SELECT l FROM Location l WHERE l.date = :date")
    , @NamedQuery(name = "Location.findByNbjour", query = "SELECT l FROM Location l WHERE l.nbjour = :nbjour")
    , @NamedQuery(name = "Location.findByMontant", query = "SELECT l FROM Location l WHERE l.montant = :montant")
    , @NamedQuery(name = "Location.findByRemarque", query = "SELECT l FROM Location l WHERE l.remarque = :remarque")})
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idl")
    private Integer idl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nbjour")
    private int nbjour;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montant")
    private int montant;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "remarque")
    private String remarque;
    @JoinColumn(name = "idVehicule", referencedColumnName = "idv")
    @ManyToOne(optional = false)
    private Vehicule idVehicule;
    @JoinColumn(name = "idClient", referencedColumnName = "idc")
    @ManyToOne(optional = false)
    private Client idClient;

    public Location() {
    }

    public Location(Integer idl) {
        this.idl = idl;
    }

    public Location(Integer idl, Date date, int nbjour, int montant, String remarque) {
        this.idl = idl;
        this.date = date;
        this.nbjour = nbjour;
        this.montant = montant;
        this.remarque = remarque;
    }

    public Integer getIdl() {
        return idl;
    }

    public void setIdl(Integer idl) {
        this.idl = idl;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNbjour() {
        return nbjour;
    }

    public void setNbjour(int nbjour) {
        this.nbjour = nbjour;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public Vehicule getIdVehicule() {
        return idVehicule;
    }

    public void setIdVehicule(Vehicule idVehicule) {
        this.idVehicule = idVehicule;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idl != null ? idl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.idl == null && other.idl != null) || (this.idl != null && !this.idl.equals(other.idl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.limamoulayeka.model.Location[ idl=" + idl + " ]";
    }
    
}
