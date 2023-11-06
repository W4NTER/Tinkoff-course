package edu.hw4;

import edu.hw4.Animal.Sex;
import edu.hw4.Animal.Type;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Tasks {
    private Tasks() {
    }

    public static List<Animal> sortAnimalsByHeight(List<Animal> animals) {
        animals.sort(Comparator.comparing(Animal::height));
        return animals;
    }

    public static List<Animal> sortAnimalsByWeight(List<Animal> animals, int k) {
        animals.sort(Comparator.comparing(Animal::weight));
        animals.reversed();
        return animals.subList(0, k);
    }

    public static Map<Type, Integer> countOfAnimalsAnyType(List<Animal> animals) {
        Map<Animal.Type, Integer> counterAnimals = new HashMap<>();
        for (Animal a : animals) {
            counterAnimals.put(a.type(), counterAnimals.get(a.type()) + 1);
        }
        return counterAnimals;
    }

    public static Animal findLongestNameOfAnimals(List<Animal> animals) {
        return Collections.max(animals, Comparator.comparing(a -> a.name().length()));
    }

    public static Sex countMaxAnimalsSex(List<Animal> animals) {
        long i = animals.stream().filter(animal -> animal.sex().equals(Sex.M)).count();
        long j = animals.stream().filter(animal -> animal.sex().equals(Sex.M)).count();

        if (i > j) {
            return Sex.M;
        } else {
            return Sex.F;
        }
    }

    public static Map<Type, Animal> heaviestAnimalOfAnyType(List<Animal> animals) {
        Map<Type, Animal> heaviestAnimals = new HashMap<>();
        return null;
    }
}
