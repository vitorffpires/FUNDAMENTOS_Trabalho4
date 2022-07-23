import java.util.Scanner;

/**
 * A classe MainApp vai rodar um Sudoku.
 * 
 * @author (vitor pires) 
 * @version (1.0)
 * @date (2021-06-17)
 */
public class MainApp
{   
    public static void MainApp()
    {
        Scanner teclado;
        int linha;
        int coluna;
        int numero;
        boolean controle; //garante que os numeros digitados sejam válidos.
        boolean[][] slots = new boolean[9][9];//numeros fixos.
        int[][] matriz = {{0,0,4,7,1,0,0,0,0},{0,7,2,8,0,6,5,0,0},{0,0,0,0,0,5,0,0,7},{0,1,0,6,9,0,2,0,0},
        {3,9,0,0,5,0,0,0,0},{0,0,0,0,0,0,0,8,5},{0,0,1,2,3,0,8,0,4},{0,0,3,5,0,4,0,0,2},{2,4,0,9,0,0,0,0,0}};
        
        teclado = new Scanner(System.in);
        
        slots = Auxiliar.numeroFixo(slots, matriz);        

        do {
            controle = true;
            System.out.println();
            
            for (int i = 0; i < matriz.length; i= i+1) {
                System.out.print("L" + (i) + " - ");
                for (int j = 0; j < matriz.length; j= j+1) {
                    System.out.print(matriz[i][j] + " ");
                    if (j == 2 || j == 5) 
                    System.out.print("| ");
                }
                System.out.println();
                if (i == 2 || i == 5)
                    System.out.print("     ------|-------|------\n");
            }
            
            do {
                System.out.print("Linha > ");
                linha = teclado.nextInt();
            
                System.out.print("Coluna > ");
                coluna = teclado.nextInt();
            
                System.out.print("Número > ");
                numero = teclado.nextInt();
                if(linha < 0 || linha > 8 || coluna < 0 || coluna > 8)
                    System.out.println("Espaço invalido, somente números de 0 a 8 são aceitos!");
                else if(numero < 1 || numero > 9)
                    System.out.println("Numero invalido, somente números de 1 a 9 são aceitos!");
                else
                    controle = false;
            } while (controle);
            if(slots[linha][coluna]) {
                System.out.println(" Essas posicões são fixas, você não pode alterá-las! ");
            } else {
                if (Auxiliar.verificarLinha(matriz, linha, coluna, numero)) {
                    if (Auxiliar.verificarColuna(matriz, linha, coluna, numero)) {
                        if (Auxiliar.verificarBox(matriz, linha, coluna, numero)) {
                            matriz[linha][coluna] = numero;
                            
                        }else{
                            System.out.println("Movimento invalido, ja existe esse numero no quadrado 3x3");
                        }
                    }else{
                        System.out.println("Movimento invalido, ja existe esse numero na coluna");
                    }
                } else {
                    System.out.println("movimento invalido, ja existe esse numero na linha");
                }
            }
            
            System.out.println("deseja parar o jogo? digite 0, para seguir digite outro numero");
            numero = teclado.nextInt();
                if(numero == 0 || Auxiliar.verificaTabuleiroCompleto(matriz)){
                    controle = false;
                }else{
                    controle = true;
                }
        }while(controle);
        System.out.println("Fim do jogo. Obrigado por jogar!");
    }
}
