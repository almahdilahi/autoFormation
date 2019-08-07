/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.limamoulayeka.service;

import com.limamoulayeka.model.Vehicule;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HP
 */
@Local
public interface VehiculeFacadeLocal {

    void create(Vehicule vehicule);

    void edit(Vehicule vehicule);

    void remove(Vehicule vehicule);

    Vehicule find(Object id);

    List<Vehicule> findAll();

    List<Vehicule> findRange(int[] range);

    int count();
    
}
