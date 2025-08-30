package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YouhuicuxiaoEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YouhuicuxiaoView;


/**
 * 优惠促销
 *
 * @author 
 * @email 
 * @date 2024-04-16 18:21:11
 */
public interface YouhuicuxiaoService extends IService<YouhuicuxiaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YouhuicuxiaoView> selectListView(Wrapper<YouhuicuxiaoEntity> wrapper);
   	
   	YouhuicuxiaoView selectView(@Param("ew") Wrapper<YouhuicuxiaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YouhuicuxiaoEntity> wrapper);
   	

}

