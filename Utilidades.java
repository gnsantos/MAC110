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
}