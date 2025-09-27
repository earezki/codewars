package com.earezki.valid_parentheses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesTest {

    @Test
    void isValid() {

        var sut = new ValidParentheses();

        assertTrue(sut.isValid("()"));
        assertTrue(sut.isValid("()[]{}"));
        assertFalse(sut.isValid("(]"));
        assertTrue(sut.isValid("([])"));
        assertFalse(sut.isValid("([)]"));

    }
}