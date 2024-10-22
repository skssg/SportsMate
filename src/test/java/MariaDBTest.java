import org.junit.Test;
import org.mariadb.jdbc.Connection;

import java.sql.DriverManager;

/**
 * packageName    : com.sportsmate
 * fileName       : MariaDBTest
 * author         : jun
 * date           : 2024. 10. 18.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 10. 18.        jun       최초 생성
 */

public class MariaDBTest {
    private static final String DRIVER = "org.mariadb.jdbc.Driver";

    private static final String URL = "jdbc:mariadb://localhost:3306/SPORTSMATE";

    private static final String USER = "SPORTSMATE";
    private static final String PW = "SPORTSMATE";

    @Test
    public void testConnection() throws Exception {
        Class.forName(DRIVER);
        try (Connection con = (Connection) DriverManager.getConnection(URL, USER, PW)){
            System.out.println(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
