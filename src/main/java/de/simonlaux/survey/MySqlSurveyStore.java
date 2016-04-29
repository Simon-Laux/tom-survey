package de.simonlaux.survey;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.UUID;

public class MySqlSurveyStore implements SurveyStore {
	private Connection con;
	private String dbName = "";
	private final String surveysTable = "CREATE TABLE `surveys` (`sid` int(11) NOT NULL AUTO_INCREMENT,`name` varchar(255) DEFAULT NULL,`desc` mediumtext,`UUID` tinytext,PRIMARY KEY (`sid`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;";
	private final String questionsTable = "CREATE TABLE `guestbook`.`questions` (`id` INT NOT NULL AUTO_INCREMENT,`name` TEXT(250) NULL,`Typ` VARCHAR(20) NULL,`sid` INT NOT NULL,PRIMARY KEY (`id`));";

	public MySqlSurveyStore(String dbHost, int port, String dbName, String benutzer, String pin)
			throws StoreInitException {
		try {
			this.dbName = dbName;
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://" + dbHost + ":" + port + "/" + dbName + "?" + "user="
					+ benutzer + "&" + "password=" + pin
					+ "&useUnicode=true&characterEncoding=UTF-8&useSSL=true&autoReconnect=true&failOverReadOnly=false&maxReconnects=3");
			System.out.println("SQL Verbindung geglückt!");
			if (con != null) {

				if (!checkForTable("surveys")) {
					createDB(surveysTable);
				}
				if (!checkForTable("questions")) {
					createDB(questionsTable);
				}
			} else {
				throw new StoreInitException("Fehler,Keine Verbindung zur Datenbank(1)");
			}
		} catch (StoreInitException e) {
			throw e;
		} catch (Exception e) {
			throw new StoreInitException("Fehler,Keine Verbindung zur Datenbank(0)", e);
		}
	}

	private void createDB(String sql) throws StoreInitException {
		try {
			Statement query;
			query = con.createStatement();
			query.executeUpdate(sql);
		} catch (SQLException e) {
			throw new StoreInitException("Fehler,Konnte die Tabelle nict erstellen\n alle Rechte richtig gesetzt?", e);
		}
	}

	private boolean checkForTable(String tableName) throws SQLException, StoreInitException {
		if (this.con != null) {
			Statement query;
			query = con.createStatement();

			String sql = "select * from INFORMATION_SCHEMA.TABLES where TABLE_NAME='" + tableName
					+ "' and TABLE_SCHEMA='" + dbName + "';";
			ResultSet result = query.executeQuery(sql);
			// int count = result.getInt("count");

			if (result.next()) {
				return true;

			} else {
				return false;
			}
		} else {
			throw new StoreInitException("Fehler,Keine Verbindung zur Datenbank");
		}
	}

	@Override
	public int add(Survey inhalt) {
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);
		try {
			java.sql.PreparedStatement rs = con.prepareStatement(
					"INSERT INTO `" + this.dbName + "`.`surveys`(`name`, `desc`,`UUID`) VALUES (?, ?, ?);");
			rs.setString(1, inhalt.getName());
			rs.setString(2, inhalt.getDescription());
			rs.setString(3, uuid);
			rs.executeUpdate();
			rs.close();
			Statement query = con.createStatement();
			String sql = "SELECT sid, UUID FROM " + dbName + ".surveys order by sid DESC";
			ResultSet result = query.executeQuery(sql);
			result.next();
			System.out.println(result.getString("UUID").equals(uuid));

			java.sql.PreparedStatement rc = con.prepareStatement(
					"INSERT INTO `" + this.dbName + "`.`surveys`(`name`, `desc`,`UUID`) VALUES (?, ?, ?);");
			rc.setString(1, inhalt.getName());
			rc.setString(2, inhalt.getDescription());
			rc.setString(3, uuid);
			rc.executeUpdate();
			rc.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public Survey getbyID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Survey> getAll(int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean close() {
		try {
			con.close();
			return con.isClosed();
		} catch (SQLException e) {
			return false;

		}
	}

}
