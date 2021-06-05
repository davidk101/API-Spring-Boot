package com.example.api.dao;

import com.example.api.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

// instantiate to inject into classes
@Repository("fakeDAO")
public class FakePersonDataAccessService implements PersonDAO {

    private static List<Person> DB = new ArrayList<Person>();

    @Override
    public int insertPerson(UUID id, Person person) {

        DB.add(new Person(id, person.getName()));
        return 0;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {

        Optional<Person> personMaybe = selectPersonById(id);

        if (personMaybe.isPresent()){
            DB.remove(personMaybe.get());
            return 1;
        }
        else {
            return 0;
        }
    }

    @Override
    public int updatePersonById(UUID id, Person update) {
        return selectPersonById(id).map(person -> { // select the person and map the person to 0 or 1
            int indexOfPersonToUpdate = DB.indexOf(person);

            if (indexOfPersonToUpdate >= 0){

                DB.set(indexOfPersonToUpdate, new Person(id, update.getName())); // set the contents of that person found to the new person from the client
                return 1;
            }
            else{
                return 0;
            }
        }).orElse(0);
    }

}
