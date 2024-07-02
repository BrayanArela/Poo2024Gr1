
package pe.edu.upeu.poo.encapinterface;

public class Loro implements Animal{
    @Override
    public void emitirSonido() {
        System.out.println("Esto es la Implementación "
                + "...no te olvides!!");
    }
    @Override
    public void dormir() {
        System.out.println("Zzz...zzz.");
    }
    @Override
    public void habla(){
        System.out.println("Hola manito no seas flojo pues");
    }
    
}
