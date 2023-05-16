package ladder.domain;

import java.util.Objects;

import ladder.strategy.PointGenerator;
import ladder.type.DirectionType;
import ladder.type.PointType;
import ladder.type.PointTypeTransition;

public class Point {

	private final boolean left;
	private final boolean current;

	private static Point of(boolean left, boolean current) {
		return PointTypeTransition.toPoint(PointType.of(left, current));
	}

	public Point(boolean left, boolean current) {
		if (left && current) {
			throw new IllegalArgumentException("인접한 좌표를 모두 채울 수 없습니다.");
		}
		this.left = left;
		this.current = current;
	}

	public static Point first(boolean current) {
		return Point.of(false, current);
	}

	public Point next(boolean current) {
		return Point.of(this.current, current);
	}

	public Point last() {
		return Point.of(this.current, false);
	}

	public DirectionType direction() {
		return DirectionType.of(this);
	}

	public boolean nextPoint(PointGenerator pointGenerator) {
		return pointGenerator.point(this.current);
	}

	public boolean isCurrent() {
		return this.current;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Point point = (Point)o;
		return left == point.left && current == point.current;
	}

	@Override
	public int hashCode() {
		return Objects.hash(left, current);
	}
}
