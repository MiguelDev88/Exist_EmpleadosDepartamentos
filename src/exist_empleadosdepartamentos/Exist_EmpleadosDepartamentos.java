package exist_empleadosdepartamentos;
import funciones.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XPathQueryService;

/**
 *
 * @author Miguel
 */
public class Exist_EmpleadosDepartamentos {


    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
        
        byte op;
        BufferedReader leer = new BufferedReader (new InputStreamReader (System.in));
        
        try{
            String driver="org.exist.xmldb.DatabaseImpl";
            Class c=Class.forName(driver);
            Database db= (Database)c.newInstance();
            DatabaseManager.registerDatabase(db);
            String uri="xmldb:exist://localhost:8080/exist/xmlrpc/db/curso2017";
            String usu="admin";
            String psw="admin";
            
            Collection col = DatabaseManager.getCollection(uri, usu, psw);
            XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");

            do{ 
                op=Menus.menuPrincipal(leer);
                switch(op){
                    case 1:
                        Altas.altas(servicio, leer);
                        break;
                    case 2:
                        Bajas.bajas(servicio, leer);
                        break;
                    case 3:
                        Modificar.modificar(servicio, leer);
                        break;
                    case 4:
                        Consultas.consultas(servicio, leer);
                        break;
                    case 0:
                        System.out.println("\n - FIN DEL PROGRAMA - \n");
                        System.exit(0);
                }
            }while(op!=0);   
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
}
