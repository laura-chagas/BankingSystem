import org.example.repository.CustomerRepository;
import org.example.controller.CustomerController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomerControllerTest {
    private CustomerRepository customerRepositoryMock;
    private CustomerController customerControllerMock;

    @BeforeEach
    public void setUp() {
        customerRepositoryMock = mock(CustomerRepository.class);
        customerControllerMock = new CustomerController(customerRepositoryMock);
    }

    @DisplayName("Deve retornar true ao fazer login")
    @Test
    void testLoginisTrue(){
        when(customerRepositoryMock.logIn("74185269325")).thenReturn(true);

        boolean rst = customerControllerMock.logIn("74185269325");

        assertTrue(rst);
    }


    @DisplayName("Deve retornar false ao fazer login")
    @Test
    void testLoginisFalse(){
        when(customerRepositoryMock.logIn("74185269325")).thenReturn(false);

        boolean rst = customerControllerMock.logIn("74185269325");

        assertFalse(rst);
    }

    @Test
    @DisplayName("Deve retornar true ao criar um novo cliente")
    public void testRegisterCustomerisTrue(){
        when(customerRepositoryMock.registerNewCustomer("Donizete", "349.546.950-82", "Rua Lorem Ipsum, 616")).thenReturn(true);
        boolean rst = customerControllerMock.registerNewCustomer("Donizete", "349.546.950-82", "Rua Lorem Ipsum, 616");
        assertTrue(rst);
    }

    @Test
    @DisplayName("Deve retornar false ao criar um novo cliente")
    public void testRegisterCustomerisFalse(){
        when(customerRepositoryMock.registerNewCustomer("Donizete", "349.546.950-82", "Rua Lorem Ipsum, 616")).thenReturn(false);
        boolean rst = customerControllerMock.registerNewCustomer("Donizete", "349.546.950-82", "Rua Lorem Ipsum, 616");
        assertFalse(rst);
    }

    @Test
    @DisplayName("Deve retornar true ao deletar um cliente")
    public void testDeleteCustomerisTrue(){
        when(customerRepositoryMock.deleteCustomer("123-456-789-10")).thenReturn(true);
        boolean rst = customerControllerMock.deleteCustomer("123-456-789-10");
        assertTrue(rst);
    }

    @Test
    @DisplayName("Deve retornar false ao deletar um cliente")
    public void testDeleteCustomerisFalse(){
        when(customerRepositoryMock.deleteCustomer("123-456-789-10")).thenReturn(false);
        boolean rst = customerControllerMock.deleteCustomer("123-456-789-10");
        assertFalse(rst);
    }

    @Test
    @DisplayName("Deve retornar true ao alterar o endereço de um cliente")
    public void testChangeAddressCustomerisTrue(){
        when(customerRepositoryMock.changeAddress("123-456-789-10", "Rua Random, 452")).thenReturn(true);
        boolean rst = customerControllerMock.changeAddress("123-456-789-10", "Rua Random, 452");
        assertTrue(rst);
    }

    @Test
    @DisplayName("Deve retornar false ao alterar o endereço de um cliente")
    public void testChangeAddressCustomerisFalse(){
        when(customerRepositoryMock.changeAddress("123-456-789-10", "Rua Random, 452")).thenReturn(false);
        boolean rst = customerControllerMock.changeAddress("123-456-789-10", "Rua Random, 452");
        assertFalse(rst);
    }

}
