import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class frmRegistrarEstu extends JFrame implements ActionListener {
    static JLabel lblNombre, lblApellido, lblCodigoEstu;
    static JTextField txtNombre, txtApellido, txtCodigoEstu;
    static JButton btnRegistrar , btnRegresar;
    static ArrayList<Estudiante> listEstudiantes;

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
            String codigo = txtCodigoEstu.getText();

            // Verificar que ningún campo esté vacío
            if (nombre.isEmpty() || apellido.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Salir del método actionPerformed sin registrar
            }

            Estudiante nuevoEstudiante = new Estudiante(nombre, apellido,codigo);
            listEstudiantes.add(nuevoEstudiante);

            // Limpiar los campos de texto después de registrar
            txtNombre.setText("");
            txtApellido.setText("");
            txtCodigoEstu.setText(generarCodigo());
        }
    }
    public frmRegistrarEstu(ArrayList<Estudiante> listEstudiantes) {

        this.listEstudiantes = listEstudiantes;

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
        lblCodigoEstu = new JLabel("Código:");

        //texto
        txtNombre = new JTextField();
        txtApellido = new JTextField();

        txtCodigoEstu = new JTextField(generarCodigo());
        txtCodigoEstu.setEditable(false);

        //boton
        btnRegistrar = new JButton("Registrar");
        btnRegresar = new JButton("Regresar");

        //Bounds
        lblNombre.setBounds(100, 330, 80, 20);
        txtNombre.setBounds(200, 330, 134, 30);

        lblApellido.setBounds(100, 367, 80, 20);
        txtApellido.setBounds(200, 365, 134, 30);

        lblCodigoEstu.setBounds(100,405, 80, 20);
        txtCodigoEstu.setBounds(200, 400, 134, 30);

        btnRegistrar.setBounds(250,470,120,30);
        btnRegresar.setBounds(50,470,120,30);

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

        contentPane.add(lblCodigoEstu);
        contentPane.add(txtCodigoEstu);

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
    public String generarCodigo() {
        Random rnd = new Random();
        int numero = rnd.nextInt(90000) + 10000; // Genera un número entre 10000 y 99999
        return String.valueOf(numero);
    }
}
