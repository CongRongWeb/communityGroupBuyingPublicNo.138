package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.NongchanpinfenleiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.NongchanpinfenleiView;


/**
 * 农产品分类
 *
 * @author 
 * @email 
 * @date 2024-04-16 18:21:10
 */
public interface NongchanpinfenleiService extends IService<NongchanpinfenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<NongchanpinfenleiView> selectListView(Wrapper<NongchanpinfenleiEntity> wrapper);
   	
   	NongchanpinfenleiView selectView(@Param("ew") Wrapper<NongchanpinfenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<NongchanpinfenleiEntity> wrapper);
   	

}

