package tan.test;

import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.shoesmall.pojo.Shoes;
import cn.shoesmall.pojo.ShoesDetail;
import cn.shoesmall.pojo.Shoesclassify;
import cn.shoesmall.pojo.Shoestype;

public class InsertDateTest {
	ShoesDetail shoesdetail = null;
	Shoes shoes = null;
	Shoestype shoestype = null;
	Shoesclassify shoesclassify = null;
	
	public static void main(String[] args) throws Exception{
		PrintWriter printWriter = null;
		Document doc = null;
		for (int i = 1; i <= 80; i++) {
			//参数：页码*60
			String uri = "https://list.tmall.com/search_product.htm?q=%D0%AC%D7%D3&type=p&vmarket=&spm=875.7931836%2FB.a2227oh.d100&from=mallfp..pc_1_searchbutton&s="+(i*60);
			String cookie = "cna=3+o5FZT1SUkCAdzKhQ2UT+n3; _med=dw:1536&dh:864&pw:1920&ph:1080&ist:0; cq=ccp%3D1; hng=CN%7Czh-CN%7CCNY%7C156; lid=fq%E8%8A%92%E6%9E%9C%E6%A8%B1%E6%A1%83562202; enc=82%2BJJZw%2BqPdr9pjejT7fzw8YgVOs0P%2FWApE92xar4%2FTEUEs%2F2MdgaF5q3Wf7M4ujtIfA8rx9NnDtbQQoj52O2A%3D%3D; _m_h5_tk=9a7c1e61c20670673d750ba5abe251c1_1574497624126; _m_h5_tk_enc=418c2fc1bc08aa92a247459781cb45d7; tk_trace=1; t=99169ff8506f01b2e179fd99c199a23f; uc3=nk2=BcEym2pcDuwFRQdQ1QRXVg%3D%3D&id2=UUBYgOaKtqsApQ%3D%3D&lg2=VFC%2FuZ9ayeYq2g%3D%3D&vt3=F8dByuQDbmQgkJgXvRI%3D; tracknick=fq%5Cu8292%5Cu679C%5Cu6A31%5Cu6843562202; uc4=id4=0%40U2LK%2FcHQmcDT5dCSXOEDoF%2FMkpYb&nk4=0%40B0185sxDih6GSKuOHHwVx4zICSRh4d0PnE9Z; lgc=fq%5Cu8292%5Cu679C%5Cu6A31%5Cu6843562202; _tb_token_=e0e6840b3b713; cookie2=14f884d4e4b6c595594d5913dccf0b9a; tt=tmall-main; res=scroll%3A1519*5956-client%3A1519*754-offset%3A1519*5956-screen%3A1536*864; _uab_collina=157466478230837941193179; x5sec=7b22746d616c6c7365617263683b32223a223130383031323566666662383031326161303966373063373539306365303035434d373037653446454a693530655337746f726942786f4d4d6a67774e444d324e6a55324f447378227d; pnm_cku822=098%23E1hvXQvUvbpvUpCkvvvvvjiPRsFO0jYUn2dZQjD2PmPhzjDnRFs9gjlUnLLy0jYPn8wCvvpvvUmmRphvCvvvvvvEvpCWCHp%2BvvwTD7zWQ8TNwyjUtRFZeXDQcneYiXhpVj%2BO3w0x9EkOJ9kx6acEn1viHExrzj7N5jXh6RFZlEKOfCuYiXVvVE6Fp%2B0x9WpXj4yCvv9vvUvzgfBbUOyCvvOUvvVva6mtvpvIvvvvvhCvvvvvvvWvphvUAQvvvQCvpvACvvv2vhCv2RvvvvWvphvWgvhCvvOvCvvvphvPvpvhMMGvvv%3D%3D; l=dBLtyHbrq0GKufcBBOCN5uI8Lm7t7IRAguPRwC4vi_5Cq6YsY0QOkdjXLFv6cjWfTsLB4NSLztv9-etkiepTY-cHtBU4uxDc.; isg=BICAfD6wyZjMjrWV5PS6QAPbUQ6SoWWvwfvdV_oRVBsudSCfohtzY2BHiZ0QRRyr";
			String refer = "https://list.tmall.com/search_product.htm/_____tmd_____/verify/?nc_token=280a6e892c420214ed501e75ee36b4a1&nc_session_id=01pHac_r7gTO1MdbrIrKtNEsNXITLqhu6PDA-yNiLiktl7YRn-GcDS-priC1-pXVLiN8HPWMx6QlMWV-Nw9LKhFln6-0AXmw2z9nEi93BnEETCAsiceQD1ScMb9DRp-c3gRLaccjPoDSHBolutbNlgz7K5xH-3ah6BVeQXD4PWuoeG6UDFw3WNP0GfeRKu_ERPHvJG0DpdSHZOdyTDPcKc6A&nc_sig=05HC3mEKWkjGf2VfkcTmbhTq16TXH2Acg_5wmVyxQKMm3Lp1x4ACHhUXdY5bymVudbu1uzNf4WhQ7EE-OnIl0Xmm8SXnp4Lf1nIF0vo2Gatr7zfpF7HufN_37L5zrEeB6HbhVu1iXu9kYfhmuuQw3ARB-LU2B7-al_9BYSw3PTpeXaG19c5L_zdSgwdu5_LIKyhzIiGJzKxLpS1LnjuS6F8jnEPs_3D0-lJiwaplLuVDYZsc7LFj1tZ39DkJrkFD-TBzJi8DR8pipG8UrOWTBN2R3GOSltYGQU_fw1IBOwj-SgoXMwQyv2A6mLQtaSjPl-eez7iZMQ5KzTY9HxTcsJYiqbv6TLy_pl5Vw6N0p2pKUo2o3GOxbowBqfBsLfhdzr-fzUWtlOEFBEzNgWhabdAlsAxQHojeOF39MSL4bxBD7hzFEHfBtnRa-WizWiPic04to2NXaKdDUXNEw7JSsG-Ck-SRZjEBQ1fw6WogYVWhc&x5secdata=5e0c8e1365474455070961b803bd560607b52cabf5960afff39b64ce58073f78d979de2416369c06d4b7baf6310e2ef30fb58e11561318b0308ef8fd9c3fa89ae9b45d91aba48934916ebdf276f289d197995f71a0a0605de0612f12b73367d781de66ecf56ceefe58b43bc7d00cbc44524b2377b38c5a19331b3954a03b72e661447f3dd0a7856e7a41af69f1700f396b080a23976da62e94da8cbf65f12922cff79d1fc6c1ef4b7821b053f00091c75fd102e32437f7b8741ec5aa54e4ecf05a96b607c3cba52cf264e0eb8554db770bc1524a0ba9894b714e5abb1799eb9201e4ee5c156d344e73c99d13eb28e7f0834483b45f7c195c851e5ea867461b6ef58a49c29fa722359df311fdf60c67e643057e2edd1838e1ccc05f4f01cfb617210e3262c1af4c702d6f07b89fa3f306fe3d96f437e26cb843d9bd96ae725188f8b26098ae3913dec42886212a6d7a39261b7f764385dfac9875f00815d4a5d1159fbba9ebb98a19904b60f4c987d9f6009df39efa3dcae4ac7e36523ca278e3c0326b25201c866cefaa605ebdfb152e03eced26c3ccd17cb89addc1dcbab0fc8c96e83275be4bbc62d35bf0b830049a1659677218a202b8613bc6db95ada332829139a52ef50a24df5cde5df0fe4c84540ab3b44d432b25b07486c8a9cdbf899730f52f17c47dabf2947f91c3d27097ab570034bcc3f82cda2fb36536ba0f78417e2ed383469d2f3dfea15e7025cff04fe732c4e0978c3f88e1afa46d72465be7281617e62893697d529a07ec48877a&x5step=100&nc_app_key=X82Y__2ce9475aeaf38ee29777ad7449d379c2";
	        doc = Jsoup.connect(uri).userAgent("Chrome").header("cookie",cookie).header("referer",refer).post();
	        Elements elements = doc.select("#J_ItemList .product");
			showMsg(elements);
		}
		
	}

	public static void showMsg(Elements elements)throws Exception
	{
	    for (Element element : elements) {
	        System.out.println(element.attr("data-id"));
	        String shoesid = element.attr("data-id");//shoes表的id
	        Element img = element.select(".productImg-wrap>a>img").get(0);
	        String detailUrl = element.select(".product-iWrap>.productImg-wrap>a").attr("href");
	        String imageurl = null;//详细信息图片路径
	        if ("".equalsIgnoreCase(img.attr("src"))){
	        	imageurl = img.attr("data-ks-lazyload");
	            System.out.println(img.attr("data-ks-lazyload"));
	            
	        }else{
	        	imageurl = img.attr("src");
	            System.out.println(img.attr("src"));
	        }
	        String desc = element.select(".product-iWrap .productTitle>a").attr("title");
	        String price = element.select(".product-iWrap .productPrice>em").attr("title");
	        System.out.println(element.select(".product-iWrap .productTitle>a").attr("title"));
	        System.out.println(element.select(".product-iWrap .productPrice>em").attr("title"));
	        try{
	            showDetail(detailUrl);
	        }catch(Exception e)
	        {
	            System.out.println("有问题！！！");
	        }
	    }
	}

	public static void showDetail(String detailUrl)throws Exception
	{
	    Document doc = Jsoup.connect("https:"+detailUrl).get();
	    Elements elements = doc.select("ul[data-property='颜色分类']>li");
	    Elements sizes = doc.select("ul[data-property='鞋码']>li");
	    for (int i = 0; i < 3; i++) {
	    	Element element = elements.get(i);
	    	Element size = sizes.get(i);
	    	String image = element.select("a").attr("style");//颜色
	    	int index = image.indexOf("(");
	    	int lastindex = image.indexOf(")");
	    	String smallImage = image.substring(index+1, lastindex);
	    	String Bigimage = smallImage.replace("40x40", "430x430");
	    	
	    	String sizestr = size.select("a>span").html();
	    	System.out.println(sizestr);
	    	System.out.println(Bigimage);
	        System.out.println(element.attr("title"));
		}
	}
}
