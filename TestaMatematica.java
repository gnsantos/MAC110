class TestaMatematica{
  
  Matematica m = new Matematica();
  
  void imprimeRelatorio(String nome, double desvioPadrao, double media){
    System.out.println("Teste com " + nome + "\nDesvio Padrao = " + desvioPadrao + "\nTempo Medio de Execucao = " + media+" milissegundos\n");
  }
  
  void testaSeno(){    
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
  
  void testaCosseno(){    
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
  
 
  void testaLogaritmo(){    
    double tempoInicio = 0;
    double tempoFim = 0;
    double soma = 0;
    double somaQuadrado = 0;
    double tempoExec = 0;
    
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
 
  void testaRaizQuadrada(){    
    double tempoInicio = 0;
    double tempoFim = 0;
    double tempoExec = 0;
    double soma = 0;
    double somaQuadrado = 0;
    
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
  
  
  
  void testaMatematica(){
    testaSeno();
   
    testaCosseno();
    
    testaLogaritmo();
    testaRaizQuadrada();
  }
  
  void comparaSeno(){
    double tempoInicio = 0;
    double tempoFim = 0;
    double tempoExec = 0;
    double somaFloat = 0;
    double diferencaDesempenho = 0;
    
    for(int exec = 1; exec <= 100; exec++){
      tempoInicio = System.nanoTime();
      m.senoRFloat(3.14f);
      tempoFim = System.nanoTime();
      tempoExec = (tempoFim - tempoInicio)/Math.pow(10.0,6.0);//Converte um tempo em nanossegundos para milissegundos
      somaFloat += tempoExec;      
    }
    
    double mediaExecFloat = somaFloat/100;
    
    double somaDouble = 0;
    for(int exec = 1; exec <= 100; exec++){
      tempoInicio = System.nanoTime();
      m.senoR(3.14);
      tempoFim = System.nanoTime();
      tempoExec = (tempoFim - tempoInicio)/Math.pow(10.0,6.0);//Converte um tempo em nanossegundos para milissegundos
      somaDouble += tempoExec;      
    }
    
    double mediaExecDouble = somaDouble/100;
    
    diferencaDesempenho = (1 -mediaExecFloat/mediaExecDouble)*100;
    System.out.println("O ganho de desmpenho percentual usando-se float para o calculo do seno foi de " +diferencaDesempenho +"%");   
    // possiveis problemas na definicao de ganho percentual;
  }
}
  
  
 
 