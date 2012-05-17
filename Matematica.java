/************************************************************/
/* MAC 110 - INTRODUCAO A CIENCIA DA COMPUTACAO             */
/* IME-USP - PRIMEIRO SEMESTRE DE 2012                      */
/* TURMA 45 - PROFESSOR MARCEL JACKWOSKI                    */
/* SEGUNDO EXERCICIO-PROGRAMA                               */
/* ARQUIVO: Matematica.java                                 */
/* GERVASIO PROTASIO DOS SANTOS NETO    NUMERO USP: 7990996 */
/* VICTOR SANCHES PORTELA               NUMERO USP:         */
/* DATA DE ENTREGA : 18/05/2012                             */
/************************************************************/

class Matematica{
  
  double precisao = 1.0E-8; /* Variavel que controla quantidade de casas de decimal de erro*/
  
  void definePrecisao(double epsilon){
    precisao = epsilon;
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
    x =limitaNumero(x); //Permite o calculo da funcao para valores altos
    double seno = x;
    double elemento = x;    
    
    for(int cont = 2; elemento*elemento > precisao*precisao; cont += 2){    
      elemento *= ((-1)*x*x)/(cont*(cont+1));
      seno += elemento;
    }
    
    return seno;
  }
  
  float senoRFloat(float x){/*Calcula Seno com variaveis float*/
    x = limitaNumeroFloat(x); //Permite o calculo da funcao para valores altos
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
    x=limitaNumero(x); //Permite o calculo da funcao para valores baixos
    
    for(int cont = 2; elemento*elemento > precisao*precisao; cont+=2){      
      elemento *= (-1)*x*x/(cont*(cont-1));
      cosseno += elemento;
    }    
    return cosseno;
  }
  
  double ln(double umMaisX) /*calcula ln de UmMaisX*/
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
  
  double raizQuadrada(double umMaisX)/*calcula raiz quadrada de UmMaisX*/
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
  
  float limitaNumeroFloat(float x){ /*limita o numero entre um valor de 2pi e -2pi, criada para o metodo que usa seno como float*/
    float pi = 3.14159265358979323846264338f;
    while (x > 2*pi)
      x-=2*pi;
    while (x<-2*pi)
      x+=2*pi;
    return x;  
    
  }
  
  
}     