$(function () {
    $("#jqGrid").jqGrid({
        url: '../setting/projectachievement/listbyuser',
        datatype: "json",
        colModel: [
            { label: '单据ID', name: 'id', width: 45, key: true },
            { label: '项目名称', name: 'projectName', width: 75 },
            { label: '考核人', name: 'ownerName', width: 75 },
            { label: '被考核人', name: 'workName', width: 90 },
            { label: '得分', name: 'totalScore', width: 90 },
            { label: '开始时间', name: 'startTime', width: 90 },
            { label: '截止时间', name: 'endTime', width: 90 },
            { label: '是否完成', name: 'finish', width: 80, formatter: function(value, options, row){
                return value === 0 ?
                    '<span class="label label-danger">否</span>' :
                    '<span class="label label-success">是</span>';
            }},

        ],
        viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList : [10,30,50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page",
            rows:"limit",
            order: "order"
        },
        gridComplete:function(){
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
        }
    });
});

var vm = new Vue({
    el:'#rrapp',
    data:{
        q:{
            projectId: null
        },
        showList: true,
        title:null,
        paTemp:{},
        projectAchievementScore:{},
        total:0,
        pac:[]
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function(){
            vm.showList = false;
            vm.title = "新增";
            vm.projectAchievementScore = {userIdList:[],projectId:null};
        },
        update: function () {
            var id = getSelectedRow();
            if(id == null){
                return ;
            }
            this.getProjectAchievementContent(id);
            vm.showList = false;
            vm.title = "打分";
            vm.pac = [];
        },
        del: function () {
            var projectIds = getSelectedRows();
            if(projectIds == null){
                return ;
            }

            confirm('确定要删除选中的记录？', function(){
                $.ajax({
                    type: "POST",
                    url: "../setting/projectachievement/delete",
                    contentType: "application/json",
                    data: JSON.stringify(projectIds),
                    success: function(r){
                        if(r.code == 0){
                            alert('操作成功', function(index){
                                vm.reload();
                            });
                        }else{
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        saveOrUpdate: function (event) {
            //var url = vm.project.id == null ? "../setting/projectachievement/savescore" : "../setting/projectachievement/update";
            for(var i=0;i <(vm.projectAchievementScore.achievementEntityList).length;i++){
                vm.projectAchievementScore.achievementEntityList[i].score = vm.pac[i];
            }
            //alert(JSON.stringify(vm.pac));
            this.calculation();
            //alert( JSON.stringify(vm.projectAchievementScore));
            $.ajax({
                type: "POST",
                url: "../setting/projectachievement/savescore",
                contentType: "application/json",
                data: JSON.stringify(vm.projectAchievementScore),
                success: function(r){
                    if(r.code === 0){
                        alert('操作成功', function(index){
                            vm.reload();
                        });
                    }else{
                        alert(r.msg);
                    }
                }
            });
        },
        getProject: function(projectId){
            $.get("../setting/projectachievement/info/"+projectId, function(r){
                vm.project = r.project;
            });
        },

        getProjectAchievementContent: function(id){
            vm.paTemp.id = id;
            $.ajax({
                type: "POST",
                url: "../setting/projectachievement/content",
                contentType: "application/json",
                data: JSON.stringify(vm.paTemp),
                success: function(r){
                    vm.projectAchievementScore = r.pe;
                }
            });
        },
        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam','page');
            $("#jqGrid").jqGrid('setGridParam',{
                postData:{'username': vm.q.username},
                page:page
            }).trigger("reloadGrid");
        },
        calculation: function (event) {
            /* vm.total = 0;
              for(var i=1;i <=vm.pac.length;i++) {
                  //vm.total = vm.total + parseInt(vm.pac[i]);
                  alert("总分" +  vm.pac[i]);
              }
              //alert("总分" +  vm.total);*/
        }
    }
});