import entes.java.Personaje;
import java.util.Scanner;
import java.util.Random;

public class Main{
	public static void main(String[] args){
		Scanner lector = new Scanner(System.in);

		Personaje nyx = new Personaje("Nyx");
		Personaje enemigo = new Personaje("Orco");

		pelear(nyx, enemigo);

	}

	public static void pelear(Personaje a, Personaje b){
		Scanner lector = new Scanner(System.in);
		Random rnd = new Random();
		int temp = 0;
		boolean flag_a= true;
		boolean flag_b=true;
		float fuerza_a = 0;
		float fuerza_b = 0;
		float defensa_a = 0;
		float defensa_b = 0;
		int i= 0;
		int j = 0;

		while((a.getVida() > 0) && (b.getVida() > 0)){
			i++;
			fuerza_a = a.getFuerza()*10.0f;
			fuerza_b = b.getFuerza()*10.0f;
			defensa_a = a.getDefensa()*5.0f;
			defensa_b = b.getDefensa()*5.0f;
			System.out.printf("Estas frente a un %s de %d HP, que vas a hacer?\n",b.getName(),b.getVida());
			System.out.printf("Tenes %d HP\n", a.getVida());
			System.out.println("[1] Ataque normal\n[2] Ataque fuerte\n[3]Defenderse");
			temp = lector.nextInt();
			switch (temp){
				case 1:
					flag_a =true;
					if((rnd.nextInt(20)%b.getDex()==0)&&flag_a){
						b.changeVida(b.getVida() -(int)fuerza_a +(int)defensa_b);
					}
					switch (rnd.nextInt(2)){
						case 0:
							flag_b= true;
							break;
						case 1:
							b.ataqueFuerte();
							flag_b = false;
							break;
						case 2:
							b.defenderse();
							flag_b = false;
							break;
					}
					if ((rnd.nextInt(20)%a.getDex()==0)&&flag_b){
						a.changeVida(a.getVida() - (int)fuerza_b + (int)defensa_a);
					}
					break;
				case 2:
					flag_a =false;
					a.ataqueFuerte();
					switch (rnd.nextInt(2)){
						case 0:
							flag_b = true;
							break;
						case 1:
							b.ataqueFuerte();
							flag_b = false;
							break;
						case 2:
							b.defenderse();
							flag_b = false;
							break;
					}
					if ((rnd.nextInt(20)%a.getDex()==0)&&flag_b){
						a.changeVida(a.getVida() - (int)fuerza_b + (int)defensa_a);
					}
					break;
				case 3:
					flag_a =false;
					a.defenderse();
					switch (rnd.nextInt(2)){
						case 0:
							flag_b = true;
							break;
						case 1:
							b.ataqueFuerte();
							flag_b = false;
							break;
						case 2:
							b.defenderse();
							flag_b = false;
							break;
					}
					if ((rnd.nextInt(20)%a.getDex()==0)&&flag_b){
						a.changeVida(a.getVida() - (int)fuerza_b + (int)defensa_a);
					}
					break;
			}

		if(i==1){
			i=0;
			a.changeFuerza(a.getFuerza()/10.0f);
		}
		if(j==1){
			j=0;
			b.changeFuerza(b.getFuerza()/10.0f);
		}

		if(flag_a==false){
			i++;
		}
		if(flag_b==false){
			j++;
		}
		}
		if(a.getVida()>0){
			a.changeDinero(a.getDinero()+b.getDinero());
			b.changeDinero(b.getDinero()-b.getDinero());
			a.changeExp(a.getExp()+15);
			System.out.printf("Exp: +%dXp\n",a.getExp());
			System.out.printf("Dinero: +%dG\n", a.getDinero());
		}else{
			b.changeDinero(b.getDinero()+a.getDinero());
			a.changeDinero(a.getDinero()-a.getDinero());
			System.out.println("Moriste");
		}
	}
}
