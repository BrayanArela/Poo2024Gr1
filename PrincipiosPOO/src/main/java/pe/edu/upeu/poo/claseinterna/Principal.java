package pe.edu.upeu.poo.claseinterna;

public class Principal {
    public static void main(String[] args) {
        Mama objM=new Mama();
        objM.alimentar();
        Mama.Bebe bb=objM.new Bebe();
        bb.moverse();
    }
}
