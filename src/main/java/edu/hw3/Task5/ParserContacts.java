package edu.hw3.Task5;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public final class ParserContacts {
    private ParserContacts() {}

    public static Contact[] parseContacts(String[] arrContacts, String sortPattern) {
        Contact[] contacts =  convertToContact(arrContacts);
        Comparator<Contact> comparator = Comparator.comparing(Contact::getLastName);
        Arrays.sort(contacts, comparator);

        if (sortPattern.contentEquals("DESC")) {
            Collections.reverse(Arrays.asList(contacts));
        }
        return contacts;
    }

    public static Contact[] convertToContact(String[] input) {
        if (input == null) {
            return new Contact[0];
        }
        Contact[] contacts = new Contact[input.length];
        String[] contact;
        for (int i = 0; i < input.length; i++) {
            contact = input[i].split(" ");
            if (contact.length > 1) {
                contacts[i] = new Contact(contact[0], contact[1]);
            } else {
                contacts[i] = new Contact(contact[0], "");
            }
        }
        return contacts;
    }
}
