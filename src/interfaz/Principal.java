package interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import inapos.*;
import leerarchivo.*;
import constabb.*;


public class Principal extends JFrame{
    
    private Dimension resolucion = Toolkit.getDefaultToolkit().getScreenSize();
    private LaminaPrincipal panel = new LaminaPrincipal();
    private String pre, in, pos;
    
    public Principal(){
        setTitle("Build AB");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,250);
        setLocation(resolucion.width/2-this.getSize().width/2, resolucion.height/2-this.getSize().height/2);
        
        add(panel);
        
        setVisible(true);
    }
    
    class LaminaPrincipal extends JPanel{

        private String[] listaOpciones = {"Infija", "Posfija"};
        private JComboBox opciones = new JComboBox(listaOpciones);
        private JButton examinar = new JButton("Examinar");
        private JButton aceptar = new JButton("Aceptar");
        private JTextField direccion =  new JTextField();
        private JLabel texto = new JLabel("Seleccionar archivo:", SwingConstants.CENTER);
        private JFileChooser buscador = new JFileChooser();
        private FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto", "txt", "text");


        public LaminaPrincipal(){

            setLayout(null);

            opciones.setBounds(50,20,200,25);

            texto.setSize(300,20);
            texto.setLocation(0, 50);
            texto.setFont(new Font("Verdana", Font.PLAIN, 14));

            direccion.setEditable(false);
            direccion.setBounds(15, 115, 260, 25);
            direccion.setText("");

            aceptar.setBounds(100, 155, 100, 30);

            examinar.setBounds(100,75,100,30);
            examinar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    Lector lector =  new Lector();
                    buscador.setFileFilter(filtro);
                    buscador.showOpenDialog(buscador);
                    direccion.setText(buscador.getSelectedFile().getPath());
                    String contenido = lector.leer(buscador.getSelectedFile());

                    if (opciones.getSelectedItem().equals("Infija")) {
                        botonAceptarInAPos(contenido, buscador.getSelectedFile().getName());
                    }
                    else{
                        botonAceptarConstAbb(contenido, buscador.getSelectedFile().getName());
                    }
                }
            });


            add(aceptar);
            add(direccion);
            add(examinar);
            add(texto);
            add(opciones);

        }

        public void botonAceptarInAPos(String cont, String archivo){
            aceptar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    InAPos inapos = new InAPos(cont);
                    Character[] posorden = inapos.transformar();
                    String posordenStr = "";
                    for (int i = 0; i < posorden.length; i++) {
                        if (!posorden[i].equals('0')) {
                            posordenStr += posorden[i];
                        } 
                    }
                    BuildAbb construir = new BuildAbb(posordenStr);
                    Abb miArbol = construir.transformar();
                    pre = miArbol.generarPreorden(miArbol.getRaiz());
                    in = miArbol.generarInorden(miArbol.getRaiz());
                    pos = miArbol.generarPosorden(miArbol.getRaiz());
                    Notaciones n = new Notaciones(pre, in, pos, archivo);
                }
            });
        }

        public void botonAceptarConstAbb(String cont, String archivo){
            aceptar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    BuildAbb construir = new BuildAbb(cont);
                    Abb miArbol = construir.transformar();
                    pre = miArbol.generarPreorden(miArbol.getRaiz());
                    in = miArbol.generarInorden(miArbol.getRaiz());
                    pos = miArbol.generarPosorden(miArbol.getRaiz());
                    Notaciones n = new Notaciones(pre, in, pos, archivo);
                }
            });
        }     
    }

}


