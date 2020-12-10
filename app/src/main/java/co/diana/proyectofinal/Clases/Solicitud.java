package co.diana.proyectofinal.Clases;

public class Solicitud {

    String nombreTrabajador;
    String idTrabajador;
    String tipoServicio;
    String idUsuario;
    String nombreUsuario;
    String direccion;
    String fecha;
    String horaLlegada;
    String horas;
    int pago;

    public Solicitud(String nombreTrabajador, String idTrabajador, String tipoServicio, String idUsuario, String nombreUsuario, String direccion, String fecha, String horaLlegada, String horas, int pago) {
        this.nombreTrabajador = nombreTrabajador;
        this.idTrabajador = idTrabajador;
        this.tipoServicio = tipoServicio;
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.direccion = direccion;
        this.fecha = fecha;
        this.horaLlegada = horaLlegada;
        this.horas = horas;
        this.pago = pago;
    }

    public Solicitud() {
    }

    public String getNombreTrabajador() {
        return nombreTrabajador;
    }

    public void setNombreTrabajador(String nombreTrabajador) {
        this.nombreTrabajador = nombreTrabajador;
    }

    public String getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(String idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public int getPago() {
        return pago;
    }

    public void setPago(int pago) {
        this.pago = pago;
    }
}