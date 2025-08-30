// app.js
App({
    onLaunch() {
        const tabarList=[]
        const genPages=[]
    tabarList.push("forum")
    tabarList.push("nongchanpin")
    tabarList.push("nongchanpinjiaoyu")
        this.globalData.tabarList=tabarList
    },
    globalData: {
        name: null,
        goodsList: [],
        detailList: {},
        detailId: null,
        tabarList:[],
        userInfo:{},
        total:"",
        editorContent:''

    },

})