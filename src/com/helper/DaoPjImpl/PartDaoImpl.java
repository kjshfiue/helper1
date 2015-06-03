package com.helper.DaoPjImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.helper.dao.BaseDao;
import com.helper.dao.PartsDao;
import com.helper.entity.Parts;

public class PartDaoImpl extends BaseDao implements PartsDao {
	/**
	 * 查询配件信息
	 * @return
	 */
	@Override
	public List<Parts> findPartsMessage(String s1, String s2, String s3) {
		// TODO Auto-generated method stub
		System.err.println(s1+s2+s3);
		String sql="select * from baseparts where 1 = 1 ";
		if(s1!=null){
			sql=sql+"and partscode ="+s1;
		}
		if(s2!=null){
			sql=sql+"and partsname ="+s2;
		}
		if(s3!=null){
			sql=sql+"and partscategory ="+s3;
		}
		System.out.println(sql);
		ResultSet rs=null;
		try{
				rs=super.executeQuery(sql);
		}catch(Exception e){
			
		}
		List<Parts> list=new ArrayList<Parts>();
		Parts parts=null;
		try {
			while(rs.next()){
				parts=new Parts();
				parts.setAddDate(rs.getString("adddate"));
				parts.setAddip(rs.getString("addip"));
				parts.setAddUser(rs.getString("adduser"));
				parts.setAddUserName(rs.getString("addusername"));
				parts.setCompCode(rs.getString("compcode"));
				parts.setCostPrice(rs.getString("costprice"));
				parts.setIdShow(rs.getString("isshow"));
				parts.setPartsBrand(rs.getString("partsbrand"));
				parts.setPartsCategory(rs.getString("PartsCategory"));
				parts.setPartsCode(rs.getString("PartsCode"));
				parts.setPartsGenetalPartsNo(rs.getString("PartsGeneralPartsNo"));
				parts.setPartsImg(rs.getString("PartsImg"));
				parts.setPartSize(rs.getString("PartsSize"));
				parts.setPartsModel(rs.getString("PartsModel"));
				parts.setPartsModelOld(rs.getString("PartsModelOld"));
				parts.setPartsName(rs.getString("PartsName"));
				parts.setPartsNo(rs.getString("PartsNo"));
				parts.setPartsUnit(rs.getString("PartsUnit"));
				parts.setPartWeight(rs.getString("PartsWeight"));
				parts.setRemarks(rs.getString("Remarks"));
				parts.setSalePrice(rs.getString("SalePrice"));
				parts.setSpell(rs.getString("Spell"));
				list.add(parts);
				
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 添加配件信息
	 * @param parts
	 * @return
	 */
	@Override
	public int insertPartMessage(Parts parts) {
		// TODO Auto-generated method stub
		Object obj[]=new Object[22];
		obj[0]=parts.getPartsCode();
		obj[1]=parts.getPartsName();
		obj[2]=parts.getSpell();
		obj[3]=parts.getPartsCategory();
		obj[4]=parts.getPartsBrand();
		obj[5]=parts.getPartsNo();
		obj[6]=parts.getPartsGenetalPartsNo();
		obj[7]=parts.getPartsModel();
		obj[8]=parts.getPartsModelOld();
		obj[9]=parts.getPartSize();
				obj[10]=parts.getPartWeight();
				obj[11]=parts.getPartsImg();
				obj[12]=parts.getPartsUnit();
				obj[13]=parts.getSalePrice();
				obj[14]=parts.getCostPrice();
				obj[15]=parts.getIdShow();
				obj[16]=parts.getRemarks();
				obj[17]=parts.getAddDate();
				obj[18]=parts.getAddUser();
				obj[19]=parts.getAddUserName();
						obj[20]=parts.getAddip();
						obj[21]=parts.getCompCode();
			String sql="insert into baseparts values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			int flag=0;
			try{
			flag=super.executeUpdate(sql,obj);
			return flag;
			}catch(Exception e){
				
				
			}	
		return flag;
	}
	/**
	 * 删除配件信息
	 * @param id
	 * @return
	 */
	@Override
	public int deletePartMessage(String id) {
		// TODO Auto-generated method stub
		Object obj[]=new Object[1];
		obj[0]=id;
		String sql="delete from baseparts where partscode = ?";
		int flag=0;
		try{
			flag=super.executeUpdate(sql,obj);
			return flag;
		}catch(Exception e){}
		return 0;
	}
	/**
	 * 统一的价格调整
	 * @param list
	 * @return
	 */
	@Override
	public int updatePartMessage(String s1,String s2,String s3,String price) {
		// TODO Auto-generated method stub
		Object obj[]=new Object[1];
		obj[0]=price;
		String sql=null;
		
		 sql="update baseparts set saleprice = ? where 1 = 1";
		
		if(s1!=null){
			sql=sql+"and partsno = "+s1;
		}
		if(s2!=null){
			sql=sql+"and partsname = "+s2;
		}
		if(s3!=null){
			sql=sql+"and partsCategory = "+s3;
		}
		System.out.println("***"+sql);
			
			int flag=super.executeUpdate(sql,obj);
			//System.out.println(flag);
			return flag;
		
		
	}
	/**
	 * 修改产品信息
	 * @param id
	 * @return
	 */
	@Override
	public int updatePartMessage(Parts parts) {
		// TODO Auto-generated method stub
		Object obj[]=new Object[12];
		obj[0]=parts.getPartsCode();
		obj[1]=parts.getPartsName();
		obj[2]=parts.getPartsCategory();
		obj[3]=parts.getPartsBrand();
		obj[4]=parts.getPartsNo();
		//obj[5]=parts.getPartsGenetalPartsNo();
		obj[5]=parts.getPartsModel();
		obj[6]=parts.getPartsModelOld();
		//obj[8]=parts.getPartSize();
		//obj[9]=parts.getPartWeight();
		//obj[10]=parts.getPartsImg();
		//obj[11]=parts.getPartsUnit();
		obj[7]=parts.getSalePrice();
		obj[8]=parts.getIdShow();
		obj[9]=parts.getRemarks();
		obj[10]=parts.getAddUserName();
		obj[11]=parts.getPartsCode();
		String sql="update baseparts set partscode = ?,partsname = ?,"
				+ "partscategory = ?,partsbrand = ?,partsno=?,"
				+ "partsmodel=?,partsmodelold=?,"
				+ "saleprice=?,isshow=?,remarks=?,addusername= ? where partscode= ?";
			
		int flag=super.executeUpdate(sql, obj);
		return flag;
	}
	
/*	public static void main(String[] args) {
		PartDaoImpl pdi=new PartDaoImpl();
		List<Parts> list=pdi.findPartsMessage(null,"'peij'", null);
		for(Parts p:list){
			System.out.println(p.getPartsCode());
		}
		Parts p=new Parts();
		p.setPartsCode("2012");
Parts parts=new Parts();
		
		
		parts.setAddUserName("11111");
	
		parts.setIdShow("1");
		parts.setPartsBrand("123");
		parts.setPartsCategory("123");
		parts.setPartsCode("12");
		
		parts.setPartsModel("123");
		parts.setPartsModelOld("123");
		parts.setPartsName("2222");
		parts.setPartsNo("123");
		
		parts.setRemarks("1234");
		parts.setSalePrice("123");
        System.out.println(pdi.updatePartMessage(parts));
	
	}*/

}
