package org.idNumberCalculation;

public class IDNumberCalculator {
    private static final char[] LETTERS = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D',
                                            'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L',
                                            'C', 'U', 'E'};

    public static char calculateLetter(int number){
        if(number < 0 || number > 99999999){
            throw new IllegalArgumentException("The ID number must be between 0 and 99999999");
        }
        return LETTERS[number%23];
    }
}
