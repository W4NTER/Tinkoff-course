package edu.hw7.Task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CashingData implements PersonDatabase {
    private final Map<Integer, Person> personMap = new HashMap<>();
    private final Map<String, List<Integer>> nameMap = new HashMap<>();
    private final Map<String, List<Integer>> addressMap = new HashMap<>();
    private final Map<String, List<Integer>> phoneMap = new HashMap<>();
    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public synchronized void add(Person person) {
        if (!nameMap.containsKey(person.name())) {
            nameMap.put(person.name(), new ArrayList<>());
        }
        if (!addressMap.containsKey(person.address())) {
            addressMap.put(person.address(), new ArrayList<>());
        }
        if (!phoneMap.containsKey(person.phoneNumber())) {
            phoneMap.put(person.phoneNumber(), new ArrayList<>());
        }

        personMap.put(person.id(), person);
        nameMap.get(person.name()).add(person.id());
        addressMap.get(person.address()).add(person.id());
        phoneMap.get(person.phoneNumber()).add(person.id());
    }

    @Override
    public synchronized void delete(int id) {
        Person currPerson = personMap.get(id);

        if (currPerson == null) {
            LOGGER.info("This person ain't exists");
            return;
        }

        var nameIds = new ArrayList<>(nameMap.get(currPerson.name()));
        var addressIds = new ArrayList<>(addressMap.get(currPerson.address()));
        var phoneIds = new ArrayList<>(phoneMap.get(currPerson.phoneNumber()));

        personMap.remove(id);

        nameMap.put(currPerson.name(), nameIds.stream().filter(a -> a != currPerson.id()).toList());
        addressMap.put(currPerson.address(), addressIds.stream().filter(a -> a != currPerson.id()).toList());
        phoneMap.put(currPerson.phoneNumber(), phoneIds.stream().filter(a -> a != currPerson.id()).toList());
    }

    @Override
    public synchronized List<Person> findByName(String name) {
        List<Person> personsWithThisName = new ArrayList<>();
        List<Integer> ids = nameMap.get(name);
        for (Integer id : ids) {
            personsWithThisName.add(personMap.get(id));
        }
        return personsWithThisName;
    }

    @Override
    public synchronized List<Person> findByAddress(String address) {
        List<Person> personsWithThisAddress = new ArrayList<>();
        List<Integer> ids = addressMap.get(address);
        for (Integer id : ids) {
            personsWithThisAddress.add(personMap.get(id));
        }
        return personsWithThisAddress;
    }

    @Override
    public List<Person> findByPhone(String phone) {
        List<Person> personsWithThisPhone = new ArrayList<>();
        List<Integer> ids = phoneMap.get(phone);
        for (Integer id : ids) {
            personsWithThisPhone.add(personMap.get(id));
        }
        return personsWithThisPhone;
    }
}
