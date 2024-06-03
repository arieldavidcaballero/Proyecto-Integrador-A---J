import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmInfoProfesor extends JFrame implements ActionListener {
    static ImageIcon imgUni1, imgUni2, imgUni3, imgUni4, imgUni5;
    static JButton btnUnidad1, btnUnidad2, btnUnidad3, btnUnidad4, btnUnidad5, btnRegresar;
    static frmInfoProfesor ventanaUnidadesP;

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnRegresar)) {
            frmLogin.ventanaInicio.setVisible(true);
            this.setVisible(false);
        }

        if (e.getSource().equals(btnUnidad1)) {
            new frmUnidadP1().setVisible(true);
            this.setVisible(false);
        } else if (e.getSource().equals(btnUnidad2)) {
            new frmUnidadP2().setVisible(true);
            this.setVisible(false);
        } else if (e.getSource().equals(btnUnidad3)) {
            new frmUnidadP3().setVisible(true);
            this.setVisible(false);
        } else if (e.getSource().equals(btnUnidad4)) {
            new frmUnidadP4().setVisible(true);
            this.setVisible(false);
        } else if (e.getSource().equals(btnUnidad5)) {
            new frmUnidadP5().setVisible(true);
            this.setVisible(false);
        }
    }

    public frmInfoProfesor() {
        ventanaUnidadesP = this;  // Inicialización de ventanaUnidadesP

        //fuente normal en negrita y tamaño
        Font fuente = new Font("Arial", Font.BOLD, 18);

        //funcion panel AQUI AGREGAMOS LAS IMAGNES DEL FONDO
        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon fondo = new ImageIcon(".\\img\\FondoINFO.jpg");
                g.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        // img
        imgUni1 = resizeImageIcon(".\\img\\unidad1.jpg", 200, 100);
        imgUni2 = resizeImageIcon(".\\img\\unidad2.jpg", 200, 100);
        imgUni3 = resizeImageIcon(".\\img\\unidad3.jpg", 200, 100);
        imgUni4 = resizeImageIcon(".\\img\\unidad4.jpg", 200, 100);
        imgUni5 = resizeImageIcon(".\\img\\unidad5.jpg", 200, 100);

        // Botones
        btnUnidad1 = new JButton(imgUni1);
        btnUnidad2 = new JButton(imgUni2);
        btnUnidad3 = new JButton(imgUni3);
        btnUnidad4 = new JButton(imgUni4);
        btnUnidad5 = new JButton(imgUni5);
        btnRegresar = new JButton("Regresar");

        // Bounds
        btnUnidad1.setBounds(100, 100, 200, 100);
        btnUnidad2.setBounds(150, 220, 200, 100);
        btnUnidad3.setBounds(100, 340, 200, 100);
        btnUnidad4.setBounds(150, 460, 200, 100);
        btnUnidad5.setBounds(100, 580, 200, 100);
        btnRegresar.setBounds(0, 735, 100, 30);

        //Color de botón
        btnRegresar.setBackground(new Color(253, 99, 48, 255));

        // Quitar el borde del botón
        btnUnidad1.setBorderPainted(false);
        btnUnidad2.setBorderPainted(false);
        btnUnidad3.setBorderPainted(false);
        btnUnidad4.setBorderPainted(false);
        btnUnidad5.setBorderPainted(false);
        btnRegresar.setBorderPainted(false);

        // Agregar escuchadores
        btnUnidad1.addActionListener(this);
        btnUnidad2.addActionListener(this);
        btnUnidad3.addActionListener(this);
        btnUnidad4.addActionListener(this);
        btnUnidad5.addActionListener(this);
        btnRegresar.addActionListener(this);

        // Agregar botones al panel
        contentPane.add(btnUnidad1);
        contentPane.add(btnUnidad2);
        contentPane.add(btnUnidad3);
        contentPane.add(btnUnidad4);
        contentPane.add(btnUnidad5);
        contentPane.add(btnRegresar);

        // Configuración de la ventana
        setContentPane(contentPane);
        setLayout(null);
        setSize(450, 800);
        setTitle("Información de Profesor");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    // Método para redimensionar la imagen y crear un ImageIcon
    private static ImageIcon resizeImageIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(path);
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
}
