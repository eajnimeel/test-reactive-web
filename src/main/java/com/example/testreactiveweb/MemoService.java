package com.example.testreactiveweb;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MemoService {

    Flux<Memo> list();

    Mono<Memo> findById(Long id);

    Mono<Memo> save(Memo memo);

    void deleteById(Long id);

    void delete(Memo memo);
}
