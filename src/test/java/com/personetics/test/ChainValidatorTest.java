package com.personetics.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChainValidatorTest {

    ChainValidator chainValidator;
    List<Node> validNumberNodeList;
    List<Node> invalidNumberNodeList;
    List<Node> validCharacterNodeList;
    List<Node> invalidCharacterNodeList;

    @BeforeEach
    void setUp() {
        chainValidator = new ChainValidator();
    }

    @Test
    void validateTest_whenValidNumberNodeList_shouldReturnTrue() {
        validNumberNodeList = new ArrayList<>();

        validNumberNodeList.add(new NumberNode(36));
        validNumberNodeList.add(new NumberNode(6));
        validNumberNodeList.add(new NumberNode(24));
        validNumberNodeList.add(new NumberNode(4));
        validNumberNodeList.add(new NumberNode(47));
        validNumberNodeList.add(new NumberNode(7));
        validNumberNodeList.add(new NumberNode(2));
        validNumberNodeList.add(new NumberNode(3));
        validNumberNodeList.add(new NumberNode(27));

        boolean validationResult = chainValidator.validate(validNumberNodeList);
        assertTrue(validationResult);
    }

    @Test
    void validateTest_whenInvalidNumberNodeList_shouldReturnFalse() {
        invalidNumberNodeList = new ArrayList<>();

        invalidNumberNodeList.add(new NumberNode(35));
        invalidNumberNodeList.add(new NumberNode(5));
        invalidNumberNodeList.add(new NumberNode(65));
        invalidNumberNodeList.add(new NumberNode(6));
        invalidNumberNodeList.add(new NumberNode(24));
        invalidNumberNodeList.add(new NumberNode(4));

        // 35, 5, 65, 6, 24, 4
        boolean validationResult = chainValidator.validate(invalidNumberNodeList);
        assertFalse(validationResult);
    }

    @Test
    void validateTest_whenValidCharacterNodeList_shouldReturnTrue() {
        validCharacterNodeList = new ArrayList<>();

        validCharacterNodeList.add(new CharacterNode("p"));
        validCharacterNodeList.add(new CharacterNode("aba"));
        validCharacterNodeList.add(new CharacterNode("a"));
        validCharacterNodeList.add(new CharacterNode("b"));
        validCharacterNodeList.add(new CharacterNode("perso"));
        validCharacterNodeList.add(new CharacterNode("o"));
        validCharacterNodeList.add(new CharacterNode("r"));
        validCharacterNodeList.add(new CharacterNode("e"));
        validCharacterNodeList.add(new CharacterNode("s"));

        // "p", "aba", "a", "b", "perso", "o", "r", "e", "s"
        boolean validationResult = chainValidator.validate(validCharacterNodeList);
        assertTrue(validationResult);
    }

    @Test
    void validateTest_whenInvalidCharacterNodeList_shouldReturnFalse() {
        invalidCharacterNodeList = new ArrayList<>();

        invalidCharacterNodeList.add(new CharacterNode("a"));
        invalidCharacterNodeList.add(new CharacterNode("abby"));
        invalidCharacterNodeList.add(new CharacterNode("z"));
        invalidCharacterNodeList.add(new CharacterNode("y"));
        invalidCharacterNodeList.add(new CharacterNode("yb"));
        invalidCharacterNodeList.add(new CharacterNode("ayyyy"));

        // "a", "abby", "z", "y", "yb", "ayyyy"
        boolean validationResult = chainValidator.validate(invalidCharacterNodeList);
        assertFalse(validationResult);
    }
}