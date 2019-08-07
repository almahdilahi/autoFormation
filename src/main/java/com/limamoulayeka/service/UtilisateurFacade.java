/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.limamoulayeka.service;

import com.limamoulayeka.model.Utilisateur;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HP
 */
@Stateless
public class UtilisateurFacade extends AbstractFacade<Utilisateur> implements UtilisateurFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_autoFormation_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public Utilisateur getUser(String login, String password) {
        try {
            return   (Utilisateur) em.createQuery("Select u FROM Utilisateur u WHERE u.login=:login AND u.password=:password")
                    .setParameter("login", login)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }   
    @Override
    public int getLastInsertedId() {
        try {
            return em.createQuery("SELECT MAX(u.id) FROM Utilisateur u",Integer.class).
                    getSingleResult();
        } catch (Exception e) {
        }
        return 0;
    }

    public UtilisateurFacade() {
        super(Utilisateur.class);
    }
    
}
