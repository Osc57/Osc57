package geometria;

public class Circulo extends Figura{
private double radio;

public Circulo(double x, double y, String color, double radio){
super (x, y, color);
this.radio = radio;
}

public double getRadio(){
return radio;
}

public void setRadio(double radio){
this.radio = radio;
}

public double area(){
return Math.PI * Math.pow (radio, 2);
}

public double perimetro(){
return 2 * Math.PI * radio;
}

public double areaEsfera(){
return 4 * Math.PI * Math.pow (radio, 2);
}

public double volumenEsfera(){
return (4.0/3) * Math.PI * Math.pow (radio, 3);
}
}
