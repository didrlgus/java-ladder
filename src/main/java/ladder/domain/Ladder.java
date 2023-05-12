package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Ladder {

	private final Lines lines;

	public static Ladder of(Line... lines) {
		return new Ladder(Arrays.stream(lines).collect(Collectors.toList()));
	}

	private Ladder(List<Line> lines) {
		this(new Lines(lines));
	}

	public Ladder(Lines lines) {
		this.lines = lines;
	}

	public int finalIndex(int index) {
		return this.lines.finalIndex(index);
	}

	public List<Line> getLines() {
		return lines.getLines();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Ladder ladder = (Ladder)o;
		return Objects.equals(lines, ladder.lines);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lines);
	}
}
