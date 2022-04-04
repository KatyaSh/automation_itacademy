package logic;

import pojo.User;
import repository.UsersRepository;

import java.sql.SQLException;

public class UserService {
   UsersRepository usersRepository = new UsersRepository();

   public User createUser(User user) throws SQLException {
       User existingUser = usersRepository.selectUserDataByName(user.getName());
       if(existingUser != null){
           throw new IllegalArgumentException("Пользователь с таким именем уже существует. Введите новое имя пользователя:");
       }
       usersRepository.insertUser(user);
       return getUserDataByName(user.getName());
   }

   public User getUserDataByName(String name) throws SQLException {
       User existingUser = usersRepository.selectUserDataByName(name);
       if(existingUser == null){
           throw new IllegalArgumentException("Пользователя с таким именем не существует. Пройдите регистрацию.");
       }
       return existingUser;
   }

}
