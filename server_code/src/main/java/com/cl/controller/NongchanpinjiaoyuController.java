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

import com.cl.entity.NongchanpinjiaoyuEntity;
import com.cl.entity.view.NongchanpinjiaoyuView;

import com.cl.service.NongchanpinjiaoyuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 农产品教育
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-16 18:21:11
 */
@RestController
@RequestMapping("/nongchanpinjiaoyu")
public class NongchanpinjiaoyuController {
    @Autowired
    private NongchanpinjiaoyuService nongchanpinjiaoyuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,NongchanpinjiaoyuEntity nongchanpinjiaoyu,
		HttpServletRequest request){
        EntityWrapper<NongchanpinjiaoyuEntity> ew = new EntityWrapper<NongchanpinjiaoyuEntity>();

		PageUtils page = nongchanpinjiaoyuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nongchanpinjiaoyu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,NongchanpinjiaoyuEntity nongchanpinjiaoyu, 
		HttpServletRequest request){
        EntityWrapper<NongchanpinjiaoyuEntity> ew = new EntityWrapper<NongchanpinjiaoyuEntity>();

		PageUtils page = nongchanpinjiaoyuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nongchanpinjiaoyu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( NongchanpinjiaoyuEntity nongchanpinjiaoyu){
       	EntityWrapper<NongchanpinjiaoyuEntity> ew = new EntityWrapper<NongchanpinjiaoyuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( nongchanpinjiaoyu, "nongchanpinjiaoyu")); 
        return R.ok().put("data", nongchanpinjiaoyuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(NongchanpinjiaoyuEntity nongchanpinjiaoyu){
        EntityWrapper< NongchanpinjiaoyuEntity> ew = new EntityWrapper< NongchanpinjiaoyuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( nongchanpinjiaoyu, "nongchanpinjiaoyu")); 
		NongchanpinjiaoyuView nongchanpinjiaoyuView =  nongchanpinjiaoyuService.selectView(ew);
		return R.ok("查询农产品教育成功").put("data", nongchanpinjiaoyuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        NongchanpinjiaoyuEntity nongchanpinjiaoyu = nongchanpinjiaoyuService.selectById(id);
		nongchanpinjiaoyu = nongchanpinjiaoyuService.selectView(new EntityWrapper<NongchanpinjiaoyuEntity>().eq("id", id));
        return R.ok().put("data", nongchanpinjiaoyu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        NongchanpinjiaoyuEntity nongchanpinjiaoyu = nongchanpinjiaoyuService.selectById(id);
		nongchanpinjiaoyu = nongchanpinjiaoyuService.selectView(new EntityWrapper<NongchanpinjiaoyuEntity>().eq("id", id));
        return R.ok().put("data", nongchanpinjiaoyu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody NongchanpinjiaoyuEntity nongchanpinjiaoyu, HttpServletRequest request){
    	nongchanpinjiaoyu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(nongchanpinjiaoyu);
        nongchanpinjiaoyuService.insert(nongchanpinjiaoyu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody NongchanpinjiaoyuEntity nongchanpinjiaoyu, HttpServletRequest request){
    	nongchanpinjiaoyu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(nongchanpinjiaoyu);
        nongchanpinjiaoyuService.insert(nongchanpinjiaoyu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody NongchanpinjiaoyuEntity nongchanpinjiaoyu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(nongchanpinjiaoyu);
        nongchanpinjiaoyuService.updateById(nongchanpinjiaoyu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        nongchanpinjiaoyuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
