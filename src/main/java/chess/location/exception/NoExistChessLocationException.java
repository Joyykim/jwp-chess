package chess.location.exception;

public class NoExistChessLocationException extends IllegalStateException {
    private static final String MESSAGE = "존재하지 않는 Location에 접근하였습니다.";

    public NoExistChessLocationException() {
        super(MESSAGE);
    }
}