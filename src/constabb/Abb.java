package constabb;


public class Abb {
    private NodoArbol raiz;
    private String inorden = "", preorden = "", posorden = "";
    
    public NodoArbol getRaiz(){
        return raiz;
    }
    
    public void setRaiz(Character c){
        raiz = new NodoArbol(c);
    }
    
    public void insertar(Object a1, Object a2){
        if (a1 instanceof Character) {
            NodoArbol hi = new NodoArbol(a1);
            getRaiz().sethIzq(hi);
        }
        else{
            Abb abb = (Abb) a1;
            getRaiz().sethIzq(abb.getRaiz());
        }
        if (a2 instanceof Character) {
            NodoArbol hd = new NodoArbol(a2);
            getRaiz().sethDer(hd);
        }
        else{
            Abb abb = (Abb) a2;
            getRaiz().sethDer(abb.getRaiz());
        }
    }
    
    public void mostrar(NodoArbol pivote){
        if (pivote != null) {
            mostrar(pivote.gethIzq());
            System.out.println(pivote.getData());
            mostrar(pivote.gethDer());
        }
        
    }
    
    public String generarInorden(NodoArbol pivote){
        if (pivote != null) {
            generarInorden(pivote.gethIzq());
            inorden += pivote.getData();
            generarInorden(pivote.gethDer());
        }
        return inorden;
    }
    
    public String generarPreorden(NodoArbol pivote){
        if (pivote != null) {
            preorden += pivote.getData();
            generarPreorden(pivote.gethIzq());
            generarPreorden(pivote.gethDer());
        }
        return preorden;
    }
    
    public String generarPosorden(NodoArbol pivote){
        if (pivote != null) {
            generarPosorden(pivote.gethIzq());
            generarPosorden(pivote.gethDer());
            posorden += pivote.getData();
        }
        return posorden;
    }
    
}
