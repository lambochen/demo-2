package club.chenlinghong.demo.springboot.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2019/12/15 2:14 下午
 * @Description test data
 **/
@Api(tags = "test")
@RestController
@RequestMapping("/test")
public class TestDataController {

    @ApiOperation(value = "testSwagger", notes = "测试 Swagger ")
    @ApiImplicitParam(name = "id", value = "123", paramType = "query", required = true, dataType = "int")
    @GetMapping("/id")
    public String testSwagger(@RequestParam(value = "id") long id) {
        return "test swagger: " + id;
    }

}
