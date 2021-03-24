package chess.domain.board;

import chess.domain.game.Side;
import chess.domain.piece.Bishop;
import chess.domain.piece.Blank;
import chess.domain.piece.King;
import chess.domain.piece.Knight;
import chess.domain.piece.Pawn;
import chess.domain.piece.Piece;
import chess.domain.piece.Queen;
import chess.domain.piece.Rook;
import chess.domain.position.Column;
import chess.domain.position.Position;
import chess.domain.position.Row;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class BoardInitializer {

    private static final Map<Column, Function<Side, Piece>> BASE_MAP = new HashMap<>();

    static {
        BASE_MAP.put(Column.A, Rook::new);
        BASE_MAP.put(Column.B, Knight::new);
        BASE_MAP.put(Column.C, Bishop::new);
        BASE_MAP.put(Column.D, Queen::new);
        BASE_MAP.put(Column.E, King::new);
        BASE_MAP.put(Column.F, Bishop::new);
        BASE_MAP.put(Column.G, Knight::new);
        BASE_MAP.put(Column.H, Rook::new);
    }

    private BoardInitializer() {
    }

    public static Map<Position, Piece> init() {
        Map<Position, Piece> result = new HashMap<>();

        setBase(result, Side.WHITE, Row.FIRST);
        setPawn(result, Side.WHITE, Row.SECOND);
        setBlank(result, Row.THIRD);
        setBlank(result, Row.FOURTH);
        setBlank(result, Row.FIFTH);
        setBlank(result, Row.SIXTH);
        setPawn(result, Side.BLACK, Row.SEVENTH);
        setBase(result, Side.BLACK, Row.EIGHTH);
        return result;
    }

    private static void setBase(Map<Position, Piece> result, Side side, Row row) {
        for (Column column : Column.values()) {
            result.put(new Position(column, row), BASE_MAP.get(column).apply(side));
        }
    }

    private static void setPawn(Map<Position, Piece> result, Side side, Row row) {
        for (Column column : Column.values()) {
            result.put(new Position(column, row), new Pawn(side));
        }
    }

    private static void setBlank(Map<Position, Piece> result, Row row) {
        for (Column column : Column.values()) {
            result.put(new Position(column, row), Blank.getBlank());
        }
    }
}
