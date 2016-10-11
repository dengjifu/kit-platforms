package com.kit.platforms.util;

import com.kit.platforms.domain.system.TreeNode;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;

/**
 * Created by luxin on 2016/8/22.
 */
public class TreeUtils {

    /**
     * 创建一颗树，以json字符串形式返回
     *
     * @param list 原始数据列表
     * @return 树
     */
    public static String createTreeJson(List<TreeNode> list,boolean isCollapseTree) {
        JSONArray rootArray = new JSONArray();
        if(isCollapseTree){
            collapseTree(list);
        }
        for (int i = 0; i < list.size(); i++) {
            TreeNode treeNode = list.get(i);
            if (treeNode.isParentNode()) {
                if(CommonUtils.isEmpty(treeNode.getDoMain())){
                    JSONObject rootObj = createBranch(list, treeNode);
                    rootArray.add(rootObj);
                } else {
                    JSONObject rootObj = createBranchDoMain(list, treeNode);
                    rootArray.add(rootObj);
                }
            }
        }
        return rootArray.toString();
    }

    /**
     * 递归创建分支节点Json对象
     *
     * @param list        创建树的原始数据
     * @param currentNode 当前节点
     * @return 当前节点与该节点的子节点json对象
     */
    public static JSONObject createBranch(List<TreeNode> list, TreeNode currentNode) {
        /*
         * 将javabean对象解析成为JSON对象
		 */
        JSONObject currentObj = JSONObject.fromObject(currentNode);
        JSONArray childArray = new JSONArray();
        /*
         * 循环遍历原始数据列表，判断列表中某对象的父id值是否等于当前节点的id值，
		 * 如果相等，进入递归创建新节点的子节点，直至无子节点时，返回节点，并将该
		 * 节点放入当前节点的子节点列表中
		 */
        for (int i = 0; i < list.size(); i++) {
            TreeNode newNode = list.get(i);
            if (newNode.getParentId() != null && newNode.getParentId().compareTo(currentNode.getId()) == 0) {
                JSONObject childObj = createBranch(list, newNode);
                childArray.add(childObj);
            }
        }
        /*
         * 判断当前子节点数组是否为空，不为空将子节点数组加入children字段中
		 */
        if (!childArray.isEmpty()) {
            currentObj.put("children", childArray);
        }
        return currentObj;
    }

    /**
     * 递归创建分支节点Json对象
     * 并判断子节点的域和父节点的域相同
     *
     * @param list        创建树的原始数据
     * @param currentNode 当前节点
     * @return 当前节点与该节点的子节点json对象
     */
    public static JSONObject createBranchDoMain(List<TreeNode> list, TreeNode currentNode) {
        /*
         * 将javabean对象解析成为JSON对象
		 */
        JSONObject currentObj = JSONObject.fromObject(currentNode);
        JSONArray childArray = new JSONArray();
        /*
         * 循环遍历原始数据列表，判断列表中某对象的父id值是否等于当前节点的id值，
		 * 如果相等，进入递归创建新节点的子节点，直至无子节点时，返回节点，并将该
		 * 节点放入当前节点的子节点列表中
		 */
        for (int i = 0; i < list.size(); i++) {
            TreeNode newNode = list.get(i);
            if (newNode.getParentId() != null && newNode.getParentId().compareTo(currentNode.getId()) == 0 && newNode.getDoMain().compareTo(currentNode.getDoMain()) == 0) {
                JSONObject childObj = createBranchDoMain(list, newNode);
                childArray.add(childObj);
            }
        }
        /*
         * 判断当前子节点数组是否为空，不为空将子节点数组加入children字段中
		 */
        if (!childArray.isEmpty()) {
            currentObj.put("children", childArray);
        }
        return currentObj;
    }

    /**
     * 如果不是叶子节点就将改节点的状态设置为closed
     * @param list
     */
    public static void collapseTree(List<TreeNode> list){
        for(int i = 0; i<list.size();i++){
            if(isNotLeaf(list,list.get(i))){
                list.get(i).setState("closed");
            }
        }
    }

    /**
     * 判断是否是叶子节点
     * @param list
     * @param currentNode
     * @return isNotLeaf
     */
    public static boolean isNotLeaf(List<TreeNode> list, TreeNode currentNode){
        boolean isNotLeaf = false;
        if(list != null){
            for(int i = 0; i < list.size(); i++){
                if(currentNode.getId().equals(list.get(i).getParentId())){
                    isNotLeaf = true;
                }
            }
        }
        return isNotLeaf;
    }
}
