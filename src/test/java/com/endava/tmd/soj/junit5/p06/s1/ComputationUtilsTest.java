package com.endava.tmd.soj.junit5.p06.s1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.endava.tmd.soj.junit5.p06.s1.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

// Provocare: Rescrieti scenariile de testare din tema precedenta folosind teste parametrizate.
// Se vor utiliza adnotarile @ParameterizedTest si @CsvSource
// E suficient sa scrieti 2 teste distincte:
// - Un test care verifica valoarea sumei a doua numere
// - Un test care verifica exceptiile generate
//
// Bonus: personalizarea numelui afisat al testului
//   * vom folosi {0} pentru a folosi valoarea primului parametru al metodei
//   * vom folosi {1} pentru a folosi valoarea celui de-al doilea parametru al metodei
//   * ...
//   dar NU in @DisplayName ci in atributul "name" al adnotarii @ParameterizedTest
class ComputationUtilsTest {

    @ParameterizedTest(name = "Test sum {0} + {1} = {2}")
    @CsvSource({"1, 2, 3", "2, 2, 4", "3, 2, 5" , "4, 2, 6", "-2147483648, 2, -2147483646"})
    void shouldSumTwoNumbers(int a, int b, int expectedSum) {
        assertThat(sum(a, b)).isEqualTo(expectedSum);
    }

    @ParameterizedTest(name = "Test sum {0} + {1} = {2}")
    @CsvSource({"1, 2147483647, 214783648"})
    void shouldThrowException(int a, int b, int ignoredValue){
        assertThatThrownBy(() -> sum(a, b))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Overflow while computing the sum");
    }
}
