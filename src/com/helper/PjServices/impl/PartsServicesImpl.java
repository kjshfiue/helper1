package com.helper.PjServices.impl;

import java.util.List;

import com.helper.DaoPjImpl.PartDaoImpl;
import com.helper.PjServices.PartsServicesDao;
import com.helper.dao.PartsDao;
import com.helper.entity.Parts;

public class PartsServicesImpl implements PartsServicesDao {
	PartsDao psd=new PartDaoImpl();
	@Override
	public List<Parts> searchParts(String s1, String s2, String s3) {
		// TODO Auto-generated method stub
		List<Parts> list=psd.findPartsMessage(s1, s2, s3);
		return list;
	}

	@Override
	public int addParts(Parts parts) {
		// TODO Auto-generated method stub
		int flag=0;
		try{
		flag=psd.insertPartMessage(parts);
		}catch(Exception e){
			
		}
		return flag;
	}

	@Override
	public int updateParts(Parts parts) {
		// TODO Auto-generated method stub
		int flag=0;
		try{
		flag=psd.updatePartMessage(parts);
		}catch(Exception e){
			
		}
		
		return flag;
	}

	@Override
	public int deleteParts(String id) {
		// TODO Auto-generated method stub
		int flag=0;
		try{
		flag=psd.deletePartMessage(id);
		}catch(Exception e){
			
		}
		return flag;
	}

	@Override
	public int deleteAllPart(List<Integer> list) {
		// TODO Auto-generated method stub
		int flag=0;
		try{
			for(int i:list){
				psd.deletePartMessage(String.valueOf(i));
			}
			return 1;
		}catch(Exception e){}
		return 0;
	}

	@Override
	public int updateParts(String s1, String s2, String s3, String price) {
		// TODO Auto-generated method stub
		int flag=0;
		try{
		flag=psd.updatePartMessage(s1, s2, s3, price);
		}catch(Exception e){
			
		}
		return flag;
	}
/*	public static void main(String[] args) {
		PartsServicesDao psd=new PartsServicesImpl();
		List<Parts> list=psd.searchParts(null,null,null);
		for(Parts p:list){
			System.out.println(p.getPartsCode());
		}
	}*/
}
