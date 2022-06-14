package com.endava.tmd.soj.junit5.p03.s1;

// Provocare: Copiati metodele de test din tema anterioara, si adaugati adnotarile necesare astfel incat
// sa fie rulate testele in ordine alfabetica. Modificati numele metodelor de test astfel incat metodele
// sa fie executate in ordinea in care sunt scrise

import org.junit.jupiter.api.*;

import static com.endava.tmd.soj.junit5.p01.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.MethodName.class) //ASC order by the method name
class ComputationUtilsTest {
    @Test
    void aZeroShouldNotChangeZero() {
        Assertions.assertEquals(0, sum(0, 0));

        assertThat(sum(0, 0)).isZero();
    }

    @Test
    void bZeroShouldNotChangePositive() {
        assertThat(sum(0, 2)).isEqualTo(2);
    }

    @Test
    void cZeroShouldNotChangeNegative() {
        assertThat(sum(0, -2)).isEqualTo(-2);
    }

    @Test
    void dTwoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertThat(sum(2, 2)).isEqualTo(4);    }

    @Test
    void eTwoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertThat(sum(-2, -2)).isEqualTo(-4);
    }

    @Test
    void fOneSmallNegativeAndOneBigPositiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertThat(sum(-2, 4)).isEqualTo(2);
    }

    @Test
    void gOneBigNegativeAndOneSmallPositiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(sum(2,-4)).isEqualTo(-2);
    }
}
