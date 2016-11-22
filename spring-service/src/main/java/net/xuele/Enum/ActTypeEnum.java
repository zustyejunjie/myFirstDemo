package net.xuele.Enum;

/**
 * Created by yejunjie on 2016/10/28.
 */
public enum ActTypeEnum {

    INSERT("插入"),UPDATE("更新"),QUERY("查询"),DELETE("删除");

    private String name;
    ActTypeEnum(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
