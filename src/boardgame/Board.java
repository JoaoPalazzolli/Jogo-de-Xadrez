package boardgame;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int column) {
        if (!PositionExist(row, column)) {
            throw new BoardException("Position not on the board");
        }
        return pieces[rows][column];
    }

    public Piece piece(Postition postition) {
        if (!PositionExist(postition)) {
            throw new BoardException("Position not on the board");
        }
        return pieces[postition.getRow()][postition.getColumn()];
    }

    public void placePiece(Piece piece, Postition postition) {
        if (thereIsAPiece(postition)) {
            throw new BoardException("There is already a piece on postition " + postition);
        }
        pieces[postition.getRow()][postition.getColumn()] = piece;
        piece.postition = postition;
    }

    private boolean PositionExist(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean PositionExist(Postition postition) {
        return PositionExist(postition.getRow(), postition.getColumn());
    }

    public boolean thereIsAPiece(Postition postition) {
        if (!PositionExist(postition)) {
            throw new BoardException("Position not on the board");
        }
        return piece(postition) != null;
    }
}
