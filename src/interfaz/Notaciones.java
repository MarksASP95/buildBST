package interfaz;
import java.awt.*;
import javax.swing.*;
import constabb.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Notaciones extends JFrame{
    
    private LaminaNotaciones panel;
    private Dimension resolucion = Toolkit.getDefaultToolkit().getScreenSize();
    
    public Notaciones(String pre, String in, String pos, String archivo){
        panel = new LaminaNotaciones(pre, in, pos);
        setTitle("Notaciones     --- " + archivo + " ---");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 295);
        setLocation(resolucion.width / 2 - this.getSize().width / 2, resolucion.height / 2 - this.getSize().height / 2);
        
        add(panel);
        
        setVisible(true);
        
        
    }

    class LaminaNotaciones extends JPanel{
    
    private JLabel infija = new JLabel("Infija", SwingConstants.LEFT);
    private JLabel prefija = new JLabel("Prefija", SwingConstants.LEFT);
    private JLabel posfija = new JLabel("Posfija", SwingConstants.LEFT);
    private JTextField textoInfija = new JTextField();
    private JTextField textoPrefija = new JTextField();
    private JTextField textoPosfija = new JTextField();
    private JButton mostrarArbol = new JButton("Mostrar arbol");
    
    public LaminaNotaciones(String pre, String in, String pos){
        
        
        setLayout(null);
        
        mostrarArbol.setBounds(160, 210, 125, 30);
        
        infija.setFont(new Font("Verdana", Font.BOLD, 18));
        infija.setBounds(50,20,450,25);
        
        prefija.setFont(new Font("Verdana", Font.BOLD, 18));
        prefija.setBounds(50,80,450,25);
        
        posfija.setFont(new Font("Verdana", Font.BOLD, 18));
        posfija.setBounds(50,140,450,25);
        
        
        textoInfija.setEditable(false);
        textoInfija.setBounds(50,50,350,25);
        textoInfija.setText(in);
        textoInfija.setFont(new Font("Consolas", Font.BOLD, 14));
        
        textoPrefija.setEditable(false);
        textoPrefija.setBounds(50,110,350,25);
        textoPrefija.setText(pre);
        textoPrefija.setFont(new Font("Consolas", Font.BOLD, 14));
        
        textoPosfija.setEditable(false);
        textoPosfija.setBounds(50,170,350,25);
        textoPosfija.setText(pos);
        textoPosfija.setFont(new Font("Consolas", Font.BOLD, 14));
        
        mostrarArbol.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ArbolFisico af =  new ArbolFisico(textoPosfija.getText());
            }
        });
        
        System.out.println(pre);
        
        add(textoInfija);
        add(textoPrefija);
        add(textoPosfija);
        add(infija);
        add(prefija);
        add(posfija);
        add(mostrarArbol);
        
    }
    
    
    }
    
    
}



