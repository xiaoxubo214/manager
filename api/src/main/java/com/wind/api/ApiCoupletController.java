package com.wind.api;

import com.wind.annotation.IgnoreAuth;
import com.wind.entity.BannerEntity;
import com.wind.entity.CoupletEntity;
import com.wind.service.CoupletService;
import com.wind.service.TokenService;
import com.wind.service.UserService;
import com.wind.utils.R;
import com.wind.validator.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiCoupletController {
    @Autowired
    private CoupletService coupletService;


    /**
     * 楹联列表
     */
    @IgnoreAuth
    @GetMapping("couplet_list")
    public R getList(String type){
        String typeName;
        if ( type.equals("1" )){
            typeName = "福喜";
        } else if( type.equals("2")) {
            typeName = "修身";
        } else if( type.equals("3")) {
            typeName = "耕读";
        } else if( type.equals("4")) {
            typeName = "治家";
        } else {
            throw new RuntimeException();
        }
        List<CoupletEntity> list = coupletService.queryList(typeName);
        return R.ok().put("list",list);
    }
    /**
     * 楹联详情
     */
    @IgnoreAuth
    @GetMapping("couplet_detail")
    public R getDetail(Long id){
        CoupletEntity coupletEntity = coupletService.queryObject(id);
        return R.ok().put("couplet",coupletEntity);
    }

    /**
     * 楹联banner
     */
    @IgnoreAuth
    @GetMapping("couplet_banner")
    public R getBanner(){
        BannerEntity bannerEntity = new BannerEntity();
        bannerEntity.getBannerList().add(
                new BannerEntity.Banner("1","http://127.0.0.1:80/statics/imgs/banner1.png"));
        bannerEntity.getBannerList().add(
                new BannerEntity.Banner("2","http://127.0.0.1:80/statics/imgs/banner2.png"));
        bannerEntity.getBannerList().add(
                new BannerEntity.Banner("3","http://127.0.0.1:80/statics/imgs/banner3.png"));
        bannerEntity.getBannerList().add(
                new BannerEntity.Banner("3","http://127.0.0.1:80/statics/imgs/banner4.png"));
        return R.ok().put("banner",bannerEntity);
    }


}
