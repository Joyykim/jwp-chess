package chess.domain.gamestate;

import chess.domain.Score;
import chess.domain.Side;
import chess.domain.board.Board;
import chess.domain.position.Position;

public interface State {
    State start();

    State move(Position from, Position to);

    State finished();

    Board board();

    Side currentTurn();

    Score score();

    Side winner();

    boolean isGameSet();

    boolean isFinished();
}