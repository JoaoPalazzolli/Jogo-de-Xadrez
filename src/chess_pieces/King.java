package chess_pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        // Para cima
        p.setValues(position.getRow() - 1, position.getColumn());
        if (getBoard().PositionExist(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // Para baixo
        p.setValues(position.getRow() + 1, position.getColumn());
        if (getBoard().PositionExist(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // Esquerda
        p.setValues(position.getRow(), position.getColumn() - 1);
        if (getBoard().PositionExist(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // Direita
        p.setValues(position.getRow(), position.getColumn() + 1);
        if (getBoard().PositionExist(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // Cima-Esquerda
        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        if (getBoard().PositionExist(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // Cima-Direita
        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        if (getBoard().PositionExist(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // baixo-Esquerda
        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        if (getBoard().PositionExist(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // baixo-Direita
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        if (getBoard().PositionExist(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        return mat;
    }

}