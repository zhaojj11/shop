package com.pyjava.shop.user.controller;


import com.pyjava.shop.entity.Result;
import com.pyjava.shop.user.model.AddressDO;
import com.pyjava.shop.user.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  收发货地址表 前端控制器
 * </p>
 *
 * @author zhaojj11
 * @since 2021-08-16
 */
@Api(tags = "收获地址模块")
@RestController
@RequestMapping("/api/address/v1/")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @ApiOperation("根据id查找地址详情")
    @GetMapping("/find/{addressId}")
    public Result<AddressDO> findAddressById(
            @ApiParam(value = "地址id", required = true) @PathVariable("addressId") long addressId
    ) {
        AddressDO address = addressService.findAddress(addressId);
        return Result.ofSuccess(address);
    }

}


