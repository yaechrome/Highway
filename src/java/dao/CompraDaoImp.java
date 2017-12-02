/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.CompraDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import sql.Conexion;

/**
 *
 * @author nippo
 */
public class CompraDaoImp implements CompraDao{

    @Override
    public boolean agregar(CompraDto dto) {
        try {
            Connection conexion = Conexion.getConexion();

            String query = "insert into compra (id_compra, pago, envio, total, encargado, feha_compra) values (?,?,?,?,?,?)";

            PreparedStatement insertar = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            insertar.setInt(1, dto.getIdCompra());
            insertar.setString(2, dto.getModoPago());
            insertar.setString(3, dto.getEnvio());
            insertar.setInt(4, dto.getTotal());
            insertar.setString(5, dto.getEncargado());
            insertar.setDate(6, new java.sql.Date(dto.getFecha().getTime()));
            

            insertar.executeUpdate();
            ResultSet generatedKeys = insertar.getGeneratedKeys();
            if (generatedKeys.next()) {
                dto.setIdCompra(generatedKeys.getInt(1));
            }

            insertar.close();
            conexion.close();
            return true;
        } catch (SQLException w) {
            System.out.println("Error SQL al agregar " + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error al agregar " + e.getMessage());
        }
        return false;
    }

 
    
}
