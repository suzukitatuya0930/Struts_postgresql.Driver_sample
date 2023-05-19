package org.apache.struts.helloworld.action;

import org.apache.struts.helloworld.DAO.UserDAO;
import org.apache.struts.helloworld.DTO.UserDTO;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction  extends ActionSupport{
	
	private UserDTO userDTO;

    // userDTOのgetter
    public UserDTO getUserDTO() {
        return userDTO;
    }

    // userDTOのsetter
    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public String execute() {
        if (userDTO != null) {
            UserDAO userDAO = new UserDAO();
            userDAO.saveUser(userDTO.getName());
            return SUCCESS;
        } else {
            return ERROR;
        }
    }


}
