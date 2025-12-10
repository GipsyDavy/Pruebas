package gipsydavy.repasoservicios;

import java.io.IOException;

/**
 *
 * @author Gipsy Buho
 */

// Para abrir un proceso (aplicacion)

public class LanzarProcesoPBuilder {  // Se crea la clase

    public static void main(String[] args) {
        
        LanzarProcesoPBuilder lp = new LanzarProcesoPBuilder ();  // Se crea el proceso (aplicación a ejecutar)
        
        String ruta1 =
                "C:\\Program Files (x86)\\AIMP\\AIMP.exe";
        
        String ruta2 = 
                "C:\\Users\\Gipsy Dávy\\Desktop\\Dibujos\\Gipsy.pdf";  // Da un error al no ser un ejecutable
                
                
        
        lp.ejecutar(ruta1);
        
     }
        
    private void ejecutar (String comando) {
        
        try {
            ProcessBuilder pb = new ProcessBuilder (comando);
            
            // La diferencia con Runtime, es que en este espacio se puede configurar el arranque del proceso, antes de que arranque.
            
            pb.start();
        } catch (IOException ex) {
            System.getLogger(LanzarProcesoPBuilder.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
    }      
        
            
}
