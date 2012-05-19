/************************************************************/
/* MAC 110 - INTRODUCAO A CIENCIA DA COMPUTACAO             */
/* IME-USP - PRIMEIRO SEMESTRE DE 2012                      */
/* TURMA 45 - PROFESSOR MARCEL JACKWOSKI                    */
/* SEGUNDO EXERCICIO-PROGRAMA                               */
/* ARQUIVO: TestaMatematica.java                            */
/* GERVASIO PROTASIO DOS SANTOS NETO    NUMERO USP: 7990996 */
/* VICTOR SANCHES PORTELA               NUMERO USP: 7991152 */
/* DATA DE ENTREGA : 18/05/2012                             */
/************************************************************/

class TestaMatematica{
  
  Matematica m = new Matematica();
  
  void imprimeRelatorio(String nome, double desvioPadrao, double media){ //Facilita a impressao do relatorio de desempenho
    System.out.println("Teste com " + nome + "\nDesvio Padrao = " + desvioPadrao + "\nTempo Medio de Execucao = " + media+" milissegundos\n");
  }
  
  void testaSeno(){    //Testa o desempenho da funcao para calculo do seno
    double tempoInicio = 0;
    double tempoFim = 0;
    double soma = 0;
    double somaQuadrado = 0;
    double tempoExec = 0;
    
    for(int exec = 1; exec <= 100; exec++){
      tempoInicio = System.nanoTime(); //tempo em nanossegundo
      m.senoR(3.14159);
      tempoFim = System.nanoTime();//tempo em nanosegundos
      tempoExec = (tempoFim - tempoInicio)/Math.pow(10.0,6.0);//Converte um tempo em nanossegundos para milissegundos      
      soma += tempoExec;
      somaQuadrado += tempoExec*tempoExec;
    }
    
    double mediaExec = soma/100;
    double variancia = somaQuadrado/100 - mediaExec*mediaExec;
    double desvioPadrao =  Math.sqrt(variancia);
    
    imprimeRelatorio("seno", desvioPadrao, mediaExec);
  }
  
  void testaCosseno(){    //Testa o desmpenho da funca para calulo do cosseno 
    double tempoInicio = 0;
    double tempoFim = 0;
    double soma = 0;
    double somaQuadrado = 0;
    double tempoExec = 0;
    
    for(int exec = 1; exec <= 100; exec++){
      tempoInicio = System.nanoTime();
      m.cossenoR(3.14159);
      tempoFim = System.nanoTime();
      tempoExec = (tempoFim - tempoInicio)/Math.pow(10.0,6.0);//Converte um tempo em nanossegundos para milissegundos
      soma += tempoExec;
      somaQuadrado += tempoExec*tempoExec;
    }
    
    double mediaExec = soma/100;
    double variancia = somaQuadrado/100 - mediaExec*mediaExec;
    double desvioPadrao =  Math.sqrt(variancia);
    
    imprimeRelatorio("cosseno", desvioPadrao, mediaExec);
  }
  
 
  void testaLogaritmo(){    //Testa o desmpenho da funca para calulo do logaritmo natural
    double tempoInicio = 0;
    double tempoFim = 0;
    double soma = 0;
    double somaQuadrado = 0;
    double tempoExec = 0;
    
    try{
      for(int exec = 1; exec <= 100; exec++){
        tempoInicio = System.nanoTime();
        m.ln(1.5);
        tempoFim = System.nanoTime();
        tempoExec = (tempoFim - tempoInicio)/Math.pow(10.0,6.0);//Converte um tempo em nanossegundos para milissegundos
        soma += tempoExec;
        somaQuadrado += tempoExec*tempoExec;
      }
      
      double mediaExec = soma/100;
      double variancia = somaQuadrado/100 - mediaExec*mediaExec;
      double desvioPadrao =  Math.sqrt(variancia);
      
      imprimeRelatorio("logaritmo natural", desvioPadrao, mediaExec);
    }
    catch(Exception e){
      System.out.println(e.getMessage());
    }
  }
 
  void testaRaizQuadrada(){    //Testa o desmpenho da funca para calulo da raiz quadrada
    double tempoInicio = 0;
    double tempoFim = 0;
    double tempoExec = 0;
    double soma = 0;
    double somaQuadrado = 0;
    try{
      for(int exec = 1; exec <= 100; exec++){
        tempoInicio = System.nanoTime();
        m.raizQuadrada(1.5);
        tempoFim = System.nanoTime();
        tempoExec = (tempoFim - tempoInicio)/Math.pow(10.0,6.0);//Converte um tempo em nanossegundos para milissegundos
        soma += tempoExec;
        somaQuadrado += tempoExec*tempoExec;
      }
      
      double mediaExec = soma/100;
      double variancia = somaQuadrado/100 - mediaExec*mediaExec;
      double desvioPadrao =  Math.sqrt(variancia);
      
      imprimeRelatorio("raiz quadrada", desvioPadrao, mediaExec);
    }
    catch(Exception e){
      System.out.println(e.getMessage());
    }
  }
  
  
  
  void testaMatematica(){ //Executa de forma conjunta os metodos para a avalicao de metodos individuais da classe Matematica.
                          //Isso permite uma avaliacao global da classe
    testaSeno();   
    testaCosseno();    
    testaLogaritmo();
    testaRaizQuadrada();
  }
  
  void comparaSeno(){ //Compara do desempenho dos metodos que calculam o seno de um valor. Um dos metodos utiliza valores float, outros valores double.
    double tempoInicio = 0;
    double tempoFim = 0;
    double tempoExec = 0;
    double somaFloat = 0;
    double diferencaDesempenho = 0;
    
    for(int exec = 1; exec <= 100; exec++){ //Permitira avaliacao do desmpenho do metodo que calcula o  seno e utiliza valores float
      tempoInicio = System.nanoTime();
      m.senoRFloat(3.14f);
      tempoFim = System.nanoTime();
      tempoExec = (tempoFim - tempoInicio)/Math.pow(10.0,6.0);//Converte um tempo em nanossegundos para milissegundos
      somaFloat += tempoExec;      
    }
    
    double mediaExecFloat = somaFloat/100;
    
    double somaDouble = 0;
    for(int exec = 1; exec <= 100; exec++){ //Permite a avaliacao do desempenho do metodo que calcula o seno e utiliza valores double
      tempoInicio = System.nanoTime();
      m.senoR(3.14);
      tempoFim = System.nanoTime();
      tempoExec = (tempoFim - tempoInicio)/Math.pow(10.0,6.0);//Converte um tempo em nanossegundos para milissegundos
      somaDouble += tempoExec;      
    }
    
    double mediaExecDouble = somaDouble/100;
    
    diferencaDesempenho = (1 -mediaExecFloat/mediaExecDouble)*100; //O ganho de desmpenho e calculado com base na razao entres os tempos de execucao
    //Subtrai-se a razao de 1 para calcular o ganho em si. A multiplicacao por 100 ocorre para trabalhar-se com porcentagens.
    System.out.println("O ganho de desmpenho percentual usando-se float para o calculo do seno foi de " +diferencaDesempenho +"%");
    if(diferencaDesempenho < 0)
      System.out.println("O tempo negativo indica que o metodo que utiliza valores float teve maior tempo medio de execucao");
    
  }
}
  
  
 
 