
package Model;


public class PersonaModel {
    
    private int numero_identificacion;
    private String nombre;
    private String apellidos;
    private int edad;

    public PersonaModel() {
    }
    
    public PersonaModel(int numero_identificacion, String nombre, String apellidos, int edad) {
        this.numero_identificacion = numero_identificacion;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public int getNumero_identificacion() {
        return numero_identificacion;
    }

    public void setNumero_identificacion(int numero_identificacion) {
        this.numero_identificacion = numero_identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Número de identificación: " + numero_identificacion + "\nNombre: " + nombre + "\nApellido: " + apellidos + "\nEdad: " + edad;
    }

  
    
}
