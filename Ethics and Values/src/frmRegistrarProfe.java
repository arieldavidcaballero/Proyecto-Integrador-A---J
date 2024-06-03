import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class frmRegistrarProfe extends JFrame implements ActionListener {
    static JLabel lblNombre, lblApellido, lblDocumento , lblEdad, lblContraseña;
    static JTextField txtNombre, txtApellido, txtDocumento, txtEdad, txtContraseña;
    static JButton btnRegistrar , btnRegresar;
    static ArrayList<Profesor> listProfesores;

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnRegresar)) {
            frmLogin.ventanaInicio.setVisible(true);
            this.setVisible(false);

            txtNombre.setText("");
            txtApellido.setText("");
        }

        if (e.getSource().equals(btnRegistrar)) {
            String nombre = txtNombre.getText().trim();
            String apellido = txtApellido.getText().trim();
            int documento = Integer.parseInt(txtDocumento.getText());
            int edad = Integer.parseInt(txtEdad.getText());
            int contraseña = Integer.parseInt(txtContraseña.getText());

            /*if (nombre.isEmpty() || apellido.isEmpty() || txtDocumento.getText().trim().isEmpty() || txtEdad.getText().trim().isEmpty() || txtContraseña.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Salir del método actionPerformed sin registrar
            }*/

            // Verificar que ningún campo esté vacío
            if (nombre.isEmpty() || apellido.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Salir del método actionPerformed sin registrar
            }

            Profesor nuevoProfesor = new Profesor(nombre, apellido, documento, edad, contraseña);
            listProfesores.add(nuevoProfesor);

            // Limpiar los campos de texto después de registrar
            txtNombre.setText("");
            txtApellido.setText("");
            txtDocumento.setText("");
            txtEdad.setText("");
            txtContraseña.setText("");
        }
    }
    public frmRegistrarProfe(ArrayList<Profesor> listProfesores) {

        this.listProfesores = listProfesores;

        //funcion panel AQUI AGREGAMOS LAS IMAGNES DEL FONDO
        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                ImageIcon fondo = new ImageIcon(".\\img\\fondoRegistrar.jpg");
                g.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this); // getWidth(), getHeight() es para que coja el ancho y el largo de la imagen y se ajuste

            }
        };

        //lbales
        lblNombre = new JLabel("Nombres:");
        lblApellido = new JLabel("Apellidos:");
        lblDocumento = new JLabel("Documento:");
        lblEdad = new JLabel("Edad:");
        lblContraseña = new JLabel("Contraseña:");

        //texto
        txtNombre = new JTextField();
        txtApellido = new JTextField();
        txtDocumento = new JTextField();
        txtEdad = new JTextField();
        txtContraseña = new JTextField();

        //boton
        btnRegistrar = new JButton("Registrar");
        btnRegresar = new JButton("Regresar");

        //Bounds
        lblNombre.setBounds(100, 322, 80, 20);
        txtNombre.setBounds(200, 320, 134, 30);

        lblApellido.setBounds(100, 357, 80, 20);
        txtApellido.setBounds(200, 355, 134, 30);

        lblDocumento.setBounds(100,392, 80, 20);
        txtDocumento.setBounds(200, 390, 134, 30);

        lblEdad.setBounds(100,427, 80, 20);
        txtEdad.setBounds(200, 425, 134,30);

        lblContraseña.setBounds(100, 462, 90, 20);
        txtContraseña.setBounds(200, 460, 134,30);

        btnRegistrar.setBounds(250,520,120, 30);
        btnRegresar.setBounds(50,520, 120, 30);

        // colores de los botones
        btnRegistrar.setBackground(new Color(171, 216, 255, 255));
        btnRegresar.setBackground(new Color(171, 216, 255, 255));

        //escuchadores
        btnRegresar.addActionListener(this);
        btnRegistrar.addActionListener(this);


        //agregar
        contentPane.add(lblNombre);
        contentPane.add(txtNombre);

        contentPane.add(lblApellido);
        contentPane.add(txtApellido);

        contentPane.add(lblDocumento);
        contentPane.add(txtDocumento);

        contentPane.add(lblEdad);
        contentPane.add(txtEdad);

        contentPane.add(lblContraseña);
        contentPane.add(txtContraseña);

        contentPane.add(btnRegistrar);
        contentPane.add(btnRegresar);


        // configuración de pantalla
        setContentPane(contentPane);
        setLayout(null);
        setSize(450, 800);
        setTitle("Login");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}