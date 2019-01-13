package com.example.testreactiveweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class MemoController {

    private MemoService memoService;

    @Autowired
    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    @GetMapping("/")
    public String main() {
        return "main";
    }

    @GetMapping("/memo")
    public Flux<Memo> getList() {
        return memoService.list();
    }

    @GetMapping("/memo/{id}")
    public Mono<Memo> getMemoById(@PathVariable Long id) {
        return memoService.findById(id);
    }

    @PostMapping("/memo")
    public Mono<Memo> save(Memo memo) {
        return memoService.save(memo);
    }

    @DeleteMapping("/memo/{id}")
    public void delete(@PathVariable Long id) {
        memoService.deleteById(id);
    }
}
