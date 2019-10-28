package com.nettyrpc.test.api;

import java.util.List;

/**
 * Created by houwenbo.
 */
public interface PersonService {
    List<Person> GetTestPerson(String name, int num);
}
