package net.xuele.fastjson;

import java.util.List;

/**
 * Created by yejunjie on 2016/10/22.
 */
public class Saction {
    private List<SRole> browse;
    private List<SRole> comment;
    private List<SRole> praise;
    private List<SRole> publish;
    private List<SRole> workCircle;

    public List<SRole> getBrowse() {
        return browse;
    }

    public void setBrowse(List<SRole> browse) {
        this.browse = browse;
    }

    public List<SRole> getComment() {
        return comment;
    }

    public void setComment(List<SRole> comment) {
        this.comment = comment;
    }

    public List<SRole> getPraise() {
        return praise;
    }

    public void setPraise(List<SRole> praise) {
        this.praise = praise;
    }

    public List<SRole> getPublish() {
        return publish;
    }

    public void setPublish(List<SRole> publish) {
        this.publish = publish;
    }

    public List<SRole> getWorkCircle() {
        return workCircle;
    }

    public void setWorkCircle(List<SRole> workCircle) {
        this.workCircle = workCircle;
    }
}
