package com.endava.tmd.soj.junit5.p06.s3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.endava.tmd.soj.junit5.p06.s3.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

// Provocare: Rescrieti cele doua teste parametrizate din sectiunea 1 astfel incat sa existe
// cate o metoda care sa furnizeze valorile parametrilor. Dar, nu se vor mai folosi valorile
// explicite pentru valoarea minima si maxima acceptata de Java pentru tipul de date intreg,
// ci se vor folosi Integer.MIN_VALUE, respectiv Integer.MAX_VALUE
// Se va utiliza adnotarea @MethodSource.
class ComputationUtilsTest {

    @MethodSource("getParams")
    @ParameterizedTest(name = "Test sum {0} + {1} = {2}")
    void shouldSumTwoNumbers(int a, int b, int expectedSum) {
        assertThat(sum(a, b)).isEqualTo(expectedSum);
    }

    @MethodSource("getParamsWithMinMax")
    @ParameterizedTest(name = "Test sum {0} + {1} = {2}")
    void shouldThrowException(int a, int b, int ignoredValue){
        assertThatThrownBy(() -> sum(a, b))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Overflow while computing the sum");
    }

    static Stream<Arguments> getParams() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(2, 2, 4),
                Arguments.of(3, 2, 5)
        );
    }
    static Stream<Arguments> getParamsWithMinMax() {
        return Stream.of(
                Arguments.of(1, Integer.MAX_VALUE, Integer.MAX_VALUE + 1),
                Arguments.of(Integer.MIN_VALUE, -1, Integer.MIN_VALUE + (-1))
        );
    }
}
