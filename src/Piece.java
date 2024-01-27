public class Piece {
    // instance variables go here!
    private int row;
    private int column;
    private int color;

    public Piece(int col, int color, Board board) { // constructor!
        this.column = col;
        this.color = color;
        this.row = findRow(column, board) ;
    }

    private int findRow(int column, Board board) { // given the state of the board, and a column, it returns the row
        int[][] boardPieces = board.getBoardPieces();
        if (this instanceof MegaPiece) {
            if(column == 0 || column == boardPieces[0].length){
                return -1;
            }
            if(boardPieces[2][column] > 0){
                return -1;
            }
            else{
                for(int row = boardPieces.length-1; row >= 0; row--){
                    if(boardPieces[row][column-1] == 0 && boardPieces[row][column] == 0 && boardPieces[row][column+1] == 0){
                        return row;
                    }
                }
                return -1;
            }
        } else {
            if(boardPieces[0][column] > 0){
                return -1;
            }
            else{
                for(int row = 0; row <= boardPieces.length-1; row++){
                    if(boardPieces[row][column] != 0){
                        return row-1;
                    }
                }
                for(int row = boardPieces.length-1; row >= 0; row--){
                    if(boardPieces[row][column] == 0){
                        return row;
                    }
                }
                return -1;
            }
        }
    }
    public int getCol() {
        return column;
    }
    public int getRow() {
        if(this instanceof MegaPiece){
            return row-1;
        }
        return row;
    }
    public int getColor() {
        return color;
    }
}
