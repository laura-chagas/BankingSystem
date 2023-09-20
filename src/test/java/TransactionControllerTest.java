
import org.example.controller.TransactionController;
import org.example.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TransactionControllerTest {
    private TransactionRepository transactionRepositoryMock;
    private TransactionController transactionControllerMock;

    @BeforeEach
    public void setUp() {
        transactionRepositoryMock = mock(TransactionRepository.class);
        transactionControllerMock = new TransactionController(transactionRepositoryMock);
    }

    @Test
    @DisplayName("Deve retornar true ao criar uma nova transação")
    public void testRegisterNewTransactionisTrue() {
        when(transactionRepositoryMock.registerNewTransaction("20/09/2023", 60.00, 1, 2)).thenReturn(true);

        boolean rst = transactionControllerMock.registerNewTransaction("20/09/2023", 60.00, 1, 2);

        assertTrue(rst);
    }

    @Test
    @DisplayName("Deve retornar false ao criar uma nova transação")
    public void testRegisterNewTransactionisFalse() {
        when(transactionRepositoryMock.registerNewTransaction("20/09/2023", 60.00, 1, 2)).thenReturn(false);

        boolean rst = transactionControllerMock.registerNewTransaction("20/09/2023", 60.00, 1, 2);

        assertFalse(rst);
    }

    @Test
    @DisplayName("Deve retornar true ao passar um id de origem e mostrar as suas transações ")
    public void testshowAllTransactionsofaSpecificAccountisTrue() {
        when(transactionRepositoryMock.showAllTransactionsofaSpecificAccount(2)).thenReturn(true);
        boolean result = transactionControllerMock.showAllTransactionsofaSpecificAccount(2);
        assertTrue(result);
    }

    @Test
    @DisplayName("Deve retornar false ao passar um id de origem e mostrar as suas transações ")
    public void testshowAllTransactionsofaSpecificAccountisFalse() {
        when(transactionRepositoryMock.showAllTransactionsofaSpecificAccount(2)).thenReturn(false);
        boolean result = transactionControllerMock.showAllTransactionsofaSpecificAccount(2);
        assertFalse(result);
    }


}
