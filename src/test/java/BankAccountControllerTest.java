import org.example.controller.BankAccountController;
import org.example.repository.BankAccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BankAccountControllerTest {

    private BankAccountRepository bankAccountRepositoryMock;
    private BankAccountController bankAccountControllerMock;

    @BeforeEach
    public void setUp() {
        bankAccountRepositoryMock = mock(BankAccountRepository.class);
        bankAccountControllerMock = new BankAccountController(bankAccountRepositoryMock);
    }

    @Test
    @DisplayName("Deve retornar true ao criar uma nova conta bancária")
    public void testRegisterBankAccountisTrue() {
        when(bankAccountRepositoryMock.registerNewBankAccount("654782", 10000.00, 7)).thenReturn(true);
        boolean rst = bankAccountControllerMock.registerNewBankAccount("654782", 10000.00, 7);
        assertTrue(rst);
    }

    @Test
    @DisplayName("Deve retornar false ao criar uma nova conta bancária")
    public void testRegisterBankAccountisFalse() {
        when(bankAccountRepositoryMock.registerNewBankAccount("654782", 10000.00, 7)).thenReturn(false);
        boolean rst = bankAccountControllerMock.registerNewBankAccount("654782", 10000.00, 7);
        assertFalse(rst);
    }

    @Test
    @DisplayName("Deve retornar true ao deletar uma conta bancária")
    public void testDeleteBankAccountisTrue() {
        when(bankAccountRepositoryMock.deleteBankAccount("654782")).thenReturn(true);
        boolean rst = bankAccountControllerMock.deleteBankAccount("654782");
        assertTrue(rst);
    }

    @Test
    @DisplayName("Deve retornar false ao deletar uma conta bancária")
    public void testDeleteBankAccountisFalse() {
        when(bankAccountRepositoryMock.deleteBankAccount("654782")).thenReturn(false);
        boolean rst = bankAccountControllerMock.deleteBankAccount("654782");
        assertFalse(rst);
    }

    @Test
    @DisplayName("Deve retornar true ao passar o numero da conta para mostrar o saldo")
    public void testShowBalanceisTrue() {
        when(bankAccountRepositoryMock.showBalance("524869")).thenReturn(true);
        boolean result = bankAccountControllerMock.showBalance("524869");
        assertTrue(result);
    }

    @Test
    @DisplayName("Deve retornar false ao passar o numero da conta para mostrar o saldo")
    public void testShowBalanceisFalse() {
        when(bankAccountRepositoryMock.showBalance("524869")).thenReturn(false);
        boolean result = bankAccountControllerMock.showBalance("524869");
        assertFalse(result);
    }

    @Test
    @DisplayName("Deve retornar true ao passar o id do Cliente para mostrar as contas pertencentes")
    public void testShowAccountCustomersisTrue() {
        when(bankAccountRepositoryMock.showAccountCustomers(6)).thenReturn(true);
        boolean result = bankAccountControllerMock.showAccountCustomers(6);
        assertTrue(result);
    }

    @Test
    @DisplayName("Deve retornar false ao passar o id do Cliente para mostrar as contas pertencentes")
    public void testShowAccountCustomersisFalse() {
        when(bankAccountRepositoryMock.showAccountCustomers(6)).thenReturn(false);
        boolean result = bankAccountControllerMock.showAccountCustomers(6);
        assertFalse(result);
    }

    @Test
    @DisplayName("Deve subtrarir e retornar true ")
    public void testUpdateBalanceOriginAccountAfterTransactionisTrue() {
        when(bankAccountRepositoryMock.updateBalanceSubstract(5, 70.00)).thenReturn(true);
        boolean rst = bankAccountControllerMock.updateBalanceSubstract(5, 70.00);
        assertTrue(rst);
    }

    @Test
    @DisplayName("Deve subtrarir e retornar false ")
    public void testUpdateBalanceOriginAccountAfterTransactionisFalse() {
        when(bankAccountRepositoryMock.updateBalanceSubstract(5, 70.00)).thenReturn(false);
        boolean rst = bankAccountControllerMock.updateBalanceSubstract(5, 70.00);
        assertFalse(rst);
    }

    @Test
    @DisplayName("Deve adicionar e retornar true ")
    public void testupdateBalanceDestinyAccountAfterTransactionisTrue() {
        when(bankAccountRepositoryMock.updateBalanceAdd(5, 70.00)).thenReturn(true);
        boolean rst = bankAccountControllerMock.updateBalanceAdd(5, 70.00);
        assertTrue(rst);
    }

    @Test
    @DisplayName("Deve adicionar e retornar false ")
    public void testupdateBalanceDestinyAccountAfterTransactionisFalse() {
        when(bankAccountRepositoryMock.updateBalanceAdd(5, 70.00)).thenReturn(false);
        boolean rst = bankAccountControllerMock.updateBalanceAdd(5, 70.00);
        assertFalse(rst);
    }


}
