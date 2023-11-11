package edu.hw4;

import edu.hw4.Animal.Sex;
import edu.hw4.Animal.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Tasks {
    private Tasks() {
    }

    private final static Integer HEIGHT_BITES_ANIMALS = 100;

    public static List<Animal> sortAnimalsByHeight(List<Animal> animals) { //Task1
        List<Animal> result = new ArrayList<>(animals);
        result.sort(Comparator.comparing(Animal::height));
        return result;
    }

    public static List<Animal> sortAnimalsByMaxWeightSelectKFirst(List<Animal> animals, int k) { //Task2
        List<Animal> result = new ArrayList<>(animals);
        result.sort(Comparator.comparing(Animal::weight));
        return result.reversed().subList(0, k);
    }

    public static Map<Type, Integer> countOfAnimalsAnyType(List<Animal> animals) { //Task3
        return animals.stream().collect(Collectors.toMap(Animal::type, i -> 1, (oldValue, newValue) -> oldValue + 1));
    }

    public static Animal findLongestNameOfAnimals(List<Animal> animals) { //Task4
        return Collections.max(animals, Comparator.comparing(a -> a.name().length()));
    }

    public static Sex maxAnimalsSex(List<Animal> animals) { //Task5
        long i = animals.stream().filter(animal -> animal.sex().equals(Sex.M)).count();
        long j = animals.stream().filter(animal -> animal.sex().equals(Sex.F)).count();

        return i >= j ? Sex.M : Sex.F;
    }

    public static Map<Type, Animal> heaviestAnimalOfAnyType(List<Animal> animals) { //Task6
        return animals.stream().sorted(Comparator.comparing(Animal::weight))
            .collect(Collectors.toMap(Animal::type, animal -> animal, (oldValue, newValue) -> newValue));
    }

    public static Animal oldestAnimal(List<Animal> animals) { //Task7
        return Collections.max(animals, Comparator.comparing(Animal::age));
    }

    public static Optional<Animal> heaviestAnimalAnderKHeight(List<Animal> animals, int k) { //Task8
        return animals.stream().filter(a -> (a.height() < k)).max(Comparator.comparing(Animal::age));
    }

    public static Integer sumAnimalsPaws(List<Animal> animals) { //Task9
        return Math.toIntExact(animals.stream().mapToInt(Animal::paws).summaryStatistics().getSum());
    }

    public static List<Animal> listAnimalWhichPawsEqualAge(List<Animal> animals) { //Task10
        return animals.stream().filter((a) -> a.paws() != a.age()).collect(Collectors.toList());
    }

    public static List<Animal> animalsWhoCanBiteAndUpperMeter(List<Animal> animals) { //Task11
        return animals.stream().filter(Animal::bites)
            .filter(animal -> animal.height() > HEIGHT_BITES_ANIMALS).collect(Collectors.toList());
    }

    public static Integer animalsWithWeightMoreThenHeight(List<Animal> animals) { //Task12
        return Math.toIntExact(animals.stream().filter(animal -> animal.weight() > animal.height()).count());
    }

    public static List<Animal> animalsMoreThanTwoWordsName(List<Animal> animals) { //Task13
        return animals.stream().filter(a -> a.name().split(" ").length > 2).collect(Collectors.toList());
    }

    public static Boolean containDogWithHeightOverK(List<Animal> animals, Integer k) { //Task14
        return animals.stream().anyMatch(a -> a.type().equals(Type.DOG) && a.height() > k);
    }

    public static Map<Type, Integer> sumWeightAnimalsWithSpecialAge(List<Animal> animals,
        Integer k, Integer l) { //Task15
        return animals.stream().filter(animal -> animal.age() > k && animal.age() < l)
            .collect(Collectors.toMap(Animal::type, Animal::age, Integer::sum
        ));
    }

    public static List<Animal> sortedAnimalsByTypeSexName(List<Animal> animals) { //Task16
        return animals.stream()
            .sorted(Comparator.comparing(Animal::type)
            .thenComparing(Animal::sex)
            .thenComparing(Animal::name))
            .collect(Collectors.toList());
    }

    public static Boolean spidersBiteMoreThanDogs(List<Animal> animals) { //Task17
        double dogCount = animals.stream().filter(a -> a.type().equals(Type.DOG)).count();
        double spiderCount = animals.stream().filter(a -> a.type().equals(Type.SPIDER)).count();

        double dogBiteCount = animals.stream()
            .filter(a -> a.type().equals(Type.DOG)).filter(Animal::bites).count();

        double spiderBiteCount = animals.stream()
            .filter(a -> a.type().equals(Type.SPIDER)).filter(Animal::bites).count();

        return dogBiteCount / dogCount < spiderBiteCount / spiderCount;
    }

    public static Animal heaviestFishFromTwoLists(List<Animal> animals, List<Animal> animals2) { //Task18
        return Collections.max(Stream.of(animals, animals2)
            .flatMap(Collection::stream)
            .toList().stream()
            .filter(a -> a.type().equals(Type.FISH)).toList(),
            Comparator.comparing(Animal::age));
    }

    public static Map<Animal, Set<ValidationError>> animalsWithErrors(List<Animal> animals) { //Task19
        return animals.stream().filter(animal -> animal.height() < 0 || animal.weight() < 0)
            .collect(Collectors.toMap(animal -> animal,
            ValidationError::validateErrors));
    }

    public static Map<String, String> animalsWithErrorsStringFormat(List<Animal> animals) { //Task20
        return animals.stream().filter(animal -> animal.height() < 0 || animal.weight() < 0)
            .collect(Collectors.toMap(Animal::name, ValidationError::validateErrorsString));
    }
}
