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
        for (int i = 0; i < array.size(); i++) {
            json +=  "    " + array.get(i).toString() + (i<array.size()-1 ? "," : "") + "\n";
        }
        json += "]";
        return json;
    }
}
