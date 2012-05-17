class Matematica{
  
  double precisao = 1.0E-8; /* Variavel que controla quantidade de casas de decimal de erro*/
  
  void definePrecisao(double epsilon){/*Calcula o numero de casas decimais dos resultados que começarão a se distanciar do valor correto*/
    precisao =1.0E-epsilon;
  }

   double fatorial(double numero){/*Calcula Fatorial*/
    double x = numero;
    int contador = 1;
    if(numero == 0) return 1;
    while(contador < numero){
      x = x*contador;
      contador = contador + 1;
    }
    return x;
  }
  
  double potencia(double base, double expoente){ /*Calcula potencia*/
    double resultado = 1;
    double contador = 0;
      while(contador != expoente){
        resultado = base*resultado;
        contador = contador + 1;
      }
      return resultado;
  }
  
  
  double senoR(double x){/*Calcula seno*/
    double seno = x;
    double elemento = x;
    x=limitaNumero(x);
    
    for(int cont = 2; elemento*elemento > precisao*precisao; cont += 2){    
      elemento *= ((-1)*x*x)/(cont*(cont+1));
      seno += elemento;
    }
    
    return seno;
  }
  
  float senoRFloat(float x){/*Calcula Seno com variaveis float*/
    float seno = x;
    float elemento = x;
    
    for(int cont = 2; elemento*elemento > precisao*precisao; cont += 2){    
      elemento *= (-1)*x*x/(cont*(cont+1));
      seno += elemento;
    }
    
    return seno;
  }
  
  double cossenoR(double x){ /*Calcula Cosseno*/
    double cosseno = 1;
    double elemento = 1;
    x=limitaNumero(x);
    
    for(int cont = 2; elemento*elemento > precisao*precisao; cont+=2){      
      elemento *= (-1)*x*x/(cont*(cont-1));
      cosseno += elemento;
    }    
    return cosseno;
  }
  
  double ln(double umMaisX) /*calcula ln de UmMaisX-1*/
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
  
  double raizQuadrada(double umMaisX)/*calcula raiz quadrada de UmMaisX -1 */
  {

    double x = umMaisX - 1;
    double sqrt = 0;
    double elemento =1;
    for(int n = 0; elemento*elemento > precisao*precisao; n++){
      elemento = (potencia(x,n)*potencia((-1),n)*fatorial(2*n))/((1-2*n)*(potencia(fatorial(n),2))*(potencia(4,n)));
      sqrt +=elemento;
    }
      return sqrt;
  }
  
  double limitaNumero(double x){ /*limita o numero entre um valor de 2pi e -2pi, util para seno e cosseno*/
    double pi =3.14159265358979323846264338;
    while (x > 2*pi)
      x-=2*pi;
    while (x<-2*pi)
      x+=2*pi;
    return x;  
    
  }
  
}


  


      