package ru.skypro.homework.service;

import ru.skypro.homework.dto.Role;
import ru.skypro.homework.entity.User;

import java.util.Collection;

/**
 * Сервис для работы с пользователем
 */
public interface UserService {

    /**
     * Создание пользователя
     *
     * @param user Объект пользователя
     * @return User Созданный пользователь
     */
    User createUser(User user);

    /**
     * Получение всех существующих пользователей
     *
     * @return Collection<User>
     */
    Collection<User> getUsers();

    /**
     * Изменение пользователя
     *
     * @param updatedUser Объект пользователя с новыми данными
     * @return User Изменённый пользователь
     */
    User updateUser(User updatedUser);

    /**
     * Получение пользователя по ID
     *
     * @param id ID пользователя
     * @return User с данным ID
     */
    User getUserById(long id);

    /**
     * Изменение пароля пользователя
     *
     * @param newPassword     новый пароль
     * @param currentPassword старый пароль
     */
    void newPassword(String newPassword, String currentPassword);


    /**
     * Изменение роли пользователя
     *
     * @param id   идентификатор пользователя
     * @param role новая роль
     */
    User updateRole(long id, Role role);
}
