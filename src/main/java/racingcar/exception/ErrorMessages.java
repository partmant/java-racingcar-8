package racingcar.exception;

public final class ErrorMessages {

    private ErrorMessages() {
    }

    // 입력 관련
    public static final String NULL_INPUT_ERROR_MESSAGE = "입력은 null일 수 없습니다.";
    public static final String EMPTY_INPUT_ERROR_MESSAGE = "입력은 비어 있을 수 없습니다.";

    // 자동차 이름 관련
    public static final String EMPTY_NAME_ERROR_MESSAGE = "자동차 이름은 비어 있을 수 없습니다.";
    public static final String BLANK_NAME_ERROR_MESSAGE = "자동차 이름은 공백일 수 없습니다.";
    public static final String LENGTH_EXCEEDED_ERROR_MESSAGE = "자동차 이름은 5자 이하만 가능합니다.";
    public static final String DUPLICATE_NAME_ERROR_MESSAGE = "중복된 자동차 이름이 존재합니다.";

    // 자동차 수 관련
    public static final String CAR_COUNT_BELOW_MIN_ERROR_MESSAGE = "자동차 수는 2개 이상이어야 합니다.";
    public static final String CAR_COUNT_ABOVE_MAX_ERROR_MESSAGE = "자동차 수는 10개 이하여야 합니다.";

    // 시도 횟수 관련
    public static final String ATTEMPT_NOT_NUMERIC_ERROR_MESSAGE = "시도 횟수는 숫자여야 합니다.";
    public static final String ATTEMPT_BELOW_MIN_ERROR_MESSAGE = "시도 횟수는 1 이상의 정수여야 합니다.";
    public static final String ATTEMPT_ABOVE_MAX_ERROR_MESSAGE = "시도 횟수는 10 이하의 정수여야 합니다.";
}
