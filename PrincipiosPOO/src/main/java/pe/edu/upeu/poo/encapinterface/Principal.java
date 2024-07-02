package pe.edu.upeu.poo.encapinterface;

public class Principal {
    public static void main(String[] args) {
        Animal obj=new Loro();
        obj.emitirSonido();
        obj.dormir();
        obj.habla();
    }
}
