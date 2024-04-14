package org.example;

/**
 * @author Roxana
 * @date 04/04/2024
 */
public class Tarea {
    private int id;
    private String nombre;
    private String descripcion;

    private String realizada;
    private String prioridad;

    public Tarea(int id, String nombre, String descripcion,String realizada, String prioridad) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.realizada = realizada;
        this.prioridad = prioridad;
    }

    public Tarea(String nombre, String descripcion, String realizada, String prioridad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.realizada = realizada;
        this.prioridad = prioridad;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRealizada() {
        return realizada;
    }

    public void setRealizada(String realizada) {
        this.realizada = realizada;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }


    @Override
    public String toString() {
        return String.format("%-3d %-38s %-65s %-24s %-5s",
                id,
                nombre,
                descripcion,
                realizada,
                prioridad);
    }
}
