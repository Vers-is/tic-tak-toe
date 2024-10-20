import java.util.Scanner;

class index {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int gameTurns = 0;
        char[][] board = {{' ', ' ', ' '},
                          {' ', ' ', ' '},
                          {' ', ' ', ' '}};

        while (gameTurns != 9) {
            printBoard(board);
            gameTurns++;
            playerInput(board, scanner, gameTurns);
        }

    }

    public static void cleanConsole(){ /// what the f-
        System.out.print("\033[H\033[2J"); 
        System.out.flush();
    }

    public static void printBoard(char[][] board){
        cleanConsole();
        System.out.println(board[0][0]+"|"+board[0][1]+"|"+board[0][2]+
                   "\n"+ "-+-+-"+
                   "\n"+ board[1][0]+"|"+board[1][1]+"|"+board[1][2]+
                   "\n"+ "-+-+-"+
                   "\n"+ board[2][0]+"|"+board[2][1]+"|"+board[2][2]);
    }

    public static void playerInput(char[][] board, Scanner scanner, int gameTurns){

        String turn = (gameTurns % 2 == 0) ? "O" : "X";

        System.out.print(turn + "'s turn. Type the number to put at (1-9): ");
        String input = scanner.nextLine();

            switch (input) {
            case "1":
                board[0][0]=turn.charAt(0);
                break;
            case "2":
                board[0][1]=turn.charAt(0);
                break;
            case "3":
                board[0][2]=turn.charAt(0);
                break;
            case "4":
                board[1][0]=turn.charAt(0);
                break;
            case "5":
                board[1][1]=turn.charAt(0);
                break;
            case "6":
                board[1][2]=turn.charAt(0);
                break;
            case "7":
                board[2][0]=turn.charAt(0);
                break;
            case "8":
                board[2][1]=turn.charAt(0);
                break;
            case "9":
                board[2][2]=turn.charAt(0);
                break;
            }
        printBoard(board);
    }

}
  