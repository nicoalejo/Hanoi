public class FactorialRecursivo {

    public long CalcularFactorialRecursivo(int n){

        if(n == 1){
            return 1;
        }
        else{
            return n * CalcularFactorialRecursivo(n-1);
        }
    }

    public long CalcularFactorialIterativo(int n){
        long resultado = 1;
        for (int i = n; i > 1; i--){
            resultado *= i;
        }
        return resultado;
    }
}
