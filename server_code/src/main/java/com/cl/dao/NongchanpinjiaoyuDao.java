package com.cl.dao;

import com.cl.entity.NongchanpinjiaoyuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.NongchanpinjiaoyuView;


/**
 * 农产品教育
 * 
 * @author 
 * @email 
 * @date 2024-04-16 18:21:11
 */
public interface NongchanpinjiaoyuDao extends BaseMapper<NongchanpinjiaoyuEntity> {
	
	List<NongchanpinjiaoyuView> selectListView(@Param("ew") Wrapper<NongchanpinjiaoyuEntity> wrapper);

	List<NongchanpinjiaoyuView> selectListView(Pagination page,@Param("ew") Wrapper<NongchanpinjiaoyuEntity> wrapper);
	
	NongchanpinjiaoyuView selectView(@Param("ew") Wrapper<NongchanpinjiaoyuEntity> wrapper);
	

}
