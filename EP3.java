import java.util.*;

class EP3{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int opcao=0;
    String nome = "";
    Imagem minhaImagem=null;
    while (opcao!=7){
      System.out.println("Menu");
      System.out.println("==");
      System.out.println("1)Ler imagem");
      System.out.println("2)Visualizar imagem");
      System.out.println("3)Suavizar com filtro médio");
      System.out.println("4)Suavizar com filtro médiano");
      System.out.println("5)Suavizar com filtro gaussiano");
      System.out.println("6)Gravar imagem");
      System.out.println("7)Sair");
      opcao = sc.nextInt();
      if (opcao==1){
        System.out.println("Digite o nome; da imagem do formato .pgm sem extenção");
        sc = new Scanner(System.in);
        nome = sc.nextLine() +".pgm";
        minhaImagem = LeituraEscritaImagem.leImagem(nome);//Tenta ler imagem
        if (minhaImagem == null){
          nome = "";
          System.out.println("Imagem não existente ou problema ao tnetar ler imagem");
        }else
          System.out.println(nome+" carregado com sucesso");
      }
      else if (opcao==2){
        VisualizadorImagem vis = new VisualizadorImagem();//Visualizador
        if (minhaImagem == null)
          System.out.println("Carregue uma imagem primeiro");
        else
          vis.mostraImagem(minhaImagem,nome);

      }
      else if (opcao==3){
        //Suaviza com filtro medio
      }
      else if (opcao==4){
        //suaviza com filtro mediano
      }
      else if (opcao==5){
        //suaviza com filtro gaussiano
      }
      else if (opcao==6){
        //grava Imagem
      }
    }
  }
}