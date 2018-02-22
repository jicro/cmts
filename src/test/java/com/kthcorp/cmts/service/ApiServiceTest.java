package com.kthcorp.cmts.service;

import com.google.gson.JsonObject;
import com.kthcorp.cmts.model.Items;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApiServiceTest {
	@Autowired
	private ApiService apiService;

	@Test
	public void test_getMovieCine21ByTitle() throws Exception{
		JsonObject result = apiService.getCine21Datas("12몽키즈");
		System.out.println("#Result:"+result.toString());

	}

	@Test
	public void test_getDicKeywordsByType() throws Exception {
		//JsonObject result = apiService.getDicKeywordsByType("WHEN", 10, 1);
		//JsonObject result = apiService.getDicKeywordsByType("CHANGE", 10, 1);
		//JsonObject result = apiService.getDicKeywordsByType("NOTUSE", 10, 1);
		//JsonObject result = apiService.getDicKeywordsByType("ADD", 10, 1);
		JsonObject result = apiService.getDicKeywordsByType("FILTER", 10, 1);
		System.out.println("#Result:" + result.toString());
	}

	@Test
	public void test_searchItemsPaging() throws Exception {
		Items req = new Items();

		JsonObject result = apiService.getItemsSearch(50, 1, "", ""
				, "", "", "최근", "title,METASWHEN");

		System.out.println("#result:"+result.toString());
	}

}
