package racingcar.view;

public final class OutputMessageFormatter {

    private static final String DISTANCE_SYMBOL = "-";

    private OutputMessageFormatter() {}

    public static String formatCarProgress(String carName, int position) {
        return carName + " : " + DISTANCE_SYMBOL.repeat(position);
    }

    public static String formatWinnerNames(String winners) {
        return "최종 우승자 : " + winners;
    }

    public static String formatResultTitle() {
        return "\n실행 결과\n";
    }
}
