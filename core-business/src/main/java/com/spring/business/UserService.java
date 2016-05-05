package com.spring.business;


import com.spring.dto.UserDTO;
import org.hibernate.DuplicateMappingException;
import org.hibernate.ObjectNotFoundException;

/**
 * Created with IntelliJ IDEA.
 * User: vietquocpham
 * Date: 4/21/16
 * Time: 14:43
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {
    UserDTO findById(Long userId) throws ObjectNotFoundException;

    UserDTO findByUserName(String userName) throws ObjectNotFoundException;

    UserDTO fetchByTerm(String admin) throws ObjectNotFoundException;

    void saveAndEncodePassword(UserDTO dto);
}
