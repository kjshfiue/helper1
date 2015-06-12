package com.helper.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.helper.dao.BaseContentDao;
import com.helper.dao.BaseDao;
import com.helper.entity.BaseContent;
import com.helper.entity.PageBean;

public class BaseContentDaoImpl extends BaseDao implements BaseContentDao {

	@Override
	public int addBaseContent(BaseContent b) {
		// TODO Auto-generated method stub
		String sql = "insert into BaseContent values(?,?,?,?,?,?,sysdate,?,?,?,?)";
		Object[] array = new Object[]{b.getCode(),b.getCodeName(),b.getCategorycode(),b.getOrderNo(),
				b.getIsShow(),b.getRemarks(),b.getAddUser(),b.getAddUserName(),
				b.getAddIp(),b.getCompCode()};
		int ret = super.executeUpdate(sql, array);
		return ret;
	}

	@Override
	public int deleteByCode(String categorycode, String code) {
		// TODO Auto-generated method stub
		String sql = "delete from basecontent where categorycode=? and code=?";
		int ret = super.executeUpdate(sql, new Object[]{categorycode,code});
		return ret;
	}
	
	@Override
	public int deleteBatchByCode(List<HashMap<String,String>> list) {
		// TODO Auto-generated method stub
		
		int ret = 0;
		for(int i=0;i<list.size();i++){
			String categorycode = list.get(i).get("categorycode");
			String code = list.get(i).get("code");
			System.out.println("删除记录："+categorycode+","+code);
			ret = deleteByCode(categorycode, code);
		}
		return ret;
	}

	@Override
	public int updateByCode(String up_categorycode,String up_code,BaseContent bc) {
		// TODO Auto-generated method stub
		String sql = "update basecontent set code=?,codeName=?,categorycode=?,orderNo=?,isShow=?,remarks=?,addUser=?,addUserName=?,addIp=?,compCode=?,adddate=sysdate where categorycode=? and code=?";
		List<String> list = new ArrayList<String>();
		list.add(bc.getCode());
		list.add(bc.getCodeName());
		list.add(bc.getCategorycode());
		list.add(bc.getOrderNo());
		list.add(bc.getIsShow());
		list.add(bc.getRemarks());
		list.add(bc.getAddUser());
		list.add(bc.getAddUserName());
		list.add(bc.getAddIp());
		list.add(bc.getCompCode());
		list.add(up_categorycode);
		list.add(up_code);
		Object[] object = list.toArray();
		int ret = super.executeUpdate(sql, object);
		return ret;
	}

	@Override
	public PageBean findPageBean(int pageNo,int pageSize) {
		// TODO Auto-generated method stub
		return searchPageBean(pageNo, pageSize, new HashMap<String, String>());
		
//		String sql = "select * from basecontent order by categorycode";
//		ResultSet rs = super.executeQueryForPage(sql, pageNo, pageSize);
//		PageBean pageBean = null;
//		List<BaseContent> list = new ArrayList<BaseContent>();
//		BaseContent bc = null;
//		//System.out.println("开始获取数据");
//		try {
//			while(rs.next()){
//				bc = new BaseContent();
//				bc.setCode(rs.getString("code"));
//				bc.setCodeName(rs.getString("codename"));
//				bc.setCategoryco(rs.getString("CATEGORYCODE"));
//				bc.setOrderNo(rs.getString("orderNo"));
//				bc.setIsShow(rs.getString("isshow"));
//				bc.setRemarks(rs.getString("remarks"));
//				bc.setAddDate(new java.util.Date(rs.getTimestamp("adddate").getTime()));
//				bc.setAddUser(rs.getString("adduser"));
//				bc.setAddUserName(rs.getString("addusername"));
//				bc.setAddIp(rs.getString("addip"));
//				bc.setCompCode(rs.getString("compcode"));
//				list.add(bc);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if(list!=null){
//			String sql2 = "select count(*) count from basecontent";
//			int total = super.executeTotalCount(sql2);
//			pageBean = new PageBean();
//			pageBean.setTotal(total);
//			pageBean.setData(list);
//		}
//		return pageBean;
	}
	
	@Override
	public List<String> findCategoryCodes() {
		// TODO Auto-generated method stub
		String sql = "select categorycode from basecontent group by categorycode order by categorycode";
		ResultSet rs = super.executeQuery(sql);
		List<String> list = new ArrayList<String>();
		try {
			while(rs.next()){
				list.add(rs.getString("categorycode"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			super.closeAll();
		}
		return list;
	}

	@Override
	public PageBean searchPageBean(int pageNo, int pageSize, HashMap<String, String> map) {
		// TODO Auto-generated method stub
		String sql = "select * from basecontent where 1=1 ";
		List<Object> pstm = new ArrayList<Object>();
		if(map.size()>0){
			
			if(map.get("categorycode")!=null && map.get("categorycode")!=""){
				sql += " and categorycode=? ";
				pstm.add(map.get("categorycode"));
			}
			if(map.get("code")!=null && map.get("code")!=""){
				sql += " and code=? ";
				pstm.add(map.get("code"));
			}
			if(map.get("codeName")!=null && map.get("codeName")!=""){
				sql += " and codeName=? ";
				pstm.add(map.get("codeName"));
			}
		}
		Object[] object1 = pstm.toArray();
		sql += " order by categorycode,orderno";
		pstm.add(pageNo*pageSize);
		pstm.add((pageNo-1)*pageSize);
		Object[] object2 = pstm.toArray();
		ResultSet rs = super.executeQueryForPage(sql, object2);
		PageBean pageBean = null;
		List<BaseContent> list = new ArrayList<BaseContent>();
		BaseContent bc = null;
		System.out.println("开始获取数据");
		try {
			while(rs.next()){
				bc = new BaseContent();
				bc.setCode(rs.getString("code"));
				bc.setCodeName(rs.getString("codename"));
				bc.setCategorycode(rs.getString("categorycode"));
				bc.setOrderNo(rs.getString("orderNo"));
				bc.setIsShow(rs.getString("isshow"));
				bc.setRemarks(rs.getString("remarks"));
				bc.setAddDate(new java.util.Date(rs.getTimestamp("adddate").getTime()));
				bc.setAddUser(rs.getString("adduser"));
				bc.setAddUserName(rs.getString("addusername"));
				bc.setAddIp(rs.getString("addip"));
				bc.setCompCode(rs.getString("compcode"));
				list.add(bc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		if(list!=null){
			String sql2 = "select count(*) count from ("+sql+")";
			int total = super.executeTotalCount(sql2,object1);
			pageBean = new PageBean();
			pageBean.setTotal(total);
			pageBean.setData(list);
		}
		return pageBean;
	}

	@Override
	public List<Map<String,Object>> findAllBaseContent(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		String sql = "select * from basecontent where 1=1 ";
		List<Object> pstm = new ArrayList<Object>();
		if(map.size()>0){
			
			if(map.get("categorycode")!=null && map.get("categorycode")!=""){
				sql += " and categorycode=? ";
				pstm.add(map.get("categorycode"));
			}
			if(map.get("code")!=null && map.get("code")!=""){
				sql += " and code=? ";
				pstm.add(map.get("code"));
			}
			if(map.get("codeName")!=null && map.get("codeName")!=""){
				sql += " and codeName=? ";
				pstm.add(map.get("codeName"));
			}
		}
		Object[] object = pstm.toArray();
		sql += " order by categorycode,orderno";
		ResultSet rs = super.executeQuery(sql, object);
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Map<String,Object> baseMap = null;
		try {
			while(rs.next()){
				baseMap = new HashMap<String,Object>();
				baseMap.put("code",rs.getString("code"));
				baseMap.put("codeName",rs.getString("codename"));
				baseMap.put("categorycode",rs.getString("categorycode"));
				baseMap.put("orderNo",rs.getString("orderNo"));
				baseMap.put("isShow",rs.getString("isshow"));
				baseMap.put("remarks",rs.getString("remarks"));
//				baseMap.put("addDate",new java.util.Date(rs.getTimestamp("adddate").getTime()));
				baseMap.put("addUser",rs.getString("adduser"));
//				baseMap.put("addUserName",rs.getString("addusername"));
//				baseMap.put("addIp",rs.getString("addip"));
				baseMap.put("compCode",rs.getString("compcode"));
				list.add(baseMap);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return list;
	}

	@Override
	public List<BaseContent> findByCategoryCode(String categorycode) {
		// TODO Auto-generated method stub
		String sql = "select * from basecontent where categorycode=? order by code";
		ResultSet rs = super.executeQuery(sql, categorycode);
		BaseContent bc = null;
		List<BaseContent> list = new ArrayList<BaseContent>();
		try {
			while(rs.next()){
				bc = new BaseContent();
				bc.setCode(rs.getString("code"));
				bc.setCodeName(rs.getString("codename"));
				bc.setCategorycode(rs.getString("categorycode"));
				list.add(bc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			super.closeAll();
		}
		return list;
	}

	

}
