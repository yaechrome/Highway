/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.EncargadoDto;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import org.apache.commons.codec.binary.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import sql.Conexion;

/**
 *
 * @author nippo
 */
public class EncargadoDaoImp implements EncargadoDao{

    @Override
    public boolean ValidarPassword(String login, String pass) {
        try {
            Connection conexion = Conexion.getConexion();
            String query = "select pass_encargado from encargado where login = ?";
            PreparedStatement buscar = conexion.prepareStatement(query);
            buscar.setString(1, login);
            buscar.execute();

            try (ResultSet rs = buscar.executeQuery()) {
                if (rs.next()) {
                    if (rs.getString("pass_encargado").equals(pass)) {

                        return true;
                    }
                }
            }
            buscar.close();
            conexion.close();

        } catch (SQLException w) {
            System.out.println("Error  " + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean ValidarLogin(String login) {
        try {
            Connection conexion = Conexion.getConexion();
            String query = "select * from encargado where login = ?";
            PreparedStatement buscar = conexion.prepareStatement(query);
            buscar.setString(1, login);
            buscar.execute();
            ResultSet rs = buscar.executeQuery();
            if (rs.next()) {
                return true;
            }
            buscar.close();
            conexion.close();

        } catch (SQLException w) {
            System.out.println("Error  " + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return false;
    }

    @Override
    public String Encriptar(String texto) {
        String secretKey = "qualityinfosolutions"; //llave para encriptar datos
        String base64EncryptedString = "";

        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] plainTextBytes = texto.getBytes("utf-8");
            byte[] buf = cipher.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            base64EncryptedString = new String(base64Bytes);

        } catch (Exception ex) {
        }
        return base64EncryptedString;
    }

    @Override
    public EncargadoDto BuscarUsuario(String login) {
        EncargadoDto dto = new EncargadoDto();
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM encargado where login = ?";
            PreparedStatement buscar = conexion.prepareStatement(query);
            buscar.setString(1, login);
            ResultSet rs = buscar.executeQuery();

            if(rs.next()) {
                
                dto.setRutEmpresa(rs.getString("rut_empresa"));
                dto.setNombre(rs.getString("nombre"));
                dto.setPassword(rs.getString("pass_encargado"));
                dto.setLogin(rs.getString("login"));
                
                
            }
            buscar.close();
            conexion.close();
           
        } catch (SQLException w) {
            System.out.println("Error SQL al buscar " + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error al buscar " + e.getMessage());
        }
        return dto;
    }

     
    
}
