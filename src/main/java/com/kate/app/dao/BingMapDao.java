package com.kate.app.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kate.app.model.BingMapVo;
@Repository 
public class BingMapDao extends BaseDao {
	public List<BingMapVo> listBingMap(){
		List<BingMapVo> bingMapList=new ArrayList<BingMapVo>();
		try {
			String sql = "select t.id,t.project_address,t.project_name,t.project_sales_remain,t.project_price_avg, MIN(h.house_size) as minarea,MAX(h.house_size) as maxarea ,h.house_type from house_project t LEFT JOIN house_info h on t.id=h.house_project_id group BY h.house_project_id";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
		    int id=0;
		    String project_address=null;
		    String project_name=null;
		    int project_sales_remain=0;
		    int project_price=0;//需要改动
		    int project_price_avg=0;
		    int maxarea=0;
		    int minarea=0;
		    String house_type=null;
		    while(rs.next()){
		    	id=rs.getInt("id");
		    	project_address=rs.getString("project_address");
		    	project_name=rs.getString("project_name");
		    	project_sales_remain=rs.getInt("project_sales_remain");
		    	maxarea=rs.getInt("maxarea");
		    	minarea=rs.getInt("minarea");
		    	project_price=rs.getInt("project_price_avg");//此处项目价格目前给的是项目平均价格
		    	project_price_avg=rs.getInt("project_price_avg");
		    	house_type=rs.getString("house_type");
		        BingMapVo bingMapVo=new BingMapVo(id,project_address, project_name, project_price,minarea, maxarea, project_sales_remain, project_price_avg,house_type);
		    	bingMapList.add(bingMapVo);
		    }
		    
		  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bingMapList;
	} 
	public List<BingMapVo> filterByHouseType(int type){
		String housetype=null;
		switch(type)
		{
		case 1:
			housetype="一居室";
			break;
		case 2:
			housetype="二居室";
			break;
		case 3:
			housetype="海景房";
			break;
		}
		List<BingMapVo> bingMapList=new ArrayList<BingMapVo>();
		try {
			String sql = "select t.id,t.project_address,t.project_name,t.project_sales_remain,t.project_price_avg, MIN(h.house_size) as minarea,MAX(h.house_size) as maxarea ,h.house_type from house_project t LEFT JOIN house_info h on t.id=h.house_project_id  where h.house_type='"+housetype+"' group BY h.house_project_id ";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
		    int id=0;
		    String project_address=null;
		    String project_name=null;
		    int project_sales_remain=0;
		    int project_price=0;//需要改动
		    int project_price_avg=0;
		    int maxarea=0;
		    int minarea=0;
		    String house_type=null;
		    while(rs.next()){
		    	id=rs.getInt("id");
		    	project_address=rs.getString("project_address");
		    	project_name=rs.getString("project_name");
		    	project_sales_remain=rs.getInt("project_sales_remain");
		    	maxarea=rs.getInt("maxarea");
		    	minarea=rs.getInt("minarea");
		    	project_price=rs.getInt("project_price_avg");//此处项目价格目前给的是项目平均价格
		    	project_price_avg=rs.getInt("project_price_avg");
		    	house_type=rs.getString("house_type");
		        BingMapVo bingMapVo=new BingMapVo(id,project_address, project_name, project_price,minarea, maxarea, project_sales_remain, project_price_avg,house_type);
		    	bingMapList.add(bingMapVo);
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bingMapList;
	}
	public List<BingMapVo> orderByPrice(int order){
	    String orderstr=null;
		switch(order)
		{
		case 1:
			orderstr="asc";
			break;
		case 2:
			orderstr="desc";
			break;
		}
		List<BingMapVo> bingMapList=new ArrayList<BingMapVo>();
		try {
			String sql = "select t.id,t.project_address,t.project_name,t.project_sales_remain,t.project_price_avg, MIN(h.house_size) as minarea,MAX(h.house_size) as maxarea ,h.house_type from house_project t LEFT JOIN house_info h on t.id=h.house_project_id  group BY h.house_project_id order by t.project_price_avg "+orderstr;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
		    int id=0;
		    String project_address=null;
		    String project_name=null;
		    int project_sales_remain=0;
		    int project_price=0;//需要改动
		    int project_price_avg=0;
		    int maxarea=0;
		    int minarea=0;
		    String house_type=null;
		    while(rs.next()){
		    	id=rs.getInt("id");
		    	project_address=rs.getString("project_address");
		    	project_name=rs.getString("project_name");
		    	project_sales_remain=rs.getInt("project_sales_remain");
		    	maxarea=rs.getInt("maxarea");
		    	minarea=rs.getInt("minarea");
		    	project_price=rs.getInt("project_price_avg");//此处项目价格目前给的是项目平均价格
		    	project_price_avg=rs.getInt("project_price_avg");
		    	house_type=rs.getString("house_type");
		        BingMapVo bingMapVo=new BingMapVo(id,project_address, project_name, project_price,minarea, maxarea, project_sales_remain, project_price_avg,house_type);
		    	bingMapList.add(bingMapVo);
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bingMapList;
	}
}
