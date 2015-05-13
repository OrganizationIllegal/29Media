package com.kate.app.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;
import com.kate.app.model.SearchList;

@Repository 
public class SearchListDao extends BaseDao {
	public List<SearchList> listSearchList(){
		List<SearchList> searchInfoList=new ArrayList<SearchList>();
		try {
			String sql = "select t.id,t.project_img,t.project_name,t.project_sales_remain, MAX(h.house_price) as maxprice,MIN(h.house_price) as  minprice,MAX(h.house_size) as maxarea,Min(h.house_size) as minarea,b.return_money from house_project t JOIN house_info  h ON t.id=h.house_project_id  JOIN buy_info b on  b.house_pro_id=h.house_project_id GROUP BY h.house_project_id";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
		    int id=0;
		    String project_img=null;
		    String project_name=null;
		    int project_sales_remain=0;
		    int maxPrice=0;
		    int minprice=0;
		    int maxarea=0;
		    int minarea=0;
		    int return_money=0;
		    while(rs.next()){
		    	id=rs.getInt("id");
		    	project_img=rs.getString("project_img");
		    	project_name=rs.getString("project_name");
		    	project_sales_remain=rs.getInt("project_sales_remain");
		    	maxPrice=rs.getInt("maxprice");
		    	minprice=rs.getInt("minprice");
		    	maxarea=rs.getInt("maxarea");
		    	minarea=rs.getInt("minarea");
		    	return_money=rs.getInt("return_money");
		    	SearchList  searchList=new SearchList( id, project_img,project_name,maxPrice, minprice , maxarea,minarea, project_sales_remain, return_money );
		    	searchInfoList.add(searchList);
		    }
		    
		  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchInfoList;
	} 
}
