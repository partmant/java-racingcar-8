package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String NAME_GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_GUIDE_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public static String readCarNames() {
        System.out.println(NAME_GUIDE_MESSAGE);
        return Console.readLine();
    }

    public static String readAttemptCount() {
        System.out.println(ATTEMPT_GUIDE_MESSAGE);
        return Console.readLine();
    }
}
