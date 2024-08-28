
package Controller;

import Model.PersonaModel;

public class PersonaController {
    
    PersonaModel persona_model;
    
    public void registrarpersona (int numero_identificacion, String nombre, String apellido, int edad){
        persona_model = new PersonaModel(numero_identificacion, nombre, apellido, edad);
    }
    
    public void actualizarpersona (int numero_identificacion, String nombre, String apellido, int edad){
        persona_model = new PersonaModel(numero_identificacion, nombre, apellido, edad);
    }
    
    public PersonaModel consultarpersona (){
       return persona_model;
    }
}
