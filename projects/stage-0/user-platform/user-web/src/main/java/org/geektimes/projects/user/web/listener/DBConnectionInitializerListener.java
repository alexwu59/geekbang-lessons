package org.geektimes.projects.user.web.listener;

import org.geektimes.projects.user.repository.DatabaseUserRepository;
import org.geektimes.projects.user.repository.UserRepository;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.projects.user.service.UserServiceImpl;
import org.geektimes.projects.user.sql.DBConnectionManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebListener
public class DBConnectionInitializerListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        try {
            InitialContext initialContext = new InitialContext();
            Context context = (Context)initialContext.lookup("java:comp/env");
            DataSource dataSource = (DataSource)context.lookup("jdbc/UserPlatformDB");
            DBConnectionManager dbConnectionManager = new DBConnectionManager();
            dbConnectionManager.setConnection(dataSource.getConnection());
            initDb(dataSource.getConnection());
            ServletContext servletContext = sce.getServletContext();
            UserRepository userRepository = new DatabaseUserRepository(dbConnectionManager);
            UserService userService = new UserServiceImpl(userRepository);

            servletContext.setAttribute("userService",userService);
            servletContext.setAttribute("userRepository",userRepository);



        }catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    private void initDb(Connection connection) throws SQLException{
        Statement statement = connection.createStatement();
        try {
            statement.execute(DBConnectionManager.CREATE_USERS_TABLE_DDL_SQL);
        }catch (SQLException e) {
            //请忽略表重复创建异常
            e.printStackTrace();
        }

    }
}
