package edu.hw4;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class task8Test {
    final static List<Animal> ANIMALS = List.of(
        new Animal("Bobik", Animal.Type.DOG, Animal.Sex.M, 10, 120, 7, true),
        new Animal("Matroskin", Animal.Type.CAT, Animal.Sex.M, 8, 40, 3, true),
        new Animal("Nemo", Animal.Type.FISH, Animal.Sex.M, 1, 5, 1, false),
        new Animal("Marusya", Animal.Type.BIRD, Animal.Sex.F, 2, 7, 2, false),
        new Animal("a s d", Animal.Type.SPIDER, Animal.Sex.F, 2, 7, 2, false)
    );

    @Test
    @DisplayName("Проверка метода нахождения самого тяжелого животного ниже 50 см")
    void testThatFindHeaviestAnimalUnderKSmReturnedSucceed() {
        final int LIMIT_HEIGHT = 50;
        final Optional<Animal> EXPECTED_VALUE = Optional.ofNullable(ANIMALS.get(1));

        Optional<Animal> result = Tasks.heaviestAnimalAnderKHeight(ANIMALS, LIMIT_HEIGHT);

        assertEquals(EXPECTED_VALUE, result);
    }

    @Test
    @DisplayName("Проверка метода нахождения самого старого животного")
    void testThatFindOldestAnimalReturnedSucceed() {
        final Animal OLDEST_ANIMAL = ANIMALS.get(0);

        Animal result = Tasks.oldestAnimal(ANIMALS);

        assertEquals(OLDEST_ANIMAL, result);
    }

    @Test
    @DisplayName("Проверка метода, выводящего пол, животных которого болше")
    void testThatFindMaxAnimalsSexReturnedSucceed() {
        final Animal.Sex EXPECTED_VALUE = Animal.Sex.M;

        Animal.Sex result = Tasks.maxAnimalsSex(ANIMALS);

        assertEquals(EXPECTED_VALUE, result);
    }


    @Test
    @DisplayName("Проверка нахождения животного с самым длинным именем")
    void testThatFindAnimalWithLongestNameReturnedSucceed() {
        final Animal EXPECTED_VALUE = ANIMALS.get(1);

        Animal result = Tasks.findLongestNameOfAnimals(ANIMALS);

        assertEquals(EXPECTED_VALUE, result);
    }

    @Test
    @DisplayName("Нахождение количества животных каждого типа")
    void testThatCountAnimalsOfAnyTypeReturnedSucceed() {
        final Map<Animal.Type, Integer> EXPECTED_VALUE = Map.of(Animal.Type.DOG, 1, Animal.Type.CAT,
            1, Animal.Type.FISH, 1, Animal.Type.BIRD, 1);

        Map<Animal.Type, Integer> result = Tasks.countOfAnimalsAnyType(ANIMALS);

        assertEquals(EXPECTED_VALUE, result);
    }

    @Test
    @DisplayName("Проверка сортировки животных по весу от самого тяжелого к самому легкому и взятие к нужных")
    void testThatSortAnimalsByMaxWeightSelectKFirstReturnedSucceed() {
        final List<Animal> EXPECTED_LIST = List.of(ANIMALS.get(0), ANIMALS.get(1), ANIMALS.get(3));
        final int SELECTED_VALUE = 3;

        List<Animal> result = Tasks.sortAnimalsByMaxWeightSelectKFirst(ANIMALS, SELECTED_VALUE);

        assertEquals(EXPECTED_LIST, result);
    }

    @Test
    @DisplayName("Проверка сотрировки животных по возрастанию роста")
    void TestThatSortAnimalsByHeightReturnedSucceed() {
        final List<Animal> EXPECTED_LIST = List.of(ANIMALS.get(2), ANIMALS.get(3), ANIMALS.get(1), ANIMALS.get(0));

        List<Animal> result = Tasks.sortAnimalsByHeight(ANIMALS);

        assertEquals(EXPECTED_LIST, result);
    }

    @Test
    @DisplayName("Сумма лап всех животных в сприске")
    void testThatSumOfAllAnimals() {
        final Integer COUNT_PAWS_AT_LIST = 10;

        Integer result = Tasks.sumAnimalsPaws(ANIMALS);

        assertEquals(COUNT_PAWS_AT_LIST, result);
    }

    @Test
    @DisplayName("Проверка списка животных с одинаковыми: количеством лап и возраста")
    void testThatFindAnimalsWitchPawsEqualAgeReturnedSucceed() {
        final List<Animal> EXPECTED_LIST = List.of(ANIMALS.get(0), ANIMALS.get(1), ANIMALS.get(2));

        List<Animal> result = Tasks.listAnimalWhichPawsEqualAge(ANIMALS);

        assertEquals(EXPECTED_LIST, result);
    }

    @Test
    @DisplayName("Проверка животных, которые могут укусить и выше 100см")
    void testThatFindAnimalsWhoCanBiteAndUpperMeterReturnedSucceed() {
        final List<Animal> EXPECTED_LIST = List.of(ANIMALS.get(0));

        List<Animal> result = Tasks.animalsWhoCanBiteAndUpperMeter(ANIMALS);

        assertEquals(EXPECTED_LIST, result);
    }

    @Test
    @DisplayName("Проверка животных у которых вес больше роста")
    void testThatFindAnimalsWithWeightMoreThenHeightReturnedSucceed() {
        final Integer EXPECTED_VAlUE = 0;

        Integer result = Tasks.animalsWithWeightMoreThenHeight(ANIMALS);

        assertEquals(EXPECTED_VAlUE, result);
    }

    @Test
    @DisplayName("Животные имена которых состоят из более чем двух слов")
    void testThatAnimalsWithMoreThanTwoWordsNameReturnedSucceed() {
        final List<Animal> EXPECTED_LIST = List.of(ANIMALS.get(4));

        List<Animal> result = Tasks.animalsMoreThanTwoWordsName(ANIMALS);

        assertEquals(EXPECTED_LIST, result);
    }

    @Test
    @DisplayName("Проверка есть ли собака с ростом более 10см")
    void testThatDogWithHeightOverKIsExists() {
        final Integer K = 10;

        assertTrue(Tasks.containDogWithHeightOverK(ANIMALS, K));
    }

    @Test
    @DisplayName("Сумма возрастов животных каждого типа")
    void testThatSumAgeOfAnyTypesAnimals() {
        final Map<Animal.Type, Integer> EXPECTED_MAP = Map.of(Animal.Type.CAT,
            8, Animal.Type.FISH, 1, Animal.Type.SPIDER, 2, Animal.Type.BIRD, 2);
        final Integer K = 0;
        final Integer L = 9;

        Map<Animal.Type, Integer> result = Tasks.sumWeightAnimalsWithSpecialAge(ANIMALS, K, L);

        assertEquals(EXPECTED_MAP, result);
    }

    @Test
    @DisplayName("Проверка самого тяжелого животного каждого типа")
    void testThatHeaviestAnimalOfAnyType() {
        final Map<Animal.Type, Animal> EXPECTED_MAP = Map.of(
            Animal.Type.DOG, ANIMALS.get(0), Animal.Type.CAT,
            ANIMALS.get(1), Animal.Type.FISH, ANIMALS.get(2),
            Animal.Type.SPIDER, ANIMALS.get(4), Animal.Type.BIRD, ANIMALS.get(3));

        Map<Animal.Type, Animal> result = Tasks.heaviestAnimalOfAnyType(ANIMALS);

        assertEquals(EXPECTED_MAP, result);
    }
}
