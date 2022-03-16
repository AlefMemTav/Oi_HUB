package Modelo;
import java.util.*;
public class TesteTP3 {
	static Pet p1;
	static Cliente c1;
	static Hospedagem h1;
 static void main(String[] args) {
	 GregorianCalendar d = new GregorianCalendar();
	 Date agora = d.getTime();
	 
	 c1 = new Cliente("teste@teste.com", "User", "123", 613311313);
	 p1 = new Pet("Sim", "Cão", "Macho", "Vira-lata", 1.3);
	}
}
