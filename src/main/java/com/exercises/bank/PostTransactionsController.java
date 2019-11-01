package com.exercises.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
public class PostTransactionsController {
    private final PostTransactionService service;

    @Autowired
    public PostTransactionsController(PostTransactionService service) {
        this.service = service;
    }

    @PostMapping("transactions")
    public ResponseEntity<Void> postTransaction(@RequestBody Transaction transaction) {
        try {
            service.storeTransaction(transaction);

        } catch (NonValidTransactionException ex) {
            return new ResponseEntity<>(NO_CONTENT);
        }

        return new ResponseEntity<>(CREATED);
    }
}
