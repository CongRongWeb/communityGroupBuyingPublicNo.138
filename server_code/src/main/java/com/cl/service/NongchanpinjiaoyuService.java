package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.NongchanpinjiaoyuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.NongchanpinjiaoyuView;


/**
 * 农产品教育
 *
 * @author 
 * @email 
 * @date 2024-04-16 18:21:11
 */
public interface NongchanpinjiaoyuService extends IService<NongchanpinjiaoyuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<NongchanpinjiaoyuView> selectListView(Wrapper<NongchanpinjiaoyuEntity> wrapper);
   	
   	NongchanpinjiaoyuView selectView(@Param("ew") Wrapper<NongchanpinjiaoyuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<NongchanpinjiaoyuEntity> wrapper);
   	

}

