public class Board {
    // declare instance variables here!
    private int[][] pieces;
    public Board(int x, int y) { // constructor!
        pieces = new int[x][y];
    }
    public void placePiece(Piece p) { // updates the state of the board with the information of the Piece
        if (p instanceof MegaPiece) {
            for(int row = -1; row < 2; row++){
                for(int col = -1; col < 2; col++){
                    pieces[p.getRow() - row][p.getCol() + col] = p.getColor();
                }
            }
        }
        else {
            pieces[p.getRow()][p.getCol()] = p.getColor();
        }
    }


    public int[][] getBoardPieces() { // getter function for boardPieces array
        return pieces;
    }

    public void displayAll() { // displays the entire board
        String board = "  ";
        if(pieces[0].length < 9){
            for(int i = 0; i < pieces[0].length; i++){
                board += String.valueOf(i+1) + "  ";
            }
        }
        else{
            for(int i = 0; i < 9; i++){
                board += String.valueOf(i+1) + "  ";
            }
            for(int i = 9; i < pieces[0].length; i++){
                board += String.valueOf(i+1) + " ";
            }
        }
        for(int row = 0; row < pieces.length; row++){
            board += "\n" + "# ";
            for(int col = 0; col < pieces[row].length; col++){
                if(pieces[row][col] == 0){
                    board += ".  ";
                }
                if(pieces[row][col] == 1){
                    board += "X  ";
                }
                if(pieces[row][col] == 2){
                    board += "O  ";
                }

            }
            board += "#";
        }
        System.out.println(board);
    }
    public boolean checkForWin(int player) {
        //check 5 in a row
        for(int row = 0; row < pieces.length; row++){
            for(int col = 0; col < pieces[0].length-4; col++) {
                if(pieces[row][col] == player){
                    if (pieces[row][col] == pieces[row][col+1] && pieces[row][col+1] == pieces[row][col+2] && pieces[row][col+2] == pieces[row][col+3] && pieces[row][col+3] == pieces[row][col+4]) {
                        return true;
                    }
                }
            }
        }
        //check 5 in a column
        for(int col = 0; col < pieces[0].length; col++){
            for(int row = 0; row < pieces.length-4; row++) {
                if(pieces[row][col] == 1 || pieces[row][col] == 2){
                    if (pieces[row][col] == pieces[row+1][col] && pieces[row+1][col] == pieces[row+2][col] && pieces[row+2][col] == pieces[row+3][col] && pieces[row+3][col] == pieces[row+4][col]) {
                        return true;
                    }
                }
            }
        }
        //check 5 across down to the right
        for(int col = 0; col < pieces[0].length-4; col++){
            for(int row = 0; row < pieces.length-4; row++) {
                if(pieces[row][col] == 1 || pieces[row][col] == 2) {
                    if (pieces[row][col] == pieces[row + 1][col + 1] && pieces[row + 1][col + 1] == pieces[row + 2][col + 2] && pieces[row + 2][col + 2] == pieces[row + 3][col + 3] && pieces[row + 3][col + 3] == pieces[row + 4][col + 4]) {
                        return true;
                    }
                }
            }
        }
        //check 5 across down to the left
        for(int col = 5; col < pieces[0].length; col++){
            for(int row = 0; row < pieces.length-4; row++) {
                if(pieces[row][col] == 1 || pieces[row][col] == 2){
                    if (pieces[row][col] == pieces[row+1][col-1] && pieces[row+1][col-1] == pieces[row+2][col-2] && pieces[row+2][col-2] == pieces[row+3][col-3] && pieces[row+3][col-3] == pieces[row+4][col-4]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
