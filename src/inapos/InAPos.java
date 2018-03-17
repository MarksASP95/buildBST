package inapos;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InAPos { //INORDEN A POSORDEN
    
    private Pila pila = new Pila();
    private Character[] inorden;
    private Character[] posorden;
    private String regex = "[a-zA-Z1-9]"; //PATRON PARA DETECTAR LETRAS O NUMEROS
    private Pattern patron = Pattern.compile(regex);
    
    public InAPos(String entrada){
        
        inorden = new Character[entrada.length()];
        posorden = new Character[entrada.length()];
        
        inicArreglo(posorden);
        
        for (int i = 0; i < entrada.length(); i++) {
            inorden[i] = entrada.charAt(i);
        }
    }
    
    public Character[] transformar(){
        
        int cont = 0;
        Character E;
        while(cont < inorden.length)
        {
            E = inorden[cont];
            Matcher m = patron.matcher(E.toString());
            if (m.find()) {
                insertarAlFinal(E, posorden);
            }
            else{
                switch(E)
                {
                    case '(':
                        pila.push(E);
                        break;
                    case ')':
                        while(!pila.esVacia() && !pila.peek().data.equals('('))
                        {
                            insertarAlFinal(pila.peek().data, posorden);
                            pila.pop();   
                        }
                        if (pila.peek().data.equals('(')) 
                        {
                            pila.pop();
                        }
                        break;
                    default: //OPERADOR
                        if (E.equals('+') || E.equals('-')) {
                            if (!pila.esVacia() && pila.peek().data.equals('*') || pila.peek().data.equals('/') || pila.peek().data.equals('^')) {
                                while(!pila.esVacia() && (pila.peek().data.equals('*') || pila.peek().data.equals('/') || pila.peek().data.equals('^')))
                                {                              
                                    insertarAlFinal(pila.peek().data, posorden);
                                    pila.pop(); 
                                }
                                if (!pila.esVacia() && (pila.peek().data.equals('+') || pila.peek().equals('-'))) {
                                    insertarAlFinal(pila.peek().data, posorden);
                                    pila.pop();
                                }
                            }
                            else if (!pila.esVacia() && (pila.peek().data.equals('+') || pila.peek().equals('-'))) {
                                insertarAlFinal(pila.peek().data, posorden);
                                pila.pop();
                            }
                            pila.push(E);
                        }
                        else if (E.equals('*') || E.equals('/')) {
                            if (!pila.esVacia() && pila.peek().data.equals('^')) {
                                while(!pila.esVacia() && pila.peek().data.equals('^'))
                                {
                                    insertarAlFinal(pila.peek().data, posorden);
                                    pila.pop(); 
                                }
                                if (!pila.esVacia() && (pila.peek().data.equals('*') || pila.peek().data.equals('/'))) {
                                    insertarAlFinal(pila.peek().data, posorden);
                                    pila.pop();
                                }
                            }
                            else if (!pila.esVacia() && (pila.peek().data.equals('*') || pila.peek().data.equals('/'))) {
                                insertarAlFinal(pila.peek().data, posorden);
                                pila.pop();
                            }
                            pila.push(E);
                        }
                        else if (E.equals('^')) {
                            pila.push(E);
                        }
                        break;
                }  
            }
            cont++;
        }
        
        while(!pila.esVacia())
        {
            insertarAlFinal(pila.peek().data, posorden);
            pila.pop();
        }
        
        //DEVUELVE EL RESULTADO CON 0's
        return posorden;
        
    }
    
    public void insertarAlFinal(Character c, Character[] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            if (!arreglo[i].equals('0')) 
            {
                arreglo[i-1] = arreglo[i];
                arreglo[i] = '0';
            }
        }
        arreglo[arreglo.length - 1] = c;
    }
    
    public void inicArreglo(Character[] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = '0';
        }
    }  
}
