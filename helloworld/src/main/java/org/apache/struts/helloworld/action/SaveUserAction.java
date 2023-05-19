package org.apache.struts.helloworld.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

public class SaveUserAction extends ActionSupport{

	
	private String name; // ユーザー名

    public String execute() {
    	
        try {
            // PostgreSQL JDBCドライバのクラスをロード
            Class.forName("org.postgresql.Driver");
            
            try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "tatu0930")) {
                String insertQuery = "INSERT INTO users1 (name) VALUES (?)";
                try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
                    statement.setString(1, name);
                    statement.executeUpdate();
                }
                return SUCCESS;
                
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    // nameのセッター
    public void setName(String name) {
        this.name = name;
    }
}
