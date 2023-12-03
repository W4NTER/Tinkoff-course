package edu.hw7.Task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class CashingData implements PersonDatabase{
    private final Map<Integer, Person> personMap;
    private final Map<Integer, String> nameIndex;
    private final Map<Integer, String> addressIndex;
    private final Map<Integer, String> phoneNumberIndex;

    public CashingData(){
        this.personMap = new HashMap<>();
        this.nameIndex = new HashMap<>();
        this.addressIndex = new HashMap<>();
        this.phoneNumberIndex = new HashMap<>();
    }

    @Override
    public synchronized void add(Person person) {
        personMap.put(person.id(), person);
        nameIndex.put(person.id(), person.name());
        addressIndex.put(person.id(), person.address());
        phoneNumberIndex.put(person.id(), person.phoneNumber());
    }

    @Override
    public synchronized void delete(int id) {
        Person person = personMap.remove(id);
        if (person != null) {
            nameIndex.remove(person.id());
            addressIndex.remove(person.id());
            phoneNumberIndex.remove(person.id());
        }
    }

    @Override
    public synchronized List<Person> findByName(String name) {
        if (nameIndex.containsValue(name)) {
            return new ArrayList<>(personMap.get(nameIndex.);
        }
        return new ArrayList<>();
    }

    @Override
    public synchronized List<Person> findByAddress(String address) {
        if (addressIndex.containsKey(address)) {
            return new ArrayList<>(personMap.values());
        }
        return new ArrayList<>();
    }

    @Override
    public synchronized List<Person> findByPhone(String phone) {
        if (phoneNumberIndex.containsKey(phone)) {
            return new ArrayList<>(personMap.values());
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        Person person = new Person(1, "name", "Pushkina", "8800");
        Person person2 = new Person(2, "Sanya", "Pushkina1", "8800");
        Person person3 = new Person(3, "Hui", "Pushkina2", "8800");
        Person person4 = new Person(4, "Sos", "Pushkina3", "8800");
        Person person1 = new Person(5, "name1", "Pushkina2", "88001");
        CashingData data = new CashingData();
        data.add(person);
        data.add(person1);
        data.add(person2);
        data.add(person3);
        data.add(person4);

        data.delete(4);
        System.out.println(data.findByName("name1"));
        System.out.println(data.findByAddress("Pushkina2"));
        System.out.println(data.findByPhone("88001"));
    }
}
