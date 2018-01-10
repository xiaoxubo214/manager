$(function () {
    $("#jqGrid").jqGrid({
        url: '../setting/achievement/list',
        datatype: "json",
        colModel: [
            { label: '单据ID', name: 'id', index: "id", width: 45, key: true },
            { label: '内容', name: 'name', width: 75 },
            { label: '分数', name: 'score', width: 75 },
            { label: '所属组', name: 'groupName', width: 90 },

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
        groupList:{},
        achievement:{
			status:1,
			groupId:null
		}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
            vm.achievement = {};


			this.getGroupList();
		},
		update: function () {
			var achievementId = getSelectedRow();
			if(achievementId == null){
				return ;
			}

			vm.showList = false;
            vm.title = "修改";

			vm.getAchievement(achievementId);
			this.getGroupList();
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
			//alert(JSON.stringify(vm.achievement));
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
        getGroupList: function () {
            $.get("../setting/group/select",function (r) {
                vm.groupList = r.list;
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