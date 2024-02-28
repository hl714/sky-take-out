package com.sky.controller.user;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(tags = "店铺相关接口")
@RestController("userShopController")
@RequestMapping("/user/shop")
public class ShopController {
    @Autowired
    private RedisTemplate redisTemplate;

    /*@ApiOperation("设置店铺状态")
    @PutMapping("/{status}")
    public Result setStatus(@PathVariable Integer status){
        log.info("设置店铺状态:{}",status);
        redisTemplate.opsForValue().set("SHOP_STATUS",status);
        return Result.success();
    }*/

    @GetMapping("/status")
    @ApiOperation("查询店铺状态")
    public Result<Integer> getStatus(){
        Integer status = (Integer) redisTemplate.opsForValue().get("SHOP_STATUS");
        log.info("查询店铺状态:{}",status==1?"营业中":"打烊中");
        return Result.success(status);
    }
}
