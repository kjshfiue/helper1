package com.helper.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.helper.dao.BaseDao;
import com.helper.dao.StockInDetailDao;
import com.helper.entity.Parts;
import com.helper.entity.SaleOrderDetail;
import com.helper.entity.StockInDetail;

public class StockInDetailDaoImpl extends BaseDao implements StockInDetailDao {
	@Override
	public List<StockInDetail> findDatailByInCode(String inCode) {
		// TODO Auto-generated method stub
		String sql = "select * from stockin_detail where incode=?";
		ResultSet rs = super.executeQuery(sql, inCode);
		List<StockInDetail> list = new ArrayList<StockInDetail>();
		StockInDetail skInDetail=null;
		Parts parts = null;
		try {
			while(rs.next()){
				skInDetail=new StockInDetail();
				parts = new Parts();
				skInDetail.setCode(rs.getString("code"));
				skInDetail.setInCode(rs.getString("incode"));
				skInDetail.setOrderCode(rs.getString("ordercode"));
				skInDetail.setpCode(rs.getString("pcode"));
				skInDetail.setNums(Integer.parseInt(rs.getString("nums")));
				skInDetail.setPrice(Double.parseDouble(rs.getString("price")));
				skInDetail.setRemarks(rs.getString("remarks"));
				skInDetail.setWareHouse(rs.getString("warehouse"));
				list.add(skInDetail);
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
