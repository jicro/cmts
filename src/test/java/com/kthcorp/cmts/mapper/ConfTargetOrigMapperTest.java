package com.kthcorp.cmts.mapper;

import com.kthcorp.cmts.model.ConfPreset;
import com.kthcorp.cmts.model.ConfTargetOrig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

//@SpringBootTest(classes = TestServiceImpl.class)
//@Configuration
//@ComponentScan(basePackages = "com.kthcorp.cmts"
//		, excludeFilters = @ComponentScan.Filter(value = ConfTargetOrigController.class, type = FilterType.ANNOTATION)
//)
//@ComponentScan

//, excludeFilters = {
//@ComponentScan.Filter(Configuration.class), @ComponentScan.Filter(ConfTargetOrigController.class) })
//@WebAppConfiguration
//@MapperScan(value={"com.kthcorp.cmts.mapper"})
//@Import({
//		WebConfig.class
//})
//@ContextConfiguration
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,DataSourceTransactionManagerAutoConfiguration.class})
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = SpringBootWebApplication.class)
//@WebIntegrationTest @FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@ActiveProfiles(profiles = "local")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@MybatisTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class ConfTargetOrigMapperTest {
    @Autowired
    private ConfTargetOrigMapper confTargetOrigMapper;
    //@Autowired
    //private TestServiceImpl testService;

    @Test
    public void testGetAll() throws Exception{
    List<ConfTargetOrig> result = confTargetOrigMapper.getAll();
    System.out.println("#Result:"+result);
    }

    @Test
    public void test_getTargetListActivePage() throws Exception{
    ConfTargetOrig req = new ConfTargetOrig();
    req.setPageNo(1);
    req.setPageSize(10);

    List<ConfTargetOrig> result = confTargetOrigMapper.getTargetListActivePage(req);
    System.out.println("#Result:"+result);
    }

    @Test
    public void test_getTargetListByStat() throws Exception{
    ConfTargetOrig req = new ConfTargetOrig();
    req.setPageNo(1);
    req.setPageSize(10);
    req.setOrderType("ASC");
    req.setStat("P");

    List<ConfTargetOrig> result = confTargetOrigMapper.getTargetListByStat(req);
    System.out.println("#Result:"+result);
    }

    @Test
    public void test_getTargetListActiveFirst10() throws Exception{
    List<ConfTargetOrig> result = confTargetOrigMapper.getTargetListActiveFirst10();
    System.out.println("#Result:"+result);
    }

    @Test
    public void test_uptTargetStat() throws Exception{
    ConfTargetOrig req = new ConfTargetOrig();
    req.setTg_id(19);
    req.setStat("P");
    int rs = confTargetOrigMapper.uptTargetStat(req);

    System.out.println("#RS:"+rs);

    List<ConfTargetOrig> result = confTargetOrigMapper.getTargetListActiveFirst10();
    System.out.println("#Result:"+result);
    }


    @Test
    @Rollback(false)
    public void test_insertConfTargetOrig() throws Exception {
        ConfTargetOrig req = new ConfTargetOrig();
        req.setTitle("naver_news collect");
        req.setDescript("news.naver.com searching news");
        req.setTg_url("NAVER_NEWS");
        req.setTg_url_param1("");
        req.setRegid("ghkdwo77");
        req.setStat("Y");
        req.setParam1("영화 title 리뷰");
        req.setIs_fail("N");
        req.setIs_limit("Y");
        req.setIs_manual("N");
        req.setContent_min1(1000);
        req.setContent_max1(20000);
        req.setContent_min2(2000);
        req.setContent_max2(20000);
        req.setFail_count1(10);
        req.setFail_count2(20);

        //int rt = confTargetOrigMapper.insConfTargetOrig(req);
        //System.out.println("#result code:"+rt);
        System.out.println("#result tg_id:"+req.getTg_id());
    }


    @Test
    @Rollback(false)
    public void test_insertConfTargetOrig_navermovie() throws Exception {
        ConfTargetOrig req = new ConfTargetOrig();
        req.setTitle("naver_movie collect");
        req.setDescript("movie.naver.com collecting");
        req.setTg_url("NAVER_MOVIE");
        req.setTg_url_param1("");
        req.setRegid("ghkdwo77");
        req.setStat("Y");
        req.setParam1("site:movie.naver.com #movietitle");
        req.setIs_fail("N");
        req.setIs_limit("Y");
        req.setIs_manual("N");
        req.setContent_min1(1000);
        req.setContent_max1(20000);
        req.setContent_min2(2000);
        req.setContent_max2(20000);
        req.setFail_count1(10);
        req.setFail_count2(20);

        //int rt = confTargetOrigMapper.insConfTargetOrig(req);
        //System.out.println("#result code:"+rt);
        System.out.println("#result tg_id:"+req.getTg_id());
    }



    @Test
    @Rollback(false)
    public void test_insertConfTargetOrig_daummovie() throws Exception {
        ConfTargetOrig req = new ConfTargetOrig();
        req.setTitle("daum_movie collect");
        req.setDescript("movie.daum.net collecting");
        req.setTg_url("DAUM_MOVIE");
        req.setTg_url_param1("");
        req.setRegid("ghkdwo77");
        req.setStat("Y");
        req.setParam1("site://movie.daum.net/moviedb #movietitle");
        req.setIs_fail("N");
        req.setIs_limit("Y");
        req.setIs_manual("N");
        req.setContent_min1(1000);
        req.setContent_max1(20000);
        req.setContent_min2(2000);
        req.setContent_max2(20000);
        req.setFail_count1(10);
        req.setFail_count2(20);

        //int rt = confTargetOrigMapper.insConfTargetOrig(req);
        //System.out.println("#result code:"+rt);
        System.out.println("#result tg_id:"+req.getTg_id());
    }

    @Test
    public void test_insConf_preset() throws Exception {

        ConfPreset ps = new ConfPreset();
        List<ConfPreset> pslist = new ArrayList<ConfPreset>();

		/*
		제외목록
		star.hankookilbo.com : ancmtsJS 사용, HttpClient 적용 안됨, 구조 변경 필요
		www.fnnews.co.kr : redirection
		www.edaily.co.kr : redirection
		chicnews.co.kr : redirection
		 */
        ps = new ConfPreset();
        ps.setDescriptp("/news.maxmovie.com");
        ps.setDest_field("inside-article");
        ps.setPs_tag(".type-post .inside-article");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.maxmovie.com");
        ps.setDest_field("inside-article");
        ps.setPs_tag(".type-post .inside-article");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.ohmynews.com");
        ps.setDest_field("atc-text");
        ps.setPs_tag(".atc-text");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.ohmynews.com");
        ps.setDest_field("article_view");
        ps.setPs_tag(".article_view");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/star.ohmynews.com");
        ps.setDest_field("atc-text");
        ps.setPs_tag(".atc-text");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/pub.chosun.com");
        ps.setDest_field("articleBody");
        ps.setPs_tag("#List_area #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/biz.chosun.com");
        ps.setDest_field("articleBody");
        ps.setPs_tag("#List_area #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/thestar.chosun.com");
        ps.setDest_field("articleBody");
        ps.setPs_tag("#container .article");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/monthly.chosun.com");
        ps.setDest_field("articleBody");
        ps.setPs_tag("#Leftwrapper #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/news.chosun.com");
        ps.setDest_field("news_body_id");
        ps.setPs_tag("#csWrap #news_body_id");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/edu.chosun.com");
        ps.setDest_field("newsCnt");
        ps.setPs_tag("#container .newsCnt");
        ps.setDest_charset("UTF-8");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.etoday.co.kr");
        ps.setDest_field("newsContent");
        ps.setPs_tag(".etoday_content #newsContent");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/enter.etoday.co.kr");
        ps.setDest_field("articleBody");
        ps.setPs_tag("#container #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.imaeil.com");
        ps.setDest_field("article");
        ps.setPs_tag(".article #_article");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/news.khan.co.kr");
        ps.setDest_field("art_body");
        ps.setPs_tag(".art_body");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.khan.co.kr");
        ps.setDest_field("art_body");
        ps.setPs_tag(".art_body");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/biz.khan.co.kr");
        ps.setDest_field("art_body");
        ps.setPs_tag(".art_body");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/sports.khan.co.kr");
        ps.setDest_field("art_body");
        ps.setPs_tag(".art_body");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/weekly.khan.co.kr");
        ps.setDest_field("article_txt");
        ps.setPs_tag(".article_txt");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.seoul.co.kr");
        ps.setDest_field("innerDiv");
        ps.setPs_tag(".middle .innerDiv");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.sportsworldi.com");
        ps.setDest_field("article");
        ps.setPs_tag(".Contents_Container #Article");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/sports.chosun.com");
        ps.setDest_field("news_content");
        ps.setPs_tag(".article .news_content");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/news.donga.com");
        ps.setDest_field("article_view");
        ps.setPs_tag("#contents .article_view");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.donga.com");
        ps.setDest_field("article_view");
        ps.setPs_tag("#contents .article_view");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/sports.donga.com");
        ps.setDest_field("article_view");
        ps.setPs_tag("#contents .article_view");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/game.donga.com");
        ps.setDest_field("contents");
        ps.setPs_tag(".container .contents");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.munhwanews.com");
        ps.setDest_field("article_view");
        ps.setPs_tag("#articleBody #talklink_contents");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.stardailynews.co.kr");
        ps.setDest_field("articleBody");
        ps.setPs_tag("#bodyWrap #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.brainmedia.co.kr");
        ps.setDest_field("contentsWrapper");
        ps.setPs_tag(".SubContents .contentsWrapper");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.vop.co.kr");
        ps.setDest_field("contents");
        ps.setPs_tag(".article-body .contents");
        ps.setDest_charset("UTF-8");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.asiatoday.co.kr");
        ps.setDest_field("article_body");
        ps.setPs_tag(".article_box .article_body");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.sedaily.com");
        ps.setDest_field("contents-article-view");
        ps.setPs_tag("#container #contents-article-view");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.hani.co.kr");
        ps.setDest_field("article-text");
        ps.setPs_tag("#contents-article .article-text");
        ps.setDest_charset("UTF-8");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/osen.mt.co.kr");
        ps.setDest_field("contents2");
        ps.setPs_tag("#container #contents2");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.osen.co.kr");
        ps.setDest_field("contents2");
        ps.setPs_tag("#container #contents2");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/theleader.mt.co.kr");
        ps.setDest_field("content");
        ps.setPs_tag("#container #content");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.segye.com");
        ps.setDest_field("article_txt");
        ps.setPs_tag(".news_article #article_txt");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.newstomato.com");
        ps.setDest_field("rns_text");
        ps.setPs_tag(".rn_scontent .rns_text");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.newsen.com");
        ps.setDest_field("CLtag");
        ps.setPs_tag(".article #CLtag");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/pop.heraldcorp.com");
        ps.setDest_field("CmAdContent");
        ps.setPs_tag(".articleText #CmAdContent");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.econovill.com");
        ps.setDest_field("articleBody");
        ps.setPs_tag("#article-control #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.kinews.net");
        ps.setDest_field("articleBody");
        ps.setPs_tag("#article-control #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.ittoday.co.kr");
        ps.setDest_field("articleBody");
        ps.setPs_tag("#article-control #articleBody");
        ps.setDest_charset("UTF-8");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.tvreport.co.kr");
        ps.setDest_field("contentarea");
        ps.setPs_tag(".news_area #contentarea");
        ps.setDest_charset("UTF-8");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/news.mt.co.kr");
        ps.setDest_field("textBody");
        ps.setPs_tag(".view_text #textBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.moneytoday.co.kr");
        ps.setDest_field("textBody");
        ps.setPs_tag("#gisa_section #textBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.mt.co.kr");
        ps.setDest_field("textBody");
        ps.setPs_tag(".view_text #textBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/topclass.chosun.com");
        ps.setDest_field("articleBody");
        ps.setPs_tag("#wrapper #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/news.khan.co.kr");
        ps.setDest_field("content_text");
        ps.setPs_tag("#container #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/newsculture.heraldcorp.com");
        ps.setDest_field("CmAdContent");
        ps.setPs_tag("#articleBody #CmAdContent");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.newsculture.tv");
        ps.setDest_field("CmAdContent");
        ps.setPs_tag("#articleBody #CmAdContent");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/newsculture.heraldcorp.com");
        ps.setDest_field("CmAdContent");
        ps.setPs_tag("#articleBody #CmAdContent");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/biz.heraldcorp.com");
        ps.setDest_field("articleText");
        ps.setPs_tag(".wrap #articleText");  // /culture
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/biz.heraldcorp.com");
        ps.setDest_field("CmAdContent");
        ps.setPs_tag("#content #CmAdContent"); //pop
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/pop.heraldcorp.com");
        ps.setDest_field("CmAdContent");
        ps.setPs_tag("#content #CmAdContent"); //pop
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/weekly.donga.com");
        ps.setDest_field("view");
        ps.setPs_tag("#content .view");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/isplus.live.joins.com");
        ps.setDest_field("adiContents");
        ps.setPs_tag("#articlebody #adiContents");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/news.joins.com");
        ps.setDest_field("article_body");
        ps.setPs_tag("#content #article_body");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/star.mt.co.kr");
        ps.setDest_field("textBody");
        ps.setPs_tag(".article #textBody");
        ps.setDest_charset("UTF-8");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/the300.mt.co.kr");
        ps.setDest_field("textBody");
        ps.setPs_tag(".view_text #textBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/news.naver.com");
        ps.setDest_field("articleBodyContents");
        ps.setPs_tag("#articleBodyContents");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/news.naver.com");
        ps.setDest_field("articleBody");
        ps.setPs_tag(".end_ct #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.naver.com");
        ps.setDest_field("articleBodyContents");
        ps.setPs_tag("#articleBodyContents");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.naver.com");
        ps.setDest_field("articleBody");
        ps.setPs_tag(".end_ct #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/entertain.naver.com");
        ps.setDest_field("articleBody");
        ps.setPs_tag(".end_ct #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.ajunews.com");
        ps.setDest_field("articleBody");
        ps.setPs_tag("#print_contents #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/polinews.co.kr");
        ps.setDest_field("CmAdContent");
        ps.setPs_tag(".section-contents #CmAdContent");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/bntnews.hankyung.com");
        ps.setDest_field("newsBody");
        ps.setPs_tag("#__newsBody__");
        ps.setDest_charset("EUC-KR");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/wstarnews.hankyung.com");
        ps.setDest_field("cnt-news-wrap");
        ps.setPs_tag("#container .hk-news-view");
        ps.setDest_charset("UTF-8");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/news.hankyung.com");
        ps.setDest_field("hk-news-view");
        //ps.setPs_tag("#container .wrap_view");
        ps.setPs_tag("#container .hk-news-view"); //news
        ps.setDest_charset("UTF-8");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/news.hankyung.com");
        ps.setDest_field("wrap_view");
        ps.setPs_tag("#container .wrap_view"); //news
        //ps.setPs_tag("#container .hk-news-view"); //news
        ps.setDest_charset("UTF-8");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.hankyung.com");
        ps.setDest_field("wrap_view");
        ps.setPs_tag("#container .wrap_view"); //news
        //ps.setPs_tag("#container .hk-news-view"); //news
        ps.setDest_charset("UTF-8");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.hankyung.com");
        ps.setDest_field("wrap_view");
        ps.setPs_tag("#container .hk-news-view");
        ps.setDest_charset("UTF-8");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/hei.hankyung.com");
        ps.setDest_field("contents");
        ps.setPs_tag("#container .hk-news-view");
        ps.setDest_charset("UTF-8");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/tenasia.hankyung.com");
        ps.setDest_field("content");
        ps.setPs_tag(".container .hk-news-view");
        ps.setDest_charset("UTF-8");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/tenasia.hankyung.com");
        ps.setDest_field("content");
        ps.setPs_tag("#content .entry-content");
        ps.setDest_charset("UTF-8");
        pslist.add(ps);
        ps = new ConfPreset();
        ps.setDescriptp("/www.tenasia.co.kr");
        ps.setDest_field("content");
        ps.setPs_tag(".container #content");
        ps.setDest_charset("UTF-8");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/maxim.wowtv.co.kr");
        ps.setDest_field("contentsbodyview");
        ps.setPs_tag("#docbody .contentsbodyview");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.wowtv.co.kr");
        ps.setDest_field("article_contents");
        ps.setPs_tag(".viewContent .article_contents");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.gukjenews.com");
        ps.setDest_field("articleBody");
        ps.setPs_tag("#ND_Wrap #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.bizwatch.co.kr");
        ps.setDest_field("news-view-info");
        ps.setPs_tag(".news-view .news-view-info");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.newsis.com");
        ps.setDest_field("textBody");
        ps.setPs_tag("#article #textBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.asiae.co.kr");
        ps.setDest_field("articleBody");
        ps.setPs_tag(".article");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/er.asiae.co.kr");
        ps.setDest_field("articleBody");
        ps.setPs_tag(".article");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/tvdaily.asiae.co.kr");
        ps.setDest_field("article");
        ps.setPs_tag("#content #_article");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/stoo.asiae.co.kr");
        ps.setDest_field("article");
        ps.setPs_tag("#content #article");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/leaders.asiae.co.kr");
        ps.setDest_field("article");
        ps.setPs_tag("#ND_Wrap #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/view.asiae.co.kr");
        ps.setDest_field("article");
        ps.setPs_tag("#bodyContents .article");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.newscj.com");
        ps.setDest_field("CmAdContent");
        ps.setPs_tag("#articleBody #CmAdContent");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/news.tf.co.kr");
        ps.setDest_field("article");
        ps.setPs_tag(".subWrapper .article");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/foundmag.co.kr");
        ps.setDest_field("xe_content");
        ps.setPs_tag(".contentBody .xe_content");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/star.mk.co.kr");
        ps.setDest_field("read_txt");
        ps.setPs_tag("#artText .read_txt");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/sports.mk.co.kr");
        ps.setDest_field("read_txt");
        ps.setPs_tag("#artText .read_txt");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/news.mk.co.kr");
        ps.setDest_field("article_body");
        ps.setPs_tag("#Content #article_body");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/uberin.mk.co.kr");
        ps.setDest_field("art_txt");
        ps.setPs_tag(".article_view .art_txt");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/mbn.mk.co.kr");
        ps.setDest_field("content");
        ps.setPs_tag("#container #content");
        ps.setDest_charset("UTF-8");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/star.mbn.co.kr");
        ps.setDest_field("artText");
        ps.setPs_tag("#article #artText");
        ps.setDest_charset("UTF-8");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/premium.mk.co.kr");
        ps.setDest_field("content");
        ps.setPs_tag("#container #content");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/chicnews.mk.co.kr");
        ps.setDest_field("CmAdContent");
        ps.setPs_tag("#container #CmAdContent");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/chicnews.co.kr");
        ps.setDest_field("CmAdContent");
        ps.setPs_tag("#container #CmAdContent");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/fashion.mk.co.kr");
        ps.setDest_field("artText");
        ps.setPs_tag("#container #artText");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.ilovepc.co.kr");
        ps.setDest_field("articleBody");
        ps.setPs_tag("#content #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/platum.kr");
        ps.setDest_field("post_content_wrapper");
        ps.setPs_tag(".post_wrapper .post_content_wrapper");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.inven.co.kr");
        ps.setDest_field("contentBody");
        ps.setPs_tag(".content .contentBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.dt.co.kr");
        ps.setDest_field("NewsAdContent");
        ps.setPs_tag("#gisa #NewsAdContent");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/etv.sbs.co.kr");
        ps.setDest_field("cnt_news");
        ps.setPs_tag("#content .cnt_news");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/sbsfune.sbs.co.kr");
        ps.setDest_field("cnt_news");
        ps.setPs_tag("#container .cnt_news");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/sbscnbc.sbs.co.kr");
        ps.setDest_field("atend_center");
        ps.setPs_tag("#content .atend_center");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/news.sbs.co.kr");
        ps.setDest_field("article_cont_area");
        ps.setPs_tag("#container .article_cont_area");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/news.kimb.co.kr");
        ps.setDest_field("articleBody");
        ps.setPs_tag("#article #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/news.kimb.co.kr");
        ps.setDest_field("content");
        ps.setPs_tag("#container #content");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.christiantoday.co.kr");
        ps.setDest_field("article_body");
        ps.setPs_tag(".container #article_body");
        ps.setDest_charset("UTF-8");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.cine21.com");
        ps.setDest_field("news_content");
        ps.setPs_tag("#content #news_content");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.etnews.com");
        ps.setDest_field("articleBody");
        ps.setPs_tag(".view_wrap #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.sisapress.com");
        ps.setDest_field("arDetail");
        ps.setPs_tag(".articleCont .arDetail");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.mediaus.co.kr");
        ps.setDest_field("articleBody");
        ps.setPs_tag(".content #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.newspim.com");
        ps.setDest_field("news_contents");
        ps.setPs_tag(".container #news_contents");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.pdjournal.com");
        ps.setDest_field("articleBody");
        ps.setPs_tag(".content #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.sisainlive.com");
        ps.setDest_field("content");
        ps.setPs_tag(".container #content");
        ps.setDest_charset("UTF-8");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.yonhapnews.co.kr");
        ps.setDest_field("article");
        ps.setPs_tag(".article-wrap .article");
        ps.setDest_charset("UTF-8");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/app.yonhapnews.co.kr");
        ps.setDest_field("article");
        ps.setPs_tag(".article-wrap .article");
        ps.setDest_charset("UTF-8");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.dailian.co.kr");
        ps.setDest_field("content1");
        ps.setPs_tag("#container #content1");
        ps.setDest_charset("UTF-8");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.topstarnews.net");
        ps.setDest_field("adnmore_inImage");
        ps.setPs_tag("#adnmore_inImage");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.newsinside.kr");
        ps.setDest_field("articleBody");
        ps.setPs_tag("#ND_Wrap #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.incheonilbo.com");
        ps.setDest_field("content");
        ps.setPs_tag("#container #content");
        ps.setDest_charset("UTF-8");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.sporbiz.co.kr");
        ps.setDest_field("user-content");
        ps.setPs_tag("#user-container .user-content");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/news20.busan.com");
        ps.setDest_field("viewConText");
        ps.setPs_tag("#s-container #viewConText");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.mydaily.co.kr");
        ps.setDest_field("article");
        ps.setPs_tag(".read_view_wrap #article");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.viva100.com");
        ps.setDest_field("view_left_wrap");
        ps.setPs_tag("#container .view_left_warp");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.kookje.co.kr");
        ps.setDest_field("news_textArea");
        ps.setPs_tag("#Contents #news_textArea");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.g-enews.com");
        ps.setDest_field("detailCont");
        ps.setPs_tag(".V_wrap .detailCont");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.joongdo.co.kr");
        ps.setDest_field("left_text_box");
        ps.setPs_tag("#container .left_text_box");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.sportsq.co.kr");
        ps.setDest_field("articleBody");
        ps.setPs_tag("#article-wrap #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.breaknews.com");
        ps.setDest_field("CLtag");
        ps.setPs_tag("#container_sub #CLtag");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/shindonga.donga.com");
        ps.setDest_field("article_text");
        ps.setPs_tag("#contents #article_text");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.xportsnews.com");
        ps.setDest_field("CmAdContent");
        ps.setPs_tag("#articleView #CmAdContent");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.kwnews.co.kr");
        ps.setDest_field("kwnews_body");
        ps.setPs_tag("#kwnews_body");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.ytn.co.kr");
        ps.setDest_field("CmAdContent");
        ps.setPs_tag("#newsContent #CmAdContent");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.wikitree.co.kr");
        ps.setDest_field("wikicon");
        ps.setPs_tag("#ar_content #wikicon");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.mediatoday.co.kr");
        ps.setDest_field("arl_view_content");
        ps.setPs_tag("#content #arl_view_content");
        ps.setDest_charset("UTF-8");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/star.spotvnews.co.kr");
        ps.setDest_field("arl_view_content");
        ps.setPs_tag("#content #arl_view_content");
        ps.setDest_charset("UTF-8");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/enews.imbc.com");
        ps.setDest_field("content");
        ps.setPs_tag(".container .content");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/imnews.imbc.com");
        ps.setDest_field("content");
        ps.setPs_tag("meta[property=og:description]|content");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.imbc.com");
        ps.setDest_field("content");
        ps.setPs_tag("meta[property=og:description]|content");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.honame.co.kr");
        ps.setDest_field("content");
        ps.setPs_tag("meta[property=og:description]|content");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.cctoday.co.kr");
        ps.setDest_field("content");
        ps.setPs_tag(".container #content");
        ps.setDest_charset("UTF-8");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.itworld.co.kr");
        ps.setDest_field("node_body");
        ps.setPs_tag("#content_body .node_body");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.gamemeca.com");
        ps.setDest_field("article");
        ps.setPs_tag("#content .article");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/news.kmib.co.kr");
        ps.setDest_field("articleBody");
        ps.setPs_tag("#content #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/legacy.acrofan.com");
        ps.setDest_field("secWrap");
        ps.setPs_tag("#wrap #secWrap");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.acrofan.com");
        ps.setDest_field("secWrap");
        ps.setPs_tag("#wrap #secWrap");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.fomos.kr");
        ps.setDest_field("view_text");
        ps.setPs_tag(".page_page_sub .view_text");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/ize.co.kr");
        ps.setDest_field("article_body");
        ps.setPs_tag("#content .article_body");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.starseoultv.com");
        ps.setDest_field("CmAdContent");
        ps.setPs_tag("#articleBody #CmAdContent");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.newsinside.kr");
        ps.setDest_field("CmAdContent");
        ps.setPs_tag("#articleBody #CmAdContent");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/enews24.tving.com");
        ps.setDest_field("article");
        ps.setPs_tag("#container .article");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/ilyo.co.kr");
        ps.setDest_field("CmAdContent");
        ps.setPs_tag(".articleView #CmAdContent");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/newsbrite.net");
        ps.setDest_field("view_content");
        ps.setPs_tag("#container #view_content");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.ujnews.co.kr");
        ps.setDest_field("articleBody");
        ps.setPs_tag("#ND_Wrap #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.ujnews.co.kr");
        ps.setDest_field("articleBody");
        ps.setPs_tag("#ND_Wrap #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.sisunnews.co.kr");
        ps.setDest_field("articleBody");
        ps.setPs_tag(".content #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.fnnews.com");
        ps.setDest_field("content");
        ps.setPs_tag("#container #article_content");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/star.fnnews.com");
        ps.setDest_field("articleBody");
        ps.setPs_tag(".post-container .post-content");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.dailygrid.net");
        ps.setDest_field("articleBody");
        ps.setPs_tag("#ND_Wrap #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.newstown.co.kr");
        ps.setDest_field("articleBody");
        ps.setPs_tag("#ND_Warp #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.gvalley.co.kr");
        ps.setDest_field("articleBody");
        ps.setPs_tag("#ND_Wrap #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.enewstoday.co.kr");
        ps.setDest_field("articleBody");
        ps.setPs_tag("#ND_Wrap #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/news1.kr");
        ps.setDest_field("articles_detail");
        ps.setPs_tag("#content #articles_detail");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.hg-times.com");
        ps.setDest_field("articleBody");
        ps.setPs_tag(".content #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.nextdaily.co.kr");
        ps.setDest_field("articleBody");
        ps.setPs_tag("#container #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.nocutnews.co.kr");
        ps.setDest_field("viewbox");
        ps.setPs_tag(".wrap .viewbox");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.sportsseoul.com");
        ps.setDest_field("article_viewWrap");
        ps.setPs_tag("#contentWrap #article_viewWrap");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.mediapen.com");
        ps.setDest_field("view_r");
        ps.setPs_tag("#.view_r");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.tfnews.co.kr");
        ps.setDest_field("news_body_area");
        ps.setPs_tag("#container .news_body_area");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/seoulwire.com");
        ps.setDest_field("viewContent");
        ps.setPs_tag("#container #viewContent");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.ccdn.co.kr");
        ps.setDest_field("articleBody");
        ps.setPs_tag("#ND_Warp #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.econotalking.kr");
        ps.setDest_field("articleBody");
        ps.setPs_tag("#ND_Warp #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.kns.tv");
        ps.setDest_field("articleBody");
        ps.setPs_tag("#ND_Warp #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.entermedia.co.kr");
        ps.setDest_field("mainCont");
        ps.setPs_tag("#wrap #mainCont");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.joseilbo.com");
        ps.setDest_field("jose_news_view");
        ps.setPs_tag(".view_article_wrap #jose_news_view");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/news.kbs.co.kr");
        ps.setDest_field("cont_newstext");
        ps.setPs_tag("#container #cont_newstext");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.nongaek.com");
        ps.setDest_field("articleBody");
        ps.setPs_tag(".content #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.anewsa.com");
        ps.setDest_field("subSecW");
        ps.setPs_tag("#contents_body #subSecW");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.the-pr.co.kr");
        ps.setDest_field("articleBody");
        ps.setPs_tag("#article-wrap #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.cnews.co.kr");
        ps.setDest_field("newsCont");
        ps.setPs_tag("#container .newsCont");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.yeongnam.com");
        ps.setDest_field("article_text");
        ps.setPs_tag("#container #article_text");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.kyeonggi.com");
        ps.setDest_field("arl_view_content");
        ps.setPs_tag("#container #arl_view_content");
        ps.setDest_charset("UTF-8");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/news.jtbc.joins.com");
        ps.setDest_field("article_content");
        ps.setPs_tag("#article .article_content");
        ps.setDest_charset("UTF-8");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/news.jtbc.com");
        ps.setDest_field("article_content");
        ps.setPs_tag("#article .article_content");
        ps.setDest_charset("UTF-8");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/news.jtbc.co.kr");
        ps.setDest_field("article_content");
        ps.setPs_tag("#article .article_content");
        ps.setDest_charset("UTF-8");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.viewsnnews.com");
        ps.setDest_field("content");
        ps.setPs_tag("#article #content");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.pressian.com");
        ps.setDest_field("content");
        ps.setPs_tag("#container #CmAdContent");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.kihoilbo.co.kr");
        ps.setDest_field("arl_view_content");
        ps.setPs_tag("#container #arl_view_content");
        ps.setDest_charset("UTF-8");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.yonhapnewstv.co.kr");
        ps.setDest_field("entry-content");
        ps.setPs_tag("#content .entry-content");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.cpbc.co.kr");
        ps.setDest_field("article_body");
        ps.setPs_tag(".article_content .article_body");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.webdaily.co.kr");
        ps.setDest_field("articleBody");
        ps.setPs_tag("#container #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.redian.org");
        ps.setDest_field("redian-view-text");
        ps.setPs_tag("#wrap .redian-view-text");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.viewsnnews.com");
        ps.setDest_field("content");
        ps.setPs_tag("#article #content");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.lawissue.co.kr");
        ps.setDest_field("content");
        ps.setPs_tag("#container #content");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.voakorea.com");
        ps.setDest_field("container");
        ps.setPs_tag("#content .container");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.voakorea.com");
        ps.setDest_field("articleBody");
        ps.setPs_tag("#ND_Warp #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.naeil.com");
        ps.setDest_field("contents");
        ps.setPs_tag("#wrap #contents");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/daily.hankooki.com");
        ps.setDest_field("GS_Content");
        ps.setPs_tag("#GS_Content");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/sports.hankooki.com");
        ps.setDest_field("GS_Content");
        ps.setPs_tag("#GS_Content");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.hankookilbo.com");
        ps.setDest_field("DetailCon");
        ps.setPs_tag("#wrap .DetailCon");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.newdaily.co.kr");
        ps.setDest_field("ndArtBody");
        ps.setPs_tag("#ndBody #ndArtBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.sisafocus.co.kr");
        ps.setDest_field("CmAdContent");
        ps.setPs_tag("#articleBody #CmAdContent");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.ktv.go.kr");
        ps.setDest_field("article");
        ps.setPs_tag("#contents .article");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.m-i.kr");
        ps.setDest_field("articleBody");
        ps.setPs_tag("#article-wrap #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/joynews.inews24.com");
        ps.setDest_field("articleBody");
        ps.setPs_tag("#content #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/news.inews24.com");
        ps.setDest_field("articleBody");
        ps.setPs_tag("#content #articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.foodtvnews.com");
        ps.setDest_field("txt_article");
        ps.setPs_tag("#contents .txt_article");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.metroseoul.co.kr");
        ps.setDest_field("CmAdContents");
        ps.setPs_tag("#news_content #CmAdContents");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.kukinews.com");
        ps.setDest_field("news_body_area");
        ps.setPs_tag("#container #news_body_area");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.kbmaeil.com");
        ps.setDest_field("article");
        ps.setPs_tag("#articleBody #_article");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/ppss.kr");
        ps.setDest_field("entry-content");
        ps.setPs_tag("#main-content .entry-content");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.joongboo.com");
        ps.setDest_field("arl_view_content");
        ps.setPs_tag("#content #arl_view_content");
        ps.setDest_charset("UTF-8");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/slownews.kr");
        ps.setDest_field("article_content");
        ps.setPs_tag(".container #article_content");
        ps.setDest_charset("UTF-8");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.insight.co.kr");
        ps.setDest_field("article_content");
        ps.setPs_tag(".content .news__view__article");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.edaily.co.kr");
        ps.setDest_field("article_body");
        ps.setPs_tag("#article_body");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/star.hankookilbo.com");
        ps.setDest_field("redirection");
        ps.setPs_tag("redirection");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.ihalla.com");
        ps.setDest_field("article_txt");
        ps.setPs_tag(".cont_gisa .article_txt");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/kpenews.com");
        ps.setDest_field("article_body");
        ps.setPs_tag("#wrap .article_body");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.cstimes.com");
        ps.setDest_field("arl_view_content");
        ps.setPs_tag("#content #arl_view_content");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.interview365.com");
        ps.setDest_field("article-view-content-div");
        ps.setPs_tag("#user-container #article-view-content-div");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/ch.yes24.com");
        ps.setDest_field("txtBox");
        ps.setPs_tag("#articleView .txtBox");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.mhj21.com");
        ps.setDest_field("textinput");
        ps.setPs_tag("#wrap #textinput");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.munhwa.com");
        ps.setDest_field("NewsAdContent");
        ps.setPs_tag("#view_body #NewsAdContent");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.idomin.com");
        ps.setDest_field("arl_view_content");
        ps.setPs_tag("#container #arl_view_content");
        ps.setDest_charset("UTF-8");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.ceci.co.kr");
        ps.setDest_field("ccmde_adn_p");
        ps.setPs_tag(".ccmd_arcdn_c_w .ccmde_adn_p");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.daejonilbo.com");
        ps.setDest_field("CmAdContent");
        ps.setPs_tag("#article #CmAdContent");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.it.co.kr");
        ps.setDest_field("news_body_area");
        ps.setPs_tag("#container #news_body_area");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/it.chosun.com");
        ps.setDest_field("news_body_area");
        ps.setPs_tag("#container #news_body_area");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.siminsori.com");
        ps.setDest_field("articleBody");
        ps.setPs_tag("#articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.jejuilbo.net");
        ps.setDest_field("articleBody");
        ps.setPs_tag("#articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.inews24.com");
        ps.setDest_field("news_content");
        ps.setPs_tag("#content #news_content");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/v.media.daum.net");
        ps.setDest_field("article");
        ps.setPs_tag(".article");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/v.media.daum.net");
        ps.setDest_field("article_view");
        ps.setPs_tag(".article_view");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.issuedaily.com");
        ps.setDest_field("single_page_content");
        ps.setPs_tag(".content_bottom .single_page_content");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/v.entertain.media.daum.net");
        ps.setDest_field("article_view");
        ps.setPs_tag(".news_view .article_view");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/entermedia.co.kr");
        ps.setDest_field("article");
        ps.setPs_tag("#warp #_article");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.widecoverage.co.kr");
        ps.setDest_field("article_1");
        ps.setPs_tag("#article_1");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.hktimes.kr");
        ps.setDest_field("content");
        ps.setPs_tag("#content");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.jndn.com");
        ps.setDest_field("content");
        ps.setPs_tag("#content");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.businesspost.co.kr");
        ps.setDest_field("rns_text");
        ps.setPs_tag("#rn_wrap .rns_text");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.itdaily.kr");
        ps.setDest_field("CmAdContent");
        ps.setPs_tag("#articleBody #CmAdContent");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.huffingtonpost.kr");
        ps.setDest_field("mainentrycontent");
        ps.setPs_tag("#wrapper #mainentrycontent");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.dkilbo.com");
        ps.setDest_field("articleBody");
        ps.setPs_tag("#article-wrap #articleBody");
        ps.setDest_charset("UTF-8");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.mbcsportsplus.com");
        ps.setDest_field("article_data");
        ps.setPs_tag("#wrap .article_data");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.egn.kr");
        ps.setDest_field("articleBody");
        ps.setPs_tag("#articleBody");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.kcsnews.co.kr");
        ps.setDest_field("contents");
        ps.setPs_tag("#content #contents");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.intronews.net");
        ps.setDest_field("article");
        ps.setPs_tag("#articleBody #_article");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.skyedaily.com");
        ps.setDest_field("newsContent");
        ps.setPs_tag(".article #newsContent");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/1boon.kakao.com");
        ps.setDest_field("section_view");
        ps.setPs_tag("#daumContent .section_view");
        pslist.add(ps);

        ps = new ConfPreset();
        ps.setDescriptp("/www.zkic.net");
        ps.setDest_field("articleBody");
        ps.setPs_tag("#ND_Warp #articleBody");
        pslist.add(ps);

    }
}
