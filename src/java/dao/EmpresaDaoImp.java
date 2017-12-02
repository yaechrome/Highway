/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.EmpresaDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sql.Conexion;

/**
 *
 * @author nippo
 */
public class EmpresaDaoImp implements EmpresaDao {

    @Override
    public EmpresaDto buscarEmpresa(String rut) {
        EmpresaDto dto = new EmpresaDto();
       try {
            Connection conexion = Conexion.getConexion();
            String query = "select * from empresa where rut_empresa = ?";
            PreparedStatement buscar = conexion.prepareStatement(query);

            ResultSet rs = buscar.executeQuery();

            if (rs.next()) {
                
                dto.setRutEmpresa(rs.getString("rut_empresa"));
                dto.setNombreEmpresa(rs.getString("nombre_empresa"));
                dto.setDireccion(rs.getString("direccion"));

                
            }
            buscar.close();
            conexion.close();
            return dto;
        } catch (SQLException w) {
            System.out.println("Error SQL al buscar " + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error al buscar " + e.getMessage());
        }
        return dto;
    }

}
