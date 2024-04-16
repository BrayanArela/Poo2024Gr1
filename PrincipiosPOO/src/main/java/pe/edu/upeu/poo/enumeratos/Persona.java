package pe.edu.upeu.poo.enumeratos;

enum GENEROD{
    Femenino, Masculino
}
enum ESTADO_CIVIL{Soltero, Casado, Divorciado, Viudo}


public class Persona {
    String nombre;
    String dni;
    String genero=GENEROD.Femenino.name();
    String estadoC;
    
    public static void main(String[] args) {
        Persona p=new Persona();
        System.out.println("Genero:"+p.genero);
        for(ESTADO_CIVIL ec:ESTADO_CIVIL.values()){
            System.out.println("EC:"+ec);}
    }
    
}

