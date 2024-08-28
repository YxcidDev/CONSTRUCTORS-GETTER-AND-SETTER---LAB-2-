
package View;

import Controller.PersonaController;
import javax.swing.JOptionPane;


public class MainView {
    
    static PersonaController persona_controller = new PersonaController();
   
    public static void main(String[] args){
        while (true){
            
            switch (imprimirMenu()) {
                
                case 1 -> {
                    solicitarRegistroPersona();
                }
                
                case 2 -> {
                    solicitarActualizacionPersona();
                }
                
                case 3 -> {
                    consultarInformacionPersona();
                }
                
                case 4 -> {
                    finalizarPrograma();
                }
                
                default -> 
                    JOptionPane.showMessageDialog(null, "INGRESE UNA OPCIóN VALIDA",
                            "MENSAJE DEL SISTEMA", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public static int imprimirMenu() {
        String menu = """
                      1. REGISTRAR
                      2. ACTUALIZAR
                      3. CONSULTAR
                      4. SALIR
                         """;
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "MENÚ", JOptionPane.INFORMATION_MESSAGE));
        return opcion;
    }
    
    public static void solicitarRegistroPersona(){
        
        try {
            int numero_identificacion = Integer.parseInt(JOptionPane.showInputDialog(null, "INGRESE EL NÚMERO DE " + "IDENTIFICACIÓN DE LA PERSONA"));
            String nombre = JOptionPane.showInputDialog(null, "INGRESE EL NOMBRE DE LA PERSONA");
            String apellido = JOptionPane.showInputDialog(null, "INGRESA EL APELLIDO DE LA PERSONA");
            int edad = Integer.parseInt(JOptionPane.showInputDialog(null, "INGRESA LA EDAD DE LA PERSONA"));
            
            persona_controller.registrarpersona(numero_identificacion, nombre, apellido, edad);
            
            JOptionPane.showMessageDialog(null, "PERSONA CREADA", "MENSAJE DEL SISTEMA", JOptionPane.INFORMATION_MESSAGE);
            
            JOptionPane.showMessageDialog(null, persona_controller.consultarpersona());
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ERROR EN EL FORMULARIO \nINGRESE LOS DATOS CORRECTAMENTE\n" + e.getMessage(), "NOTIFICACIÓN DEL SISTEMA", JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
    public static void solicitarActualizacionPersona() {
        try {
            int confirmar = JOptionPane.showConfirmDialog(null, "¿DESEA ACTUALIZAR LA INFORMACIÓN DE " + persona_controller.consultarpersona().getNombre().toUpperCase() + " " + persona_controller.consultarpersona().getApellidos().toUpperCase() + "?", "NOTIFICACION DEL SISTEMA", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirmar == 0) {
                persona_controller.consultarpersona().setNumero_identificacion(Integer.parseInt(JOptionPane.showInputDialog("INGRESE EL NÚMERO DE IDENTIFICACIÓN " + "DE LA PERSONA")));
                persona_controller.consultarpersona().setNombre(JOptionPane.showInputDialog("INGRESE EL NOMBRE DE " + "LA PERSONA"));
                persona_controller.consultarpersona().setApellidos(JOptionPane.showInputDialog("INGRESE EL APELLIDO " + "DE LA PERSONA"));
                persona_controller.consultarpersona().setEdad(Integer.parseInt(JOptionPane.showInputDialog("INGRESE " + "LA EDAD DE LA PERSONA")));
                
                JOptionPane.showMessageDialog(null, "PERSONA ACTUALIZADA", "MENSAJE DEL SISTEMA", JOptionPane.INFORMATION_MESSAGE);
                
                JOptionPane.showMessageDialog(null, persona_controller.consultarpersona());
            } else {
                JOptionPane.showMessageDialog(null, "PROCESO DENEGADO", "NOTIFICACION DEL SISTEMA", JOptionPane.WARNING_MESSAGE);
                
            } 
        } catch(NullPointerException e) {
            JOptionPane.showMessageDialog(null, "PRIMERO DEBE REGISTRAR A LA PERSONA", "NOTIFICACIÓN DEL SISTEMA", JOptionPane.ERROR_MESSAGE);
            
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "ERROR EN EL FORMULARIO \nINGRESE LOS DATOS CORRECTAMENTE\n" + e.getMessage(), "NOTIFICACIÓN DEL SISTEMA", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void consultarInformacionPersona(){
        if (persona_controller.consultarpersona() != null){
            JOptionPane.showMessageDialog(null, persona_controller.consultarpersona());
            
        }else{
            JOptionPane.showMessageDialog(null, "NO HAY PERSONA REGISTRADA", "NOTIFICACIÓN DEL SISTEMA", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void finalizarPrograma(){
        JOptionPane.showMessageDialog(null, "PROGRAMA FINALIZADO");
        System.exit(0);
    }
}
