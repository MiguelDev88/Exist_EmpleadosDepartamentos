package funciones;
import java.io.BufferedReader;
import java.io.IOException;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XPathQueryService;


// @author Miguel

public class Bajas {
    
    public static void bajas (XPathQueryService servicio , BufferedReader leer) throws IOException, XMLDBException {
        
        int dep;
        
        
        System.out.println("Introducir número de departamento a dar de baja:");
        dep=Integer.parseInt(leer.readLine());
        
        ResourceSet result=servicio.query("for $dep in /departamentos/departamento[numero = "+dep+"] return $dep");
        ResourceIterator i = result.getIterator();
        
        if(!i.hasMoreResources())
            System.out.println("No existe ningún departamento con ese número.");
        else{
            if(Menus.menuConfirmar(leer)==1){
                servicio.query("update delete /departamentos/departamento[numero="+dep+"]");
                System.out.println(" - Departamento Eliminado ");
            }
            else{
                System.out.println("Operación cancelada.");
            }
        }  
    }
}
