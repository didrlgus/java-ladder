package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NamesTest {

	@DisplayName("유효한 문자열로 이름 목록 생성 시, 객체를 반환한다.")
	@Test
	void test1() {
		Names names = new Names("pobi,honux,crong,jk");
		assertThat(names).isEqualTo(new Names("pobi,honux,crong,jk"));
	}

	@DisplayName("사람 이름은 ,를 기준으로 구분한다.")
	@Test
	void test2() {
		assertThat(new Names("pobi,honux,crong,jk").countOfPerson()).isEqualTo(4);
	}
}
