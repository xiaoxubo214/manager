$(function () {
    $("#jqGrid").jqGrid({
        url: '../setting/achievement/list',
        datatype: "json",
        colModel: [
            { label: '绩效ID', name: 'id', index: "id", width: 45, key: true },
			{ label: '绩效内容', name: 'name', index: "name", width: 45, key: true },
            { label: '组ID', name: 'group_id', index: "group_id", width: 45, key: true },
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
            achievementId: null
		},
		showList: true,
		title:null,
        achievementList:{},
        achievement:{
			status:1,
            achievementIdList:[]
		}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.achievementList = {};
            vm.achievement = {};
			
			//获取角色信息
			this.getAchievementList();
		},
		update: function () {
			var achievementId = getSelectedRow();
			if(achievementId == null){
				return ;
			}
			
			vm.showList = false;
            vm.title = "修改";
			
			vm.getAchievement(achievementId);
			//获取角色信息
			this.getAchievementList();
		},
		del: function () {
			var achievementIds = getSelectedRows();
			if(achievementIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../setting/achievement/delete",
                    contentType: "application/json",
				    data: JSON.stringify(achievementIds),
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
			var url = vm.achievement.achievementId == null ? "../setting/achievement/save" : "../setting/achievement/update";

			$.ajax({
				type: "POST",
			    url: url,
                contentType: "application/json",
			    data: JSON.stringify(vm.achievement),
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
		getAchievement: function(achievementId){
			$.get("../setting/achievement/info/"+achievementId, function(r){
				vm.achievement = r.achievement;
			});
		},
		getAchievementList: function(){
			$.get("../setting/achievement/select", function(r){
				vm.achievementList = r.list;
			});
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                postData:{'username': vm.q.username},
                page:page
            }).trigger("reloadGrid");
		}
	}
});