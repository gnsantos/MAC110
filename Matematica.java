class Matematica{
  
  double precisao = 1.0E-8;
  
  void definePrecisao(double epsilon){
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
      while(contador != expoente){
        resultado = base*resultado;
        contador = contador + 1;
      }
      return resultado;
  }
  
  double cos(double x){
    double cos = 0;
    double elemento = 0;
    double k = 0;
       
    do{
    elemento = ((potencia(-1,k) * potencia(x,2*k)) / fatorial(2*k));
    cos = cos + elemento;
    k = k +1;
    } while(elemento*elemento > precisao*precisao);   
      
    return cos;
  }
  
  double seno(double x){
    double seno = 0;
    double elemento = 0;
    double k = 0;
    
    do{
      elemento = potencia(x,2*k+1) * potencia(-1, k) / fatorial(2*k+1);
      seno = seno + elemento;
      k = k + 1;     
    } while(elemento*elemento > precisao*precisao);
    return seno;
  }
  
  double senoR(double x){
    double seno = x;
    double elemento = x;
    
    for(int cont = 2; elemento*elemento > precisao*precisao; cont += 2){    
      elemento *= ((-1)*x*x)/(cont*(cont+1));
      seno += elemento;
    }
    
    return seno;
  }
  
  float senoRFloat(float x){
    float seno = x;
    float elemento = x;
    
    for(int cont = 2; elemento*elemento > precisao*precisao; cont += 2){    
      elemento *= (-1)*x*x/(cont*(cont+1));
      seno += elemento;
    }
    
    return seno;
  }
  
  double cossenoR(double x){
    double cosseno = 1;
    double elemento = 1;
    
    for(int cont = 2; elemento*elemento > precisao*precisao; cont+=2){      
      elemento *= (-1)*x*x/(cont*(cont-1));
      cosseno += elemento;
    }    
    return cosseno;
  }
  
  double ln(double umMaisX)
  {
    double x = umMaisX - 1;
    double ln = x;
    double elemento = x;
    
    for(int cont = 2; elemento*elemento > precisao*precisao; cont++){      
      elemento *= (-1)*x;
      ln += elemento/cont;
    }    
    return ln;    
  }
  
  double raizQuadrada(double umMaisX)
  {
    double x = umMaisX - 1;
    double sqrt = 1;
    double elemento = 1;
    double numerador=-1;
    double denominador = 1;
    
   /* for(int n = 0; elemento*elemento > precisao*precisao; n++){
      elemento = (potencia(x,n)*potencia((-1),n)*fatorial(2*n))/((1-2*n)*(potencia(fatorial(n),2))*(potencia(4,n)));
      sqrt +=elemento;
    }*/
    for(int n = 1; elemento*elemento > precisao*precisao; n++){
      numerador = numerador*(2*(n-1)+2)*(2*(n-1)+1);
      denominador = (denominador + 2*denominador/(1-(2*(n-1))))*(n)*(n)*4;
      elemento=(numerador/denominador)*(-x);  
      sqrt += elemento;
    }
      return sqrt;
  }
    
}


  


      