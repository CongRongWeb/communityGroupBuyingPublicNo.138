const config = {
  get() {
    return {
      url:
        process.env.VUE_APP_BASE_API_URL + process.env.VUE_APP_BASE_API + '/',
      name: process.env.VUE_APP_BASE_API,
      // 退出到首页链接
      indexUrl:
        'http://localhost:8080/communityGroupBuying/client/h5/index.html',
    }
  },
  getProjectName() {
    return {
      projectName: '农产品团购平台设计与实现',
    }
  },
}
export default config
