package co.diana.proyectofinal;

import java.util.ArrayList;

public class Ropa {
    String idusuario;
    String nombre;
    String id;
    String tipo;
    String direccion;
    String estado;
    String horaderecogida;
    String fechaderecogida;
    String inforopa;

    private ArrayList<String> informacionselecciondetipoycantidadderopa;

    public Ropa(String idusuario, String nombre, String id, String tipo, String direccion, String estado, String horaderecogida, String fechaderecogida,String inforopa) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.id = id;
        this.tipo = tipo;
        this.direccion = direccion;
        this.estado = estado;
        this.horaderecogida = horaderecogida;
        this.fechaderecogida = fechaderecogida;
        this.inforopa=inforopa;

    }

    public Ropa(){

    }

    public String getInforopa() {
        return inforopa;
    }

    public void setInforopa(String inforopa) {
        this.inforopa = inforopa;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getHoraderecogida() {
        return horaderecogida;
    }

    public void setHoraderecogida(String horaderecogida) {
        this.horaderecogida = horaderecogida;
    }

    public String getFechaderecogida() {
        return fechaderecogida;
    }

    public void setFechaderecogida(String fechaderecogida) {
        this.fechaderecogida = fechaderecogida;
    }

    public ArrayList<String> getInformacionselecciondetipoycantidadderopa() {
        return informacionselecciondetipoycantidadderopa;
    }

    public void setInformacionselecciondetipoycantidadderopa(ArrayList<String> informacionselecciondetipoycantidadderopa) {
        this.informacionselecciondetipoycantidadderopa = informacionselecciondetipoycantidadderopa;
    }
}

