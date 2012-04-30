class Utilidades{
   double fatorial(double numero){
    double x = numero;
    int contador = 1;
    if(numero == 0) return 1;
    while(contador < numero){
      x = x*contador;
      contador = contador + 1;
    }
    return x;
  }
  
  double potencia(double base, double expoente){
    double resultado = 1;
    double contador = 0;
    if(expoente == 0) return 1;
    else{
      while(contador != expoente){
        resultado = base*resultado;
        contador = contador + 1;
      }
      return resultado;
  }
  }
  
  void teste(){
    if(potencia(2,5) == 32) System.out.println("O metodo potencia funciona!");
    else System.out.println("O método potencia nao funciona!");
    
    if(fatorial(5) == 120) System.out.println("O metodo fatorial funciona!");
    else System.out.println("O método fatorial nao funciona!");
  }
}