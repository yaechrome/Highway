/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.DetalleCompraDto;
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
public class DetalleCompraDaoImp implements DetalleCompraDao {

    @Override
    public ArrayList<DetalleCompraDto> ListarPorVenta(int numeroVenta) {
        ArrayList<DetalleCompraDto> lista = new ArrayList<DetalleCompraDto>();
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM detalle_compra where id_compra =?";
            PreparedStatement buscar = conexion.prepareStatement(query);
            buscar.setInt(1, numeroVenta);

            ResultSet rs = buscar.executeQuery();

            while (rs.next()) {
                DetalleCompraDto dto = new DetalleCompraDto();
                dto.setIdCarretera(rs.getInt("id_carretera"));
                dto.setCantidad(rs.getInt("cantidad"));
                dto.setIdCompra(rs.getInt("id_compra"));

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

    @Override
    public boolean agregar(DetalleCompraDto dto) {
        try {

            Connection conexion = Conexion.getConexion();

            String query = "INSERT INTO detalle_compra ( id_carretera, id_compra, cantidad) VALUES ( ?, ?, ?)";

            PreparedStatement insertar = conexion.prepareStatement(query);

            insertar.setInt(1, dto.getIdCarretera());
            insertar.setInt(3, dto.getIdCompra());
            insertar.setInt(2, dto.getCantidad());

            insertar.execute();
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
    public boolean eliminar(DetalleCompraDto dto) {
        try {

            Connection conexion = Conexion.getConexion();

            String query = "DELETE FROM detalle_compra WHERE id_compra=? and id_carretera=?";

            PreparedStatement eliminar = conexion.prepareStatement(query);

            eliminar.setInt(1, dto.getIdCompra());
            eliminar.setInt(2, dto.getIdCarretera());
            eliminar.execute();
            eliminar.close();

            conexion.close();
            return true;
        } catch (SQLException w) {
            System.out.println("Error SQL al eliminar " + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error al eliminar " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean modificar(DetalleCompraDto dto) {
        try {
            //solo se puede modificar la cantidad
            Connection conexion = Conexion.getConexion();

            String query = "UPDATE detalle_compra SET  cantidad=? where id_carretera=? and id_compra=?";

            PreparedStatement modificar = conexion.prepareStatement(query);

            modificar.setInt(1, dto.getCantidad());
            modificar.setInt(2, dto.getIdCarretera());
            modificar.setInt(3, dto.getIdCompra());

            modificar.execute();
            modificar.close();
            conexion.close();
            return true;
        } catch (SQLException w) {
            System.out.println("Error SQL al modificar " + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error al modificar " + e.getMessage());
        }
        return false;
    }

    @Override
    public ArrayList<DetalleCompraDto> listar() {
        ArrayList<DetalleCompraDto> lista = new ArrayList<DetalleCompraDto>();
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM detalle_compra";
            PreparedStatement buscar = conexion.prepareStatement(query);

            ResultSet rs = buscar.executeQuery();

            while (rs.next()) {
                DetalleCompraDto dto = new DetalleCompraDto();
                dto.setCantidad(rs.getInt("cantidad"));
                dto.setIdCarretera(rs.getInt("id_carretera"));
                dto.setIdCompra(rs.getInt("id_compra"));

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

    @Override
    public boolean DuplicarDetalleCompra(ArrayList<DetalleCompraDto> lista, int idCompraNuevo) {
        try {

            Connection conexion = Conexion.getConexion();

            for (DetalleCompraDto detalle : lista) {
                String query = "INSERT INTO detalle_compra ( id_carretera, id_compra, cantidad) VALUES ( ?, ?, ?)";

                PreparedStatement insertar = conexion.prepareStatement(query);

                insertar.setInt(1, detalle.getIdCarretera());
                insertar.setInt(3, detalle.getCantidad());
                insertar.setInt(2, idCompraNuevo);

                insertar.execute();
                insertar.close();
                
            }
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
