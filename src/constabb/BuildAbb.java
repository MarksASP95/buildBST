package constabb;

import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class BuildAbb {
    
    private Character[] posorden;
    Object[] pilaObjetos;
    private String regex = "[a-zA-Z1-9]";
    private Pattern patron = Pattern.compile(regex);
    
    public BuildAbb(String entrada){
        
        posorden = new Character[entrada.length()];
        pilaObjetos = new Object[entrada.length()];
        inicPila(pilaObjetos);
        
        for (int i = 0; i < posorden.length; i++) {
            posorden[i] = entrada.charAt(i);
        }
        
    }
    
    public void inicPila(Object[] p){
        for (int i = 0; i < p.length; i++) {
            p[i] = '0';
        }
    }
    
    public boolean esVacio(Character[] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            if (!arreglo[i].equals('0')) {
                return false;
            }
        }
        return true;
    }
    
    public Object cima(){
        Object elem = new Object();
        for (int i = 0; i < pilaObjetos.length; i++) {
            if (!pilaObjetos[i].equals('0')) {
                elem =  pilaObjetos[i];
                i = pilaObjetos.length;
            }
        }
        return elem;
    }
    
    public void desapilar(){
        for (int i = 0; i < pilaObjetos.length; i++) {
            if (!pilaObjetos[i].equals('0') ) {
                pilaObjetos[i] = '0';
                i = pilaObjetos.length;
            }
        }
        
    }
    
    public void apilar(Object nuevo){
        for (int i = 0; i < pilaObjetos.length; i++) {
            if (!pilaObjetos[i].equals('0')) {
                pilaObjetos[i-1] = nuevo;
                i = pilaObjetos.length;
            }
            else if(i == pilaObjetos.length - 1){
                pilaObjetos[i] = nuevo;
            }
        }
    }
    
    public Abb transformar(){
        int cont = 0;
        Object a1, a2;
        Abb arbol = new Abb();
        Abb arbolTemp = new Abb();
        while(!esVacio(posorden)){
            Character E = posorden[cont];
            Matcher m = patron.matcher(E.toString());
            if (m.find()) {
                apilar(E);
                
            }
            else{
                a2 = cima();
                desapilar();
                a1 = cima();
                desapilar();
                arbolTemp = new Abb();
                arbolTemp.setRaiz(E);
                arbolTemp.insertar(a1, a2);
                apilar(arbolTemp);
                arbol = arbolTemp;
            }
            posorden[cont] = '0';
            cont++;
        }
        return arbol;
    }
}
