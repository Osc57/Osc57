public class Calculadora{

    public Calculadora(int par, int par1) {
    }
    private int num1;
    private int num2;
    
    public int suma(){
        int resul = num1+num2;
        return resul;
    }

    public int multiplica(){
        int resul = num1 * num2;
        return resul;
    }

    public int resta(){
        int resul;
        if (resta21()){
            resul = num1-num2;
        }else{
            resul = num2-num1;
        }
        return resul;
    }

    public boolean resta21(){
        if(num1>=num2) {
            return true;
        }else{
            return false;
        }
        
    }

}