package com.gipsy.pruebas;

/**
 *
 * @author Gipsy Dávy
 */

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.*;


public class Prueba01 extends JFrame {                                          // Se crea la ventana
    
    private static final boolean USAR_HASH = false;                             // Indicamos modo validación contraseña: false-> las contraseñas se guardan en texto plano; true-> las contraseñas están encriptadas (SHA-256)
    
    private static final Path RUTA_USUARIOS =                                   // Aquí se construye la ruta del archivo que contine los usuarios y contraseñas, la clase Path es al que indica la ruta.
            Paths.get(System.getProperty("user.dir"),
            "src", "data",
            "usuarios.txt");
    
            
    private JTextField txtUsuario;                                              // Crea el campo de usuario
    private JPasswordField txtPass;                                             // Crea el campo de contraseña
    
    // Hasta aquí lo que se ha creado en la ventana
    
    // A partir de aquí lo que se crea es la interface de nuestra ventana
   
    public Prueba01() {                                                         // Éste es el constructor, se llama así mismo, los paréntesis vacíos indican que no tiene argumento, este extiende JFrame.
        super ("Access");                                                       // Ya tenemos nuestra ventana, al poner super("Access"), le indicamos que en la parte de arriba ponga lo que se indica en el parentesis
        
        // Ahora creamos las etiquetas para nuestro usuario y contraseÑA en la ventana
        
        JLabel lbUsuario = new JLabel ("Usuario:");                             // Es un componente gráfico que sirve para mostrar texto o imágenes en una ventana.
        JLabel lbPass = new JLabel ("Contraseña");                              // No permite que el usuario escriba nada (a diferencia de JTextField). Se usa generalmente para etiquetas de campos de entrada, títulos o mensajes.
        
        // Ya tenemos las etiquetas, ahora creamos el campo que vamos a rellenar
        
        txtUsuario = new JTextField(15);                                        // Indicamos con (15) el número de columnas de ancho que se escribiran para el usuario.
        txtPass = new JPasswordField(15);                                       // Indicamos con (15) el número de columnas de ancho que se escribiran para la password.
        
        // Ahora pasamos a crear los botones de Inicio de la aplicacion o cierra de la misma una vez metidos el usuario y contraseña
        
        JButton btnInicio = new JButton ("Start");                              // Creaamos la etiqueta del boton de inicio
        JButton btnSalir = new JButton ("Close");                                // Creaamos la etiqueta del boton de cierre
        
        // Ahora le damos las instrucciones de lo que queremos que hagan el boton "Start" y el boton "Close", son los Listener
        // nota: no deja importar la clase awt nativa de JDK, por lo que da error y la solucion es que el IDE genera una linea de comando para obtenrr la clase awt
        
        btnInicio.addActionListener(this::onInicio);                            // Asocia handler al botón incio.
        btnSalir.addActionListener(e -> System.exit(0));                        // Cierra la aplicación
        
        // Con la clase siguiente setLayout(...); indicamos posición y tamaño de los componentes dentro del container, esta clase está dentro de JFrame, JPanel....
        // Con la clase GridBagLayout() permite colocar los componentes dentro de una cuadrícula (grid), cada celda puede tener diferente tamaño y alineación, esta dentro del paquete Java.awt.
        // Además GridBagLayout, a diferenci de FlowLayout o BorderLayout, GridBagLayout te deja controlar exactamente la posición, expansión, y márgenes de cada componente usando un objeto GridBagConstraints.
        // Se crea un nuevo objeto GridBagLayout. Ese objeto se pasa a setLayout(...). A partir de ese momento, todos los componentes añadidos al JFrame (con add(...)) serán organizados según las reglas del GridBagLayout.
        
        setLayout(new GridBagLayout());                                         // Layout de cuadrícula flexible
        GridBagConstraints c = new GridBagConstraints();                        // Restricciones para colocar componentes
        c.insets = new Insets(8, 10, 8, 10);                                    // Insets es una clase del paquete java.awt y c.insets es el atributo (variable) del objeto c (que es del tipo GripBagConstraints)
                                                                                // Insets define los márgenes internos (espacios) alrededor de un componente dentro de la celda del GridBagLayout, new Insets(arriba, izquierda, abajo, derecha)
        c.fill = GridBagConstraints.HORIZONTAL;                                 // De esta forma los campos se estiran en horizontal
        
        // Es ene ste momento cuando colocamos cada elemento en su celda con los atributos gridx (columna) y gridy (fila), empiezan desde 0 y no desde 1
        
        c.gridx = 0; c.gridy = 0; add(lbUsuario, c);                            // En esta línea se ha indicado la columna 0 y fila 0 para ubicar la etiqueta de Usuario
        c.gridx = 1; c.gridy = 0; add(txtUsuario, c);                           // En esta línea se ha indicado la columna 1 y fila 0 para ubicar eñ campo donde se introducira el usuario
        c.gridx = 0; c.gridy = 1; add(lbPass, c);                               // En esta línea se ha indicado la columna 0 y fila 1 para ubicar la etiqueta de Password
        c.gridx = 1; c.gridy = 1; add(txtPass, c);                              // En esta línea se ha indicado la columna 1 y fila 1 para ubicar la el campo dode se introducira el Password
        
        // Ahora se crea el panel para los botones Start y Close con un pequeño espacio entre ellos
        
        JPanel pnlBtns = new JPanel(new FlowLayout(FlowLayout.CENTER, 12,0));   // Panel para botones
        pnlBtns.add(btnInicio);                                                 // Añade el boton Start al panel
        pnlBtns.add(btnSalir);                                                  // Añade el boton Close al panel.
        
        // Posteriormente los ubicamos en la cuadrícula
        
        c.gridx = 0; c.gridy = 2; c.gridwidth = 2;                              // Los ubicamos en la columna 0 fila 2, con un ancho de 2 columnas
        add(pnlBtns, c);                                                        // Añade panel de botones
        
        // Para finalizar configuramos el final de la ventana
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                         // Hxce que la aplicación se cierre al salir
        setSize(360, 190);                                                      // Tamaño de la ventana
        setLocationRelativeTo(null);                                            // Centra la ventana en la pantalla, si se le indica setLocationRelativeTo(otraVentana) la centra respecto s otra ventana.
        
        // setLocation(360, 190); la ventana la colocaria segun eje X (horizontal) y eje Y (vertical).
        
        getRootPane().setDefaultButton(btnInicio);                              // Al pulsar enter por defecto dispara "inicio".
        
        
        
        
        
        
        
}

  

  
    
    
    
    
    
    
    

}
