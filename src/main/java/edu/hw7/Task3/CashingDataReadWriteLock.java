package edu.hw7.Task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public class CashingDataReadWriteLock implements PersonDatabase {
    private final Map<Integer, Person> personMap = new HashMap<>();
    private final Map<String, List<Integer>> nameMap = new HashMap<>();
    private final Map<String, List<Integer>> addressMap = new HashMap<>();
    private final Map<String, List<Integer>> phoneMap = new HashMap<>();
    private final static Logger LOGGER = LogManager.getLogger();
    private final static ReentrantReadWriteLock LOCK = new ReentrantReadWriteLock();

    @Override
    public void add(Person person) {
        try {
            LOCK.writeLock().lock();
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
        } finally {
            LOCK.writeLock().unlock();
        }
    }

    @Override
    public void delete(int id) {
        try {
            LOCK.writeLock().lock();
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
        } finally {
            LOCK.writeLock().unlock();
        }
    }

    @Override
    public List<Person> findByName(String name) {
        try {
            LOCK.readLock().lock();
            return getPeople(name, nameMap);
        } finally {
            LOCK.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByAddress(String address) {
        try {
            LOCK.readLock().lock();
            return getPeople(address, addressMap);
        } finally {
            LOCK.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByPhone(String phone) {
        try {
            LOCK.readLock().lock();
            return getPeople(phone, phoneMap);
        } finally {
            LOCK.readLock().unlock();
        }
    }

    @NotNull private List<Person> getPeople(String address, Map<String, List<Integer>> map) {
        try {
            LOCK.readLock().lock();
            List<Person> personsWithThisAddress = new ArrayList<>();
            List<Integer> ids = map.get(address);
            if (ids == null) {
                return new ArrayList<>();
            }
            for (Integer id : ids) {
                personsWithThisAddress.add(personMap.get(id));
            }
            return personsWithThisAddress;
        } finally {
            LOCK.readLock().unlock();
        }
    }
}
