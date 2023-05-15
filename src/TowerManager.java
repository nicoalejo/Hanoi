import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.util.Stack;

public class TowerManager {

    private Stack<String> torre1 = new Stack();
    private Stack<String> torre2 = new Stack();
    private Stack<String> torre3 = new Stack();

    private DefaultTableModel modelTorre1 = new DefaultTableModel();
    private DefaultTableModel modelTorre2 = new DefaultTableModel();
    private DefaultTableModel modelTorre3 = new DefaultTableModel();
    int objetivo = 0;
    long numMinMov = 0;
    long contNumMov = 0;
    boolean Stop = false;

    public TowerManager(){

        modelTorre1.setRowCount(10);
        modelTorre2.setRowCount(10);
        modelTorre3.setRowCount(10);

    }

    public void Limpiar(){
        numMinMov = 0;
        contNumMov = 0;
    }

    public void UpdateContNumMov(){
        contNumMov++;
    }

    public long getNumMinMov() {
        return numMinMov;
    }

    public long getContNumMov() {
        return contNumMov;
    }

    public void Init(int objetivo) {
        torre1.clear();
        torre2.clear();
        torre3.clear();

        numMinMov = (long)Math.pow(2, objetivo) - 1;

        contNumMov = 0;

        for (int i=objetivo; i >= 1; i--){
            String Disco = "";
            for (int j=i; j > 0; j--){
                Disco += "#";
            }

            torre1.push(Disco);
        }

    }

    public DefaultTableModel PresentarTorre(int torreNum){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Torre");
        Stack<String> torreTemp = new Stack<>();
        switch (torreNum){
            case 1:
                torreTemp.addAll(torre1);
                break;
            case 2:
                torreTemp.addAll(torre2);
                break;
            case 3:
                torreTemp.addAll(torre3);
                break;
        }

        while(!torreTemp.isEmpty()){
            model.addRow(new Object[]{torreTemp.pop()});
        }

        return model;
    }



    public void moveFrom1To2() {
        if(torre1.isEmpty()) return;

        String discoTop = torre1.peek();

        if(!torre2.isEmpty()){
            if(discoTop.compareTo(torre2.peek()) > 0) return;
        }

        torre2.push(torre1.pop());

        UpdateContNumMov();
    }
    public void moveFrom1To3() {
        if(torre1.isEmpty()) return;

        String discoTop = torre1.peek();

        if(!torre3.isEmpty()){
            if(discoTop.compareTo(torre3.peek()) > 0) return;
        }

        torre3.push(torre1.pop());

        UpdateContNumMov();
    }

    public void moveFrom2To1() {
        if(torre2.isEmpty()) return;

        String discoTop = torre2.peek();

        if(!torre1.isEmpty()){
            if(discoTop.compareTo(torre1.peek()) > 0) return;
        }

        torre1.push(torre2.pop());

        UpdateContNumMov();
    }

    public void moveFrom2To3() {
        if(torre2.isEmpty()) return;

        String discoTop = torre2.peek();

        if(!torre3.isEmpty()){
            if(discoTop.compareTo(torre3.peek()) > 0) return;
        }

        torre3.push(torre2.pop());

        UpdateContNumMov();
    }

    public void moveFrom3To1() {
        if(torre3.isEmpty()) return;

        String discoTop = torre3.peek();

        if(!torre3.isEmpty()){
            if(discoTop.compareTo(torre3.peek()) > 0) return;
        }

        torre3.push(torre1.pop());

        UpdateContNumMov();
    }
}

