package inapos;

public class Pila {

    private int iN;
    private Nodo peek;
    
    public Boolean esVacia(){
        if(iN  == 0)
        {
            return true;
        }
        return false;
    }
    
    public void push(Character x){
        Nodo nuevo = new Nodo(x);
        nuevo.pNext = peek;
        peek = nuevo;
        iN++;
    }
    
    public void pop(){
        Nodo temp = peek;
        peek = peek.pNext;
        temp.pNext = null;
        iN--;
    }
    
    public int size(){
        return iN;
    }
    
    public Nodo peek(){
        return peek;
    }
    
    public void mostrar(){
        Character elem;
        if (!esVacia()) {
           elem = peek().data;
           System.out.println(elem);
           pop();
           mostrar();
           push(elem);
        }
    }
    
    
    
}
