package com.kit.platforms.controller;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stu")
@Api(value = "Student", description = "获取学生数据信息")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

//    @Autowired
//    private StudentService studentService;

    @RequestMapping("/list")
    public void getStus(){
        logger.info("从数据库读取Student集合");
       // return studentService.getList();
        //

    }

//    @ApiOperation("获取用户信息")
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType="path",name="name",dataType="String",required=true,value="用户的姓名",defaultValue="zhaojigang")
//    })
//    @ApiResponses({
//            @ApiResponse(code=400,message="请求参数没填好"),
//            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
//    })
//    @RequestMapping(value="/likeName/{name}",method= RequestMethod.GET)
//    public List<Student> likeName(@PathVariable String name){
//        return studentService.likeName(name);
//    }


}
