package inapos;

public class Nodo {
    
    Character data;
    int prec;
    Nodo pNext;
    
    public Nodo(Character x){
        data = x;
    }
    
    public Character getData(){
        return data;
    }
    
}