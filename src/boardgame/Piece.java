package boardgame;

public class Piece {
    
    protected Postition postition;
    private Board board;
    
    public Piece(Board board) {
        this.board = board;
        postition = null;
    }

    protected Board getBoard() {
        return board;
    }
    
}
