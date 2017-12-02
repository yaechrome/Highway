/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.DetalleCompraDto;
import java.util.ArrayList;

/**
 *
 * @author nippo
 */
public interface DetalleCompraDao extends BaseDao<DetalleCompraDto>{
    
    public ArrayList<DetalleCompraDto> ListarPorVenta(int numeroVenta);
    
    public boolean DuplicarDetalleCompra(ArrayList<DetalleCompraDto> lista, int idCompraNuevo);
}
