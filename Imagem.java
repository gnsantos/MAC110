class Imagem
{
  int[][] pixels;
  int[][] auxiliar; // matriz auxiliar que sera usada para conservar os valores originais de cada pixel
  
  // Inicializa matriz de pixels da classe
  Imagem(int[][] matriz)
  {
    pixels = matriz;
    auxiliar=new int[altura()][largura()];
    for(int i=0; i<altura();i++)
      for(int j =0;j<largura();j++)
          auxiliar[i][j]=pixels[i][j];
  }
  
  // Devolve largura em pixels da imagem
  int largura()
  {
    if (pixels != null)
      return pixels[0].length;
    else
      return 0;
  }
  
  // Devolve altura em pixels da imagem
  int altura()
  {
    if (pixels != null)
      return pixels.length;
    else
      return 0;
  }
  
  // Suaviza imagem com filtro medio
  void filtroMedio(int tamanho)
  {
    for(int i = 0; i < altura(); i++){
      for(int j = 0; j < largura(); j++){
        pixels[i][j] = media(i,j,tamanho);
      } 
    }
  }
  
  int media(int i, int j, int tamanho){ // calcula a dupla somatoria que determina o novo valor de um pixle no filtro medio    
    int soma = 0;       
    int n = 0;
    for(int k = -tamanho/2; k <= tamanho/2; k++){
      for(int l = -tamanho/2; l <= tamanho/2; l++){
        if (i+k<auxiliar.length && j+l<auxiliar[0].length && i+k>=0 && j+l>=0){
          soma += auxiliar[i+k][j+l];
          n++;
        }
      }     
    }
    int media = soma/n;
    return media;
  }
  
  int mediaQuadrada(int i,int j,int tamanho){
    int soma = 0;       
    
    for(int k = -tamanho/2; k <= tamanho/2; k++){
      for(int l = -tamanho/2; l <= tamanho/2; l++){        
        soma += auxiliar[i+k][j+l]*auxiliar[i+k][j+l];
      }     
    }
    int media = soma/(tamanho*tamanho);
    return media;
  }
  
  int mediana(int l, int c, int tamanho){ // calcula a mediana de uma vizinhanca para o metodo filtroMediana    
    int[] aux = new int[tamanho*tamanho];// Vetor que será usado para ordenação
    int k= 0;
    
    for(int i =-tamanho/2; i <= tamanho/2; i++){//passa os valores originais da izinhança para um vetor
      for(int j = -tamanho/2; j <= tamanho/2; j++){
        if (l+i<auxiliar.length && j+c<auxiliar[0].length && l+i>0 && j+c>0){
          aux[k] = auxiliar[l+i][c+j];        
          k++;
        }
      }
    }      
    k = 0;
    for(int i = 0; i < aux.length-1; i++){ // ordena o vetor
      for(int j = i+1; j < aux.length; j++){
        if( aux[i] > aux[j]){
          int x = aux[i];
          aux[i] = aux[j];
          aux[j] = x;
        }
      }      
    }
    return aux[(int)(aux.length/2+0.5)];//retorna o valor do meio do vetor (arredondando para cima)
  }
    
  // Suaviza imagem com filtro mediano
  void filtroMediano(int tamanho)
  {
    for(int i = 0; i < altura(); i++){
      for(int j = 0; j < largura(); j++){
        pixels[i][j] = mediana(i, j, tamanho);
      }
    }
  }
  
  // Suaviza imagem com filtro gaussiano
  void filtroGaussiano(double sigma, int tamanho)
  {
     for(int i = 0; i < altura(); i++){
      for(int j = 0; j < largura(); j++){
        pixels[i][j] = somatoriaGaussiana(i,j, tamanho, sigma);
      }
     }
    
  }
  
  int somatoriaGaussiana(int l, int c, int tamanho, double sigma){    
    double soma = 0, normal = 0;//normal serve para normalizar a função gaussiana
    for(int i = -tamanho/2; i <= tamanho/2; i++){
      for(int j =  - tamanho/2; j <= tamanho/2; j++){
        if (l+i<auxiliar.length && j+c<auxiliar[0].length && l+i>0 && j+c>0){
          normal +=(funcaoGaussiana(i, j, sigma));
          soma +=(funcaoGaussiana(i, j, sigma)*auxiliar[i+l][j+c]);
        }
      }
    }
    return (int)(soma/normal+0.5);
  }
  
  double funcaoGaussiana(int x, int y, double sigma){
    double g;    
    double euler = 2.718281828;//4590452353602874713526624977572470936999595;
    double pi = 3.141592653;//5897932384626433832795028841971693993751058;
    g = ((1/(2*pi*sigma*sigma) * Math.pow(euler, ((-x*x - y*y)/(2*sigma*sigma)))));
    return g;
  }
  
}