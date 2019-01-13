package com.example.testreactiveweb;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemoRepository extends CrudRepository<Memo, Long> {
}
