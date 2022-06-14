package com.endava.tmd.soj.junit5.p02;

// Provocare: Copiati metodele de test din tema anterioara, si adaugati adnotarile necesare astfel incat:
// 1. Sa fie afisat "Tests for my sum method" in loc de "ComputationUtilsTest"
// 2. La fiecare test sa fie afisata suma. De exemplu "zeroShouldNotChangeZero" ar trebui sa fie inlocuit cu "0 + 0 = 0"

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.endava.tmd.soj.junit5.p01.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Tests for my sum method")
class ComputationUtilsTest {
    @Test
    @DisplayName("0+0=0")
    void zeroShouldNotChangeZero() {
        Assertions.assertEquals(0, sum(0, 0));

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

}
