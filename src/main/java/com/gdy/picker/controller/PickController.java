package com.gdy.picker.controller;

import com.gdy.picker.pick.Photos;
import com.gdy.picker.pick.PickStarter;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PickController {


    @GetMapping("/getPicInfo")
    @ApiResponses(value = {@ApiResponse(code = 200, response = Photos.class, message = "调用成功")})
    @ApiOperation(value = "获取图片相关信息", httpMethod = "GET", notes = "获取图片相关信息")
    @ResponseBody
    public Photos getPicInfo(
            @ApiParam(name = "searchName", value = "搜索名称", required = true)
            @RequestParam(value = "searchName") String searchName

    ) {
        Photos photos = null;
        try {
            photos = PickStarter.parseImgInfo(searchName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return photos;
    }


    @PostMapping("/downLoadPics")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "调用成功")})
    @ApiOperation(value = "下载照片", httpMethod = "POST", notes = "下载照片")
    public void downLoadPics(
            @ApiParam(name = "searchName", value = "搜索名称", required = true)
            @RequestParam(value = "searchName") String searchName,

            @ApiParam(name = "picSize", value = "照片尺寸：0为小，1为大", required = true)
            @RequestParam(value = "picSize") Integer picSize,

            @ApiParam(name = "startPage", value = "开始页码", required = true)
            @RequestParam(value = "picSize") Integer startPage,

            @ApiParam(name = "endPage", value = "结束页码", required = true)
            @RequestParam(value = "endPage") Integer endPage

    ) {
        try {
            PickStarter.parseImgUrl(searchName, startPage, endPage, picSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
