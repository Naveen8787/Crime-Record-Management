package services;

import model.User;

public interface UserDaoInterface {
	int signUp(User user) throws ClassNotFoundException;
	boolean loginUser(User user);
}
