package com.softserve.academy;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberAnalyzerTest {

    // AAA: Arrange-Act-Assert pattern
    // Arrange - підготовка даних (BeforeEach створює базову колекцію)
    // Act - виконання дії
    // Assert - перевірка результату

    private NumberAnalyzer analyzer;
    private List<Integer> testNumbers;

    @BeforeEach
    void setUp() {
        // Arrange - створюємо фіксовану колекцію для тестування
        testNumbers = new ArrayList<>(Arrays.asList(
                45, 12, 78, 23, 56, 89, 34, 67, 90, 15,
                42, 8, 73, 29, 61, 5, 38, 82, 50, 19
        ));
        analyzer = new NumberAnalyzer(testNumbers);
    }

    // ===== Constructor tests =====

    @Test
    void shouldCreateAnalyzerWithValidNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        NumberAnalyzer analyzer = new NumberAnalyzer(numbers);
        assertEquals(3, analyzer.size());
    }

    @Test
    @DisplayName("TODO: Реалізувати тест - має кинути виключення якщо список null")
    void shouldThrowExceptionWhenNumbersListIsNull() {
        List<Integer> numbers = null;
        assertThrows(IllegalArgumentException.class, () -> new NumberAnalyzer(numbers));
    }

    // ===== findMinimum() tests =====

    @Test
    @DisplayName("TODO: Реалізувати тест - має знайти мінімальне число в колекції")
    void shouldFindMinimumNumber() {
        int min = analyzer.findMinimum();
        assertEquals(5, min);
    }

    @Test
    @DisplayName("TODO: Реалізувати тест - має кинути виключення для порожньої колекції")
    void shouldThrowExceptionWhenFindingMinimumInEmptyCollection() {
        List<Integer> emptyCollection = new ArrayList<>();
        NumberAnalyzer analyzer = new NumberAnalyzer(emptyCollection);
        assertThrows(IllegalStateException.class, () -> analyzer.findMinimum());
    }

    // ===== findMaximum() tests =====

    @Test
    @DisplayName("TODO: Реалізувати тест - має знайти максимальне число в колекції")
    void shouldFindMaximumNumber() {
        int max = analyzer.findMaximum();
        assertEquals(90, max);
    }

    @Test
    @DisplayName("TODO: Реалізувати тест - має кинути виключення для порожньої колекції")
    void shouldThrowExceptionWhenFindingMaximumInEmptyCollection() {
        List<Integer> emptyCollection = new ArrayList<>();
        NumberAnalyzer analyzer = new NumberAnalyzer(emptyCollection);
        assertThrows(IllegalStateException.class, () -> analyzer.findMaximum());
    }

    // ===== calculateAverage() tests =====

    @Test
    @DisplayName("TODO: Реалізувати тест - має обчислити середнє значення")
    void shouldCalculateAverageValue() {
        double average = analyzer.calculateAverage();
        assertEquals(45.8, average, 0.001);
    }

    @Test
    @DisplayName("TODO: Реалізувати тест - має кинути виключення для порожньої колекції")
    void shouldThrowExceptionWhenCalculatingAverageOfEmptyCollection() {
        List<Integer> emptyCollection = new ArrayList<>();
        NumberAnalyzer analyzer = new NumberAnalyzer(emptyCollection);
        assertThrows(IllegalStateException.class, () -> analyzer.calculateAverage());

    }

    @Test
    @DisplayName("TODO: Реалізувати тест - має правильно обчислити середнє для однієї цифри")
    void shouldCalculateAverageForSingleNumber() {
        NumberAnalyzer singleNumber = new NumberAnalyzer(Arrays.asList(15));
        double average = singleNumber.calculateAverage();
        assertEquals(15, average, 0.001);
    }

    // ===== removeEvenNumbers() tests =====

    @Test
    @DisplayName("TODO: Реалізувати тест - має видалити всі парні числа")
    void shouldRemoveAllEvenNumbers() {
        analyzer.removeEvenNumbers();
        List<Integer> expected = new ArrayList<>(List.of(45,23,89,67,15,73,29,61,5,19));
        assertEquals(expected, analyzer.getNumbers());

    }

    @Test
    @DisplayName("TODO: Реалізувати тест - має залишити колекцію порожньою якщо всі числа парні")
    void shouldLeaveEmptyCollectionWhenAllNumbersAreEven() {
        NumberAnalyzer analyzer = new NumberAnalyzer(Arrays.asList(20,30,40,50));
        analyzer.removeEvenNumbers();
        assertEquals(0, analyzer.size());
    }

    @Test
    @DisplayName("TODO: Реалізувати тест - не має змінювати колекцію якщо всі числа непарні")
    void shouldNotChangeCollectionWhenAllNumbersAreOdd() {
        NumberAnalyzer analyzer = new NumberAnalyzer(Arrays.asList(5,7,9,11));
        analyzer.removeEvenNumbers();
        assertEquals(4, analyzer.size());
    }

    // ===== contains() tests =====

    @Test
    @DisplayName("TODO: Реалізувати тест - має знайти число яке існує в колекції")
    void shouldReturnTrueWhenNumberExists() {
        boolean result = analyzer.contains(15);
        assertTrue(result);
    }

    @Test
    @DisplayName("TODO: Реалізувати тест - має повернути false для числа якого немає")
    void shouldReturnFalseWhenNumberDoesNotExist() {
        boolean result = analyzer.contains(2);
        assertFalse(result);
    }

    @Test
    @DisplayName("TODO: Реалізувати тест - має повернути false для порожньої колекції")
    void shouldReturnFalseForEmptyCollection() {
        boolean result = (analyzer.size() == 0);
        assertFalse(result);
    }

    // ===== sortAscending() tests =====

    @Test
    @DisplayName("TODO: Реалізувати тест - має відсортувати числа за зростанням")
    void shouldSortNumbersInAscendingOrder() {
        List<Integer> numbers = new ArrayList<>(List.of(10, 9, 8, 7, 6, 5));
        NumberAnalyzer analyzer = new NumberAnalyzer(numbers);
        analyzer.sortAscending();
        List<Integer> result  = analyzer.getNumbers();
        List<Integer> expected = new ArrayList<>(List.of(5,6,7,8,9,10));
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("TODO: Реалізувати тест - має залишити вже відсортовану колекцію без змін")
    void shouldNotChangeAlreadySortedCollection() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        NumberAnalyzer analyzer = new NumberAnalyzer(new ArrayList<>(numbers));
        analyzer.sortAscending();
        assertEquals(numbers, analyzer.getNumbers());
    }

    @Test
    @DisplayName("TODO: Реалізувати тест - має правильно відсортувати колекцію з дублікатами")
    void shouldSortCollectionWithDuplicates() {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 3, 1);
        NumberAnalyzer analyzer = new NumberAnalyzer(new ArrayList<>(numbers));
        analyzer.sortAscending();
        List<Integer> expected = Arrays.asList(1, 2, 3, 3, 4);
        assertEquals(expected, analyzer.getNumbers());
    }

    // ===== size() tests =====

    @Test
    void shouldReturnCorrectSize() {
        int size = analyzer.size();
        assertEquals(20, size);
    }

    @Test
    @DisplayName("TODO: Реалізувати тест - має повернути 0 для порожньої колекції")
    void shouldReturnZeroForEmptyCollection() {
        List<Integer> numbers = new ArrayList<>();
        NumberAnalyzer analyzer = new NumberAnalyzer(numbers);
        assertEquals(0, analyzer.size());
    }

    // ===== getNumbers() tests =====

    @Test
    @DisplayName("TODO: Реалізувати тест - має повернути копію колекції (не оригінал)")
    void shouldReturnCopyOfNumbers() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3));
        NumberAnalyzer analyzer = new NumberAnalyzer(numbers);
        List<Integer> copy = analyzer.getNumbers();
        assertEquals(numbers, copy);
    }

    // ===== Integration tests =====

    @Test
    @DisplayName("TODO: Реалізувати тест - має виконати послідовність операцій (видалити парні, потім сортувати)")
    void shouldRemoveEvenNumbersAndThenSort() {
        List<Integer> numbers = new ArrayList<>(List.of(10, 9, 8, 7, 6, 5));
        NumberAnalyzer analyzer = new NumberAnalyzer(numbers);
        analyzer.removeEvenNumbers();
        analyzer.sortAscending();
        List<Integer> result  = analyzer.getNumbers();
        List<Integer> expected = new ArrayList<>(List.of(5,7,9));
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("TODO: Реалізувати тест - має правильно працювати після видалення парних чисел")
    void shouldFindMinMaxAfterRemovingEvenNumbers() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        NumberAnalyzer analyzer = new NumberAnalyzer(numbers);
        analyzer.removeEvenNumbers();
        int min = analyzer.findMinimum();
        int max = analyzer.findMaximum();
        assertEquals(1, min);
        assertEquals(5, max);
    }

    // ===== Edge cases =====

    @Test
    @DisplayName("TODO: Реалізувати тест - має працювати з негативними числами")
    void shouldHandleNegativeNumbers() {
        NumberAnalyzer analyzer = new NumberAnalyzer(Arrays.asList(-7, -5, 0, 5));
        int min = analyzer.findMinimum();
        assertEquals(-7, min);
    }

    @Test
    @DisplayName("TODO: Реалізувати тест - має працювати з нулем в колекції")
    void shouldHandleZeroInCollection() {
        NumberAnalyzer analyzer = new NumberAnalyzer(Arrays.asList(-7, -5, 0, 5));
        boolean zero = analyzer.contains(0);
        assertTrue(zero);
    }
}
