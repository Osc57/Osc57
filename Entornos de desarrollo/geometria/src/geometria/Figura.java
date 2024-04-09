package geometria;

public abstract class Figura {
private Punto centro;
private String color;

public Figura(double x, double y, String color){
centro = new Punto (x, y);
this.color = color;
}

public double getXCentro(){
return centro.getX();
}

public double getYCentro(){
return centro.getY();
}

public String getColor(){
return color;
}

public void setXCentro(double x){
centro.setX (x);
}

public void setYCentro(double y){
centro.setY (y);
}

public void setColor(String color){
this.color = color;
}

public abstract double perimetro();

public abstract double area();

}
