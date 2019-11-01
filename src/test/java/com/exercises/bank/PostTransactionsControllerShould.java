package com.exercises.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PostTransactionsControllerShould {

    @Mock
    private PostTransactionService service;

    private PostTransactionsController controller;
    private Transaction transaction;

    @BeforeEach
    void setUp() {
        controller = new PostTransactionsController(service);
        transaction = Mockito.mock(Transaction.class);
    }

    @Test
    public void return_http_status_201_for_a_valid_transaction() {
        ResponseEntity<Void> expectedHttpStatusCode = controller.postTransaction(transaction);

        verify(service).storeTransaction(transaction);
        assertThat(expectedHttpStatusCode.getStatusCodeValue()).isEqualTo(201);
    }

    @Test
    public void return_http_status_204_for_a_non_valid_transaction() {
        doThrow(new NonValidTransactionException()).when(service).storeTransaction(transaction);

        ResponseEntity<Void> expectedHttpStatusCode = controller.postTransaction(transaction);

        assertThat(expectedHttpStatusCode.getStatusCodeValue()).isEqualTo(204);
    }
}
