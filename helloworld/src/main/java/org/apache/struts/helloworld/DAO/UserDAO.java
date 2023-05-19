package org.apache.struts.helloworld.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
	
	public void saveUser(String name) {
        try {
            // PostgreSQL JDBCドライバのクラスをロード
            Class.forName("org.postgresql.Driver");

            try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "tatu0930")) {
                String insertQuery = "INSERT INTO users1 (name) VALUES (?)";
                try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
                    statement.setString(1, name);
                    statement.executeUpdate();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // 例外処理の方法によって適切な例外やエラーコードを返すことができます
        }
    }

}
