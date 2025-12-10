package gipsydavy.repasoservicios;

import java.io.IOException;

/**
 *
 * @author Gipsy Buho
 */
public class LanzarProcesoRuntime {
    
    public static void main(String[] args) {
         LanzarProcesoRuntime lr = new LanzarProcesoRuntime();
    
    String ruta1 =
             "C:\\Program Files (x86)\\AIMP\\AIMP.exe";
    
        lr.ejecutar(ruta1);
        
    }

    private void ejecutar(String comando) {
        try {
            Runtime runtime = Runtime.getRuntime();
            Process p = runtime.exec(comando);
        } catch (IOException ex) {
            System.getLogger(LanzarProcesoRuntime.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
               
    }
   
    
}
