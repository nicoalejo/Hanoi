import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainForm extends JFrame {
    private JTabbedPane tabbedPane1;
    private JButton factorialButton;
    private JTextArea textAFactorial;
    private JPanel mainPanel;
    private JTextField textFnumber;
    private JTable torre1;
    private JTable torre2;
    private JTable torre3;
    private JButton bButton1;
    private JButton cButton1;
    private JButton aButton2;
    private JButton cButton2;
    private JButton aButton3;
    private JButton bButton3;
    private JComboBox cmbNumberDiscs;
    private JLabel textMinMov;
    private JLabel textNumMov;
    private JButton btnIniciar;
    private JButton btnResolver;
    private JButton btnReiniciar;

    private  FactorialRecursivo factorialClase = new FactorialRecursivo();
    private  TowerManager towerManager;
    public mainForm() {
        FillNumberDiscs();

        towerManager = new TowerManager();
        factorialButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            timeFactorial();
        }
    });
        btnIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InitTowers();
            }
        });
        btnReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResetTowers();
            }
        });
        btnResolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        bButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MoveFrom1To2();
            }
        });
        cButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        aButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        cButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        aButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        bButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void MoveFrom1To2() {
        towerManager.moveFrom1To2();
        FillTowers(1, torre1);
        FillTowers(2, torre2);
        textNumMov.setText(String.valueOf(towerManager.getContNumMov()));
    }

    private void ResetTowers() {
        Limpiar();
        InitTowers();
    }

    private void InitTowers() {
        towerManager.Init(Integer.parseInt(cmbNumberDiscs.getSelectedItem().toString()));
        textNumMov.setText(String.valueOf(towerManager.getContNumMov()));
        textMinMov.setText(String.valueOf(towerManager.getNumMinMov()));
        FillTowers(1, torre1);
    }

    private void FillNumberDiscs() {
        for (int i=3; i <= 10; i++){
            cmbNumberDiscs.addItem(i);
        }
    }

    private void FillTowers(int towerNumber, JTable tableTower) {

        tableTower.setModel(towerManager.PresentarTorre(towerNumber));

        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(SwingConstants.CENTER);
        tableTower.getColumnModel().getColumn(0).setCellRenderer(render);
    }

    private void Limpiar(){
        towerManager.Limpiar();
        textMinMov.setText(String.valueOf(towerManager.getNumMinMov()));
        textNumMov.setText(String.valueOf(towerManager.getContNumMov()));
    }

    private void CantidadMovimientos(){
        towerManager.UpdateContNumMov();
        textNumMov.setText(String.valueOf(towerManager.getContNumMov()));
    }

    private void timeFactorial(){
        long startTime = System.nanoTime();
        long resultadoFactorial = factorialClase.CalcularFactorialRecursivo(Integer.parseInt(textFnumber.getText()));
        long endTime = System.nanoTime();
        long timeTotal = endTime - startTime;
        textAFactorial.setText("Factorial Recursivo " + resultadoFactorial + " se tardo " + timeTotal + "ns\n");

        startTime = System.nanoTime();
        resultadoFactorial = factorialClase.CalcularFactorialIterativo(Integer.parseInt(textFnumber.getText()));
        endTime = System.nanoTime();
        timeTotal = endTime - startTime;
        textAFactorial.append("Factorial Iterativo " + resultadoFactorial + " se tardo " + timeTotal + "ns");
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
