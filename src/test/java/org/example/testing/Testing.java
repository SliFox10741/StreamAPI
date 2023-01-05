package org.example.testing;

import org.example.Education;
import org.example.Person;
import org.example.Sex;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

// При названии класса лучше не использовать в его имени слово Class
public class Testing {

    Person person = new Person("Maxim", "Guselnikov", 17, Sex.MAN, Education.SECONDARY);

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Перед всем тестом");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("После всего теста");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("Перед каждым тестом");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("После каждого тестом");
    }

    @Test
    @Disabled("Ошибка в ожидаемом значении") // Данная аннотация позволяет отключать тесты
    public void testGetName() {
        Assertions.assertEquals("Maxim", person.getName());
    }


    @Test
    public void testConstructor() {
        Assertions.assertNotNull(person);
    }

    @ParameterizedTest
    @ValueSource(ints = {18, 21, 26})
    public void testAddParamFunction(int age) {
        Person personTest = new Person("Maxim", "Guselnikov", age, Sex.MAN, Education.SECONDARY);
        System.out.println("Тестируем возраст на пригодность в призывники: " + age);
        Assertions.assertTrue(personTest.getAge() >= 18 && personTest.getAge() < 27);
    }


    @Test
    @Disabled("Тоже есть ошибка")
    public void testAddPFunction() {

    }
}
