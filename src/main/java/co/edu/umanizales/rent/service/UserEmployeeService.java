package co.edu.umanizales.rent.service;

import org.springframework.stereotype.Service;

@Service
public class UserEmployeeService {

    public boolean loginValidate(String userName, String password) {
        return userName.equals("user") && password.equals("1234");
    }

    public boolean loginValidateAdmin(String userName, String password) {
        return userName.equals("admin") && password.equals("admin123");
    }
}
