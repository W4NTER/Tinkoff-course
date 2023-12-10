package edu.hw7;

import edu.hw7.Task3.CashingData;
import edu.hw7.Task3.Person;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3Test {
    @Test
    @DisplayName("Проверка вытягивания данных в многопоточном режиме")
    void testThatCatchSomeDataByMultiThreadsReturnedSucceed() {
        CashingData data = getCashingData();
        List<Person> addressIds = new ArrayList<>();
        List<Person> nameIds = new ArrayList<>();
        List<Person> phoneIds = new ArrayList<>();

        var thread = new Thread(() -> {
            addressIds.addAll(data.findByAddress("Pushkina"));
            phoneIds.addAll(data.findByPhone("8800"));
            nameIds.addAll(data.findByName("name"));
        });
        var del = new Thread(() ->
            data.delete(1));

        thread.start();
        del.start();

        try {
            thread.join();
            del.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (addressIds.size() == 1) {
            assertFalse(addressIds.isEmpty());
            assertFalse(nameIds.isEmpty());
            assertFalse(phoneIds.isEmpty());
        } else {
            assertTrue(addressIds.isEmpty());
            assertTrue(nameIds.isEmpty());
            assertTrue(phoneIds.isEmpty());
        }
        //Это выбивается из стандартов тестирования, но это единственное что я придумал
        //Идея в том что, если успело удалиться, то не найдется ничего, если нет, то найдется все.
    }

    @NotNull private static CashingData getCashingData() {
        Person person = new Person(1, "name", "Pushkina", "8800");
        CashingData data = new CashingData();
        data.add(person);

        return data;
    }
}
