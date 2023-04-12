package entes.java;

public class Personaje {
    String name;
    int nivel;
    int vida;
    int dinero;
    int exp;
    float fuerza;
    float defensa;
    int dex;


    public Personaje(String name){
        this.name = name;
	this.nivel = 1;
	this.vida = 100;
	this.dinero = 100;
	this.exp = 0;
	this.fuerza = 1.0f;
	this.defensa = 1.0f;
	this.dex = 5;
    }

    public String getName(){
    	return this.name;
    }
    
    public int getNivel(){
    	return this.nivel;
    }

    public int getVida(){
	return this.vida;
    }

    public int getDinero(){
    	return this.dinero;
    }

    public int getExp(){
    	return this.exp;
    }

    public float getFuerza(){
	return this.fuerza;
    }

    public float getDefensa(){
	return this.defensa;
    }

    public int getDex(){
	return this.dex;
    }

    public void changeNivel(int nivel){
	this.nivel = nivel;
    }

    public void changeVida(int vida){
	this.vida = vida;
    }

    public void changeDinero(int dinero){
	this.dinero = dinero;
    }
	
    public void changeExp(int exp){
	this.exp = exp;
    }

    public void changeFuerza(float fuerza){
	this.fuerza = fuerza;
    }

    public void changeDefensa(float defensa){
	this.defensa = defensa;
    }

    public void changeDex(int dex){
	this.dex = dex;
    }

    public void ataqueFuerte(){
	this.fuerza = this.fuerza*2.0f;
    }

    public void defenderse(){
	this.defensa = this.defensa*2.0f;
    }

}
