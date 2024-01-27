import java.util.Locale;
import java.util.Scanner;
public class Main {
    static final int BOARDX = 7;
    static final int BOARDY = 15;
    public static void main(String[] args) {
        System.out.println("Welcome to MEGA Connect 5!");
        System.out.println("You may choose to place one 3x3 MegaPiece");
        System.out.println();
        Board board = new Board(BOARDX, BOARDY);
        Scanner input = new Scanner(System.in); //creates scanner obj
        int player = 1;
        int[] remainingMegaPiece = new int[2];
        remainingMegaPiece[0] = 1;
        remainingMegaPiece[1] = 1;
        String answer;
        int column;

        while (true) {
            board.displayAll();
            System.out.println("Player: " + player + ":");
            if (remainingMegaPiece[player - 1] == 1) {
                System.out.println("Use MegaPiece? (Y/N)?");
                answer = input.nextLine();
                answer.toUpperCase();
                while(!(answer.equals("Y") || answer.equals("N"))){
                    answer = input.nextLine();
                }
                if (answer.equals("Y")) {
                    System.out.println("Enter the column you would like to place your MegaPiece at.");
                    column = Integer.parseInt(input.nextLine()) - 1;
                    if (column > 0 && column < board.getBoardPieces()[0].length - 1) {
                        MegaPiece tempPiece = new MegaPiece(column, player, board);
                        if (tempPiece.getRow() > -1) {
                            board.placePiece(tempPiece);
                            remainingMegaPiece[player - 1] = 0;
                        } else {
                            System.out.println("Not a valid placement.");
                        }
                    } else {
                        System.out.println("Not a valid placement.");
                    }
                } else if (answer.equals("N")) {
                    System.out.println("Enter the column you would like to place your Piece at.");
                    column = Integer.parseInt(input.nextLine()) - 1;
                    if (column >= 0 && column <= board.getBoardPieces()[0].length - 1) {
                        Piece tempPiece = new Piece(column, player, board);
                        if (tempPiece.getRow() > -1) {
                            board.placePiece(tempPiece);
                        } else {
                            System.out.println("Not a valid placement.");
                        }
                    } else {
                        System.out.println("Not a valid placement.");
                    }
                }else{
                    System.out.println("Please enter a valid answer.");
                }
            }
            else{
                System.out.println("Enter the column you would like to place your Piece at.");
                column = Integer.parseInt(input.nextLine()) - 1;
                if (column >= 0 && column <= board.getBoardPieces()[0].length-1) {
                    Piece tempPiece = new Piece(column, player, board);
                    if (tempPiece.getRow() > -1) {
                        board.placePiece(tempPiece);
                    } else {
                        System.out.println("Not a valid placement.");
                    }
                } else {
                    System.out.println("Not a valid placement.");
                }
            }

            if (board.checkForWin(player)) {
                System.out.println("player: " + player + " has won!");
                board.displayAll();
                break;
            }
            player = player % 2 + 1;
        }
    }
}
