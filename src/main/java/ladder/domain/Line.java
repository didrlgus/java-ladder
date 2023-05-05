package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {

	private static final Random RANDOM = new Random();

	private final Points points;
	private BeforePoint beforePoint;

	public Line(int countOfPerson) {
		this.points = new Points(new ArrayList<>());
		this.beforePoint = new BeforePoint(false);
		IntStream.range(0, countOfPerson - 1).forEach(i -> this.addPoint(Line.RANDOM.nextBoolean()));
	}

	// TC를 수월하게 작성하기 위한 생성자, 프로덕션 코드에서 사용금지.
	public Line(List<Boolean> points, boolean beforePoint) {
		this.points = new Points(points);
		this.beforePoint = new BeforePoint(beforePoint);
	}

	public void addPoint(boolean randomBoolean) {
		if (this.beforePoint.equals(new BeforePoint(true))) {
			this.beforePoint = new BeforePoint(false);
			this.points.add(false);
			return;
		}
		this.beforePoint = new BeforePoint(randomBoolean);
		this.points.add(randomBoolean);
	}

	public Points getPoints() {
		return this.points;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Line line = (Line)o;
		return Objects.equals(points, line.points) && Objects.equals(beforePoint, line.beforePoint);
	}

	@Override
	public int hashCode() {
		return Objects.hash(points, beforePoint);
	}
}
