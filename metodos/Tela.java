package metodos;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.*; //Importando a biblioteca JOptionPane
import java.awt.*; //Importando a biblioteca Dimension e Font
public class Tela {
    public static String nextString(String menssage){
        JTextArea areaTexto = new JTextArea(menssage);
        areaTexto.setPreferredSize(new Dimension(400, 150));
        Font fontePersonalizada = new Font("Arial", Font.PLAIN, 16); 
        areaTexto.setFont(fontePersonalizada);
        areaTexto.setEditable(false);
        areaTexto.setBackground(new JLabel().getBackground()); 
    
    return JOptionPane.showInputDialog(null, areaTexto);
    
    //return JOptionPane.showInputDialog(menssage);
    }
    
    public static double nextDouble(String menssage){
        String valor = nextString(menssage);
        valor =  valor.trim().replace(".","").replace(",",".");
        if(valor == null){
            return 0;
        }
        try{
            return Double.parseDouble(valor);
        } catch (Exception e){
            exibirMensagem("Número Inválido!");
            return nextDouble(menssage);
        }
    }
    
    public static int nextInt(String menssage){
        try{
            String valor =nextString(menssage);
            if (valor != null){
                return Integer.parseInt(valor.trim());
            }
            return 0;
        }catch (Exception e){
            exibirMensagem( "Número Inválido!");
            return nextInt(menssage);
        }
    }
    
    public static Date nextDate(String menssage){
        String data = nextString(menssage);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try{
            return df.parse(data);
        }catch(Exception e){
            return null;
        }
    }
    
    public static void exibirMensagem(String menssage){
        JOptionPane.showMessageDialog(null, menssage);
    }
}
