package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShequzixunEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShequzixunView;


/**
 * 社区资讯
 *
 * @author 
 * @email 
 * @date 2024-04-16 18:21:10
 */
public interface ShequzixunService extends IService<ShequzixunEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShequzixunView> selectListView(Wrapper<ShequzixunEntity> wrapper);
   	
   	ShequzixunView selectView(@Param("ew") Wrapper<ShequzixunEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShequzixunEntity> wrapper);
   	

}

