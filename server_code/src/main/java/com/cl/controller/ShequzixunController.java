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

import com.cl.entity.ShequzixunEntity;
import com.cl.entity.view.ShequzixunView;

import com.cl.service.ShequzixunService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 社区资讯
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-16 18:21:10
 */
@RestController
@RequestMapping("/shequzixun")
public class ShequzixunController {
    @Autowired
    private ShequzixunService shequzixunService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShequzixunEntity shequzixun,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date fabushijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date fabushijianend,
		HttpServletRequest request){
        EntityWrapper<ShequzixunEntity> ew = new EntityWrapper<ShequzixunEntity>();
                if(fabushijianstart!=null) ew.ge("fabushijian", fabushijianstart);
                if(fabushijianend!=null) ew.le("fabushijian", fabushijianend);

		PageUtils page = shequzixunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shequzixun), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShequzixunEntity shequzixun, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date fabushijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date fabushijianend,
		HttpServletRequest request){
        EntityWrapper<ShequzixunEntity> ew = new EntityWrapper<ShequzixunEntity>();
                if(fabushijianstart!=null) ew.ge("fabushijian", fabushijianstart);
                if(fabushijianend!=null) ew.le("fabushijian", fabushijianend);

		PageUtils page = shequzixunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shequzixun), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShequzixunEntity shequzixun){
       	EntityWrapper<ShequzixunEntity> ew = new EntityWrapper<ShequzixunEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shequzixun, "shequzixun")); 
        return R.ok().put("data", shequzixunService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShequzixunEntity shequzixun){
        EntityWrapper< ShequzixunEntity> ew = new EntityWrapper< ShequzixunEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shequzixun, "shequzixun")); 
		ShequzixunView shequzixunView =  shequzixunService.selectView(ew);
		return R.ok("查询社区资讯成功").put("data", shequzixunView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShequzixunEntity shequzixun = shequzixunService.selectById(id);
		shequzixun = shequzixunService.selectView(new EntityWrapper<ShequzixunEntity>().eq("id", id));
        return R.ok().put("data", shequzixun);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShequzixunEntity shequzixun = shequzixunService.selectById(id);
		shequzixun = shequzixunService.selectView(new EntityWrapper<ShequzixunEntity>().eq("id", id));
        return R.ok().put("data", shequzixun);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShequzixunEntity shequzixun, HttpServletRequest request){
    	shequzixun.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shequzixun);
        shequzixunService.insert(shequzixun);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShequzixunEntity shequzixun, HttpServletRequest request){
    	shequzixun.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shequzixun);
        shequzixunService.insert(shequzixun);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShequzixunEntity shequzixun, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shequzixun);
        shequzixunService.updateById(shequzixun);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shequzixunService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
