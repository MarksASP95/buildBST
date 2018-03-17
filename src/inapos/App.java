package inapos;


public class App {
    
    public static void main(String[] args){
        
        InAPos inapos = new InAPos("(4+5*3)/(9-8)");
        Character[] posorden = inapos.transformar();
        
        for (int i = 0; i < posorden.length; i++) {
            if (!posorden[i].equals('0')) {
                System.out.println(posorden[i]);
            }
        }
        
    }

}
