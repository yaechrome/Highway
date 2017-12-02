/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.CompraDto;
import java.util.ArrayList;

/**
 *
 * @author nippo
 */
public interface CompraDao {
    
    public boolean agregar(CompraDto dto);
    
    public ArrayList<CompraDto> listarComprasPorEmpresa (String rutEmpresa);
    
    
}
