package org.idNumberCalculation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class IDNumberCalculatorTest {
    private final IDNumberCalculator idNumberCalculator = new IDNumberCalculator();
    @ParameterizedTest
    @CsvSource({
            "12345678, Z",
            "26773469, C",
            "11111111, H",
            "29354599, U",
            "43986666, V",
            "43986444, W",
            "25896478, L",
            "25896499, V",
            "88888888, Y",
            "39865789, G"
    })

    void should_return_correct_letter_for_valid_id_number(int number, char letter){
        assertThat(idNumberCalculator.calculateLetter(number)).isEqualTo(letter);
    }

    @Test
    void should_throw_exception_for_negative_number(){
        assertThatThrownBy(()-> idNumberCalculator.calculateLetter(-1))
                                .isInstanceOf(IllegalArgumentException.class)
                                .hasMessage("The ID number must be between 0 and 99999999");
    }

    @Test
    void should_throw_exception_for_number_too_large(){
        assertThatThrownBy(()-> idNumberCalculator.calculateLetter(100000000))
                                .isInstanceOf(IllegalArgumentException.class)
                                .hasMessage("The ID number must be between 0 and 99999999");
    }
}
