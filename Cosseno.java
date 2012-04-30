class Cosseno{
  
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
  
  double cos(double x, double precisao){
    double cos = 0;
    double elemento = 0;
    double k = 0;
       
    while(k != precisao){
    elemento = ((potencia(-1,k) * potencia(x,2*k)) / fatorial(2*k));
    cos = cos + elemento;
    k = k +1;
    }   
      
    return cos;
  }
}