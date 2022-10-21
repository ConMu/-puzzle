package demo;

import java.util.List;

public class SmsSendRecord {

    private Long id;

    private Long businessid;

    private Long channelid;

    private String nimid;

    private String remoteid;

    private String mobile;

    private String content;

    private String extendcode;

    private Integer carriertype;

    private Integer spliced;

    private Integer status;

    private Long submittime;

    private String report;

    private Long reporttime;

    private Long createtime;

    private Long updatetime;

    private String senderid;

    private long appid;

    private Integer smstype;

    private Integer spendtime;

    private Integer channeltype;

    private Long templateid;

    private Boolean needUp;

    private String signature;

    /**
     * ModeType,客户类型，1：官网直客，2：渠道客户
     */
    private Integer modeType;

    /**
     * 语音验证码的相关配置，主要用于配置语速，音量，重复次数等
     */
    private String audioConfig;

    /**
     * 视频短信，模板参数
     */
    private String videoParams;

    /**
     * 视频短信，报备参数列表
     */
    private List<String> videoReportParams;


    public long getAppid() {
        return appid;
    }

    public void setAppid(long appid) {
        this.appid = appid;
    }

    public Integer getSmstype() {
        return smstype;
    }

    public void setSmstype(Integer smstype) {
        this.smstype = smstype;
    }

    public Integer getSpendtime() {
        return spendtime;
    }

    public void setSpendtime(Integer spendtime) {
        this.spendtime = spendtime;
    }

    public Integer getChanneltype() {
        return channeltype;
    }

    public void setChanneltype(Integer channeltype) {
        this.channeltype = channeltype;
    }

    public Long getTemplateid() {
        return templateid;
    }

    public void setTemplateid(Long templateid) {
        this.templateid = templateid;
    }

    public Boolean getNeedUp() {
        return needUp;
    }

    public void setNeedUp(Boolean needUp) {
        this.needUp = needUp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBusinessid() {
        return businessid;
    }

    public void setBusinessid(Long businessid) {
        this.businessid = businessid;
    }

    public Long getChannelid() {
        return channelid;
    }

    public void setChannelid(Long channelid) {
        this.channelid = channelid;
    }

    public String getNimid() {
        return nimid;
    }

    public void setNimid(String nimid) {
        this.nimid = nimid;
    }

    public String getRemoteid() {
        return remoteid;
    }

    public void setRemoteid(String remoteid) {
        this.remoteid = remoteid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExtendcode() {
        return extendcode;
    }

    public void setExtendcode(String extendcode) {
        this.extendcode = extendcode;
    }

    public Integer getCarriertype() {
        return carriertype;
    }

    public void setCarriertype(Integer carriertype) {
        this.carriertype = carriertype;
    }

    public Integer getSpliced() {
        return spliced;
    }

    public void setSpliced(Integer spliced) {
        this.spliced = spliced;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getSubmittime() {
        return submittime;
    }

    public void setSubmittime(Long submittime) {
        this.submittime = submittime;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public Long getReporttime() {
        return reporttime;
    }

    public void setReporttime(Long reporttime) {
        this.reporttime = reporttime;
    }

    public Long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }

    public Long getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Long updatetime) {
        this.updatetime = updatetime;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Integer getModeType() {
        return modeType;
    }

    public void setModeType(Integer modeType) {
        this.modeType = modeType;
    }
    public String getSenderid() {
        return senderid;
    }

    public void setSenderid(String senderid) {
        this.senderid = senderid;
    }

    public String getAudioConfig() {
        return audioConfig;
    }

    public void setAudioConfig(String audioConfig) {
        this.audioConfig = audioConfig;
    }

    public String getVideoParams() {
        return videoParams;
    }

    public void setVideoParams(String videoParams) {
        this.videoParams = videoParams;
    }

    public List<String> getVideoReportParams() {
        return videoReportParams;
    }

    public void setVideoReportParams(List<String> videoReportParams) {
        this.videoReportParams = videoReportParams;
    }
}
