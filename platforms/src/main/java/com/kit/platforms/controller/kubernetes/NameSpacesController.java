package com.kit.platforms.controller.kubernetes;

import com.kit.platforms.domain.result.TableResult;
import com.kit.platforms.domain.system.User;
import com.kit.platforms.service.kubernetes.NameSpacesService;
import com.kit.platforms.util.CommonUtils;
import io.fabric8.kubernetes.api.model.NamespaceList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jelly on 2016/9/30.
 */
@RestController
@RequestMapping(value = "/kubernetes/namespace/")
@Api(value = "NameSpacesdata", description = "获取命名空间信息")
public class NameSpacesController {

    @Autowired
    private NameSpacesService nameSpacesService;

  //  private MD5Utils md5Utils = new MD5Utils();

    @RequestMapping(value = "findNameSpaceList", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取命名空间列表", notes = "")
    @ApiResponses(value = {@ApiResponse(code = 500, message = "Server Error")})
    public TableResult findNameSpaceList(@ModelAttribute User user, int page, int rows) throws Exception {
        Map paramMap=new HashMap<>();
        NamespaceList list=nameSpacesService.findNamespaceList("",paramMap);
        TableResult tr = new TableResult();
        tr.setTotal(Long.valueOf(list.getItems().size()));
        JSONArray jsonArray = new JSONArray();
        System.out.println(jsonArray.toString());
        List<Object> objectList=converNamespaceListtoobjet(list);
        tr.setRows(objectList);
        return tr;
    }

    public   List<Object> converNamespaceListtoobjet(NamespaceList list){
        List<Object> objectList=new ArrayList<>();
        for (int i=0;i<list.getItems().size();i++){
            Map paramMap=new HashMap<>();

            paramMap.put("name",list.getItems().get(i).getMetadata().getName());
            paramMap.put("labels",list.getItems().get(i).getMetadata().getLabels());
            paramMap.put("status",list.getItems().get(i).getStatus().getPhase());
            paramMap.put("time",list.getItems().get(i).getMetadata().getCreationTimestamp());
            objectList.add(paramMap);
        }
        return objectList;
    }

//    @RequestMapping(value = "getUser/{userId}", method = RequestMethod.GET)
//    @ResponseBody
//    @ApiOperation(value = "获取单个用户", notes = "")
//    @ApiResponses(value = {@ApiResponse(code = 500, message = "Server Error")})
//    public User getUser(@PathVariable int userId) throws Exception {
//        Map paramMap=new HashMap<>();
//        DynamicDataSourceContextHolder.setDataSourceType("ds1");
//        paramMap.put("userId",userId);
//        List<Object> lists1= userService.findUserList("systemuser.getUser",paramMap);
//
//        if(lists1.size()>0){
//            Map map = (Map) lists1.get(0);
//            User user = new User();
//            user.setUserId(userId);
//            user.setLoginName(map.get("LOGIN_NAME") == null ? "" : map.get("LOGIN_NAME").toString());
//            user.setRealName(map.get("REAL_NAME") == null ? "" : map.get("REAL_NAME").toString());
//            user.setUserStatus(map.get("USER_STATUS") == null ? "" : map.get("USER_STATUS").toString());
//
//            return user;
//        }
//
//        return null;
//    }

    @RequestMapping(value = "addNameSpace", method = RequestMethod.PATCH)
    @ResponseBody
    @ApiOperation(value = "新增命名空间", notes = "")
    @ApiResponses(value = {@ApiResponse(code = 500, message = "Server Error")})
    public String addNameSpace(@ModelAttribute User userPara) throws Exception {
        String resultMsg ="";
        JSONArray jsonArray = new JSONArray();
        try{
            Map paramMap=new HashMap<>();
            paramMap = CommonUtils.obj2map(userPara);
            nameSpacesService.CreateNameSpace("",paramMap);
            resultMsg = "{\"success\":true}";
            JSONObject currentObj = JSONObject.fromObject(resultMsg);
            jsonArray.add(currentObj);
            System.out.println("=================="+jsonArray.toString()+"=====================");
            return jsonArray.toString();

        }catch (Exception ex){
            ex.printStackTrace();
            resultMsg = "{\"success\":false}";
            JSONObject currentObj = JSONObject.fromObject(resultMsg);
            jsonArray.add(currentObj);
            jsonArray.add(ex.getMessage());
            return jsonArray.toString();
        }
    }

//    @RequestMapping(value = "updateUser", method = RequestMethod.PATCH)
//    @ResponseBody
//    @ApiOperation(value = "修改用户", notes = "")
//    @ApiResponses(value = {@ApiResponse(code = 500, message = "Server Error")})
//    public String updateUser(@ModelAttribute User userPara) throws Exception {
//        try{
//            String resultMsg ="";
//            Map paramMap=new HashMap<>();
//            DynamicDataSourceContextHolder.setDataSourceType("ds1");
//            paramMap = CommonUtils.obj2map(userPara);
//            if(paramMap.get("password")==null||"".equals(paramMap.get("password").toString())){
//                paramMap.remove("password");
//            }else {
//                paramMap.put("password", md5Utils.toMD5(paramMap.get("password").toString()));
//            }
//            Object obj = userService.updateUser("systemuser.updateUser",paramMap);
//            resultMsg = "{\"success\":true}";
//            JSONArray jsonArray = new JSONArray();
//            JSONObject currentObj = JSONObject.fromObject(resultMsg);
//            jsonArray.add(currentObj);
//            System.out.println("=================="+jsonArray.toString()+"=====================");
//            return jsonArray.toString();
//        }catch (Exception ex){
//            ex.printStackTrace();
//
//            return dealException();
//        }
//    }
//
//    @RequestMapping(value = "deleteUser", method = RequestMethod.DELETE)
//    @ResponseBody
//    @ApiOperation(value = "删除用户", notes = "")
//    @ApiResponses(value = {@ApiResponse(code = 500, message = "Server Error")})
//    public String deleteUser(@RequestBody  List<User> userParaList) throws Exception {
//        try {
//            String resultMsg = "";
//            DynamicDataSourceContextHolder.setDataSourceType("ds1");
//            if (userParaList.size() > 0) {
//                System.out.println("===============" + userParaList.size() + "===============");
//                Object objRemove = userService.deleteUser("systemuser.deleteUser", userParaList);
//            }
//            resultMsg = "{\"success\":true}";
//            JSONArray jsonArray = new JSONArray();
//            JSONObject currentObj = JSONObject.fromObject(resultMsg);
//            jsonArray.add(currentObj);
//            System.out.println("==================" + jsonArray.toString() + "=====================");
//            return jsonArray.toString();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return dealException();
//        }
//
//    }

//        public static void main(String[] args) throws InterruptedException {
//            Map paramMap=new HashMap<>();
//            NamespaceList list=nameSpacesService.findNamespaceList("",paramMap);
//            JSONArray jsonArray = new JSONArray();
//            jsonArray.add(list);
//            System.out.println(jsonArray.toString());
//       }


}
