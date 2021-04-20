package org.edu.bo.complaint;

public class EditComplaintReqBO {
    private String complaintTitle;
    private String complaintName;
    private String complaintTel;
    private String complaintContent;
    private Integer complaintId;

    public Integer getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Integer complaintId) {
        this.complaintId = complaintId;
    }

    public String getComplaintTitle() {
        return complaintTitle;
    }

    public void setComplaintTitle(String complaintTitle) {
        this.complaintTitle = complaintTitle;
    }

    public String getComplaintName() {
        return complaintName;
    }

    public void setComplaintName(String complaintName) {
        this.complaintName = complaintName;
    }

    public String getComplaintTel() {
        return complaintTel;
    }

    public void setComplaintTel(String complaintTel) {
        this.complaintTel = complaintTel;
    }

    public String getComplaintContent() {
        return complaintContent;
    }

    public void setComplaintContent(String complaintContent) {
        this.complaintContent = complaintContent;
    }

    @Override
    public String toString() {
        return "EditComplaintReqBO{" +
                "complaintTitle='" + complaintTitle + '\'' +
                ", complaintName='" + complaintName + '\'' +
                ", complaintTel='" + complaintTel + '\'' +
                ", complaintContent='" + complaintContent + '\'' +
                ", complaintId=" + complaintId +
                '}';
    }
}
