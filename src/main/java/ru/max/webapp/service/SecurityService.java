package ru.max.webapp.service;

/**
 * @author Serov Maxim
 */
public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
