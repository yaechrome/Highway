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

            String query = "insert into compra (pago, envio, total, encargado, fecha_compra) values (?,?,?,?,now())";

            PreparedStatement insertar = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            insertar.setString(1, dto.getModoPago());
            insertar.setString(2, dto.getEnvio());
            insertar.setInt(3, dto.getTotal());
            insertar.setString(4, dto.getEncargado());
            

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

    @Override
    public ArrayList<CompraDto> listarComprasPorEmpresa(String rutEmpresa) {
        ArrayList<CompraDto> lista = new ArrayList<CompraDto>();
        try {
            Connection conexion = Conexion.getConexion();
            String query = "select id_compra, pago,envio,total,encargado,fecha_compra from "
                    + "compra join encargado on (compra.encargado = encargado.login)"
                    + "where encargado.rut_empresa = ?";
            PreparedStatement buscar = conexion.prepareStatement(query);
            buscar.setString(1, rutEmpresa);

            ResultSet rs = buscar.executeQuery();

            while (rs.next()) {
                CompraDto dto = new CompraDto();
                dto.setIdCompra(rs.getInt("id_compra"));
                dto.setModoPago(rs.getString("pago"));
                dto.setEnvio(rs.getString("envio"));
                dto.setTotal(rs.getInt("total"));
                dto.setEncargado(rs.getString("encargado"));
                dto.setFecha(rs.getDate("fecha_compra"));

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
