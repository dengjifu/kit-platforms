package com.kit.platforms.controller.kubernetes;

import com.kit.platforms.config.datasource.DynamicDataSourceContextHolder;
import com.kit.platforms.domain.result.TableResult;
import com.kit.platforms.domain.system.User;
import com.kit.platforms.service.system.UserService;
import com.kit.platforms.util.CommonUtils;
import com.kit.platforms.util.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jelly on 2016/9/30.
 */
@RestController
@RequestMapping(value = "/system/user/")
@Api(value = "userdata", description = "获取用户管理信息")
public class NameSpacesController {

    @Autowired
    private UserService userService;

    private MD5Utils md5Utils = new MD5Utils();

    @RequestMapping(value = "findUserList", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取用户列表", notes = "")
    @ApiResponses(value = {@ApiResponse(code = 500, message = "Server Error")})
    public TableResult findUser(@ModelAttribute User user, int page, int rows) throws Exception {
        Map paramMap=new HashMap<>();
        //ArrayList userList = new ArrayList();
        TableResult tr = new TableResult();
        DynamicDataSourceContextHolder.setDataSourceType("ds1");
        if(null!=user.getRealName()&&user.getRealName().length()!=0){
            paramMap.put("realName",user.getRealName());
        }
        if(null!=user.getLoginName()&&user.getLoginName().length()!=0){
            paramMap.put("userName",user.getLoginName());
        }
        if(null!=user.getUserStatus()&&user.getUserStatus().length()!=0){
            paramMap.put("userStatus",user.getUserStatus());
        }
        long count = userService.getUserListCount("systemuser.getUserListCount",paramMap);
        tr.setTotal(count);
        paramMap.put("start",(page-1)*rows);
        paramMap.put("end",(page)*rows);
        System.out.println("paramMap==="+paramMap);
        List<Object> lists1= userService.findUserList("systemuser.getUserList",paramMap);
        tr.setRows(lists1);
        return tr;
    }

    @RequestMapping(value = "getUser/{userId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取单个用户", notes = "")
    @ApiResponses(value = {@ApiResponse(code = 500, message = "Server Error")})
    public User getUser(@PathVariable int userId) throws Exception {
        Map paramMap=new HashMap<>();
        DynamicDataSourceContextHolder.setDataSourceType("ds1");
        paramMap.put("userId",userId);
        List<Object> lists1= userService.findUserList("systemuser.getUser",paramMap);

        if(lists1.size()>0){
            Map map = (Map) lists1.get(0);
            User user = new User();
            user.setUserId(userId);
            user.setLoginName(map.get("LOGIN_NAME") == null ? "" : map.get("LOGIN_NAME").toString());
            user.setRealName(map.get("REAL_NAME") == null ? "" : map.get("REAL_NAME").toString());
            user.setUserStatus(map.get("USER_STATUS") == null ? "" : map.get("USER_STATUS").toString());

            return user;
        }

        return null;
    }

    @RequestMapping(value = "addUser", method = RequestMethod.PATCH)
    @ResponseBody
    @ApiOperation(value = "新增用户", notes = "")
    @ApiResponses(value = {@ApiResponse(code = 500, message = "Server Error")})
    public String addUser(@ModelAttribute User userPara) throws Exception {
        try{
            String resultMsg ="";
            Map paramMap=new HashMap<>();
            DynamicDataSourceContextHolder.setDataSourceType("ds1");
            paramMap = CommonUtils.obj2map(userPara);
            if(paramMap.get("password")==null||"".equals(paramMap.get("password").toString())){
                return dealException();
            }else {
                paramMap.put("password", md5Utils.toMD5(paramMap.get("password").toString()));
            }
            Object obj = userService.updateUser("systemuser.addUser",paramMap);
            resultMsg = "{\"success\":true}";
            JSONArray jsonArray = new JSONArray();
            JSONObject currentObj = JSONObject.fromObject(resultMsg);
            jsonArray.add(currentObj);
            System.out.println("=================="+jsonArray.toString()+"=====================");
            return jsonArray.toString();
        }catch (Exception ex){
            ex.printStackTrace();

            return dealException();
        }
    }

    @RequestMapping(value = "updateUser", method = RequestMethod.PATCH)
    @ResponseBody
    @ApiOperation(value = "修改用户", notes = "")
    @ApiResponses(value = {@ApiResponse(code = 500, message = "Server Error")})
    public String updateUser(@ModelAttribute User userPara) throws Exception {
        try{
            String resultMsg ="";
            Map paramMap=new HashMap<>();
            DynamicDataSourceContextHolder.setDataSourceType("ds1");
            paramMap = CommonUtils.obj2map(userPara);
            if(paramMap.get("password")==null||"".equals(paramMap.get("password").toString())){
                paramMap.remove("password");
            }else {
                paramMap.put("password", md5Utils.toMD5(paramMap.get("password").toString()));
            }
            Object obj = userService.updateUser("systemuser.updateUser",paramMap);
            resultMsg = "{\"success\":true}";
            JSONArray jsonArray = new JSONArray();
            JSONObject currentObj = JSONObject.fromObject(resultMsg);
            jsonArray.add(currentObj);
            System.out.println("=================="+jsonArray.toString()+"=====================");
            return jsonArray.toString();
        }catch (Exception ex){
            ex.printStackTrace();

            return dealException();
        }
    }

    @RequestMapping(value = "deleteUser", method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation(value = "删除用户", notes = "")
    @ApiResponses(value = {@ApiResponse(code = 500, message = "Server Error")})
    public String deleteUser(@RequestBody  List<User> userParaList) throws Exception {
        try {
            String resultMsg = "";
            DynamicDataSourceContextHolder.setDataSourceType("ds1");
            if (userParaList.size() > 0) {
                System.out.println("===============" + userParaList.size() + "===============");
                Object objRemove = userService.deleteUser("systemuser.deleteUser", userParaList);
            }
            resultMsg = "{\"success\":true}";
            JSONArray jsonArray = new JSONArray();
            JSONObject currentObj = JSONObject.fromObject(resultMsg);
            jsonArray.add(currentObj);
            System.out.println("==================" + jsonArray.toString() + "=====================");
            return jsonArray.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
            return dealException();
        }

    }

    public String dealException(){
        String resultMsg = "{\"success\":false}";
        JSONArray jsonArray = new JSONArray();
        JSONObject currentObj = JSONObject.fromObject(resultMsg);
        jsonArray.add(currentObj);

        return jsonArray.toString();
    }
}
