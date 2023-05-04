package ladder.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LineTest {

	@DisplayName("이전 좌표가 true인 경우 - 이후 좌표 false")
	@ValueSource(booleans = {true, false})
	@ParameterizedTest
	void test1(boolean randomBoolean) {
		Line line = new Line(new ArrayList<>(), true);
		line.addPoint(randomBoolean);
		assertThat(line).isEqualTo(new Line(List.of(false), false));
	}

	@DisplayName("이전 좌표가 false인 경우 - 이후 좌표 randomBoolean")
	@ValueSource(booleans = {true, false})
	@ParameterizedTest
	void test2(boolean randomBoolean) {
		Line line = new Line(new ArrayList<>(), false);
		line.addPoint(randomBoolean);
		assertThat(line).isEqualTo(new Line(List.of(randomBoolean), randomBoolean));
	}
}
