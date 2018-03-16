package com.kthcorp.cmts.controller;

import com.google.gson.JsonObject;
import com.kthcorp.cmts.model.*;
import com.kthcorp.cmts.service.AdminService;
import com.kthcorp.cmts.service.DicService;
import com.kthcorp.cmts.service.ItemsService;
import com.kthcorp.cmts.service.TestService;
import com.kthcorp.cmts.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.ws.rs.Path;
import java.util.List;
import java.util.Map;

@Controller
//@RequestMapping(value = {"", "/dummy"})
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Value("${cmts.collector.naverblog.search_url}")
	private String naverblog_url;
	@Value("${cmts.collector.daumnews.search_url}")
	private String daumnews_url;
	@Value("${cmts.collector.navernews.search_url}")
	private String navernews_url;
	@Value("${cmts.admin.page_size}")
	private Integer pageSize;

	@Autowired
	private AdminService adminService;
	@Autowired
	private DicService dicService;
	@Autowired
	private ItemsService itemsService;



	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public ModelAndView home(Model model
			, @RequestParam(value="page", required=false, defaultValue = "1") Integer pageno
			, @RequestParam(value="search", required=false, defaultValue = "") String search
	) {

		logger.debug("#/admin/item/list get");

		if(pageno < 1) { pageno = 1; }
		Items req = new Items();
		req.setPageNo(pageno);
		req.setPageSize(pageSize);
		if(!"".equals(search)) req.setTitle(search);

		List<Items> itemsList = adminService.getItemsList(req);

		/* pagination */
		Integer countItems = adminService.countItems(req);
		Map<String, Object> listPaging = CommonUtil.getPagination(countItems, pageSize, pageno,5 );
		List<String> listActive = null;
		List<Integer> listPage = null;
		if (listPaging != null) {
			listActive = (List<String>) listPaging.get("listActive");
			listPage = (List<Integer>) listPaging.get("listPage");
		}

		ModelAndView mav = new ModelAndView("admin/itemsList");
		mav.addObject("itemsList", itemsList);
		mav.addObject("pageSize", pageSize);
		mav.addObject("countItems", countItems);
		mav.addObject("pageno", pageno);

		mav.addObject("listActive", listActive);
		mav.addObject("listPage", listPage);
		mav.addObject("searchTxt", search);

		return mav;
	}

	@RequestMapping(value="/admin/items/list", method=RequestMethod.GET)
	public ModelAndView itemsList(Map<String, Object> model
			, @RequestParam(value="page", required=false, defaultValue = "1") Integer pageno
			, @RequestParam(value="search", required=false, defaultValue = "") String search
	) {

		logger.debug("#/admin/item/list get");

		if(pageno < 1) { pageno = 1; }
		Items req = new Items();
		req.setPageNo(pageno);
		req.setPageSize(pageSize);
		if(!"".equals(search)) req.setTitle(search);

		List<Items> itemsList = adminService.getItemsList(req);

		/* pagination */
		Integer countItems = adminService.countItems(req);
		Map<String, Object> listPaging = CommonUtil.getPagination(countItems, pageSize, pageno, 5);
		List<String> listActive = null;
		List<Integer> listPage = null;
		if (listPaging != null) {
			listActive = (List<String>) listPaging.get("listActive");
			listPage = (List<Integer>) listPaging.get("listPage");
		}

		ModelAndView mav = new ModelAndView("admin/itemsList");
		mav.addObject("itemsList", itemsList);
		mav.addObject("pageSize", pageSize);
		mav.addObject("countItems", countItems);
		mav.addObject("pageno", pageno);

		mav.addObject("listActive", listActive);
		mav.addObject("listPage", listPage);
		mav.addObject("searchTxt", search);

		return mav;
	}



	@RequestMapping(value="/admin/movie_cine21/list", method=RequestMethod.GET)
	public ModelAndView movieCine21List(Map<String, Object> model
			, @RequestParam(value="page", required=false, defaultValue = "1") Integer pageno
			, @RequestParam(value="search", required=false, defaultValue = "") String search
			) {

		logger.debug("#/admin/movie_cine21/list get");

		if(pageno < 1) { pageno = 1; }
		MovieCine21 req = new MovieCine21();
		req.setPageNo(pageno);
		req.setPageSize(pageSize);
		if(!"".equals(search)) req.setMovieNm(search);

		List<MovieCine21> itemsList = adminService.getMovieCine21(req);

		/* pagination */
		Integer countItems = adminService.cntMovieCine21(req);
		Map<String, Object> listPaging = CommonUtil.getPagination(countItems, pageSize, pageno, 5);
		List<String> listActive = null;
		List<Integer> listPage = null;
		if (listPaging != null) {
			listActive = (List<String>) listPaging.get("listActive");
			listPage = (List<Integer>) listPaging.get("listPage");
		}

		ModelAndView mav = new ModelAndView("admin/cine21List");
		mav.addObject("itemsList", itemsList);
		mav.addObject("pageSize", pageSize);
		mav.addObject("countItems", countItems);
		mav.addObject("pageno", pageno);

		mav.addObject("listActive", listActive);
		mav.addObject("listPage", listPage);

		return mav;
	}


	@RequestMapping(value="/admin/item/{idx}", method=RequestMethod.GET)
	public ModelAndView itemGet(Map<String, Object> model
			, @PathVariable Integer idx ) {

		logger.debug("#/admin/item/"+idx+" get");

		Items req = new Items();
		req.setIdx(idx);
		Items item = adminService.getItemsByIdx(req);

		List<SchedTrigger> schedList = adminService.getSchedTriggerListByItemIdx(idx);

		ModelAndView mav = new ModelAndView("admin/item");
		mav.addObject("item", item);
		mav.addObject("schedList", schedList);
		return mav;
	}


	@RequestMapping(value="/admin/item/content/{type}/{sc_id}", method=RequestMethod.GET)
	public ModelAndView itemGetContent(Map<String, Object> model
			, @PathVariable String type , @PathVariable Integer sc_id ) {

		logger.debug("#/admin/item/content/"+type+"/"+sc_id+" get");

		SchedTargetMappingHist reqh = new SchedTargetMappingHist();
		reqh.setType(type);
		reqh.setSc_id(sc_id);
		List<SchedTargetMappingHist> contentList = adminService.getSchedTriggerListBySc_id(reqh);

		ModelAndView mav = new ModelAndView("admin/contentList");
		mav.addObject("sc_id", sc_id);
		mav.addObject("contentList", contentList);
		return mav;
	}


	@RequestMapping(value="/admin/item/history/{type}/{sc_id}", method=RequestMethod.GET)
	public ModelAndView itemGetHistory(Map<String, Object> model
			, @PathVariable String type , @PathVariable Integer sc_id ) {

		logger.debug("#/admin/item/history/"+type+"/"+sc_id+" get");

		SchedTargetMappingHist reqh = new SchedTargetMappingHist();
		reqh.setType(type);
		reqh.setSc_id(sc_id);
		List<SchedTargetMappingHist> contentList = adminService.getSchedTriggerHistListAll(reqh);

		ModelAndView mav = new ModelAndView("admin/historyList");
		mav.addObject("sc_id", sc_id);
		mav.addObject("contentList", contentList);
		return mav;
	}


	@RequestMapping(value="/admin/properties/list", method=RequestMethod.GET)
	public ModelAndView getPropertiesList(Map<String, Object> model) {

		logger.debug("#/admin/properties/list get");
		ConfTarget req = new ConfTarget();
		req.setPageNo(1);
		req.setPageSize(10);

		List<ConfTarget> result = adminService.getConfTargetList(req);

		System.out.println("#/admin/properties/list result:"+result.toString());

		ModelAndView mav = new ModelAndView("admin/propertiesList");
		mav.addObject("propertiesList", result);
		mav.addObject("naverblog_url", naverblog_url);
		mav.addObject("daumnews_url", daumnews_url);
		mav.addObject("navernews_url", navernews_url);
		return mav;
	}


	@RequestMapping(value="/admin/dic/{type}/list", method=RequestMethod.GET)
	public ModelAndView getDicList(Map<String, Object> model
			, @PathVariable String type) {

		logger.debug("#/admin/dic/"+type+"/list get");


		ModelAndView mav = new ModelAndView("admin/dicList");
		mav.addObject("type", type);

		switch(type) {
			case "filter":
				List<DicFilterWords> filterList = dicService.getDicFilterWords();
				mav.addObject("wordsList", filterList);
				break;
			case "change":
				List<DicChangeWords> changeList = dicService.getDicChangeWords();
				mav.addObject("wordsList", changeList);
				break;
			case "notuse":
				List<DicNotuseWords> notuseList = dicService.getDicNotuseWords();
				mav.addObject("wordsList", notuseList);
				break;
			case "add":
				List<DicAddWords> addList = dicService.getDicAddWords();

				System.out.println("#addList:"+addList.toString());
				mav.addObject("wordsList", addList);
				break;
			case "keywords":
				List<DicKeywords> keywordsList = dicService.getDicKeywordsListAll();

				System.out.println("#keywordsList:"+keywordsList.toString());
				mav.addObject("wordsList", keywordsList);
				break;
			case "tags":
				List<MetaKeywordMapping> tagList = dicService.getMetaKeywordMappingListAll();

				System.out.println("#tagList:"+tagList.toString());
				mav.addObject("wordsList", tagList);
				break;
		}

		return mav;
	}


	@RequestMapping(value="/admin/dic/tags", method=RequestMethod.GET)
	public ModelAndView getDicTagsList(Map<String, Object> model) {

		logger.debug("#/admin/dic/tags get");
		String type = "tags";

		ModelAndView mav = new ModelAndView("admin/tagList");
		mav.addObject("type", type);

		List<MetaKeywordMapping> tagList = dicService.getMetaKeywordMappingListAll();
		System.out.println("#tagList:"+tagList.toString());
		mav.addObject("wordsList", tagList);

		return mav;
	}


	@RequestMapping(value="/admin/dic/keywords", method=RequestMethod.GET)
	public ModelAndView getDicKeywordsList(Map<String, Object> model) {

		logger.debug("#/admin/dic/keywords get");
		String type = "keywords";

		ModelAndView mav = new ModelAndView("admin/keywordsList");
		mav.addObject("type", type);

		List<DicKeywords> keywordsList = dicService.getDicKeywordsListAll();
		System.out.println("#keywordsList:"+keywordsList.toString());
		mav.addObject("wordsList", keywordsList);

		return mav;
	}


	/** HTTP-POST **/
	@RequestMapping(value="/admin/items/add", method=RequestMethod.POST)
	@ResponseBody
	public String addItem(Map<String, Object> model
				, @RequestParam(value="title", required=true) String title ) {
		JsonObject result = new JsonObject();

		System.out.println("#/admin/items/add input title:"+title);

			int rtcode = 0;
			String rtmsg = "";
			try {
				Items req = new Items();
				req.setCid("");
				req.setTitle(title);
				req.setRegid("ghkdwo77");
				req.setStat("Y");
				req.setType("movie");
				rtcode = itemsService.insItems(req);

				System.out.println("#/admin/items/add inserted idx:"+req.getIdx());
			} catch(Exception e) {
				rtcode = -999;
				rtmsg = "System fail.";
				e.printStackTrace();
			}
			result.addProperty("rtcode", rtcode);
			result.addProperty("rtmsg", rtmsg);

		return result.toString();
	}

	@RequestMapping(value="/admin/items/del", method=RequestMethod.POST)
	@ResponseBody
	public String delItem(Map<String, Object> model
			, @RequestParam(value="idx", required=true) Integer idx ) {
		JsonObject result = new JsonObject();

		System.out.println("#/admin/items/del input idx:"+idx);

		int rtcode = 0;
		String rtmsg = "";
		try {
			Items req = new Items();
			req.setIdx(idx);
			rtcode = itemsService.delItems(req);

			System.out.println("#/admin/items/del deleted idx:"+req.getIdx());
		} catch(Exception e) {
			rtcode = -999;
			rtmsg = "System fail.";
			e.printStackTrace();
		}
		result.addProperty("rtcode", rtcode);
		result.addProperty("rtmsg", rtmsg);

		return result.toString();
	}

	@RequestMapping(value="/admin/sched/retry", method=RequestMethod.POST)
	@ResponseBody
	public String uptSchedTriggerRetry(Map<String, Object> model
			, @RequestParam(value="sc_id", required=true) int sc_id ) {
		JsonObject result = new JsonObject();

		System.out.println("#/admin/sched/retry by:"+sc_id);

		int rtcode = 0;
		String rtmsg = "";
		try {
			SchedTrigger req = new SchedTrigger();
			req.setSc_id(sc_id);

			rtcode = adminService.uptSchedTriggerRetry(req);
			if (rtcode > 0) rtmsg = "SUCCESS";

		} catch(Exception e) {
			rtcode = -999;
			rtmsg = "System fail.";
			e.printStackTrace();
		}
		result.addProperty("rtcode", rtcode);
		result.addProperty("rtmsg", rtmsg);

		return result.toString();
	}
	/*
	@RequestMapping(value="/admin/dic/{type}/list", method=RequestMethod.GET)
	public ModelAndView getPropertiesList(Map<String, Object> model
			, @PathVariable String type) {

		logger.debug("#/admin/dic/"+type+"/list get");


		ModelAndView mav = new ModelAndView("admin/dic/list");
		return mav;
	}


	@RequestMapping(value="/admin/items/add", method=RequestMethod.POST)
	public JsonObject addItem(Map<String, Object> model) {
		JsonObject result = new JsonObject();

			int rtcode = 0;
			String rtmsg = "";
			try {

			} catch(Exception e) {
				rtcode = -999;
				rtmsg = "System fail.";
				e.printStackTrace();
			}
			result.addProperty("rtcode", rtcode);
			result.addProperty("rtmsg", rtmsg);

		return result;
	}
	*/
	@RequestMapping(value="/admin/properties/target/edit", method=RequestMethod.POST)
	@ResponseBody
	public String uptTarget(Map<String, Object> model
			, @RequestParam(value="tg_id", required=true) int tg_id
			, @RequestParam(value="title", required=false) String title
			, @RequestParam(value="descript", required=false) String descript
			, @RequestParam(value="tg_url", required=false) String tg_url
			, @RequestParam(value="tg_url_param1", required=false) String tg_url_param1
			, @RequestParam(value="tg_url_param2", required=false) String tg_url_param2
			, @RequestParam(value="tg_url_param3", required=false) String tg_url_param3
			, @RequestParam(value="param1", required=false) String param1
			, @RequestParam(value="regid", required=false) String regid
			, @RequestParam(value="stat", required=false) String stat
			, @RequestParam(value="fail_count1", required=false) Integer fail_count1
			, @RequestParam(value="fail_count2", required=false) Integer fail_count2
	) {
		JsonObject result = new JsonObject();

		System.out.println("#/admin/properties/target/edit:"+tg_id);

		int rtcode = 0;
		String rtmsg = "";
		try {
			ConfTarget req = new ConfTarget();
			req.setTg_id(tg_id);
			req.setTitle(title);
			req.setDescript(descript);
			req.setTg_url(tg_url);
			req.setTg_url_param1(tg_url_param1);
			req.setTg_url_param2(tg_url_param2);
			req.setTg_url_param3(tg_url_param3);
			req.setRegid(regid);
			req.setParam1(param1);
			req.setStat(stat);
			req.setFail_count1(fail_count1);
			req.setFail_count2(fail_count2);

			rtcode = adminService.uptConfTarget(req);
			if (rtcode > 0) rtmsg = "SUCCESS";

		} catch(Exception e) {
			rtcode = -999;
			rtmsg = "System fail.";
			e.printStackTrace();
		}
		result.addProperty("rtcode", rtcode);
		result.addProperty("rtmsg", rtmsg);

		return result.toString();
	}

	@RequestMapping(value="/admin/properties/target/remove", method=RequestMethod.POST)
	@ResponseBody
	public String delTarget(Map<String, Object> model
			, @RequestParam(value="tg_id", required=true) int tg_id) {
		JsonObject result = new JsonObject();

		System.out.println("#/admin/properties/target/remove:"+tg_id);

		int rtcode = 0;
		String rtmsg = "";
		try {
			ConfTarget req = new ConfTarget();
			req.setTg_id(tg_id);

			rtcode = adminService.delConfTarget(req);
			if (rtcode > 0) rtmsg = "SUCCESS";

		} catch(Exception e) {
			rtcode = -999;
			rtmsg = "System fail.";
			e.printStackTrace();
		}
		result.addProperty("rtcode", rtcode);
		result.addProperty("rtmsg", rtmsg);

		return result.toString();
	}


	@RequestMapping(value="/admin/properties/preset/edit", method=RequestMethod.POST)
	@ResponseBody
	public String uptPreset(Map<String, Object> model
			, @RequestParam(value="ps_id", required=true) int ps_id
			, @RequestParam(value="ps_tag", required=false) String ps_tag
			, @RequestParam(value="ps_type", required=false) String ps_type
			, @RequestParam(value="dest_field", required=false) String dest_field
			, @RequestParam(value="ps_add_url", required=false) String ps_add_url
			, @RequestParam(value="descriptp", required=false) String descriptp
			, @RequestParam(value="dest_charset", required=false) String dest_charset
	) {
		JsonObject result = new JsonObject();

		System.out.println("#/admin/properties/preset/edit:"+ps_id);

		int rtcode = 0;
		String rtmsg = "";
		try {
			ConfPreset req = new ConfPreset();
			req.setPs_id(ps_id);
			req.setPs_tag(ps_tag);
			req.setPs_type(ps_type);
			req.setDest_field(dest_field);
			req.setPs_add_url(ps_add_url);
			req.setDescriptp(descriptp);
			req.setDest_charset(dest_charset);


			System.out.println("#/admin/properties/preset/edit:"+ps_id+"  // params:"+req.toString());


			rtcode = adminService.uptConfPreset(req);
			if (rtcode > 0) rtmsg = "SUCCESS";

		} catch(Exception e) {
			rtcode = -999;
			rtmsg = "System fail.";
			e.printStackTrace();
		}
		result.addProperty("rtcode", rtcode);
		result.addProperty("rtmsg", rtmsg);

		return result.toString();
	}

	@RequestMapping(value="/admin/properties/preset/remove", method=RequestMethod.POST)
	@ResponseBody
	public String delPreset(Map<String, Object> model
			, @RequestParam(value="ps_id", required=true) int ps_id) {
		JsonObject result = new JsonObject();

		System.out.println("#/admin/properties/preset/remove:"+ps_id);

		int rtcode = 0;
		String rtmsg = "";
		try {
			ConfPreset req = new ConfPreset();
			req.setPs_id(ps_id);

			rtcode = adminService.delConfPreset(req);
			if (rtcode > 0) rtmsg = "SUCCESS";

		} catch(Exception e) {
			rtcode = -999;
			rtmsg = "System fail.";
			e.printStackTrace();
		}
		result.addProperty("rtcode", rtcode);
		result.addProperty("rtmsg", rtmsg);

		return result.toString();
	}
}