class TestaMatematica{
  
  Matematica m = new Matematica();
  
  void imprimeRelatorio(String nome, double desvioPadrao, double media){
    System.out.println("Teste com " + nome + "\nDesvio Padrão = " + desvioPadrao + "\nTempo Médio de Execução = " + media);
  }
  
  void testaSeno(){    
    double tempoInicio = 0;
    double tempoFim = 0;
    double soma = 0;
    double somaQuadrado = 0;
    
    for(int exec = 1; exec != 100; exec++){
      tempoInicio = System.nanoTime();
      m.senoR(3.14159);
      tempoFim = System.nanoTime();
      tempoExec = tempoInicio - tempoFim;
      soma += tempoExec;
      somaQuadrado += tempoExec*tempoExec;
    }
    
    double mediaExec = soma/100;
    double variancia = somaQuadrado/100 - mediaExec*mediaExec;
    double desvioPadrao =  math.sqrt(variancia);
    
    imprimeRelatorio("seno", desvioPadrao, mediaExec);
  }
  
  void testaCosseno(){    
    double tempoInicio = 0;
    double tempoFim = 0;
    double soma = 0;
    double somaQuadrado = 0;
    
    for(int exec = 1; exec != 100; exec++){
      tempoInicio = System.nanoTime();
      m.cossenoR(3.14159);
      tempoFim = System.nanoTime();
      tempoExec = tempoInicio - tempoFim;
      soma += tempoExec;
      somaQuadrado += tempoExec*tempoExec;
    }
    
    double mediaExec = soma/100;
    double variancia = somaQuadrado/100 - mediaExec*mediaExec;
    double desvioPadrao =  math.sqrt(variancia);
    
    imprimeRelatorio("cosseno", desvioPadrao, mediaExec);
  }
 
  void testaLogaritmo(){    
    double tempoInicio = 0;
    double tempoFim = 0;
    double soma = 0;
    double somaQuadrado = 0;
    
    for(int exec = 1; exec != 100; exec++){
      tempoInicio = System.nanoTime();
      m.ln(1.5);
      tempoFim = System.nanoTime();
      tempoExec = tempoInicio - tempoFim;
      soma += tempoExec;
      somaQuadrado += tempoExec*tempoExec;
    }
    
    double mediaExec = soma/100;
    double variancia = somaQuadrado/100 - mediaExec*mediaExec;
    double desvioPadrao =  math.sqrt(variancia);
    
    imprimeRelatorio("logarítmo natural", desvioPadrao, mediaExec);
  }
 
  void testaRaizQuadrada(){    
    double tempoInicio = 0;
    double tempoFim = 0;
    double soma = 0;
    double somaQuadrado = 0;
    
    for(int exec = 1; exec != 100; exec++){
      tempoInicio = System.nanoTime();
      m.raizQuadrada(1.5);
      tempoFim = System.nanoTime();
      tempoExec = tempoInicio - tempoFim;
      soma += tempoExec;
      somaQuadrado += tempoExec*tempoExec;
    }
    
    double mediaExec = soma/100;
    double variancia = somaQuadrado/100 - mediaExec*mediaExec;
    double desvioPadrao =  math.sqrt(variancia);
    
    imprimeRelatorio("raiz quadrada", desvioPadrao, mediaExec);
  }
  
  void testaMatematica(){
    testaSeno();
    testaCosseno();
    testaLogaritmo();
    testaRaizQuadrada();
  }
}
  
  
 
 