package racingcar.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNameParserTest {

    @Test
    @DisplayName("입력 문자열을 쉼표를 기준으로 분리한다.")
    void splitByComma() {
        String input = "pobi,woni,jun";

        String[] result = CarNameParser.splitCarName(input);

        assertThat(result).containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("입력 문자열에 공백이 포함되어 있으면 제거 후 분리한다.")
    void trimAndSplitByComma() {
        String input = " pobi,woni ,   jun   ";

        String[] result = CarNameParser.splitCarName(input);

        assertThat(result).containsExactly("pobi", "woni", "jun");
    }
}
