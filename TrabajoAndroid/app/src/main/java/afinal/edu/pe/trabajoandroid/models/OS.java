package afinal.edu.pe.trabajoandroid.models;

import java.util.Date;

public class OS {

    private int idOS;
    private Client cliente;
    private String fechaInicio;
    private String fechaFin;
    private Vehicle vehiculo;
    private String descripcion;
    private String observacion;
    private float adelantoPago;
    private int estado;
    private String nroOS;

    public OS(){

    }

    public int getIdOS() {
        return idOS;
    }

    public void setIdOS(int idOS) {
        this.idOS = idOS;
    }

    public Client getCliente() {
        return cliente;
    }

    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Vehicle getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehicle vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public float getAdelantoPago() {
        return adelantoPago;
    }

    public void setAdelantoPago(float adelantoPago) {
        this.adelantoPago = adelantoPago;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getNroOS() {
        return nroOS;
    }

    public void setNroOS(String nroOS) {
        this.nroOS = nroOS;
    }
}
