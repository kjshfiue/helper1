package com.helper.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	
	private Connection conn=null;
	private PreparedStatement pstm=null;
	private ResultSet rs=null;
	private final static String URL="jdbc:oracle:thin:@localhost:1521:orcl";
	private final static String USER="k24";
	private final static String PWD="a1234";
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		try {
			conn=DriverManager.getConnection(URL,USER,PWD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public int executeUpdate(String sql,Object[] paramValues){
		conn=this.getConnection();
		int ret=0;
		try {
			pstm=conn.prepareStatement(sql);
			if(paramValues!=null){
				for(int i=0;i<paramValues.length;i++){
					pstm.setObject(i+1, paramValues[i]);
				}
			}
			ret=pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret=-1;
		}finally{
			this.closeStatement();
		}
		return ret;
	}
	
	public int executeUpdate(String sql){
		return this.executeUpdate(sql, null);	 
	}
	public ResultSet executeQuery(String sql){
		
		return executeQuery(sql,null);
	}
	
	public ResultSet executeQuery(String sql,Object param){
		return executeQuery(sql,new Object[]{param});
	}
	
	public ResultSet executeQuery(String sql,Object[] paramValues){
		conn=this.getConnection();
		try {
			pstm=conn.prepareStatement(sql);
			if(paramValues!=null){
				for(int i=0;i<paramValues.length;i++){
					pstm.setObject(i+1,paramValues[i]);
				}
			}
			rs=pstm.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return rs;
	}
	public void closeStatement(){
		try {
			if(pstm!=null)pstm.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 两种方法，法一
	 * @param sql
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public  ResultSet executeQueryForPage(String sql,int pageNo,int pageSize){
		String pageSql="select * from (select rownum r,x.* " +
				"from (";
			pageSql+=sql+") x where rownum<=?) where r>?";
		return this.executeQuery(pageSql, new Object[]{pageNo*pageSize,
				(pageNo-1)*pageSize});
			
	}
	/**
	 * 两种方法，法二
	 * @param sql
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public  ResultSet executeQueryForPage(String sql,Object[] params){		
		String pageSql="select * from (select rownum r,x.* " +
				"from (";
			pageSql+=sql+") x where rownum<=?) where r>?";
		return this.executeQuery(pageSql, params);
	}
	//返回新产生的id
	public int executeQueryForNewId(String sql){
		
		ResultSet rs=this.executeQuery(sql);
		int newId=0;
		try {
			if(rs.next()){
				newId=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.closeAll();
		}
		return newId;
		
	}
	//计算记录数
	public int executeTotalCount(String sql){
		return executeTotalCount(sql,null);
	}
	//计算记录数
	public int executeTotalCount(String sql,Object[] params){
		rs=this.executeQuery(sql,params);
		int total=0;
		try {
			if(rs.next()){
				total=rs.getInt("count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return total;
	}
	public void closeAll(){
		
		try {
			if(rs!=null)rs.close();
			if(pstm!=null)pstm.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
