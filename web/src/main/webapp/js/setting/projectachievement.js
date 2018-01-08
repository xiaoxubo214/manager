$(function () {
    $("#jqGrid").jqGrid({
        url: '../setting/project/list',
        datatype: "json",
        colModel: [
            { label: '单据编号', name: 'id', index: "id", width: 45, key: true },
			{ label: '项目名称', name: 'projectName', index: "projectName", width: 45, key: true },
            { label: '考核人', name: 'name', index: "name", width: 45, key: true },
            { label: '开始时间', name: 'starttime', index: "starttime", width: 45, key: true },
            { label: '截止时间', name: 'endtime', index: "endtime", width: 45, key: true },
            { label: '是否结束', name: 'finish', width: 80, formatter: function(value, options, row){
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
		projectList:{},
		userList:{},
		project:{
			status:1,
            roleIdList:[],
		}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.projectList = {};
            vm.project = {roleIdList:[]};
            vm.userList = {};
			
			//获取角色信息
			this.getUserList();
		},
		update: function () {
			var projectId = getSelectedRow();
			if(projectId == null){
				return ;
			}
			
			vm.showList = false;
            vm.title = "修改";
			
			vm.getProject(projectId);

			this.getUserList();
		},
		del: function () {
			var projectIds = getSelectedRows();
			if(projectIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../setting/project/delete",
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
			var url = vm.project.projectId == null ? "../setting/project/save" : "../setting/project/update";
			$.ajax({
				type: "POST",
			    url: url,
                contentType: "application/json",
			    data: JSON.stringify(vm.project),
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
			$.get("../setting/project/info/"+projectId, function(r){
				vm.project = r.project;
			});
		},
		getUserList: function(){
			$.get("../sys/user/select", function(r){
				vm.userList = r.list;
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