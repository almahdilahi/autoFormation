/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.limamoulayeka.service;

import com.limamoulayeka.model.Modele;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HP
 */
@Local
public interface ModeleFacadeLocal {

    void create(Modele modele);

    void edit(Modele modele);

    void remove(Modele modele);

    Modele find(Object id);

    List<Modele> findAll();

    List<Modele> findRange(int[] range);

    int count();
    
}
