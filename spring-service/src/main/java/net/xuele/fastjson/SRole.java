package net.xuele.fastjson;

/**
 * Created by yejunjie on 2016/10/22.
 */
public class SRole {

    private String roleType;
    private Integer isChecked;
    private Integer isCancel;

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public Integer getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Integer isChecked) {
        this.isChecked = isChecked;
    }

    public Integer getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(Integer isCancel) {
        this.isCancel = isCancel;
    }
}
