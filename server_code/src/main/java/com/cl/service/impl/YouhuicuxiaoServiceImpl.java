package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.YouhuicuxiaoDao;
import com.cl.entity.YouhuicuxiaoEntity;
import com.cl.service.YouhuicuxiaoService;
import com.cl.entity.view.YouhuicuxiaoView;

@Service("youhuicuxiaoService")
public class YouhuicuxiaoServiceImpl extends ServiceImpl<YouhuicuxiaoDao, YouhuicuxiaoEntity> implements YouhuicuxiaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YouhuicuxiaoEntity> page = this.selectPage(
                new Query<YouhuicuxiaoEntity>(params).getPage(),
                new EntityWrapper<YouhuicuxiaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YouhuicuxiaoEntity> wrapper) {
		  Page<YouhuicuxiaoView> page =new Query<YouhuicuxiaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YouhuicuxiaoView> selectListView(Wrapper<YouhuicuxiaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YouhuicuxiaoView selectView(Wrapper<YouhuicuxiaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
