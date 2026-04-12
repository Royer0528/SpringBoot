package Microservicios.Spring.Domain;

//Clase POJO
public class Customer {
    //atributos
    private int ID;
    private String nombre;
    private String username;
    private String password;

    //Constructor
    public Customer(int ID, String nombre, String username, String password) {
        this.ID = ID;
        this.nombre = nombre;
        this.username = username;
        this.password = password;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
