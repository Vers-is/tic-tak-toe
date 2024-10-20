import java.util.Scanner;

class index {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int gameTurns = 0;
        char[][] board = {{' ', ' ', ' '},
                          {' ', ' ', ' '},
                          {' ', ' ', ' '}};
        boolean[] occupiedPositions = new boolean[9]; 

        while (gameTurns != 9) {
            printBoard(board);
            gameTurns++;
            playerInput(board, scanner, gameTurns, occupiedPositions);

            Character winner = determineWinner(board);
            if (winner != null) {
            if (winner == 'T') {
                System.out.println("Tie!");
            } else {
                System.out.println(winner + " wins!");
            }
                break; 
            }
        }
    }

    public static void cleanConsole(){ 
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

    public static void playerInput(char[][] board, Scanner scanner, int gameTurns,
                                   boolean[] occupiedPositions){

            String turn = (gameTurns % 2 == 0) ? "O" : "X";
            boolean validInput = false; 
        
            while (!validInput) { 
                System.out.print(turn + "'s turn. Type the number of a cell (1-9): ");
                String input = scanner.nextLine();
        
                if (input.matches("[1-9]")) {
                    int position = Integer.parseInt(input); // making string into string

                    if (!occupiedPositions[position - 1]) { 
                        board[(position - 1) / 3][(position - 1) % 3] = turn.charAt(0);
                        occupiedPositions[position - 1] = true; 
                        validInput = true; 

                    } else {
                        System.out.println("Cell is occupied. Try again.");
                    }
                } else {
                    System.out.println("Invalid input. Try again."); 
                }
            }
        
            printBoard(board); 
        }

        public static Character determineWinner(char[][] board) {
            
            for (int i = 0; i < board.length; i++) { // horizontal
                if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
                    return board[i][0]; 
                }
            }
        
            for (int j = 0; j < board[0].length; j++) { // vertical
                if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != ' ') {
                    return board[0][j]; 
                }
            }
        
            if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
                return board[0][0]; // main diagonal
            }
        
            if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') {
                return board[0][2]; // side diag
            }
        
            for (int i = 0; i < board.length; i++) { //tie
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == ' ') {
                        return null;
                    }
                }
            }
            return 'T';
        }
        
}