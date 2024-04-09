package pe.edu.upeu.poo.abspolimorfismo;


public class Loro extends Animal{

    @Override
    public void animalSound() {
        System.out.println("Hola manito");

    }
    @Override
    public void sleep(){
        System.out.println("No molestes... Estoy durmiendo");
    }  
}
