package org.example;
import java.util.List;
public class Screenlocker {
    public static int calculateCombinations(char startPosition, int patternLength, int fieldSize) {
        return getCombinationNum(new Board(fieldSize).getInitialBoard(startPosition), patternLength);
    }

    private static int getCombinationNum(Board board, int patternLength) {
        if (patternLength <= 0)
            return 0;
        List<Point> availableMoves = board.getAvailableMoves();
        if (patternLength == 1)
            return 1;
        int combinationNum = 0;
        for (Point availableMove : availableMoves)
            combinationNum += getCombinationNum(Board.getBoarWithNewPosition(board, availableMove), patternLength - 1);
        return combinationNum;
    }
}
