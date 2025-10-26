package racingcar.view;

import java.util.List;

public final class OutputMessageFormatter {

    private static final String DISTANCE_SYMBOL = "-";
    private static final String WINNER_SEPARATOR = ", ";

    private OutputMessageFormatter() {}

    public static String buildResultMessage() {
        return "\n실행 결과\n";
    }

    public static String buildRoundResult(List<String> carNames, List<Integer> positions) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < carNames.size(); i++) {
            sb.append(carNames.get(i))
                    .append(" : ")
                    .append(DISTANCE_SYMBOL.repeat(positions.get(i)))
                    .append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }

    public static String buildWinners(List<String> winnerNames) {
        String winners = String.join(WINNER_SEPARATOR, winnerNames);
        return "최종 우승자 : " + winners + "\n";
    }
}
