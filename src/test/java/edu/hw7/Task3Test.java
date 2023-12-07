package edu.hw7;

import edu.hw7.Task3.CashingData;
import edu.hw7.Task3.Person;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Test {
    @Test
    @DisplayName("Проверка вытягивания данных в многопоточном режиме")
    void testThatCatchSomeDataByMultiThreadsReturnedSucceed() {
        CashingData data = getCashingData();

        var thread = new Thread(() -> {
            var AddressIds = data.findByAddress("Pushkina");
        });

        var thread1 = new Thread(() -> {
            var NameIds = data.findByName("Anna");
        });

        var thread3 = new Thread(() -> {
            var phoneIds = data.findByAddress("8080");
        });

//        assertEquals();

    }

    @NotNull private static CashingData getCashingData() {
        Person person = new Person(1, "name", "Pushkina", "8800");
        Person person1 = new Person(5, "name", "Pushkina2", "88001");
        Person person2 = new Person(2, "Sasha", "Lenina, 1, 1", "8800");
        Person person3 = new Person(3, "Anna", "Lenina 1, 2", "8801");
        Person person4 = new Person(4, "Dmitry", "address", "8802");
        CashingData data = new CashingData();
        data.add(person);
        data.add(person);
        data.add(person);
        data.add(person);
        data.add(person);
        return data;
    }
}
