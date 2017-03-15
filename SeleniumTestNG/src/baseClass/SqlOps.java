package baseClass;
import java.sql.*;

import inf.Infos;

public class SqlOps {
	String className;
	String jdbcUrl;
	String username;
	String password;
	String sql;
	ResultSet result;
	String dbType;
	
	public void SetProperties(String className, String jdbcUrl, String username, String password, String sql) {
		this.className = className;
		this.jdbcUrl = jdbcUrl;
		this.username = username;
		this.password = password;
		this.sql = sql;
	}
	
	public SqlOps() {
		this.jdbcUrl = Infos.jdbcUrl;
		this.username = Infos.dbUsername;
		this.password = Infos.dbPassword;
	}

	public ResultSet executeSql(){
		try {
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn;
		try {
			conn = DriverManager.getConnection(jdbcUrl,username,password);
			Statement stmt = conn.createStatement();
			result = stmt.executeQuery(sql);
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public ResultSet executeSql(String dbType,String sql){
		switch(dbType){
			case "mysql":
				className = Infos.mysqlDriver;
				break;
			case "postgresql":
				className = Infos.postgresqlDriver;
				break;
			case "oracle":
				className = Infos.oracleDriver;
				break;
			default:
				System.out.println("sql type:mysql/postgresql/oracle");
		}
		username = Infos.dbUsername;
		password = Infos.dbPassword;
		jdbcUrl = Infos.jdbcUrl;
		try {
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn;
		try {
			conn = DriverManager.getConnection(jdbcUrl,username,password);
			Statement stmt = conn.createStatement();
			result = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getJdbcUrl() {
		return jdbcUrl;
	}

	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	public ResultSet getResult() {
		return result;
	}
}
