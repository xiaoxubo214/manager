package com.wind.controller;

import com.wind.entity.GroupEntity;
import com.wind.entity.SysUserEntity;
import com.wind.service.GroupService;
import com.wind.service.SysUserRoleService;
import com.wind.utils.*;
import com.wind.validator.Assert;
import com.wind.validator.ValidatorUtils;
import com.wind.validator.group.AddGroup;
import com.wind.annotation.SysLog;
import com.wind.utils.*;
import com.wind.validator.group.Group;
import com.wind.validator.group.UpdateGroup;

import org.apache.commons.lang.ArrayUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/setting/group")
public class GroupController extends AbstractController {
    @Autowired
    private GroupService groupService;
    /**
     * 所有组列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("setting:group:list")
    public R list(@RequestParam Map<String, Object> params){
        //只有超级管理员，才能查看所有管理员列表
        if(getUserId() != Constant.SUPER_ADMIN){
            params.put("createUserId", getUserId());
        }

        //查询列表数据
        Query query = new Query(params);
        List<GroupEntity> userList = groupService.queryList(query);
        int total = groupService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(userList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 获取登录的用户信息
     */
    @RequestMapping("/info")
    public R info(){
        return R.ok().put("user", getUser());
    }




    /**
     * 保存用户
     */
    @SysLog("保存组")
    @RequestMapping("/save")
    @RequiresPermissions("setting:group:save")
    public R save(@RequestBody GroupEntity groupEntity){
        System.out.println(groupEntity.getGroupId() + groupEntity.getGroupName());
        ValidatorUtils.validateEntity(groupEntity, GroupEntity.class);

        //g.setCreateUserId(getUserId());
        groupService.save(groupEntity);

        return R.ok();
    }

    /**
     * 修改组
     */
    @SysLog("修改组")
    @RequestMapping("/update")
    @RequiresPermissions("setting:group:update")
    public R update(@RequestBody GroupEntity groupEntity){
        ValidatorUtils.validateEntity(groupEntity, GroupEntity.class);

        //user.setCreateUserId(getUserId());
        groupService.update(groupEntity);

        return R.ok();
    }

    /**
     * 删除组
     */
    @SysLog("删除组")
    @RequestMapping("/delete")
    @RequiresPermissions("setting:group:delete")
    public R delete(@RequestBody Long[] userIds){
        if(ArrayUtils.contains(userIds, 1L)){
            return R.error("不能删除");
        }

        if(ArrayUtils.contains(userIds, getUserId())){
            return R.error("不能删除");
        }

        groupService.deleteBatch(userIds);

        return R.ok();
    }
}
