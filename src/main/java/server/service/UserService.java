package server.service;
import server.entity.User;

public interface UserService {

    User getUser(String login);

}