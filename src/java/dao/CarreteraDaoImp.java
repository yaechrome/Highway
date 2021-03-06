/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.CarreteraDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sql.Conexion;

/**
 *
 * @author nippo
 */
public class CarreteraDaoImp implements CarreteraDao {

    @Override
    public ArrayList<CarreteraDto> listar() {
        ArrayList<CarreteraDto> lista = new ArrayList<CarreteraDto>();
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM carretera";
            PreparedStatement buscar = conexion.prepareStatement(query);

            ResultSet rs = buscar.executeQuery();

            while (rs.next()) {
                CarreteraDto dto = new CarreteraDto();
                dto.setId(rs.getInt("id"));
                dto.setNombre(rs.getString("nombre"));
                dto.setPrecio(rs.getInt("precio"));

                lista.add(dto);
            }
            buscar.close();
            conexion.close();
        } catch (SQLException w) {
            System.out.println("Error SQL al buscar " + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error al buscar " + e.getMessage());
        }
        return lista;
    }

}
