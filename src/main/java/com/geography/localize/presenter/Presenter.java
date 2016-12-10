/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geography.localize.presenter;

import com.geography.localize.domain.Locality;

import java.util.Map;

/**
 *
 * @author Kazimirov
 */
public interface Presenter {
    
    void showLocalities(Map<String, Locality> localities);
    void showMessage(String message);
}
