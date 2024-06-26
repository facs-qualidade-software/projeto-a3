package mercadinho.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

import io.github.cdimascio.dotenv.Dotenv;

public class DbConexao {

    private DbConexao(){
        throw new IllegalStateException("Utility class only");
    }

    public static Connection conectar() throws SQLException {

//        Credenciais para rodar Banco de dados com arquivo .env local:
        Dotenv dotenv = Dotenv.load();
        String dbUrl = dotenv.get("MY_ENV_DBURL");
        String user = dotenv.get("MY_ENV_USER");
        String password = dotenv.get("MY_ENV_PASSWORD");

        try {

            return DriverManager.getConnection(dbUrl, user, password);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            Logger.getLogger("context", String.valueOf(e));
            return null;
        }
    }

}
