class Seno{
  double fatorial(double numero){
    double x = numero;
    int contador = 1;
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
  
  double seno(double x, double precisao){
    double seno = 0;
    double elemento = 0;
    double k = 0;
    
    while(k != precisao){
      elemento = potencia(x,2*k+1) * potencia(-1, k) / fatorial(2*k+1);
      seno = seno + elemento;
      k = k + 1;     
    }
    return seno;
  }
}
  