package edu.hw3;

import edu.hw3.Task5.Contact;
import java.util.Arrays;
import java.util.stream.Collectors;
import edu.hw3.Task5.ParserContacts;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw3.Task5.ParserContacts.parseContacts;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {
    @Test
    @DisplayName("Проверка на сортировку ASC")
    void testSortContactsByASC() {
        //Given
        String[] contacts = { "John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes" };
        final String command = "ASC";

        //When
        Contact[] sortedContacts = ParserContacts.parseContacts(contacts, command);

        //Then
        final String expectedValue = "Thomas Aquinas,Rene Descartes,David Hume,John Locke";
        assertEquals(expectedValue, Arrays.stream(sortedContacts).map(Contact::getFullName).collect(
            Collectors.joining(",")));
    }

}

