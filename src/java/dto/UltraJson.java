/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.ArrayList;

/**
 *
 * @author yaechrome
 */
public class UltraJson<T> {
    public String generate(ArrayList<T> array) {
        String json = "[\n";
        for (T t : array) {
            json +=  "\t" + t.toString() + ",\n";
        }
        json += "\n]";
        return json;
    }
}
