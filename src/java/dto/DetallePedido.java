/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author yaechrome
 */
public class DetallePedido {
    public Integer id;
    public Integer cantidad;
    public String nombre;
    public Integer precio;
    public Integer idCompra;

    @Override
    public String toString() {
        return "{" + "\"id\": " + "\"" + id + "\""+ ", \"cantidad\": " + "\"" + cantidad + "\""+ ", \"nombre\": " + "\"" + nombre + "\""+ ", \"precio\": " + "\"" + precio + "\""+ ", \"idCompra\": " + idCompra +'}';
        
    }
    
    
}
