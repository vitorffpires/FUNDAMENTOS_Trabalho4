
/**
 * A classe Auxiliar contém os subprogramas utilizados pela classe MainApp.
 * 
 * @author (vitor pires) 
 * @version (1.0)
 * @date (2021-06-17)
 */
public class Auxiliar
{
    /**
     * O método verificarLinha garante que não tem numeros repetidos na mesma linha
     * @param matriz
     * @param linha
     * @param coluna
     * @param numero
     * @return boolean
     */
    public static boolean verificarLinha(int[][] matriz, int linha, int coluna, int numero) {
        for (int i = 0; i < matriz[0].length; i= i+1) {
            if (matriz[linha][i] == numero)
                return false;
        }
        return true;
    }
    
    /**
     * O método verificarColuna garante que não tem numeros repetidos na mesma coluna
     * @param matriz
     * @param linha
     * @param coluna
     * @param numero
     * @return boolean
     */
    public static boolean verificarColuna(int[][] matriz, int linha, int coluna, int numero) {
        for (int i = 0; i < matriz.length; i= i+1) {
            if (matriz[i][coluna] == numero)
                return false;
        }
        return true;
    }
        
    /**
     * O método verificarBox garante que não tem numeros repetidos no mesmo Box
     * @param matriz
     * @param linha
     * @param coluna
     * @param numero
     * @return boolean
     */   
    public static boolean verificarBox(int[][] matriz, int linha, int coluna, int numero) {
        int boxLinha = linha - linha % 3;
        int boxColuna = coluna - coluna % 3;
        for (int i = 0; i < 3; i= i+1) {
            for (int j = 0; j < 3; j= j+1) {
                if (matriz[boxLinha + i][boxColuna + j] == numero)
                    return false;
            }
        }
        return true;
    }
    
    /**
     * O método numeroFixo faz com que os números pré definidos não possam ser alterados
     * @param slots
     * @param matriz
     * @return boolean
     */
        public static boolean[][] numeroFixo(boolean[][] slots, int[][] matriz) {
        for (int i = 0; i < matriz.length; i= i+1) {
            for (int j = 0; j < matriz[0].length; j= j+1) {
                if (matriz[i][j] != 0)
                    slots[i][j] = true;
            }
        }
        return slots;
    }
    
    /**
     * O método verificaTabuleiroCompleto testa se o jogador venceu o jogo
     * @param matriz
     * @return boolean
     */
    public static boolean verificaTabuleiroCompleto(int[][] matriz) {
        for (int i = 0; i < matriz.length; i= i+1) {
            for (int j = 0; j < matriz[0].length; j= j+1) {
                if(matriz[i][j] == 0)
                    return false;
            }
        }
        return true;
    }
}
