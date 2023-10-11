package tobyspring.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tobyspring.helloboot.HellobootApplication;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@HellobootTest
public class DataSourceTest {
    @Autowired
    DataSource dataSource;

    @DisplayName("")
    @Test
    void connect() throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.close();
    }
}
