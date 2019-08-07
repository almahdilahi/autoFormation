/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.limamoulayeka.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author HP
 */
@Entity
@Table(name = "vehicule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehicule.findAll", query = "SELECT v FROM Vehicule v")
    , @NamedQuery(name = "Vehicule.findByIdv", query = "SELECT v FROM Vehicule v WHERE v.idv = :idv")
    , @NamedQuery(name = "Vehicule.findByMatricule", query = "SELECT v FROM Vehicule v WHERE v.matricule = :matricule")
    , @NamedQuery(name = "Vehicule.findByMarque", query = "SELECT v FROM Vehicule v WHERE v.marque = :marque")
    , @NamedQuery(name = "Vehicule.findByModele", query = "SELECT v FROM Vehicule v WHERE v.modele = :modele")
    , @NamedQuery(name = "Vehicule.findByCouleur", query = "SELECT v FROM Vehicule v WHERE v.couleur = :couleur")
    , @NamedQuery(name = "Vehicule.findByPrixjour", query = "SELECT v FROM Vehicule v WHERE v.prixjour = :prixjour")})
public class Vehicule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idv")
    private Integer idv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "matricule")
    private String matricule;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "marque")
    private String marque;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "modele")
    private String modele;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "couleur")
    private String couleur;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prixjour")
    private int prixjour;
    @JoinColumn(name = "idModele", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Modele idModele;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVehicule")
    private List<Location> locationList;

    public Vehicule() {
    }

    public Vehicule(Integer idv) {
        this.idv = idv;
    }

    public Vehicule(Integer idv, String matricule, String marque, String modele, String couleur, int prixjour) {
        this.idv = idv;
        this.matricule = matricule;
        this.marque = marque;
        this.modele = modele;
        this.couleur = couleur;
        this.prixjour = prixjour;
    }

    public Integer getIdv() {
        return idv;
    }

    public void setIdv(Integer idv) {
        this.idv = idv;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public int getPrixjour() {
        return prixjour;
    }

    public void setPrixjour(int prixjour) {
        this.prixjour = prixjour;
    }

    public Modele getIdModele() {
        return idModele;
    }

    public void setIdModele(Modele idModele) {
        this.idModele = idModele;
    }

    @XmlTransient
    public List<Location> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<Location> locationList) {
        this.locationList = locationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idv != null ? idv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehicule)) {
            return false;
        }
        Vehicule other = (Vehicule) object;
        if ((this.idv == null && other.idv != null) || (this.idv != null && !this.idv.equals(other.idv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.limamoulayeka.model.Vehicule[ idv=" + idv + " ]";
    }
    
}
