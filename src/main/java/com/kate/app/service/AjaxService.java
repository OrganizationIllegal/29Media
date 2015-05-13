package com.kate.app.service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kate.app.dao.AjaxDao;
import com.kate.app.dao.HouseProjectDao;
import com.kate.app.model.BrokerInfo;
import com.kate.app.model.BuyInfo;
import com.kate.app.model.DeveloperInfo;
import com.kate.app.model.HouseInfo;
import com.kate.app.model.HouseProject;
import com.kate.app.model.InvestmentDate;
import com.kate.app.model.NewsInfo;

@Service
public class AjaxService {
	@Autowired
    private AjaxDao ajaxDao;
	
	public JSONArray select(){
		JSONArray array = new JSONArray();
		List<InvestmentDate> list = ajaxDao.select();
		for(InvestmentDate data : list){
			JSONObject obj = new JSONObject();
			obj.put("id", data.getId());
			obj.put("data_exam", data.getData_exam()==null?"":data.getData_exam());
			obj.put("middle_price", data.getMiddle_price());
			obj.put("middle_zu_price", data.getMiddle_zu_price());
			obj.put("price_review", data.getPrice_review());
			obj.put("year_increment_rate", data.getYear_increment_rate());
			obj.put("zu_house_rate", data.getZu_house_rate());
			obj.put("zu_xuqiu", data.getZu_xuqiu()==null?"":data.getZu_xuqiu());
			int proId = data.getHouse_pro_id();
			if(proId==0){
				obj.put("project_name", "");
			}
			else{
				HouseProject pro = ajaxDao.findProById(proId);
				if(pro==null){
					obj.put("project_name", "");
				}
				else{
					String name = pro.getProject_name();
					String proName = name==null? "" : name;
					obj.put("project_name", proName);
				}
			}
			array.add(obj);
		}
		return array;
	}
	
	public JSONArray selectBrokerInfo(){
		JSONArray array = new JSONArray();
		List<BrokerInfo> list = ajaxDao.selectBrokerInfo();
		for(BrokerInfo data : list){
			JSONObject obj = new JSONObject();
			obj.put("id", data.getId());
			obj.put("broker_name", data.getBroker_name()==null?"":data.getBroker_name());
			obj.put("broker_language", data.getBroker_language()==null?"":data.getBroker_language());
			obj.put("broker_region", data.getBroker_region()==null?"":data.getBroker_region());
			obj.put("broker_img", data.getBroker_img()==null?"":data.getBroker_img());
			array.add(obj);
		}
		return array;
	}
	
	
	
	public JSONArray selectHouseInfo(){
		JSONArray array = new JSONArray();
		List<HouseInfo> list = ajaxDao.selectHouseInfo();
		for(HouseInfo data : list){
			JSONObject obj = new JSONObject();
			obj.put("id", data.getId());
			obj.put("house_type", data.getHouse_type()==null?"":data.getHouse_type());
			obj.put("house_room_num", data.getHouse_room_num());
			obj.put("house_toilet_num", data.getHouse_toilet_num());
			obj.put("house_size", data.getHouse_size());
			obj.put("house_price", data.getHouse_price()==null?"":data.getHouse_price());
			obj.put("house_img", data.getHouse_img()==null?"":data.getHouse_img());
			int proId = data.getHouse_project_id();
			if(proId==0){
				obj.put("project_name", "");
			}
			else{
				HouseProject pro = ajaxDao.findProById(proId);
				if(pro==null){
					obj.put("project_name", "");
				}
				else{
					String name = pro.getProject_name();
					String proName = name==null? "" : name;
					obj.put("project_name", proName);
				}
			}
			array.add(obj);
		}
		return array;
	}
	/*
	 * 查找项目信息
	 */
	public JSONArray selectHouseProject(){
		JSONArray array = new JSONArray();
		List<HouseProject> list = ajaxDao.selectHouseProject();
		
		for(HouseProject data : list){
			JSONObject obj = new JSONObject();
			obj.put("id", data.getId());
			obj.put("project_name", data.getProject_name()==null?"":data.getProject_name());
			obj.put("project_area", data.getProject_area());
			obj.put("project_nation", data.getProject_nation()==null?"":data.getProject_nation());
			obj.put("project_address", data.getProject_address()==null?"":data.getProject_address());
			obj.put("project_sales_remain", data.getProject_sales_remain());
			String timeResule = null;
			Timestamp time = data.getProject_finish_time();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			if(time!=null){
				timeResule = df.format(time);
			}
			obj.put("project_finish_time", timeResule==null?"":timeResule);
			obj.put("project_desc", data.getProject_desc()==null?"":data.getProject_desc());  // 项目详情
			obj.put("project_city", data.getProject_city()==null?"":data.getProject_city());
			obj.put("project_house_type", data.getProject_house_type()==null?"":data.getProject_house_type());
			obj.put("project_price", data.getProject_price()==null?"":data.getProject_price());
			obj.put("project_lan", data.getProject_lan()==null?"":data.getProject_lan());  // 项目一句话
			if(data.getDeveloper_id()==0){
				obj.put("developer_name", "");
				obj.put("developer_logo", "");
			}
			else{
				DeveloperInfo deve = ajaxDao.selectDevInfo(data.getDeveloper_id());
				if(deve!=null){
					String deve_name = deve.getDeveloper_name()==null?"":deve.getDeveloper_name();
					String deve_log = deve.getDeveloper_logo()==null?"":deve.getDeveloper_logo();
					obj.put("developer_name", deve_name);
					obj.put("developer_log", deve_log); 
				}
			}
			array.add(obj);
		}
		return array;
	}
	
	/*
	 * 删除项目信息
	 */
	
	public boolean deletePro(int proid) throws Exception{
		boolean flag = ajaxDao.deletePro(proid);
		return flag;	
	}
	
	/*
	 * 增加项目和开发商信息
	 */
	public boolean addPro(String project_name, String project_lan, String project_desc, String project_nation, String project_address, String project_area, int project_sales_remain, String project_finish_time, String project_city, String project_house_type, String project_price, String developer_name, String developer_logo, String developer_desc) throws Exception{
		int deve_id = 0;
		boolean flag = false;
		int searchDeveId = ajaxDao.findDeveByName(developer_name);
		if(searchDeveId==0){   //没有查到开发商
			boolean flag_deve = ajaxDao.addDeveInfo(developer_name, developer_logo, developer_desc);
			if(flag_deve==true){    //增加成功
				if(null==developer_name||"".equals(developer_name)){
					deve_id = 0;
				}
				else{
					deve_id = ajaxDao.findDeveByName(developer_name);
				}
			flag = ajaxDao.addPro(project_name, project_lan, project_desc, project_nation, project_address, project_area, project_sales_remain, project_finish_time, project_city, project_house_type, project_price, deve_id);	
			}
		}else{
			boolean flag_deve_edit = ajaxDao.editDeveloperInfo(searchDeveId, developer_name, developer_logo, project_desc);
			flag = ajaxDao.addPro(project_name, project_lan, project_desc, project_nation, project_address, project_area, project_sales_remain, project_finish_time, project_city, project_house_type, project_price, searchDeveId);	
		}

		return flag;	
}
	
	
	/*
	 * 查找信息
	 */
	public boolean findProByName(String project_name) throws Exception{
		boolean flag = false;
		int id = ajaxDao.findProByName(project_name);
		if(id!=0){          //名称已经存在
			return true;
		}
		return flag;	
}
	
	
	/*
	 * 选取其他信息
	 */
	public JSONArray selectInfomation(){
		JSONArray array = new JSONArray();
		List<HouseProject> list = ajaxDao.selectHouseProject();
		
		if(list.size()<=0){
			return null;
		}
		for(HouseProject data : list){
			JSONObject obj = new JSONObject();
			String timeResule = null;
			Timestamp time = data.getProject_finish_time();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			if(time!=null){
				timeResule = df.format(time);
			}
			
			obj.put("id", data.getId());    //项目id
			obj.put("project_name", data.getProject_name()==null?"":data.getProject_name());    //项目名称
			obj.put("project_finish_time", timeResule==null?"":timeResule);
			DeveloperInfo deve = new DeveloperInfo();
			if(data.getDeveloper_id()==0){
				obj.put("developer_name", "");
				obj.put("developer_logo", "");
			}
			else{
				deve = ajaxDao.selectDevInfo(data.getDeveloper_id());   //得到开发商
				if(deve!=null){   //开发商信息存在
					String name = deve.getDeveloper_name()==null?"":deve.getDeveloper_name();
					String logo = deve.getDeveloper_logo()==null?"":deve.getDeveloper_logo();
					obj.put("developer_name", name);
					obj.put("developer_logo", logo);
				}
			}
			
			List<BuyInfo> listInfo = ajaxDao.selectBuyInfo(data.getId());   //购买信息
			BuyInfo buyInfo = new BuyInfo();
			if(listInfo.size()>0){
				buyInfo = ajaxDao.selectBuyInfo(data.getId()).get(0);   //取其中第一条数据
				obj.put("first_money", buyInfo.getFirst_money());
				obj.put("stamp_tax", buyInfo.getStamp_tax());
			}
			else{
				obj.put("first_money", 0);
				obj.put("stamp_tax", 0);
			}
			array.add(obj);
		}
		return array;
	}
	
	
	/*
	 * 价格区间显示
	 */
	public JSONArray selectPriceInfo(){
		JSONArray array = new JSONArray();
		List<HouseProject> list = ajaxDao.selectHouseProject();
		
		if(list.size()<=0){
			return null;
		}
		for(HouseProject data : list){
			JSONObject obj = new JSONObject();
			obj.put("id", data.getId());    //项目id
			String project_name = data.getProject_name()==null? "":data.getProject_name();
			String project_price_qujian = data.getProject_price()==null?"":data.getProject_price();
			obj.put("project_name", project_name);
			obj.put("project_price_avg", data.getProject_price_avg());   //平均价格
			obj.put("project_price_qujian", project_price_qujian);   //价格区间
			
			List<BuyInfo> listInfo = ajaxDao.selectBuyInfo(data.getId());
			BuyInfo buyInfo = new BuyInfo();
			if(listInfo.size()>0){
				buyInfo = ajaxDao.selectBuyInfo(data.getId()).get(0);
				obj.put("return_money", buyInfo.getReturn_money());
			}
			else{
				obj.put("return_money", 0);
			}
			array.add(obj);
		}
		return array;
	}
	
	
	/*
	 * 查找项目信息
	 */
	public JSONArray selectRecomProject(){
		JSONArray array = new JSONArray();
		array = ajaxDao.selectRecomProject();
		return array;
	}
	
	/*
	 * 查找新闻信息
	 */
	public JSONArray selectNewsInfo(){
		JSONArray array = new JSONArray();
		List<NewsInfo> list = ajaxDao.selectNewsInfo();
		for(NewsInfo data : list){
			JSONObject obj = new JSONObject();
			String timeResule = null;
			obj.put("id", data.getId());
			obj.put("title", data.getTitle()==null?"":data.getTitle());
			obj.put("source", data.getSource()==null?"":data.getSource());
			Timestamp time = data.getTime();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			if(time!=null){
				timeResule = df.format(time);
			}
			obj.put("time", timeResule==null?"":timeResule);
			obj.put("detail", data.getDetail()==null?"":data.getDetail());
			obj.put("news_img", data.getNews_img()==null?"":data.getNews_img());
			if(data.getHouse_pro_id()==0){
				obj.put("project_name", "");
			}
			else{
				HouseProject pro = ajaxDao.findProById(data.getHouse_pro_id());
				if(pro == null){
					obj.put("project_name", "");
				}else{
					String name = pro.getProject_name();
					String proName = name==null? "" : name;
					obj.put("project_name", proName);
				}
			}
			array.add(obj);
		}
		return array;
	}
	
	/*
	 * 增加新闻信息
	 */
	public int addNewsInfo(String project_name, String title, String source, String time, String detail, String news_img) throws Exception{
	    boolean result = false;
		int proId= ajaxDao.findProByName(project_name);
		if(proId==0){    //项目名称错误
			return -1;
		}
		else{
			result = ajaxDao.addNewsInfo(title, source, time, detail, news_img, proId);
			if(result==true)
				return 1;
			else
				return -2;
		}
	}
	
	
	
	
	/*
	 * 修改新闻信息
	 */
	public int editNewsInfo(int id, String project_name, String title, String source, String time, String detail, String news_img) throws Exception{
		boolean result = false;
		int proId= ajaxDao.findProByName(project_name);
		if(proId==0){    //项目名称错误
			return -1;
		}
		else{
			result = ajaxDao.editNewsInfo(id, title, source, time, detail, news_img, proId);
			if(result==true)
				return 1;
			else
				return -2;
		}	
	}
	
	/*--------------------------*/
	/*
	 * 查找区域特点信息
	 */
	public JSONArray selectArea(){
		JSONArray array = new JSONArray();
		array = ajaxDao.selectArea();
		return array;
	}
	
	/*
	 * 增加区域特点信息
	 */
	public int addArea(String project_name, String area_character) throws Exception{
	    boolean result = false;
		int proId= ajaxDao.findProByName(project_name);
		if(proId==0){    //项目名称错误
			return -1;
		}
		else{
			result = ajaxDao.addArea(area_character, proId);
			if(result==true)
				return 1;
			else
				return -2;
		}
		
	}
	
	/*
	 * 修改区域特点信息
	 */
	public int editArea(int id, String project_name, String area_character) throws Exception{
		boolean result = false;
		int proId= ajaxDao.findProByName(project_name);
		if(proId==0){    //项目名称错误
			return -1;
		}
		else{
			result = ajaxDao.editArea(id, area_character, proId);
			if(result==true)
				return 1;
			else
				return -2;
		}		
	}

	/*
	 * 删除区域特点信息
	 */
	public boolean deleteArea(int id) throws Exception{
		boolean flag = ajaxDao.deleteArea(id);
	    return flag;			
	}
	
	/*------------------------------------------------*/
	
	
	public int count(){
		int count = ajaxDao.count();
		return count;
	}
	public int countBrokerInfo(){
		int count = ajaxDao.countBrokerInfo();
		return count;
	}
	
	
	public int countHouseInfo(){
		int count = ajaxDao.countHouseInfo();
		return count;
	}
	
	public int countHouseProject(){
		int count = ajaxDao.countHouseProject();
		return count;
	}
	public int countRecomendProject(){
		int count = ajaxDao.countRecomendProject();
		return count;
	}
	
	public int countNewsInfo(){
		int count = ajaxDao.countNewsInfo();
		return count;
	}
	
	public int countArea(){
		int count = ajaxDao.countArea();
		return count;
	}
	
	public int addTouziData(String project_name, int middle_price, int middle_zu_price, int price_review, int year_increment_rate, int zu_house_rate, String zu_xuqiu,String data_exam) throws Exception{
	    boolean result = false;
		int proId= ajaxDao.findProByName(project_name);
		if(proId==0){    //项目名称错误
			return -1;
		}
		else{
			result = ajaxDao.addTouziData(middle_price, middle_zu_price, price_review, year_increment_rate, zu_house_rate, zu_xuqiu, data_exam, proId);
			if(result==true){
				return 1;   
			}
			else
				return -2;    //添加失败
				
		}		
	}
	/*
	 * 增加推荐项目
	 */
	
	public int addRecoProject(String project_name, String recommend_project_name) throws Exception{
	    boolean result = false;
		int proId= ajaxDao.findProByName(project_name);
		if(proId == 0){
			return -1;
		}
		int pro_reId = ajaxDao.findProByName(recommend_project_name);
		if(pro_reId == 0){
			return -1;
		}
		result = ajaxDao.addRecoProject(pro_reId, proId);
		if(result==true)
			return 1;
		else 
			return -2;	
	}
	/*
	 * 修改推荐项目
	 */
	public int editRecoProject(int id, String project_name, String recommend_project_name) throws Exception{
	    boolean result = false;
		int proId= ajaxDao.findProByName(project_name);
		if(proId == 0){
			return -1;
		}
		int pro_reId = ajaxDao.findProByName(recommend_project_name);
		if(pro_reId == 0){
			return -1;
		}
		result = ajaxDao.editRecoProject(id, pro_reId, proId);
		if(result==true)
			return 1;
		else
			return -2;
	}
	
	
	
	
	
	
	public int addHouseInfo(String project_name, String house_type, int house_room_num, int house_toilet_num, int house_size, String house_price, String house_img) throws Exception{
	    boolean result = false;
		int proId= ajaxDao.findProByName(project_name);
		if(proId==0){    //项目名称错误
			return -1;
		}
		else{
			result = ajaxDao.addHouseInfo(house_type, house_room_num, house_toilet_num, house_size, house_price, house_img, proId);
			if(result==true)
				return 1;
			else
				return -2;
		}
	}
	
	
	public int addBrokerInfo(String broker_name, String broker_language, String broker_region, String broker_img) throws Exception{
	    boolean result = false;
		result = ajaxDao.addBrokerInfo(broker_name, broker_language, broker_region, broker_img);
		if(result==true)
			return 1;
		else
			return -2;
	}

	
	
	
	public int editTouziData(int id, String project_name, int middle_price, int middle_zu_price, int price_review, int year_increment_rate, int zu_house_rate, String zu_xuqiu,String data_exam) throws Exception{
		boolean result = false;
		int proId= ajaxDao.findProByName(project_name);
		if(proId==0){    //项目名称错误
			return -1;
		}
		else{
			result = ajaxDao.editTouziData(id, middle_price, middle_zu_price, price_review, year_increment_rate, zu_house_rate, zu_xuqiu, data_exam, proId);
			if(result==true){
				return 1;   
			}
			else
				return -2;    //添加失败
		}		
	}
	
	
	
	public int editBrokerInfo(int id, String broker_name, String broker_language, String broker_region, String broker_img) throws Exception{
		boolean result = false;
		result = ajaxDao.editBrokerInfo(id, broker_name, broker_language, broker_region, broker_img);
			if(result==true){
				return 1;   
			}
			else
				return -2;    //添加失败
	}		

	
	
	
	
	public int editHouseInfo(int id, String project_name, String house_type, int house_room_num, int house_toilet_num, int house_size, String house_price, String house_img) throws Exception{
		boolean result = false;
		int proId= ajaxDao.findProByName(project_name);
		if(proId==0){    //项目名称错误
			return -1;
		}
		else{
			result = ajaxDao.editHouseInfo(id, house_type, house_room_num, house_toilet_num, house_size, house_price, house_img, proId);
			if(result==true)
				return 1;
			else{
				return -2;
			}
		}	
	}
	
	public boolean deleteTouziData(int id) throws Exception{
		boolean flag = ajaxDao.deleteTouziData(id);
	    return flag;			
	}
	public boolean deleteBrokerInfo(int id) throws Exception{
		boolean flag = ajaxDao.deleteBrokerInfo(id);
	    return flag;			
	}
	
	
	public boolean deleteHouseInfo(int id) throws Exception{
		boolean flag = ajaxDao.deleteHouseInfo(id);
	    return flag;			
	}
	
	public boolean deleteHouseProject(int id) throws Exception{
		boolean flag = ajaxDao.deleteHouseProject(id);
	    return flag;			
	}
	
	public boolean deleteNewsInfo(int id) throws Exception{
		boolean flag = ajaxDao.deleteNewsInfo(id);
	    return flag;			
	}
	
	public boolean deleteRecomProject(int id) throws Exception{
		boolean flag = ajaxDao.deleteRecomHouseProject(id);
	    return flag;			
	}
	
	
	
	
	
	
	
	
	public boolean findById(int id) throws Exception{
		boolean flag = ajaxDao.findById(id);
		return flag;			
	}
	
	
	public boolean editPro(int proid, String project_name, String project_lan, String project_desc, String project_nation, String project_address, String project_area, int project_sales_remain, String project_finish_time, String project_city, String project_house_type, String project_price, String developer_name, String developer_logo, String developer_desc) throws Exception{
		int deve_id = 0;
		boolean flag = false;
		deve_id = ajaxDao.findDeveByName(developer_name);
		if(deve_id == 0){   // 开发商名称必须已经存在
			return flag;
		}
		else{
			boolean flag_deve = ajaxDao.editDeveloperInfo(deve_id, developer_name, developer_logo, developer_desc);
			if(flag_deve==true){
				flag = ajaxDao.editPro(proid, project_name, project_lan, project_desc, project_nation, project_address, project_area, project_sales_remain, project_finish_time, project_city, project_house_type, project_price, deve_id);
			}
		}
		return flag;			
	}
}
