package tan.test;

import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.shoesmall.pojo.Shoes;
import cn.shoesmall.pojo.Shoesdetail;
import cn.shoesmall.pojo.Shoesclassify;
import cn.shoesmall.pojo.Shoestype;
import cn.shoesmall.util.PrimaryKeyGeneric;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;

public class InsertDateTest {
	private static BaseDao dao = new BaseDaoImpl();
	private static Shoesdetail shoesdetail = null;
	private static Shoes shoes = null;
	private static Shoestype shoestype = null;
	private static Shoesclassify shoesclassify = null;
	private static String desc = null;
	private static String price = null;
	private static String shoesid = null;
	private static String imageurl = null;//详细信息图片路径
	
	public static void main(String[] args) throws Exception{
		PrintWriter printWriter = null;
		Document doc = null;
		for (int i = 7; i <= 80; i++) {
			//参数：页码*60
			System.out.println(i);
			String uri = "https://list.tmall.com/search_product.htm?q=%D0%AC%D7%D3&type=p&vmarket=&spm=875.7931836%2FB.a2227oh.d100&from=mallfp..pc_1_searchbutton&s="+(i*60);
			String cookie = "t=d0405d47a1e925c04d248c2a5d4a08bc; _tb_token_=eae86e3e7ef35; cookie2=16b838ee4f1182e8cd0e5580d24d339f; _med=dw:1536&dh:864&pw:1920&ph:1080&ist:0; cna=XNRaFgXIAy8CAXWIGKn8ej4I; _m_h5_tk=336f90a41faf8c31ade63ea55d5c2301_1574672838824; _m_h5_tk_enc=36b05d743233b09967096d11e0ae8492; dnk=fq%5Cu8292%5Cu679C%5Cu6A31%5Cu6843562202; uc1=cookie14=UoTbmVY1AY5q9A%3D%3D&lng=zh_CN&cookie15=V32FPkk%2Fw0dUvg%3D%3D&tag=8&existShop=false&cookie21=UIHiLt3xThH8t7YQoFNq&pas=0&cookie16=WqG3DMC9UpAPBHGz5QBErFxlCA%3D%3D; uc3=vt3=F8dByuQBIyDVMT%2FRT%2Bw%3D&id2=UUBYgOaKtqsApQ%3D%3D&lg2=WqG3DMC9VAQiUQ%3D%3D&nk2=BcEym2pcDuwFRQdQ1QRXVg%3D%3D; tracknick=fq%5Cu8292%5Cu679C%5Cu6A31%5Cu6843562202; lid=fq%E8%8A%92%E6%9E%9C%E6%A8%B1%E6%A1%83562202; uc4=id4=0%40U2LK%2FcHQmcDT5dCSXOEDong6odTz&nk4=0%40B0185sxDih6GSKuOHHwVx4zICSRh47OUmNYK; lgc=fq%5Cu8292%5Cu679C%5Cu6A31%5Cu6843562202; csg=ecea6b82; enc=e9zvQmcPhk8OGiTIH0k0gMC202%2BYZpfAXH0Wc0qAnpBwd8QEFbTGmz61f25v8Egwh0fDTKR6N3XZn%2FoptQ3%2BuQ%3D%3D; _uab_collina=157466461189154933098291; cq=ccp%3D1; res=scroll%3A1022*7160-client%3A1022*754-offset%3A1022*7160-screen%3A1536*864; pnm_cku822=098%23E1hvS9vUvbpvjQCkvvvvvjiPRsFOgjDbPscp6j1VPmPhljnhR2zOQjEVR25O1jR5vpvhvvmv9FyCvvpvvvvvvphvC9vhvvCvpvyCvhQvSlvvC0TB9W2%2B%2BfvsxI2hzR9t%2BFBCAfevD40wjomxfaClHqhIowynSXVAI2pwD7zOaXp7EcqZafFCKdyIvExrtj7ZHkyZAn2ptCOqKphv8vvvvvCvpvvvvvvmC6CvmW%2BvvvWvphvW9pvvvQCvpvs9vvv2vhCv2RmEvpvVmvvC9jaPuphvmvvv92Nk9IBF2QhvCPMMvvv%3D; x5sec=7b22746d616c6c7365617263683b32223a223338336266646262376536653832353038663238623437363530373261663530434a5742372b344645492f5977506a4c2b66503664426f4e4d6a67774e444d324e6a55324f4473784d673d3d227d; isg=BLKy6A64OxbYIAcqhO6m_g56A_iUQ7bdTY12bnyLq2VQD1AJZNFE7Lxu_-sWfy51; l=dBgVyXZqqV8aVV8YBOCwnurza77tMIRVguPzaNbMi_5Ct6L1Zv_OkdDiQFp6cjWciQTB4dH2-setRFZ4-yJZjdVoqYP3VmnJBef..";
			String refer = "https://list.tmall.com/search_product.htm/_____tmd_____/verify/?nc_token=6b2cc2ce2278343e22691afdceeb21d4&nc_session_id=01Fnme8e7F--1XLwwv8kNCV2Ct6QM-0JxCkOqMgcwRYD_rIp-vuKert7QHMUO3sFYRN8HPWMx6QlMWV-Nw9LKhFln6-0AXmw2z9nEi93BnEERe6zXe46-IVDsv8JiOZml6RLaccjPoDSHBolutbNlgz7K5xH-3ah6BVeQXD4PWuoeG6UDFw3WNP0GfeRKu_ERPHvJG0DpdSHZOdyTDPcKc6A&nc_sig=05HC3mEKWkjGf2VfkcTmbhTq16TXH2Acg_5wmVyxQKMm3881eEJLyAy8VVvNhzRJbp3_RBUkkwkTT0Zau-6O3h1yO2QY8NVas-TmCPv2LqHIRlx7wRnhajEkOBQtp2Y3rID8M2Q7ic4YLfd5XCMThYkaCPpEW2BnFQnpsHSB0_VgJ1idGa9ucFcrKJkw5KdokkhzIiGJzKxLpS1LnjuS6F8jnEPs_3D0-lJiwaplLuVDZF-dohaItntkf_zxlz1j7qo498k1tBzP-OlSGXUFw32h3GOSltYGQU_fw1IBOwj-SgoXMwQyv2A6mLQtaSjPl-eez7iZMQ5KzTY9HxTcsJYiqbv6TLy_pl5Vw6N0p2pKUo2o3GOxbowBqfBsLfhdzr7tMe557WiYzMk6M6bzoKzlsAxQHojeOF39MSL4bxBD5uGNFCsVM5emLf8JPe-GAkh-PorG_oWcqnO8LRLR4Ff-Q7KAl9e4x3gSlU5GRFmlk&x5secdata=5e0c8e1365474455070961b803bd560607b52cabf5960afff39b64ce58073f78d979de2416369c06d4b7baf6310e2ef30fb58e11561318b0308ef8fd9c3fa89ae9b45d91aba48934916ebdf276f289d197995f71a0a0605de0612f12b73367d781de66ecf56ceefe58b43bc7d00cbc44524b2377b38c5a19331b3954a03b72e6906bb9c029307bd77b997b5aa99165751435f2a99f858e7d33e0baea19166c316455fa79c8c7c2d8e057fdb99e9cd3f85fd102e32437f7b8741ec5aa54e4ecf05a96b607c3cba52cf264e0eb8554db770bc1524a0ba9894b714e5abb1799eb9201e4ee5c156d344e73c99d13eb28e7f0834483b45f7c195c851e5ea867461b6ef58a49c29fa722359df311fdf60c67e643057e2edd1838e1ccc05f4f01cfb617210e3262c1af4c702d6f07b89fa3f306fe3d96f437e26cb843d9bd96ae725188f8b26098ae3913dec42886212a6d7a39261b7f764385dfac9875f00815d4a5d1159fbba9ebb98a19904b60f4c987d9f6009df39efa3dcae4ac7e36523ca278e3c0326b25201c866cefaa605ebdfb152e03eced26c3ccd17cb89addc1dcbab0fcc51d89c1e68b4e3fd638972570cb3fdebdb6299375ebc7816874c85fff08c632d0afc680f14447003da0bfefdef75eb1546e959c6286fbb6decd71514c40b3c815bd8a5c93b5dfb1d04921a9b7980a31f98bd09acd56c29f0504959e615ba26be45435f6ddd824118b38693c50fe7fac6a6cb6389eec17f85ad44ed0641b805ae5b8ee0fa3d387e3f75b3e37d26f8b565d9a678964b11679bf2531504047e854&x5step=100&nc_app_key=X82Y__2ce9475aeaf38ee29777ad7449d379c2";
	        doc = Jsoup.connect(uri).userAgent("Chrome").header("cookie",cookie).header("referer",refer).post();
	        Elements elements = doc.select("#J_ItemList .product");
			showMsg(elements);
		}
		
	}

	public static void showMsg(Elements elements)
	{
	    for (Element element : elements) {
	    	shoesclassify = new Shoesclassify();
	    	shoes = new Shoes();
	    	shoestype = new Shoestype();
	    	
	    	//生成uuid
	    	String shoestypeid = PrimaryKeyGeneric.getPrimaryKey();
	    	String shoesclassifyid = PrimaryKeyGeneric.getPrimaryKey();
	    	
	        shoesid = element.attr("data-id");//shoes表的id
	        Element img = element.select(".productImg-wrap>a>img").get(0);
	        String detailUrl = element.select(".product-iWrap>.productImg-wrap>a").attr("href");
	        if ("".equalsIgnoreCase(img.attr("src"))){
	        	imageurl = img.attr("data-ks-lazyload");
	            System.out.println(img.attr("data-ks-lazyload"));
	            
	        }else{
	        	imageurl = img.attr("src");
	            System.out.println(img.attr("src"));
	        }
	        desc = element.select(".product-iWrap .productTitle>a").attr("title");
	        price = element.select(".product-iWrap .productPrice>em").attr("title");
	        //设置鞋子属性
	        shoes.setShoesid(shoesid);
	        shoes.setShoesname(desc);
	        shoes.setShoestypeid(shoestypeid);
	        shoes.setShoesclassifyid(shoesclassifyid);
	        
	        //设置鞋子种类属性
	        shoestype.setShoestypeid(shoestypeid);
	        shoestype.setShoestypename(desc);
	        shoestype.setWhether(getWe(desc));
	        
	        //设置鞋子分类属性
	        shoesclassify.setShoesclassifyid(shoesclassifyid);
	        shoesclassify.setShoescalssifyname(desc);
	        
	        dao.insert("insertShoes", shoes);
	        dao.insert("insertShoesType", shoestype);
	        dao.insert("insertShoesClassify", shoesclassify);
	        
	        try{
	            showDetail(detailUrl);
	        }catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
	}

	public static void showDetail(String detailUrl)throws Exception
	{
	    Document doc = Jsoup.connect("https:"+detailUrl).get();
	    Elements elements = doc.select("ul[data-property='颜色分类']>li");
	    Elements sizes = doc.select("ul[data-property='尺码']>li");
	    int lenght = 0;
	    if (elements.size() < 3) {
	    	lenght = elements.size();
		}else {
			lenght = 3;
		}
	    for (int i = 0; i < lenght; i++) {
	    	Element element = elements.get(i);
	    	String image = element.select("a").attr("style");//颜色
	    	int index = image.indexOf("(");
	    	int lastindex = image.indexOf(")");
	    	String smallImage = image.substring(index+1, lastindex);
	    	String Bigimage = smallImage.replace("40x40", "430x430");
	    	String color = element.attr("title");
	    	System.out.println(Bigimage);
	    	
	    	//得到尺码
	    	for (int j = 0; j < 3; j++) {
	    		shoesdetail = new Shoesdetail();
	    		String shoesdetailid = PrimaryKeyGeneric.getPrimaryKey();
	    		
	    		Element size = sizes.get(j);
	    		String sizestr = size.select("a>span").html().substring(0,2);
	    		System.out.println(sizestr);
	    		
	    		//shoesdetail设置属性
	    		shoesdetail.setShoesid(shoesid);
	    		shoesdetail.setShoesdetailid(shoesdetailid);
	    		shoesdetail.setColor(color);
	    		shoesdetail.setSize(sizestr);
	    		shoesdetail.setDescs(desc);
	    		shoesdetail.setCount(100);
	    		shoesdetail.setPrice(Float.parseFloat(price));
	    		shoesdetail.setFrequence(0);
	    		shoesdetail.setImage(Bigimage);
	    		dao.insert("insertShoesDetail", shoesdetail);
			}
	    	System.out.println(Bigimage);
	        System.out.println(element.attr("title"));
		}
	}
	
	public static String getWe(String s) {
		if (s.indexOf("春")!=-1) {
			return "spring";
		}
		if (s.indexOf("夏")!=-1) {
			return "summer";
		}
		if (s.indexOf("秋")!=-1) {
			return "autumn";
		}
		if (s.indexOf("冬")!=-1) {
			return "winter";
		}
		return "spring";
	}
	
	
}
