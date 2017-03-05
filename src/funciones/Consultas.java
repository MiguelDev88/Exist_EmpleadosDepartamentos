package funciones;
import java.io.BufferedReader;
import java.io.IOException;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XPathQueryService;


// @author Miguel

public class Consultas {
    
    public static void consultas (XPathQueryService servicio , BufferedReader leer) throws IOException, XMLDBException {
        
        int dep;
        
        
        System.out.println("Introducir número de departamento a buscar:");
        dep=Integer.parseInt(leer.readLine());
        
        ResourceSet result=servicio.query("for $dep in /departamentos/departamento[numero = "+dep+"] return $dep");
        ResourceIterator i = result.getIterator();
        
        if(!i.hasMoreResources())
            System.out.println("No existe ningún departamento con ese número.");
        else{
            result=servicio.query("for $emp in /empleados/empleado[dept_no = "+dep+"] return $emp");
            i = result.getIterator();
            
            System.out.println("Resultado:");
            
            while(i.hasMoreResources()){
                Resource resource =i.nextResource();
                System.out.println(resource.getContent());
            }
        }  
    }
}
