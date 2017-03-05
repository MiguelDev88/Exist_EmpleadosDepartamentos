package funciones;
import java.io.BufferedReader;
import java.io.IOException;


// @author Miguel

public class Menus {
    
    public static byte menuPrincipal (BufferedReader leer) throws IOException {
        
        byte op;
        
        System.out.println("\nSeleccione opción:"
                + "\n1.Altas"
                + "\n2.Bajas"
                + "\n3.Modificaciones"
                + "\n4.Consultas"
                + "\n0.Finalizar");
        op=Byte.parseByte(leer.readLine());
        
        return op;  
        
    }
    
    public static byte menuConsultas (BufferedReader leer) throws IOException {
    
        byte op;
        
        System.out.println("¿Qué desea consultar?"
                        + "\n1.Datos de un Socio"
                        + "\n2.Datos de un Uso"
                        + "\n0.Finalizar");
        
        op=Byte.parseByte(leer.readLine());
        
        return op;
        
    }
    
    public static byte menuModificiar (BufferedReader leer) throws IOException {
        
        byte op;
        
        System.out.println("¿Qué desea modificar?"
                + "\n1.Nombre"
                + "\n2.Localidad"
                + "\n0.Finalizar");
        op=Byte.parseByte(leer.readLine());
        
        return op;
        
    }
    
    public static byte menuConfirmar (BufferedReader leer) throws IOException {
        
        byte op;
        System.out.println("¿Seguro que desea eliminar este registro?"
                + "\n1.SI"
                + "\n2.NO");
        
        op=Byte.parseByte(leer.readLine());
        
        return op;
    }

}
