package com.insight68taf.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

/**
 * This class is used to get the database connection object to interact with the
 * database
 * 
 * @author Yugendhar Utkam
 */
public class DatabaseConnection {

	private static DatabaseConnection instance;
	private Connection connection;
	private ResultSet resultSet;
	private static final Logger logger = Logger.getLogger(DatabaseConnection.class);

	/**
	 * This is used to get the database connection by giving the values from
	 * property file
	 * 
	 * @throws SQLException
	 */
	public DatabaseConnection() {
		try {
			PropertyFileLoader configProperty = PropertyFileLoader.getConfigInstance();
			Class.forName(configProperty.getConfigValue("jdbcDriver"));
			this.connection = DriverManager.getConnection(configProperty.getConfigValue("dbUrl"),
					configProperty.getConfigValue("user"), configProperty.getConfigValue("password"));
			logger.info("Database connection instance created");
		} catch (ClassNotFoundException ex) {
			logger.error("DatabaseConnection:: Database Connection ClassNotFoundException : " + ex.getMessage());
		} catch (Exception ex) {
			logger.error("DatabaseConnection:: Database Connection failed  : " + ex.getMessage());
		}
	}

	/**
	 * This is used to get the instance of the configured database, instance will
	 * create if it null, other wise return existed instance.
	 * 
	 * @return DatabaseConnection instance
	 * @throws SQLException
	 */
	public static DatabaseConnection getInstance() {
		try {
			if (instance == null) {
				instance = new DatabaseConnection();
			} else if (instance.getConnection().isClosed()) {
				instance = new DatabaseConnection();
			}
		} catch (SQLException e) {
			logger.error("SQLException:: getInstance:: " + e.getMessage());
		} catch (Exception e) {
			logger.error("Exception:: getInstance:: " + e.getMessage());
		}
		return instance;
	}

	/**
	 * This is used to get the connection instance to connect the database tables
	 * 
	 * @return
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 * This method is used to get the resultSet object for the given query
	 * 
	 * @param query
	 *            as string
	 * @return
	 */
	public ResultSet getResultSet(String query) {
		try {
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(query);

		} catch (SQLException e) {
			logger.error("SQLException:: getResultSet:: " + e.getMessage());
		} catch (Exception e) {
			logger.error("Exception:: getResultSet:: " + e.getMessage());
		}
		return resultSet;
	}

	public void validateResult() {
		try {
			while (resultSet.next()) {
				System.out.println(resultSet.getInt("empid") + "  " + resultSet.getString("empname") + " "
						+ resultSet.getInt("empsalary"));
				// Assert.assertEquals(myName,name);
			}
		} catch (SQLException e) {
			logger.error("SQLException:: validateResult:: " + e.getMessage());
		} catch (Exception e) {
			logger.error("Exception:: validateResult:: " + e.getMessage());
		}
	}

	/**
	 * This method is used to close the DataBase connection
	 */
	public void closeConnection() {
		try {
			if (connection != null && !connection.isClosed())
				connection.close();
		} catch (Exception e) {
			logger.error("Exception:: closeConnection:: " + e.getMessage());
		}
	}

	/**
	 * Execute static SQL query statement. It returns ResultSet object if
	 * successful, otherwise returns null.
	 **/
	public ResultSet getResultByQuery(String sql) {
		ResultSet resultSet = null;
		if (sql == null || sql.isEmpty()) {
			logger.error("Query empty or null :: getResultByQuery ");
			return resultSet;
		}

		try (Connection conn = getInstance().getConnection()) {
			Statement statement = conn.createStatement();
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			logger.error("SQLException:: getResultByQuery:: " + e.getSQLState() + ": " + e.getMessage());
		} catch (Exception e) {
			logger.error("SQLException:: getResultByQuery:: " + e.getMessage());
		}
		return resultSet;
	}

	/**
	 * Execute static SQL update statement. It returns 0 or # of rows are changed if
	 * successful, otherwise returns -1.
	 * 
	 * @param sql
	 * @return
	 */
	public int updateAndDelete(String sql) {
		int result = -1;
		if (sql == null || sql.isEmpty()) {
			logger.error("Query empty or null :: update ");
			return result;
		}

		try (Connection conn = getInstance().getConnection()) {
			Statement statement = conn.createStatement();
			result = statement.executeUpdate(sql);
		} catch (SQLException e) {
			logger.error("SQLException:: update:: " + e.getSQLState() + ": " + e.getMessage());
		} catch (Exception e) {
			logger.error("SQLException:: update:: " + e.getMessage());
		}
		return result;
	}

}