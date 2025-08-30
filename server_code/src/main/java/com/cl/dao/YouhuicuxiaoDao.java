package com.cl.dao;

import com.cl.entity.YouhuicuxiaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YouhuicuxiaoView;


/**
 * 优惠促销
 * 
 * @author 
 * @email 
 * @date 2024-04-16 18:21:11
 */
public interface YouhuicuxiaoDao extends BaseMapper<YouhuicuxiaoEntity> {
	
	List<YouhuicuxiaoView> selectListView(@Param("ew") Wrapper<YouhuicuxiaoEntity> wrapper);

	List<YouhuicuxiaoView> selectListView(Pagination page,@Param("ew") Wrapper<YouhuicuxiaoEntity> wrapper);
	
	YouhuicuxiaoView selectView(@Param("ew") Wrapper<YouhuicuxiaoEntity> wrapper);
	

}
