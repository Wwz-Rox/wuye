package org.edu.util.Excel;

import java.util.List;

public abstract class BaseVo {

    public abstract Boolean validate();

    public String getErrMsgForUI(List<String> errList) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < errList.size(); i++) {
            if (i != 0) {
                sb.append(";");
            }
            sb.append(errList.get(i));
        }
        return sb.toString();
    }

}
