package ladder.domain;

import ladder.exception.LadderExceptionMessage;

import java.util.Objects;

public class Name {
    private static final int NAME_MAX_LENGTH = 5;

    private String name;

    public Name(String name) {
        this.name = name;
    }

    public static Name from(String name) {
        validate(name);

        return new Name(name);
    }

    private static void validate(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(LadderExceptionMessage.PARTICIPANT_NAME_TOO_LONG);
        }
    }

    @Override
    public String toString() {
        return name;
    }

    public int length() {
        return name.length();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return name.equals(name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
