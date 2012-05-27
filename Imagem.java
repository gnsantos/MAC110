class Imagem
{
  int[][] pixels;
  
  // Inicializa matriz de pixels da classe
  Imagem(int[][] matriz)
  {
    pixels = matriz;
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
  
  int media(int i, int j, int tamanho){    
    int soma;
    int[][] auxiliar = pixels;    
    
    for(int k = -tamanho/2; k < tamanho/2; k++){
      for(int l = -tamanho/2; l < tamanho/2; l++){        
        soma += auxiliar[i+k][j+l];
      }     
    }
    int media = 1/(tamanho*tamanho) * soma;
    return media;
  }
    
  // Suaviza imagem com filtro mediano
  void filtroMediano(int tamanho)
  {
    // Para voce completar!
  }
  
  // Suaviza imagem com filtro gaussiano
  void filtroGaussiano(double sigma, int tamanho)
  {
    // Para voce completar!
  }
  
}