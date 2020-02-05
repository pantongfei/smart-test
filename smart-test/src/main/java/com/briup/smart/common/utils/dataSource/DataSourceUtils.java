package com.briup.smart.common.utils.dataSource;

import java.beans.PropertyVetoException;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class DataSourceUtils {
	/*
	 * public static DataSource first() { try { OracleConnectionPoolDataSource
	 * datasource = new OracleConnectionPoolDataSource();
	 * datasource.setURL("jdbc:mysql://localhost:3306/smart_sxnd");
	 * datasource.setUser("root"); datasource.setPassword("123456"); return
	 * datasource; } catch (SQLException e) { e.printStackTrace(); return null; } }
	 */

	public static DataSource getDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl("jdbc:mysql://47.102.205.67:3306/smart_sxnd?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8");
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("root");
		ds.setMaxIdle(5);
		ds.setMinIdle(3);
		ds.setMaxTotal(10);
		return ds;
	}
	/*
	 * public static DataSource third() { ComboPooledDataSource ds = null; try { ds
	 * = new ComboPooledDataSource();
	 * ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
	 * ds.setDriverClass("oracle.jdbc.OracleDriver"); ds.setUser("sxnd");
	 * ds.setPassword("sxnd"); ds.setMaxPoolSize(10); ds.setMinPoolSize(3);
	 * ds.setInitialPoolSize(5); } catch (PropertyVetoException e) {
	 * e.printStackTrace(); } return ds; }
	 */
	public static void main(String[] args) {
		DataSource ds = DataSourceUtils.getDataSource();
		System.out.println(ds);
	}

}
