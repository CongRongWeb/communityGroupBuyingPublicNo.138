package com.cl.dao;

import com.cl.entity.ShequzixunEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShequzixunView;


/**
 * 社区资讯
 * 
 * @author 
 * @email 
 * @date 2024-04-16 18:21:10
 */
public interface ShequzixunDao extends BaseMapper<ShequzixunEntity> {
	
	List<ShequzixunView> selectListView(@Param("ew") Wrapper<ShequzixunEntity> wrapper);

	List<ShequzixunView> selectListView(Pagination page,@Param("ew") Wrapper<ShequzixunEntity> wrapper);
	
	ShequzixunView selectView(@Param("ew") Wrapper<ShequzixunEntity> wrapper);
	

}
