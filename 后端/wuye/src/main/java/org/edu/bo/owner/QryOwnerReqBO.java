package org.edu.bo.owner;

import org.edu.common.page.BO.ReqPageBO;

/**
 * 标题:查询业主
 */
public class QryOwnerReqBO extends ReqPageBO {
    private String ownerName;

    private String ownerCardid;

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerCardid() {
        return ownerCardid;
    }

    public void setOwnerCardid(String ownerCardid) {
        this.ownerCardid = ownerCardid;
    }

    @Override
    public String toString() {
        return "QryOwnerReqBO{" +
                "ownerName='" + ownerName + '\'' +
                ", ownerCardid='" + ownerCardid + '\'' +
                '}';
    }
}
