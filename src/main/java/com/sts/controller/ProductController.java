package com.sts.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sts.pojo.Product;
import com.sts.pojo.User;
import com.sts.service.CategoryService;
import com.sts.service.ProductService;
import com.sts.service.UserService;

import cn.itcast.commons.CommonUtils;

@Controller
@RequestMapping(value="/product/")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping("productUpload")
	public String upload(Product product, HttpServletRequest request, Model model) throws Exception{
	  /*//保存数据库的路径
	  String sqlPath = null; */
	  //定义文件保存的本地路径
      String localPath="F:\\images\\";
      //定义 文件名
      String filename = null;  
      if(!product.getFile().isEmpty()){  
          //生成uuid作为文件名称  
          String uuid = CommonUtils.uuid();  
          //获得文件类型（可以判断如果不是图片，禁止上传）  
          String contentType = product.getFile().getContentType();  
          //获得文件后缀名 
          String suffixName = contentType.substring(contentType.indexOf("/")+1);
          //得到 文件名
          filename = uuid+"."+suffixName; 
          //文件保存路径
          product.getFile().transferTo(new File(localPath+filename));  
      }
      /*//把图片的相对路径保存至数据库
      sqlPath = "/images/"+filename;*/
      
      product.setGoodImage(filename);
      
      User u = new User();
      u = (User) request.getSession().getAttribute("cur_user");
      
      product.setUserId(u.getUserId());
      boolean flag = false;
      flag = productService.saveProduct(product);
      if(flag){
    	  return "common_success";
      }
	  return "common_error";
	}
	
	@RequestMapping("productInfo")
	public String queryInfo(String goodId, Model model){
		Product product = new Product();
		product = productService.queryInfo(goodId);
		User seller = userService.queryByUid(product.getUserId());
		model.addAttribute("seller", seller);
		model.addAttribute("product", product);
		return "product_info";
	}
	
	/**
	 * 根据商品类别查找商品列表
	 * @return
	 */
	@RequestMapping("productList")
	public String queryListByCid(@RequestParam(defaultValue="1",required=true,value="pageNo") Integer pageNo, String cid, Model model){
		
		//根据cid查找商品分类名称
		String categoryName = categoryService.queryCNameByCid(cid);
		
		Integer pageSize = 6;//每页显示记录数
        //分页查询
        PageHelper.startPage(pageNo, pageSize);
        
        if(cid != null && !"".equals(cid)){
        	//根据cid查找该类下的商品列表
            List<Product> productList = productService.queryListByCid(cid);
            
            PageInfo<Product> pageInfo = new PageInfo<Product>(productList);
            
            model.addAttribute("pageInfo", pageInfo);
    		model.addAttribute("categoryName", categoryName);
    		model.addAttribute("cid", cid);
        } else {
        	List<Product> productList = productService.queryListByType();
            PageInfo<Product> pageInfo=new PageInfo<Product>(productList);
            model.addAttribute("pageInfo", pageInfo);
    		model.addAttribute("categoryName", "拍卖专区");
        }
        
		return "main";
	}
	
	@RequestMapping("queryListByName")
	public String queryListByName(@RequestParam(defaultValue="1",required=true,value="pageNo") Integer pageNo, String goodName, Model model){
		
		Integer pageSize = 6;//每页显示记录数
        //分页查询
        PageHelper.startPage(pageNo, pageSize);
        
        List<Product> productList = productService.queryListByName(goodName);
        PageInfo<Product> pageInfo = new PageInfo<Product>(productList);
        
        model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("categoryName", "有关"+goodName+"的结果");
        
		return "main";
	}
	
	@RequestMapping("productPub")
	public String pubProducts(){
		
		return "product_pub";
	}

}
