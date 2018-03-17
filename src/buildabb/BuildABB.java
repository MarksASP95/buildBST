package buildabb;
import interfaz.*;
import javax.swing.UIManager;

public class BuildABB {

    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception e){
            
        }
        
        Principal p = new Principal();
        
    }
    
}
