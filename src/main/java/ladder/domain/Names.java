package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Names {

	public static final int MAX_LENGTH = 5;

	private final List<String> names = new ArrayList<>();

	public Names(String inputNames) {
		Arrays.stream(inputNames.trim().split(","))
			.map(String::trim)
			.forEach(name -> {
				if (name.isBlank()) {
					throw new IllegalArgumentException("이름은 비어있을 수 없습니다.");
				}
				if (name.length() > Names.MAX_LENGTH) {
					throw new IllegalArgumentException("이름은 최대 5자까지 가능합니다.");
				}
				this.names.add(name);
			});
	}

	public int countOfPerson() {
		return this.names.size();
	}

	public List<String> getNames() {
		return this.names;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Names names1 = (Names)o;
		return Objects.equals(names, names1.names);
	}

	@Override
	public int hashCode() {
		return Objects.hash(names);
	}
}
