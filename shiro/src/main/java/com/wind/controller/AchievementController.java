package com.wind.controller;

import com.wind.annotation.SysLog;
import com.wind.entity.AchievementEntity;
import com.wind.entity.ProjectEntity;
import com.wind.service.AchievementService;
import com.wind.service.ProjectService;
import com.wind.utils.Constant;
import com.wind.utils.PageUtils;
import com.wind.utils.Query;
import com.wind.utils.R;
import com.wind.validator.ValidatorUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/setting/achievement")
public class AchievementController extends AbstractController {
    @Autowired
    private AchievementService achievementService;
    /**
     * 所有组列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("setting:achievement:list")
    public R list(@RequestParam Map<String, Object> params){
        // 只有超级管理员，才能查看所有管理员列表
        if(getUserId() != Constant.SUPER_ADMIN){
            params.put("createUserId", getUserId());
        }

        //查询列表数据
        Query query = new Query(params);
        List<AchievementEntity> groupList = achievementService.queryList(query);
        int total = achievementService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(groupList, total, query.getLimit(), query.getPage());

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
     * 修改绩效标准
     */
    @SysLog("修改绩效标准")
    @RequestMapping("/save")
    @RequiresPermissions("setting:achievement:save")
    public R save(@RequestBody AchievementEntity achievementEntity){
        ValidatorUtils.validateEntity(achievementService, AchievementEntity.class);

        //g.setCreateUserId(getUserId());
        achievementService.save(achievementEntity);

        return R.ok();
    }

    /**
     * 修改绩效标准
     */
    @SysLog("修改绩效标准")
    @RequestMapping("/update")
    @RequiresPermissions("setting:achievement:update")
    public R update(@RequestBody AchievementEntity achievementEntity){
        ValidatorUtils.validateEntity(achievementEntity, AchievementEntity.class);

        //user.setCreateUserId(getUserId());
        achievementService.update(achievementEntity);

        return R.ok();
    }

    /**
     * 删除组
     */
    @SysLog("删除项目")
    @RequestMapping("/delete")
    @RequiresPermissions("setting:achievement:delete")
    public R delete(@RequestBody Long[] projectIds){
        if(ArrayUtils.contains(projectIds, 1L)){
            return R.error("不能删除");
        }

/*        if(ArrayUtils.contains(userIds, getUserId())){
            return R.error("不能删除");
        }*/

        achievementService.deleteBatch(projectIds);

        return R.ok();
    }
}
