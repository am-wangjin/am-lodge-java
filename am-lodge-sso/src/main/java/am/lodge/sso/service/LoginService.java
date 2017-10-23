package am.lodge.sso.service;

import am.lodge.sso.model.LoginTicket;

/**
 * @author am
 */
public interface LoginService {

  LoginTicket login(String loginName, String password);
}
