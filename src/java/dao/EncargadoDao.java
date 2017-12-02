/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.EncargadoDto;

/**
 *
 * @author nippo
 */
public interface EncargadoDao {

    public boolean ValidarPassword(String login, String pass);

    public boolean ValidarLogin(String login);
    
    public String Encriptar(String texto);
    
    public EncargadoDto BuscarUsuario(String login);
}
