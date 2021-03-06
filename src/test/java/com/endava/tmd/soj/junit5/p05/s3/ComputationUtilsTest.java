package com.endava.tmd.soj.junit5.p05.s3;

import com.endava.tmd.soj.junit5.p01.ComputationUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.endava.tmd.soj.junit5.p05.s1.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Scopul acestei sectiuni este sa urmarim rescrierile de cod din partea de productie
// Deci pastram testele din sectiunea precedenta
class ComputationUtilsTest {
    @Test
    @DisplayName("0+0=0")
    void zeroShouldNotChangeZero() {
        assertEquals(0, sum(0, 0));

        assertThat(sum(0, 0)).isZero();
    }

    @Test
    @DisplayName("0+2")
    void zeroShouldNotChangePositive() {
        assertThat(sum(0, 2)).isEqualTo(2);
    }

    @Test
    @DisplayName("0+(-2) = -2")
    void zeroShouldNotChangeNegative() {
        assertThat(sum(0, -2)).isEqualTo(-2);
    }

    @Test
    @DisplayName("2+2 = 4")
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertThat(sum(2, 2)).isEqualTo(4);    }

    @Test
    @DisplayName("-2+(-2) = -4")
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertThat(sum(-2, -2)).isEqualTo(-4);
    }

    @Test
    @DisplayName("(-2) + 4 = 2")
    void oneSmallNegativeAndOneBigPositiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertThat(sum(-2, 4)).isEqualTo(2);
    }

    @Test
    @DisplayName("2 + (-4) = -2")
    void oneBigNegativeAndOneSmallPositiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(sum(2,-4)).isEqualTo(-2);
    }
    @Test
    void zeroShouldNotChangeMaxInt() {
        assertThat(ComputationUtils.sum(0, Integer.MAX_VALUE)).isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    void maxIntAndANegativeNumber() {
        assertThat(ComputationUtils.sum(Integer.MAX_VALUE, -1)).isEqualTo(2147483646);
    }

    @Test
    void zeroShouldNotChangeMinInt() {
        assertThat(ComputationUtils.sum(0, Integer.MIN_VALUE)).isEqualTo(Integer.MIN_VALUE);
    }

    @Test
    void minIntAndAPositiveNumber() {
        assertThat(ComputationUtils.sum(Integer.MIN_VALUE, 1)).isEqualTo(-2147483647);
    }

    @Test
    void minIntAndMaxInt() {
        assertThat(ComputationUtils.sum(Integer.MIN_VALUE, Integer.MAX_VALUE)).isEqualTo(Integer.MIN_VALUE + Integer.MAX_VALUE);
    }

    @Test
    @Disabled
    void whatToDoWhenSumExceedsMaxIntegerValue() {
        assertThat(ComputationUtils.sum(Integer.MAX_VALUE, 2)).isEqualTo(2147483649L);
    }

    @DisplayName("2147483647 + 1 \u21D2 Overflow")
    @Test
    void exceptionWhenSumIsGreaterThanIntegerMaxValue() {
        // JUnit way of checking the exception class
//        assertThrows(ArithmeticException.class, () -> sum(2147483647, 1));
//
////        // JUnit way of checking the exception class and its characteristics
//        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> sum(2147483647, 1));
//        assertEquals("Overflow while computing the sum", exception.getMessage());

        // AssertJ
        assertThatThrownBy(() -> sum(2147483647, 1))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Overflow while computing the sum");
    }

    @DisplayName("-2147483648 + (-1) \u21D2 Overflow")
    @Test
    void exceptionWhenSumIsLowerThanIntegerMinValue() {
        assertThatThrownBy(() -> sum(-2147483648, -1))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Overflow while computing the sum");
    }
}
