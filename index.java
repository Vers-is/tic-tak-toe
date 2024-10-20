import java.util.Scanner;

class index {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] board = {{' ', ' ', ' '},
                          {' ', ' ', ' '},
                          {' ', ' ', ' '}};
        printBoard(board);

        playerInput(board, scanner);

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

    public static void playerInput(char[][] board, Scanner scanner){
        System.out.print("X's turn. Type the number to put at (1-9): ");
        String input = scanner.nextLine();

        switch (input) {
            case "1":
                board[0][0]='X';
                break;
            case "2":
                board[0][1]='X';
                break;
            case "3":
                board[0][2]='X';
                break;
            case "4":
                board[1][0]='X';
                break;
            case "5":
                board[1][1]='X';
                break;
            case "6":
                board[1][2]='X';
                break;
            case "7":
                board[2][0]='X';
                break;
            case "8":
                board[2][1]='X';
                break;
            case "9":
                board[2][2]='X';
                break;
        }
        printBoard(board);
    }

}
  