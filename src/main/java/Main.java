import entes.java.Personaje;
import java.utils.Scanner;
import java.utils.Random;

public class Main{
	public static void main(String[] args){
		Scanner lector = new Scanner(System.in);

		Personaje nyx = new Personaje("Nyx");
		Personaje enemigo = new Personaje("Orco");


	}

	public static void pelear(Personaje a, Personaje b){
		Scanner lector = new Scanner(System.in);
		Random rnd = new Random();
		int temp = 0;
		while((a.getVida > 0) && (b.getVida > 0)){
			System.out.printf("Estas frente a un %s de %d HP, que vas a hacer?\n",b.getName(),b.getVida());
			System.out.println("[1] Ataque normal\n[2] Ataque fuerte\n[3]Defenderse");
			temp = lector.nextInt();
			switch temp{
				case 1:
					if(rnd.nextInt(20)%b.getDex()==0){
						b.changeVida(b.getVida() - 10*a.getFuerza() + 5*b.getDefensa());
					}
					switch rnd.nextInt(2){
						case 0:
							break;
						case 1:
							b.ataqueFuerte();
							break;
						case 2:
							b.defender();
							break;
					}
					if (rnd.nextInt(20)%a.getDex()==0){
						a.changeVida(a.getVida() - 10*b.getFuerza() + 5*a.getDefensa());
					}
					break;
				case 2:
					break;
				case 3:
					break;
			}
		}
	}
}
