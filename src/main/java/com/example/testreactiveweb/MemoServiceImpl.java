package com.example.testreactiveweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.stream.Stream;

@Service
public class MemoServiceImpl implements MemoService {

    private MemoRepository repository;

    @Autowired
    public MemoServiceImpl(MemoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<Memo> list() {
        Iterable<Memo> all = repository.findAll();

//        return Flux.fromIterable(all).log();
        return Flux.fromIterable(all).subscribeOn(Schedulers.elastic())
                .log();
    }

    @Override
    public Mono<Memo> findById(Long id) {
//        return Mono.justOrEmpty(repository.findById(id));
        return Mono.fromCallable(() -> repository.findById(id).get())
                .subscribeOn(Schedulers.elastic())
                .log();
    }

    @Override
    public Mono<Memo> save(Memo memo) {
        return Mono.fromCallable(() -> repository.save(memo))
                .subscribeOn(Schedulers.elastic())
                .log();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(Memo memo) {
        repository.delete(memo);
    }
}
