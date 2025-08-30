	import {
		createRouter,
		createWebHashHistory
	} from 'vue-router'
	import nongchanpin from '@/views/nongchanpin/list'
	import youhuicuxiao from '@/views/youhuicuxiao/list'
	import address from '@/views/address/list'
	import users from '@/views/users/list'
	import cart from '@/views/cart/list'
	import nongchanpinjiaoyu from '@/views/nongchanpinjiaoyu/list'
	import forum from '@/views/forum/list'
	import discussnongchanpin from '@/views/discussnongchanpin/list'
	import nongchanpinfenlei from '@/views/nongchanpinfenlei/list'
	import yonghu from '@/views/yonghu/list'
	import orders from '@/views/orders/list'
	import config from '@/views/config/list'
	import shequzixun from '@/views/shequzixun/list'

export const routes = [{
		path: '/login',
		name: 'login',
		component: () => import('../views/login.vue')
	},{
		path: '/',
		name: '首页',
		component: () => import('../views/index'),
		children: [{
			path: '/',
			name: '首页',
			component: () => import('../views/HomeView.vue'),
			meta: {
				affix: true
			}
		}, {
			path: '/updatepassword',
			name: '修改密码',
			component: () => import('../views/updatepassword.vue')
		}
		
		,{
			path: '/nongchanpin',
			name: '农产品',
			component: nongchanpin
		}
		,{
			path: '/youhuicuxiao',
			name: '优惠促销',
			component: youhuicuxiao
		}
		,{
			path: '/address',
			name: '地址',
			component: address
		}
		,{
			path: '/users',
			name: '管理员',
			component: users
		}
		,{
			path: '/cart',
			name: '购物车',
			component: cart
		}
		,{
			path: '/nongchanpinjiaoyu',
			name: '农产品教育',
			component: nongchanpinjiaoyu
		}
		,{
			path: '/forum',
			name: '我的发布',
			component: forum
		}
		,{
			path: '/discussnongchanpin',
			name: '农产品评论',
			component: discussnongchanpin
		}
		,{
			path: '/nongchanpinfenlei',
			name: '农产品分类',
			component: nongchanpinfenlei
		}
		,{
			path: '/yonghu',
			name: '用户',
			component: yonghu
		}
		,{
			path: '/orders',
			name: '订单管理',
			component: orders
		}
		,{
			path: '/config',
			name: '轮播图',
			component: config
		}
		,{
			path: '/shequzixun',
			name: '社区资讯',
			component: shequzixun
		}
		]
	},
]

const router = createRouter({
	history: createWebHashHistory(process.env.BASE_URL),
	routes
})

export default router
