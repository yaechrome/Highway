/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Objects;

/**
 *
 * @author nippo
 */
public class EmpresaDto {
    private String rutEmpresa;
    private String nombreEmpresa;
    private String direccion;

    public EmpresaDto() {
    }

    public String getRutEmpresa() {
        return rutEmpresa;
    }

    public void setRutEmpresa(String rutEmpresa) {
        this.rutEmpresa = rutEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.rutEmpresa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EmpresaDto other = (EmpresaDto) obj;
        if (!Objects.equals(this.rutEmpresa, other.rutEmpresa)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "{" + "\"rutEmpresa\": " + "\"" + rutEmpresa + "\""+ ", \"nombreEmpresa\": " + "\"" + nombreEmpresa + "\""+ ", \"direccion\": " + "\"" + direccion + "\""+ '}';
    }
    
    
}
