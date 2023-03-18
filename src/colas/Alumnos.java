package colas;

/**
 * @author LUID
 */
public class Alumnos {
    private String nombre, sexo;

    public Alumnos(String nombre, String sexo) {
        this.nombre = nombre;
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
}
