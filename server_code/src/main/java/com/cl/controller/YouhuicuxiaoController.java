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

import com.cl.entity.YouhuicuxiaoEntity;
import com.cl.entity.view.YouhuicuxiaoView;

import com.cl.service.YouhuicuxiaoService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 优惠促销
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-16 18:21:11
 */
@RestController
@RequestMapping("/youhuicuxiao")
public class YouhuicuxiaoController {
    @Autowired
    private YouhuicuxiaoService youhuicuxiaoService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YouhuicuxiaoEntity youhuicuxiao,
		HttpServletRequest request){
        EntityWrapper<YouhuicuxiaoEntity> ew = new EntityWrapper<YouhuicuxiaoEntity>();

		PageUtils page = youhuicuxiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, youhuicuxiao), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YouhuicuxiaoEntity youhuicuxiao, 
		HttpServletRequest request){
        EntityWrapper<YouhuicuxiaoEntity> ew = new EntityWrapper<YouhuicuxiaoEntity>();

		PageUtils page = youhuicuxiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, youhuicuxiao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YouhuicuxiaoEntity youhuicuxiao){
       	EntityWrapper<YouhuicuxiaoEntity> ew = new EntityWrapper<YouhuicuxiaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( youhuicuxiao, "youhuicuxiao")); 
        return R.ok().put("data", youhuicuxiaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YouhuicuxiaoEntity youhuicuxiao){
        EntityWrapper< YouhuicuxiaoEntity> ew = new EntityWrapper< YouhuicuxiaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( youhuicuxiao, "youhuicuxiao")); 
		YouhuicuxiaoView youhuicuxiaoView =  youhuicuxiaoService.selectView(ew);
		return R.ok("查询优惠促销成功").put("data", youhuicuxiaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YouhuicuxiaoEntity youhuicuxiao = youhuicuxiaoService.selectById(id);
		youhuicuxiao = youhuicuxiaoService.selectView(new EntityWrapper<YouhuicuxiaoEntity>().eq("id", id));
        return R.ok().put("data", youhuicuxiao);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YouhuicuxiaoEntity youhuicuxiao = youhuicuxiaoService.selectById(id);
		youhuicuxiao = youhuicuxiaoService.selectView(new EntityWrapper<YouhuicuxiaoEntity>().eq("id", id));
        return R.ok().put("data", youhuicuxiao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YouhuicuxiaoEntity youhuicuxiao, HttpServletRequest request){
    	youhuicuxiao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(youhuicuxiao);
        youhuicuxiaoService.insert(youhuicuxiao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YouhuicuxiaoEntity youhuicuxiao, HttpServletRequest request){
    	youhuicuxiao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(youhuicuxiao);
        youhuicuxiaoService.insert(youhuicuxiao);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YouhuicuxiaoEntity youhuicuxiao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(youhuicuxiao);
        youhuicuxiaoService.updateById(youhuicuxiao);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        youhuicuxiaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
