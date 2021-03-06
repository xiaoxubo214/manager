package com.wind.controller;

import com.wind.annotation.SysLog;
import com.wind.entity.AchievementEntity;
import com.wind.entity.ProjectAchievementEntity;
import com.wind.entity.ProjectAchievementItemEntity;
import com.wind.service.AchievementService;
import com.wind.service.ProjectAchievementItemService;
import com.wind.service.ProjectAchievementService;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/setting/projectachievement")
public class ProjectAchievementController extends AbstractController {
    @Autowired
    private ProjectAchievementService projectAchievementService;
    @Autowired
    private AchievementService achievementService;
    @Autowired
    ProjectAchievementItemService projectAchievementItemService;
    /**
     * 所有组列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("setting:projectachievement:list")
    public R list(@RequestParam Map<String, Object> params){
        //只有超级管理员，才能查看所有管理员列表
        if(getUserId() != Constant.SUPER_ADMIN){
            params.put("ownerId", getUserId());
        }

        //查询列表数据
        Query query = new Query(params);
        List<ProjectAchievementEntity> groupList = projectAchievementService.queryList(query);
        int total = projectAchievementService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(groupList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 所有组列表
     */
    @RequestMapping("/listbyuser")
    @RequiresPermissions("setting:projectachievement:listbyuser")
    public R listByUser(@RequestParam Map<String, Object> params){
        //只有超级管理员，才能查看所有管理员列表
        if(getUserId() != Constant.SUPER_ADMIN){
            params.put("userId", getUserId());
        }

        //查询列表数据
        Query query = new Query(params);
        List<ProjectAchievementEntity> groupList = projectAchievementService.queryList(query);
        int total = projectAchievementService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(groupList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 所有组列表
     */
    @RequestMapping("/content")
    @RequiresPermissions("setting:projectachievement:content")
    public R content(@RequestBody ProjectAchievementEntity projectAchievementEntity){
        Map map = new HashMap();
        map.put("id",projectAchievementEntity.getId());
        List<ProjectAchievementEntity> peList = projectAchievementService.queryList(map);
        List<AchievementEntity> achievementEntityList = achievementService.queryAchievementStandard(peList.get(0));
        peList.get(0).setAchievementEntityList(achievementEntityList);
        return R.ok().put("pe",peList.get(0));
    }

    /**
     * 保存分数
     */
    @RequestMapping("/savescore")
    @RequiresPermissions("setting:projectachievement:savescore")
    public R saveScore(@RequestBody ProjectAchievementEntity projectAchievementEntity){
        ProjectAchievementEntity pae = new ProjectAchievementEntity();
        pae.setId(projectAchievementEntity.getId());
        long total = 0;
        for( AchievementEntity achievementEntity : projectAchievementEntity.getAchievementEntityList()){
            total =total + achievementEntity.getScore();
            ProjectAchievementItemEntity projectAchievementItemEntity = new ProjectAchievementItemEntity();
            projectAchievementItemEntity.setGetScore(achievementEntity.getScore());
            projectAchievementItemEntity.setAchievementId(pae.getId());
            projectAchievementItemService.save(projectAchievementItemEntity);
        }
        pae.setTotalScore(total);
        pae.setFinish(1);
        projectAchievementService.update(pae);
/*        List<AchievementEntity> achievementEntityList = achievementService.queryAchievementStandard(peList.get(0));
        peList.get(0).setAchievementEntityList(achievementEntityList);*/
        return R.ok();
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
    @SysLog("新建项目")
    @RequestMapping("/save")
    @RequiresPermissions("setting:projectachievement:save")
    public R save(@RequestBody ProjectAchievementEntity projectAchievementEntity){
        ValidatorUtils.validateEntity(projectAchievementEntity, ProjectAchievementEntity.class);

        //g.setCreateUserId(getUserId());
        for(Long userId:projectAchievementEntity.getUserIdList()) {
            projectAchievementEntity.setUserId(userId);
            projectAchievementService.getSaveKey(projectAchievementEntity);
        }

        return R.ok();
    }

    /**
     * 修改组
     */
    @SysLog("修改项目")
    @RequestMapping("/update")
    @RequiresPermissions("setting:projectachievement:update")
    public R update(@RequestBody ProjectAchievementEntity projectAchievementEntity){
        ValidatorUtils.validateEntity(projectAchievementEntity, ProjectAchievementEntity.class);

        //user.setCreateUserId(getUserId());
        projectAchievementService.update(projectAchievementEntity);

        return R.ok();
    }

    /**
     * 删除组
     */
    @SysLog("删除项目")
    @RequestMapping("/delete")
    @RequiresPermissions("setting:projectachievement:delete")
    public R delete(@RequestBody Long[] projectIds){
        if(ArrayUtils.contains(projectIds, 1L)){
            return R.error("不能删除");
        }

/*        if(ArrayUtils.contains(userIds, getUserId())){
            return R.error("不能删除");
        }*/

        projectAchievementService.deleteBatch(projectIds);

        return R.ok();
    }
}
