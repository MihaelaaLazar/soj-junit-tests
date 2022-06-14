package com.endava.tmd.soj.junit5.p07;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.util.Locale;

import static java.lang.Double.parseDouble;
import static org.assertj.core.api.Assertions.assertThat;

// Provocare: definiti cel putin 3 teste pentru clasa care tine scorul
// Unde e cel mai potrivit ca sa initializam variabila "score"?
//
// Pentru un raspuns corect si doua incorecte, cat ar trebui sa fie scorul: 33.3 sau 33,3 ?
// 
// Daca avem colegi pe proiect care sunt din diferite parti ale lumii,
// cum putem scrie testul astfel incat sa functioneze pentru toti, indiferent de ce Locale are fiecare? 
class ScoreTest {
    Score score = new Score();

    @AfterEach
    void tearDown() {
        score = null;
    }
    @BeforeEach
    void setUp() {
        score = new Score();
    }

    @Test
    void shouldReturn33_3() {
        score.addCorrectAnswer();
        score.addIncorrectAnswer();
        score.addIncorrectAnswer();
        assertThat(score.getPercent()).isEqualTo("33.3");
    }

    @Test
    void shouldReturn33_3_RegardlessOfLocale() {
        //get the default locale from the system environment variables and set it to the current locale
        Locale locale = Locale.getDefault();
        String lang = locale.getLanguage();
        String country = locale.getCountry();
        Locale currentLocale = new Locale(lang, country);
        Locale.setDefault(currentLocale);

        //add correct answers and incorrect answers
        score.addCorrectAnswer();
        score.addIncorrectAnswer();
        score.addIncorrectAnswer();

        NumberFormat numberFormatted = NumberFormat.getInstance(currentLocale);
        String actualValue = numberFormatted.format(parseDouble(score.getPercent().replace(",", ".")));

        assertThat(score.getPercent()).isEqualTo(actualValue);

    }
}
