public class Estudiante {

    // ATRIBUTOS
    private String nombres;
    private String apellidos;
    private String codigo;

    //METODOS
    public Estudiante(String nombres, String apellidos, String codigo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.codigo = codigo;
    }
    public  Object[] getInformacion(Estudiante estudiante){
        Object[] lista = {getNombres(),getApellidos(),getCodigo()};
        return lista;
    }
    // GET
    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }
    public String getCodigo(){return codigo;}

}
