package gipsydavy.repasoservicios;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Gipsy Dávy
 */
public class TerminarProceso {
    
    public static void main(String[] args) {
        TerminarProceso tp = new TerminarProceso();
        tp. ejecutar();
   }

    private void ejecutar() {
        try {
            ProcessBuilder pb = new ProcessBuilder("C:\\Program Files (x86)\\AIMP\\AIMP.exe");  
            
            Process p = pb.start();
            
            System.out.println("Terminar el proceso?? S|N");
            Scanner sc = new Scanner(System.in);
            
            if (sc.nextLine().charAt(0) == 'S') {
                 p.waitFor(3, TimeUnit.SECONDS);  // Asi indicamos que espere 3 segundos para ejecutar el siguiente comando.
                 p.destroy();  // Con esto se cierra el proceso
            }     
                       
        } catch (IOException | InterruptedException ex) {
            System.getLogger(TerminarProceso.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
               
        
    }
    
}
