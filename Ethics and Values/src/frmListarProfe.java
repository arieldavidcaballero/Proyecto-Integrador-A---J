import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class frmListarProfe extends JFrame implements ActionListener {
    static ArrayList<Profesor> listProfesores;
    static JTable tabla;
    static DefaultTableModel model;
    static JScrollPane scrollPanel;
    static JButton btnRegresar;
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnRegresar)) {
            frmLogin.ventanaInicio.setVisible(true);
            this.setVisible(false);
            limpiarRegistros();

        }
    }
    public frmListarProfe(ArrayList<Profesor> listProfesores) {
        this.listProfesores = listProfesores;

        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                ImageIcon fondo = new ImageIcon(".\\img\\fondoListar.jpg");
                g.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        model = new DefaultTableModel();
        tabla = new JTable(model);

        model.addColumn("Nombres");
        model.addColumn("Apellidos");
        model.addColumn("Documento");
        model.addColumn("Edad");
        model.addColumn("Contraseña");

        scrollPanel = new JScrollPane(tabla);
        scrollPanel.setBounds(50, 50, 350, 500);

        btnRegresar = new JButton("Regresar");
        btnRegresar.setBounds(50, 650, 120, 30);

        btnRegresar.addActionListener(this);


        contentPane.add(scrollPanel);
        contentPane.add(btnRegresar);

        setContentPane(contentPane);
        setLayout(null);
        setSize(450, 800);
        setTitle("Listado de Profesores Registrados");
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    static public void listar(){

        for (Profesor profesor : listProfesores){
            model.addRow(profesor.getInformacion(profesor));
        }

    }
    static public void limpiarRegistros() {
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }
}
