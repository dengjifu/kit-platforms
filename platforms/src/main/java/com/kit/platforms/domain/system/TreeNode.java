package com.kit.platforms.domain.system;

/**
 * Created by luxin on 2016/8/18.
 */
public class TreeNode implements Cloneable{
    String id;
    String parentId;
    String text;
    String iconCls;
    String state;
    String doMain;
    boolean parentNode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isParentNode() {
        return parentNode;
    }

    public void setParentNode(boolean parentNode) {
        this.parentNode = parentNode;
    }

    public String getDoMain() {
        return doMain;
    }

    public void setDoMain(String doMain) {
        this.doMain = doMain;
    }
}
