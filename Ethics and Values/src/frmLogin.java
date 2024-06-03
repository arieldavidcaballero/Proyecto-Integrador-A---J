import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmLogin extends JFrame implements ActionListener {
    static ImageIcon imgUsuario, imgContraseña;

    static JLabel lblUsuario, lblContraseña, lblGmail, lblCandado; //TEXTOS
    static JTextField txtUsuario; //ENTRADA DE TEXTO
    static JPasswordField txtContraseña; // ENTRADA DE CONTRASEÑA
    static JButton btnIniciarSesion; // BOTONES

    // VENTANAS
    static frmLogin ventanaLogin;
    static frmInicial ventanaInicio;

    // FUNCION PARA "ESCUCHAR" CUANDO HACEN CLICK EN UN BOTON
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnIniciarSesion)) {
            String usuario = txtUsuario.getText();
            String contraseña = txtContraseña.getText();

            if(Usuarios.validarUsuario(usuario,contraseña)){
                ventanaInicio.setVisible(true);
                this.setVisible(false);
                txtUsuario.setText("");
                txtContraseña.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o clave incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public frmLogin() {
        // ventanas
        ventanaInicio = new frmInicial();

        // funcion panel AQUI AGREGAMOS LAS IMAGNES DEL FONDO
        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                ImageIcon fondo = new ImageIcon(".\\img\\fondo.jpg");
                g.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this); // getWidth(), getHeight() es para que coja el ancho y el largo de la imagen y se ajuste
            }
        };

        // imagenes
        imgUsuario = new ImageIcon(".\\img\\gmail.png");
        imgContraseña = new ImageIcon(".\\img\\candado.png");

        // lbales
        lblUsuario = new JLabel("Usuario:");
        lblContraseña = new JLabel("Contraseña:");
        lblGmail = new JLabel(imgUsuario);
        lblCandado = new JLabel(imgContraseña);

        // txt
        txtUsuario = new JTextField();
        txtContraseña = new JPasswordField();

        //botones
        btnIniciarSesion = new JButton("Iniciar");

        // Bounds
        lblGmail.setBounds(92, 380, 40, 40);
        lblUsuario.setBounds(145,359,80,40);
        txtUsuario.setBounds(145,390,170,30);

        lblCandado.setBounds(92, 447, 40, 40);
        lblContraseña.setBounds(145,425,80,40);
        txtContraseña.setBounds(145,455,170,30);

        btnIniciarSesion.setBounds(350,413, 100,45);

        //Color de botón
        btnIniciarSesion.setBackground(new Color(245, 178, 36, 255));

        // Quitar el borde del botón
        btnIniciarSesion.setBorderPainted(false);

        //agregar el escuchador al boton
        btnIniciarSesion.addActionListener(this);

        // agregar al panel
        contentPane.add(lblGmail);
        contentPane.add(lblUsuario);
        contentPane.add(txtUsuario);

        contentPane.add(lblCandado);
        contentPane.add(lblContraseña);
        contentPane.add(txtContraseña);

        contentPane.add(btnIniciarSesion);

        // configuración de pantalla
        setContentPane(contentPane);
        setLayout(null);
        setSize(450, 800);
        setTitle("Login");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        ventanaLogin = new frmLogin();
        ventanaLogin.setVisible(true);
    }
}
