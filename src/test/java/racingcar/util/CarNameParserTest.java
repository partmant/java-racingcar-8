package racingcar.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class CarNameParserTest {

    @Test
    @DisplayName("입력 문자열을 쉼표로 구분하여 분리한다")
    void 입력_문자열을_쉼표로_구분하여_분리한다() {
        String input = "pobi,woni,jun";

        List<String> result = CarNameParser.splitCarName(input);

        assertThat(result).containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("입력 문자열에 공백이 포함되어 있으면 제거 후 분리한다")
    void 입력_문자열에_공백이_포함되어_있으면_제거_후_분리한다() {
        String input = " pobi,woni ,   jun   ";

        List<String> result = CarNameParser.splitCarName(input);

        assertThat(result).containsExactly("pobi", "woni", "jun");
    }
}
