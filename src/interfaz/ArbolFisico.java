package interfaz;

import constabb.Abb;
import java.awt.*;
import javax.swing.*;
import constabb.BuildAbb;
import constabb.NodoArbol;
import java.awt.Toolkit;
import java.awt.Graphics.*;

public class ArbolFisico extends JFrame{
    
    private BuildAbb construir;
    private Abb arbol;
    private LaminaArbolFisico panel;
    private Dimension resolucion =  Toolkit.getDefaultToolkit().getScreenSize();

    public ArbolFisico(String posfijaStr){
        construir = new BuildAbb(posfijaStr);
        arbol = construir.transformar();
        panel = new LaminaArbolFisico(arbol);
        
        setTitle("Arbol binario");
        setSize(1200,500);
        setLocation(resolucion.width / 2 - this.getSize().width / 2, resolucion.height / 2 - this.getSize().height / 2);
        
        add(panel);
        setVisible(true);
    }
    
    class LaminaArbolFisico extends JPanel{
        
        private Abb arbol;
        JLabel label;
        
        public LaminaArbolFisico(Abb arbol){
            setLayout(null);
            this.arbol = arbol;
            
        }
        
        public void paintComponent(Graphics g){
                
            super.paintComponent(g);
            
            Graphics f = g;
            
            g.setFont(new Font("Verdana", Font.BOLD, 20));

            
            
            
            dibujarArbol(g, arbol.getRaiz(), 600.0, 20.0, 200.0);

        }
        
        public void dibujarArbol(Graphics g, NodoArbol pivote, Double x, Double y, Double factor){
            if (pivote != null) {
                dibujarArbol(g, pivote.gethIzq(), x - 40 - factor, y + 40, (factor*0.2));
                g.drawString(pivote.getData().toString(), x.intValue(), y.intValue());
                dibujarArbol(g, pivote.gethDer(), x + 40 + factor, y + 40, (factor*0.2));
            }
        }
        
        
    }

}
