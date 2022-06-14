package com.endava.tmd.soj.junit5.p03.s2;

import org.junit.jupiter.api.*;

import static com.endava.tmd.soj.junit5.p01.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;

// Provocare: Copiati metodele de test din tema anterioara (p02), si adaugati adnotarile necesare astfel incat
// sa fie rulate testele in functie de adnotarea de ordine specificata pe fiecare metoda de test. Adnotarea de ordine
// trebuie sa fie pusa pe fiecare metoda de test astfel incat metodele sa fie executate in ordinea in care sunt scrise

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ComputationUtilsTest {

    @Test
    @DisplayName("0+0=0")
    @Order(1)
    void zeroShouldNotChangeZero() {
        Assertions.assertEquals(0, sum(0, 0));

        assertThat(sum(0, 0)).isZero();
    }

    @Test
    @DisplayName("0+2")
    @Order(2)
    void zeroShouldNotChangePositive() {
        assertThat(sum(0, 2)).isEqualTo(2);
    }

    @Test
    @DisplayName("0+(-2) = -2")
    @Order(3)
    void zeroShouldNotChangeNegative() {
        assertThat(sum(0, -2)).isEqualTo(-2);
    }

    @Test
    @DisplayName("2+2 = 4")
    @Order(4)
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertThat(sum(2, 2)).isEqualTo(4);    }

    @Test
    @DisplayName("-2+(-2) = -4")
    @Order(5)
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertThat(sum(-2, -2)).isEqualTo(-4);
    }

    @Test
    @DisplayName("(-2) + 4 = 2")
    @Order(6)
    void oneSmallNegativeAndOneBigPositiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertThat(sum(-2, 4)).isEqualTo(2);
    }

    @Test
    @DisplayName("2 + (-4) = -2")
    @Order(7)
    void oneBigNegativeAndOneSmallPositiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(sum(2,-4)).isEqualTo(-2);
    }
}
