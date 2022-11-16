package org.auctionsense.service;

import java.math.BigDecimal;

import javax.inject.Inject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;

@QuarkusTest
public class BalanceServiceTest {
    @Inject
    BalanceService balanceService;

    @Test
    @TestSecurity(user = "alice@gmail.com", roles = "user")
    public void When_Get_Balance_Fails_Because_Token_And_Email_Arent_From_The_Same_User()
    {
        // Arrange
        String email = "admin@gmail.com";

        // Act
        String message = balanceService.getBalanceByEmail(email);

        // Assert
        Assertions.assertEquals("{\"message\": \"User and token aren't correct.\"}", message);
    }

    @Test
    public void When_Put_Balance_Fails_Because_User_Doesnt_Exists()
    {
        // Arrange
        String email = "test@gmail.com";
        BigDecimal amount = new BigDecimal(15);

        // Act
        String message = balanceService.UpdateBalance(email, amount);

        // Assert
        Assertions.assertEquals("{\"message\": \"User doesn't exist.\"}", message);
    }

    @Test
    @TestSecurity(user = "alice@gmail.com", roles = "user")
    public void When_Put_Balance_Fails_Because_Token_And_Email_Arent_From_The_Same_User()
    {
        // Arrange
        String email = "admin@gmail.com";
        BigDecimal amount = new BigDecimal(15);

        // Act
        String message = balanceService.UpdateBalance(email, amount);

        // Assert
        Assertions.assertEquals("{\"message\": \"User and token aren't correct.\"}", message);
    }

    @Test
    @TestSecurity(user = "alice@gmail.com", roles = "user")
    public void When_Put_Balance_Fails_Because_Value_Is_Invalid()
    {
        // Arrange
        String email = "alice@gmail.com";
        BigDecimal amountToLow = new BigDecimal(9);
        BigDecimal amountToHigh = new BigDecimal(1001);

        // Act
        String messageToLow = balanceService.UpdateBalance(email, amountToLow);
        String messageToHigh = balanceService.UpdateBalance(email, amountToHigh);
        // Assert
        Assertions.assertEquals("{\"message\": \"Minimum amount is €10,- and maximum amount is €1000,-\"}", messageToLow);
        Assertions.assertEquals("{\"message\": \"Minimum amount is €10,- and maximum amount is €1000,-\"}", messageToHigh);
    }
}

