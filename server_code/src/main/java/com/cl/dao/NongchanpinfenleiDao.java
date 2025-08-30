package com.cl.dao;

import com.cl.entity.NongchanpinfenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.NongchanpinfenleiView;


/**
 * 农产品分类
 * 
 * @author 
 * @email 
 * @date 2024-04-16 18:21:10
 */
public interface NongchanpinfenleiDao extends BaseMapper<NongchanpinfenleiEntity> {
	
	List<NongchanpinfenleiView> selectListView(@Param("ew") Wrapper<NongchanpinfenleiEntity> wrapper);

	List<NongchanpinfenleiView> selectListView(Pagination page,@Param("ew") Wrapper<NongchanpinfenleiEntity> wrapper);
	
	NongchanpinfenleiView selectView(@Param("ew") Wrapper<NongchanpinfenleiEntity> wrapper);
	

}
