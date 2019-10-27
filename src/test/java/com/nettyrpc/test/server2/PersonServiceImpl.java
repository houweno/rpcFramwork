package com.nettyrpc.test.server2;

import com.nettyrpc.server.RpcService;
import com.nettyrpc.test.client.PersonService;
import com.nettyrpc.test.client.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by houwenbo
 */
@RpcService(PersonService.class)
public class PersonServiceImpl implements PersonService {

    @Override
    public List<Person> GetTestPerson(String name, int num) {
        List<Person> persons = new ArrayList<>(num);
        for (int i = 0; i < num; ++i) {
            persons.add(new Person(Integer.toString(i), name));
        }
        return persons;
    }
}
