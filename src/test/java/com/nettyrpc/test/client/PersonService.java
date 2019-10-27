package com.nettyrpc.test.client;

import java.util.List;

/**
 * Created by houwenbo.
 */
public interface PersonService {
    List<Person> GetTestPerson(String name, int num);
}
