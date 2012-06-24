/************************************************************/
/* MAC 110 - INTRODUCAO A CIENCIA DA COMPUTACAO             */
/* IME-USP - PRIMEIRO SEMESTRE DE 2012                      */
/* TURMA 45 - PROFESSOR MARCEL JACKWOSKI                    */
/* SEGUNDO EXERCICIO-PROGRAMA                               */
/* ARQUIVO: Matematica.java                                 */
/* GERVASIO PROTASIO DOS SANTOS NETO    NUMERO USP: 7990996 */
/* VICTOR SANCHES PORTELA               NUMERO USP: 7991152 */
/* DATA DE ENTREGA : 18/05/2012                             */
/************************************************************/

import java.util.*;

class EP3{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int opcao=0;
    String nome = "";
    Imagem minhaImagem=null;
    while (opcao!=7){//Enquanto o usuário não escolehr sair, o menu semrpe será re-escrito a cada ação, inclusive no inicio do programa.
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
      if (opcao==1){//Ler imagem
        System.out.println("Digite o nome; da imagem do formato .pgm sem extenção");
        sc = new Scanner(System.in);
        nome = sc.nextLine() +".pgm";
        minhaImagem = LeituraEscritaImagem.leImagem(nome);//Tenta ler imagem
        if (minhaImagem == null){
          nome = "";
          System.out.println("Imagem não existente ou problema ao tentar ler imagem");
        }else
          System.out.println(nome+" carregado com sucesso");
      }
      else if (opcao==2){
        VisualizadorImagem vis = new VisualizadorImagem();//Visualizador
        if (minhaImagem == null)//Caso não tneha imagem carregada, é cancelada a ação
          System.out.println("Carregue uma imagem primeiro");
        else
          vis.mostraImagem(minhaImagem,nome);

      }
      else if (opcao==3){ // suaviza imagem com filtro medio
        if (minhaImagem == null)
          System.out.println("Carregue uma imagem primeiro!");
        else{
          System.out.println("Entre um tamanho para a vizinhanca: ");
          int tamanho = sc.nextInt();
          minhaImagem.filtroMedio(tamanho);
          System.out.println("Imagem suavizada com sucesso!");
          VisualizadorImagem vis = new VisualizadorImagem();//Visualizador
          vis.mostraImagem(minhaImagem,nome); //Abre imagem apos a suavizacao para que o usuario a visualize;
        }
      }
      else if (opcao==4){ //suaviza imagem com filtro mediano
        if (minhaImagem == null)
          System.out.println("Carregue uma imagem primeiro!");
        else{
          System.out.println("Entre um tamanho para a vizinhanca: ");
          int tamanho = sc.nextInt();
          minhaImagem.filtroMediano(tamanho);
          System.out.println("Imagem suavizada com sucesso!");
          VisualizadorImagem vis = new VisualizadorImagem();//Visualizador
          vis.mostraImagem(minhaImagem,nome); //Abre imagem apos a suavizacao para que o usuario a visualize;
        }
      }
      else if (opcao==5){ //suaviza imagem com filtro gaussiano
        if (minhaImagem == null)
          System.out.println("Carregue uma imagem primeiro!");
        else{
          System.out.println("Entre um tamanho para a vizinhanca: ");
          int tamanho = sc.nextInt();
          System.out.println("Entre um sigma (desvio padrao) para a vizinhanca: ");
          int sigma = sc.nextInt();
          minhaImagem.filtroGaussiano(tamanho, sigma);
          System.out.println("Imagem suavizada com sucesso!");
          VisualizadorImagem vis = new VisualizadorImagem();//Visualizador
          vis.mostraImagem(minhaImagem,nome); //Abre imagem apos a suavizacao para que o usuario a visualize;
        }
      }
      else if (opcao==6){ // grava a imagem
        if (minhaImagem == null)//Cancela ação caso não haja imagem carregada.
          System.out.println("Carregue uma imagem primeiro!");
        else{
          String nomeNovo;
          while(true){//Laço que pede o nome do novo arquivo, e caso exista um arquivo com o mesmo nome, o usuário é avisado e é dada 
            //a opção do usuário cancelar ou redigitar o nome do arquivo.
            System.out.println("Digite o nome da copia que você deseja salvar sem extenção. Caso deseje cancelar esta ação, aperte somente enter");
            sc = new Scanner(System.in);
            nomeNovo = sc.nextLine();
            if (nomeNovo.equals(""))
              break;
            Imagem imagemTemp = LeituraEscritaImagem.leImagem(nomeNovo+ ".pgm");//Tenta carregar a imagem, caso retorne nulo, a imagem nao existe.
            if (imagemTemp == null)
              break;
            else{
              System.out.println("Ja existe um arquivo com este nome. Caso deseje sobre escreve-lo, digitite 's', caso contrario aperte enter");
              sc = new Scanner(System.in);
              String opcao2 = sc.nextLine();
              if (opcao2.equals("s") || opcao2.equals("S"))
                break;
              else
                System.out.println("Ação cancelada.O arquivo ainda não foi salvo");
            }
          }
          if (!nomeNovo.equals("")){//Caso o usuário tenha apertado enter, a imagem não é gravada.
            nomeNovo = nomeNovo + ".pgm";
            LeituraEscritaImagem.escreveImagem(nomeNovo, minhaImagem);
            System.out.println("Imagem gravada com sucesso! Imagem salva como:"+nomeNovo);
          }
        }
      }
    }
  }
}