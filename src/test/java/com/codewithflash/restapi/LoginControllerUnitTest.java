package com.codewithflash.restapi;

import com.codewithflash.restapi.controllers.LoginController;
import com.codewithflash.restapi.processors.LoginProcessor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import  static  org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

@ExtendWith(MockitoExtension.class)
public class LoginControllerUnitTest {

    @Mock
    private Model model;
    @Mock
    private LoginProcessor loginProcessor;

    @InjectMocks
    private LoginController loginController;

    @Test
    public void loginPostLoginSuccessTest() {
        given(loginProcessor.login()).willReturn(true);

        String result = loginController.loginPost("username", "password", model);

        //verify if the method returns the expected return type
        assertEquals("redirect:/main",result);
    }

    @Test
    public void loginPostLoginFailTest() {

        given(loginProcessor.login()).willReturn(false);

        String result = loginController.loginPost("username", "password", model);
        assertEquals("login.html",result);
        verify(model).addAttribute("message" , "Login failed");

    }
}
