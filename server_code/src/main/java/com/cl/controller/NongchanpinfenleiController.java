package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.NongchanpinfenleiEntity;
import com.cl.entity.view.NongchanpinfenleiView;

import com.cl.service.NongchanpinfenleiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 农产品分类
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-16 18:21:10
 */
@RestController
@RequestMapping("/nongchanpinfenlei")
public class NongchanpinfenleiController {
    @Autowired
    private NongchanpinfenleiService nongchanpinfenleiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,NongchanpinfenleiEntity nongchanpinfenlei,
		HttpServletRequest request){
        EntityWrapper<NongchanpinfenleiEntity> ew = new EntityWrapper<NongchanpinfenleiEntity>();

		PageUtils page = nongchanpinfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nongchanpinfenlei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,NongchanpinfenleiEntity nongchanpinfenlei, 
		HttpServletRequest request){
        EntityWrapper<NongchanpinfenleiEntity> ew = new EntityWrapper<NongchanpinfenleiEntity>();

		PageUtils page = nongchanpinfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nongchanpinfenlei), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( NongchanpinfenleiEntity nongchanpinfenlei){
       	EntityWrapper<NongchanpinfenleiEntity> ew = new EntityWrapper<NongchanpinfenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( nongchanpinfenlei, "nongchanpinfenlei")); 
        return R.ok().put("data", nongchanpinfenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(NongchanpinfenleiEntity nongchanpinfenlei){
        EntityWrapper< NongchanpinfenleiEntity> ew = new EntityWrapper< NongchanpinfenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( nongchanpinfenlei, "nongchanpinfenlei")); 
		NongchanpinfenleiView nongchanpinfenleiView =  nongchanpinfenleiService.selectView(ew);
		return R.ok("查询农产品分类成功").put("data", nongchanpinfenleiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        NongchanpinfenleiEntity nongchanpinfenlei = nongchanpinfenleiService.selectById(id);
		nongchanpinfenlei = nongchanpinfenleiService.selectView(new EntityWrapper<NongchanpinfenleiEntity>().eq("id", id));
        return R.ok().put("data", nongchanpinfenlei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        NongchanpinfenleiEntity nongchanpinfenlei = nongchanpinfenleiService.selectById(id);
		nongchanpinfenlei = nongchanpinfenleiService.selectView(new EntityWrapper<NongchanpinfenleiEntity>().eq("id", id));
        return R.ok().put("data", nongchanpinfenlei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody NongchanpinfenleiEntity nongchanpinfenlei, HttpServletRequest request){
    	nongchanpinfenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(nongchanpinfenlei);
        nongchanpinfenleiService.insert(nongchanpinfenlei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody NongchanpinfenleiEntity nongchanpinfenlei, HttpServletRequest request){
    	nongchanpinfenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(nongchanpinfenlei);
        nongchanpinfenleiService.insert(nongchanpinfenlei);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody NongchanpinfenleiEntity nongchanpinfenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(nongchanpinfenlei);
        nongchanpinfenleiService.updateById(nongchanpinfenlei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        nongchanpinfenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
