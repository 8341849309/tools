package com.nt.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.XMLLayout;

public class SelectTest2 {
	private static final Logger log = Logger.getLogger(SelectTest2.class);

	static {
		Layout layout = new XMLLayout();
		FileAppender appender = null;
		try {
			appender = new FileAppender(layout, "XmlLayout.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.addAppender(appender);
		log.setLevel(Level.ALL);

		log.info("Log4J is Ready...");
	}

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			// establish the connection (Road)
			con = DriverManager.getConnection("jdbc:mysql:///spring", "root", "root");
			log.warn("Connection esttablishing in Localhost");
			// create JDBC Statement object
			if (con != null) {
				st = con.createStatement();
				log.debug("Connection Established");
			}
			// Send and execute SQL SELECT Query in Db s/w and get JDBC ResultSet object
			if (st != null) {
				rs = st.executeQuery("SELECT  * FROM CRUD_EMPLOYEE");
			}

			if (rs != null) {
				// process the ResultSet object
				while (rs.next() != false) {
					// System.out.println(rs.getString(1) + " " + rs.getString(2) + " " +
					// rs.getString(3) + " "
					// + rs.getString(4));
					log.info(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "   "
							+ rs.getString(4));
				} // while
			} // if
		} // try
		catch (SQLException se) {
			se.printStackTrace();
			log.error(se);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e);
		} finally {
			// close jdbc objs
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (st != null)
					st.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		} // finally
		log.debug("Closing Main()");
	}

}
