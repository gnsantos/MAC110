class Imagem
{
  int[][] pixels;
  int[][] auxiliar; // matriz auxiliar que sera usada para conservar os valores originais de cada pixel
  
  // Inicializa matriz de pixels da classe
  Imagem(int[][] matriz)
  {
    pixels = matriz;
    auxiliar = matriz;
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
    
    for(int k = -tamanho/2; k < tamanho/2; k++){
      for(int l = -tamanho/2; l < tamanho/2; l++){        
        soma += auxiliar[i+k][j+l];
      }     
    }
    int media = 1/(tamanho*tamanho) * soma;
    return media;
  }
  
  int mediana(int l, int c, int tamanho){ // calcula a mediana de uma vizinhanca para o metodo filtroMediana
    int a[][] = new int[tamanho][tamanho];    
    int[] aux = new int[a.length*a[0].length];
    int k= 0, l1= 0, c1 = 0;
    
    for(int i = l-tamanho/2; i <= l+tamanho/2; i++){
      for(int j = c - tamanho/2; j <= c+tamanho/2; j++){
        a[l1][c1] = auxiliar[i][j];        
        c1++;
      }
      c1 = 0;
      l1++;
    }      
    
    for(int i = 0; i < a.length; i++){
      for(int j = 0; j < a[0].length; j++){
        aux[k] = a[i][j];
        k++;
      }
    }
    k = 0;
    for(int i = 1; i < aux.length; i++){
      for(int j = 0; j < aux.length - i; j++){
        if( aux[j] > aux[j+1]){
          int x = aux[j];
          aux[j] = aux[j+1];
          aux[j+1] = x;
        }
      }      
    }
    for(int i = 0; i < a.length; i++){
      for(int j = 0; j < a[0].length; j++){
        a[i][j] = aux[k];
        k++;
      }
    }
    return a[a.length/2][a[0].length/2];
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
    // Para voce completar!
  }
  
}