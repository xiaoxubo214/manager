$(function () {
    $("#jqGrid").jqGrid({
        url: '../setting/group/list',
        datatype: "json",
        colModel: [
            { label: '组ID', name: 'id', index: "id", width: 45, key: true },
			{ label: '组名称', name: 'name', index: "name", width: 45, key: true },
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
			groupId: null
		},
		showList: true,
		title:null,
		groupList:{},
		group:{
			status:1,
			groupIdList:[]
		}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.groupList = {};
            vm.group = {};
			
			//获取角色信息
			this.getGroupList();
		},
		update: function () {
			var groupId = getSelectedRow();
			if(groupId == null){
				return ;
			}
			
			vm.showList = false;
            vm.title = "修改";
			
			vm.getGroup(groupId);
			//获取角色信息
			this.getGroupList();
		},
		del: function () {
			var groupIds = getSelectedRows();
			if(groupIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../setting/group/delete",
                    contentType: "application/json",
				    data: JSON.stringify(groupIds),
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
			var url = vm.group.groupId == null ? "../setting/group/save" : "../setting/group/update";

			$.ajax({
				type: "POST",
			    url: url,
                contentType: "application/json",
			    data: JSON.stringify(vm.group),
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
		getGroup: function(groupId){
			$.get("../setting/group/info/"+groupId, function(r){
				vm.group = r.group;
			});
		},
		getGroupList: function(){
			$.get("../setting/group/select", function(r){
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