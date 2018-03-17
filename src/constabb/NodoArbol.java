package constabb;


public class NodoArbol {
    
    private Object data;
    private NodoArbol hIzq;
    private NodoArbol hDer;
    
    public NodoArbol(Object c){
        this.setData(c);
        this.hDer = null;
        this.hIzq = null;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void sethIzq(NodoArbol hi) {
        this.hIzq = hi;
    }

    public void sethDer(NodoArbol hd) {
        this.hDer = hd;
    }

    public NodoArbol gethIzq() {
        return hIzq;
    }

    public NodoArbol gethDer() {
        return hDer;
    }
    
    
    
    public Object getData(){
        return this.data;
    }

}
