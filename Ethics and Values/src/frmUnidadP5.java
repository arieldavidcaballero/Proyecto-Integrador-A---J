import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmUnidadP5 extends JFrame implements ActionListener {
    static JButton btnRegresar;

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnRegresar)) {
            frmInfoProfesor.ventanaUnidadesP.setVisible(true);
            this.setVisible(false);
        }
    }

    public frmUnidadP5() {
        //fuente normal en negrita y tamaño
        Font fuente = new Font("Arial", Font.BOLD, 18);

        //funcion panel AQUI AGREGAMOS LAS IMAGNES DEL FONDO
        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon fondo = new ImageIcon(".\\img\\unidadP5.jpg");
                g.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);

            }
        };

        // Botones
        btnRegresar = new JButton("Regresar");

        // Bounds
        btnRegresar.setBounds(0, 735, 100, 30);

        // Agregar escuchadores
        btnRegresar.addActionListener(this);

        //Color de botón
        btnRegresar.setBackground(new Color(207, 253, 1, 255));

        // Quitar el borde del botón
        btnRegresar.setBorderPainted(false);

        // Agregamos al Panel
        contentPane.add(btnRegresar);

        // Configuración de la ventana
        setContentPane(contentPane);
        setLayout(null);
        setSize(450, 800);
        setTitle("Unidad 5 Profesor");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}