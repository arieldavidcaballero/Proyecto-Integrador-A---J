import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class frmInicial extends JFrame implements ActionListener {

    static ImageIcon imgEstudiantes, imgProfesores;

    static JLabel lblTitulo, lblEstudiantes, lblProfesores;

    static JButton btnEstudiantes, btnProfesores, btnRegresar;

    //ventanas
    static frmRegistrarEstu ventanaRegistroE;
    static frmRegistrarProfe ventanaRegistroP;
    static frmListarEstu ventanaListarE;
    static frmListarProfe ventanaListarP;
    static frmInfoEstudiante ventanaInfoE;
    static frmInfoProfesor ventanaInfoP;
    static frmInicial ventanaInicio;

    //listas
    static ArrayList<Estudiante> listEstudiantes = new ArrayList();
    static ArrayList<Profesor> listProfesores = new ArrayList();


    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnRegresar)) {
            frmLogin.ventanaLogin.setVisible(true);
            this.setVisible(false);

        }

        if (e.getSource().equals(btnEstudiantes)) {
            // Mostrar JOptionPane(ventana chiquita) para opciones de estudiantes
            JRadioButton registrarEstudiante = new JRadioButton("Registrar");
            JRadioButton listarEstudiante = new JRadioButton("Listar");
            JRadioButton informacionEstudiante = new JRadioButton("Informacion");

            ButtonGroup group = new ButtonGroup();
            group.add(registrarEstudiante);
            group.add(listarEstudiante);
            group.add(informacionEstudiante);

            Object[] options = {"Aceptar", "Cancelar"};

            int result = JOptionPane.showOptionDialog(null, new Object[]{"Seleccione una acción:", registrarEstudiante, listarEstudiante, informacionEstudiante},
                    "Opciones de Estudiantes", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);

            if (result == JOptionPane.YES_OPTION) {
                if (registrarEstudiante.isSelected()) {
                    ventanaRegistroE.setVisible(true);
                    this.setVisible(false);
                } if (listarEstudiante.isSelected()) {
                    ventanaListarE.setVisible(true);
                    frmListarEstu.listar();
                    this.setVisible(false);
                } else if (informacionEstudiante.isSelected()) {
                    ventanaInfoE.setVisible(true);
                    this.setVisible(false);
                }

            }
        }
        if (e.getSource().equals(btnProfesores)) {
            // Mostrar JOptionPane(ventana chiquita) para opciones de profesores
            JRadioButton registrarProfesor = new JRadioButton("Registrar");
            JRadioButton listarProfesor = new JRadioButton("Listar");
            JRadioButton informacionProfesor = new JRadioButton("Informacion");

            ButtonGroup group = new ButtonGroup();
            group.add(registrarProfesor);
            group.add(listarProfesor);
            group.add(informacionProfesor);

            Object[] options = {"Aceptar", "Cancelar"};

            int result = JOptionPane.showOptionDialog(null, new Object[]{"Seleccione una acción:", registrarProfesor, listarProfesor, informacionProfesor},
                    "Opciones de Profesores", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);

            if (result == JOptionPane.YES_OPTION) {
                if (registrarProfesor.isSelected()) {
                    ventanaRegistroP.setVisible(true);
                    this.setVisible(false);
                } else if (listarProfesor.isSelected()) {
                    ventanaListarP.setVisible(true);
                    frmListarProfe.listar();
                    this.setVisible(false);
                } else if (informacionProfesor.isSelected()) {
                    ventanaInfoP.setVisible(true);
                    this.setVisible(false);
                }
            }
        }
    }

    public frmInicial() {
        //Ventanas
        ventanaRegistroE = new frmRegistrarEstu(listEstudiantes);
        ventanaRegistroP = new frmRegistrarProfe(listProfesores);

        ventanaListarE = new frmListarEstu(listEstudiantes);
        ventanaListarP = new frmListarProfe(listProfesores);

        ventanaInfoE = new frmInfoEstudiante();
        ventanaInfoP = new frmInfoProfesor();

        //fuente normal en negrita y tamaño
        Font fuente = new Font("Arial", Font.BOLD, 18);

        //funcion panel AQUI AGREGAMOS LAS IMAGNES DEL FONDO
        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon fondo = new ImageIcon(".\\img\\fondoRol2.jpg");
                g.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);

            }
        };

        //img
        imgEstudiantes = new ImageIcon(".\\img\\estudiantes.png");
        imgProfesores = new ImageIcon(".\\img\\profesores.png");

        //lables
        lblTitulo = new JLabel("Elige el tipo de usuario:");
        lblEstudiantes = new JLabel("Estudiante");
        lblProfesores = new JLabel("Profesor");

        //botones
        btnEstudiantes = new JButton(imgEstudiantes);
        btnProfesores = new JButton(imgProfesores);
        btnRegresar = new JButton("Cerrar");

        //camabiar fuentes o colores
        lblTitulo.setFont(fuente);
        lblProfesores.setFont(fuente);
        lblEstudiantes.setFont(fuente);

        btnEstudiantes.setBorderPainted(false);
        btnEstudiantes.setBackground(Color.WHITE);

        btnProfesores.setBorderPainted(false);
        btnProfesores.setBackground(Color.WHITE);

        //bounds
        lblTitulo.setBounds(110, 285, 210, 35);

        lblEstudiantes.setBounds(75, 330, 110, 35);
        lblProfesores.setBounds(280, 330, 110, 35);

        btnEstudiantes.setBounds(60, 365, 129, 128);
        btnProfesores.setBounds(250, 365, 128, 128);

        btnRegresar.setBounds(180, 540, 75, 60);

        //Color de botón
        btnRegresar.setBackground(new Color(245, 178, 36, 255));

        // Quitar el borde del botón
        btnRegresar.setBorderPainted(false);

        //escuchadores
        btnEstudiantes.addActionListener(this);
        btnProfesores.addActionListener(this);
        btnRegresar.addActionListener(this);

        //agregar al panel
        contentPane.add(lblTitulo);

        contentPane.add(lblEstudiantes);
        contentPane.add(btnEstudiantes);

        contentPane.add(lblProfesores);
        contentPane.add(btnProfesores);

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