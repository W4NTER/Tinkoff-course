package edu.hw2;

import edu.hw2.Task2.Rectangle;
import edu.hw2.Task2.Square;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    static Arguments[] rectangles() {
        return new Arguments[]{
            Arguments.of(new Rectangle()),
            Arguments.of(new Square())
        };
    }

    @ParameterizedTest
    @MethodSource("rectangles")
    void rectangleArea(Rectangle rect) {
        rect.setWidth(20);
        rect.setHeight(10);

        assertThat(rect.area()).isEqualTo(200.0);
    }

    static Arguments[] squares() {
        return new Arguments[] {
            Arguments.of(new Square())
        };
    }

    @ParameterizedTest
    @MethodSource("squares")
    @DisplayName("Через такой костыль оно частично работает...")
    void squareArea(Square sqr) {
        sqr.setWidth(10);

        assertThat(sqr.area()).isEqualTo(100.0);
    }
}
