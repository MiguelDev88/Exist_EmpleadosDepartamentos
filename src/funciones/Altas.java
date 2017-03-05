/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package funciones;

import java.io.BufferedReader;
import java.io.IOException;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XPathQueryService;


// @author Miguel

public class Altas {
    
    public static void altas (XPathQueryService servicio , BufferedReader leer) throws IOException, XMLDBException {
        
        String nombre, localizacion;
        int dep;
        
        
        System.out.println("Introducir número de departamento:");
        dep=Integer.parseInt(leer.readLine());
        
        ResourceSet result=servicio.query("for $dep in /departamentos/departamento[numero = "+dep+"] return $dep");
        ResourceIterator i = result.getIterator();
        
        if(i.hasMoreResources())
            System.out.println("Ya existe un departamento con ese número.");
        else{
            System.out.println("Introducir nombre del departamento:");
            nombre=leer.readLine();
            System.out.println("Introducir localización:");
            localizacion=leer.readLine();
            
            servicio.query("update insert"
                    + "<departamento>"
                    + "<numero>"+dep+"</numero>"
                    + "<nombre>"+nombre+"</nombre>"
                    + "<localizacion>"+localizacion+"</localizacion>"
                    + "</departamento>"
                    + "into /departamentos");
            
            System.out.println(" - Departamento Registrado - ");
        }  
    }

}
