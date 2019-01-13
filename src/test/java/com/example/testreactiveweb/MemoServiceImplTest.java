package com.example.testreactiveweb;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemoServiceImplTest {

    @Autowired
    private MemoService memoService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void list() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void save() {

    }

    @Test
    public void deleteById() {
    }

    @Test
    public void delete() {
    }
}
