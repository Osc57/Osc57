public class Ej3 {
    public static void main(String[] args) {
        int fibo1 =1;
        int fibo2=1;


        for(int i=2;i<=20;i++){
            System.out.print(fibo2 + " ");
            fibo2 = fibo1 + fibo2;
            fibo1 = fibo2 - fibo1;
        }
        System.out.println();
    }
}
