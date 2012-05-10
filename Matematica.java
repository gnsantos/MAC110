class Matematica{
  
  double precisao = 1.0e - 8;
  
  double deifnePrecisao(double epsilon){
    precisao = epsilon;
  }

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
  
  double cos(double x){
    double cos = 0;
    double elemento = 0;
    double k = 0;
       
    while(k*k != precisao*precisao){
    elemento = ((potencia(-1,k) * potencia(x,2*k)) / fatorial(2*k));
    cos = cos + elemento;
    k = k +1;
    }   
      
    return cos;
  }
  
  double seno(double x){
    double seno = 0;
    double elemento = 0;
    double k = 0;
    
    while(k*k != precisao*precisao){
      elemento = potencia(x,2*k+1) * potencia(-1, k) / fatorial(2*k+1);
      seno = seno + elemento;
      k = k + 1;     
    }
    return seno;
  }
  
  double senoR(double x){
    double seno = 0;
    double elemento = 1;
    
    for(int cont = 1; cont*cont > precisao*precisao; cont += 2){
      if(cont == 1)
        elemento = x;
      else
        elemento *= (-1)*x*x/(cont*(cont-1));
      seno += elemento;
    }
    
    return seno;
  }
  
  double cossenoR(double x){
    double cosseno = 1;
    double elemento = x;
    
    for(int cont = 2; cont*cont > precisao*precisao; cont++){      
      elemento *= (-1)*x/cont;
      cosseno += elemento;
    }    
    return cosseno;
  }
}
  

  


      