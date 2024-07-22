package dominio;

import java.io.Serializable;

public class Cliente implements Serializable {
    private String nombreCliente;
    private int idCliente;
    private int telefonoCliente;
    private String direccionCliente;

      @Override
    public String toString() {
        return "Cliente{" + "nombreCliente=" + nombreCliente + ", idCliente=" + idCliente + ", telefonoCliente=" + telefonoCliente + ", direccionCliente=" + direccionCliente + '}';
    }

        
    public Cliente(String nombreCliente, int idCliente, int telefonoCliente, String direccionCliente) {
        this.nombreCliente = nombreCliente;
        this.idCliente = idCliente;
        this.telefonoCliente = telefonoCliente;
        this.direccionCliente = direccionCliente;
    }


    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(int telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }



}
