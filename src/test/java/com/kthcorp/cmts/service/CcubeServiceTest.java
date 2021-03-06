package com.kthcorp.cmts.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.kthcorp.cmts.mapper.CcubeMapper;
import com.kthcorp.cmts.model.InItems;
import com.kthcorp.cmts.model.Items;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CcubeServiceTest {
	@Autowired
	private CcubeService ccubeService;
	@Autowired
	private CcubeMapper ccubeMapper;

	@Test
	public void test_loopReadCcubeDatas() throws Exception {

		int pageSize = 20;
		Items req = new Items();
		req.setType("CcubeContent");
		req.setPageSize(pageSize);

		List<Map<String, Object>> reqItems = null;
		int countAll = 0;
		countAll = ccubeMapper.cntCcubeOutputListStandby(req);
		System.out.println("#countAll:"+countAll);
		int pageAll = 0;
		if (countAll == 0) {
			pageAll = 1;
		} else {
			pageAll = countAll / pageSize + 1;
		}
		System.out.println("#pageAll:"+pageAll);

		for (int pno = 1; pno <= pageAll; pno++) {
			req.setPageNo(pno);
			reqItems = ccubeMapper.getCcubeOutputListStandby(req);

			//if (reqItems != null && reqItems.size() > 0) {
				System.out.println("#RES pno:"+pno+" / pno.size:"+reqItems.size());
			//}
		}


	}



	@Test
	public void test_loopReadCcubeDatasSeries() throws Exception {

		int pageSize = 20;
		Items req = new Items();
		req.setType("CcubeSeries");
		req.setPageSize(pageSize);

		List<Map<String, Object>> reqItems = null;
		int countAll = 0;
		countAll = ccubeMapper.cntCcubeOutputListStandby(req);
		System.out.println("#countAll:"+countAll);
		int pageAll = 0;
		if (countAll == 0) {
			pageAll = 1;
		} else {
			pageAll = countAll / pageSize + 1;
		}
		System.out.println("#pageAll:"+pageAll);

		for (int pno = 1; pno <= pageAll; pno++) {
			req.setPageNo(pno);
			reqItems = ccubeMapper.getCcubeOutputListStandby(req);

			//if (reqItems != null && reqItems.size() > 0) {
			System.out.println("#RES pno:"+pno+" / pno.size:"+reqItems.size());
			//}
		}


	}

	@Test
	public void test_getCcubeDatasByItemIdx() throws Exception{
		JsonObject result = ccubeService.getCcubeDatasByItemIdx(19968,"");//2019.12.06 itemIdx -> itemIdx + cid
		System.out.println("#Result:"+result.toString());

	}


	@Test
	public void test_processCcubeOutputToJson() throws Exception {
		int rt = ccubeService.processCcubeOutputToJson();
	}

	@Test
	public void test_processCcubeOutputToJsonForSeries() throws Exception {
		int rt = ccubeService.processCcubeSeriesOutputToJsonTest();
	}

	@Test
	public void test_getJsonArrayForCcubeOutput() throws Exception {
		Map<String, Object> ins = new HashMap();
		ins.put("idx",3257);
		JsonArray contents = ccubeService.getJsonArrayForCcubeOutput(null, "CcubeContents", ins);
		System.out.println("#RES:"+contents.toString());
	}

	@Test
	public void test_processMultipleSuccessItemByMCID() throws Exception {
		int rt = ccubeService.processMultipleSuccessItemByMCID();
		System.out.println("#RES:"+rt);
	}

}
