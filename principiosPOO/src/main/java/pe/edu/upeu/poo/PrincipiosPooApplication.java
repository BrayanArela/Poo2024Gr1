package pe.edu.upeu.poo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.upeu.poo.cobjeto.Persona;

@SpringBootApplication
public class PrincipiosPooApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrincipiosPooApplication.class, args);
                Persona person=new Persona(); //aplicando objetos//para usar sus atributos y acciones
                person.setNombre("Brayan");
                person.setEdad(25);
                person.edad=50;
                System.out.println("yo soy "+person.getNombre()
                +" y tengo "+person.getEdad()+" años");
                person.saludo();
	}
}
