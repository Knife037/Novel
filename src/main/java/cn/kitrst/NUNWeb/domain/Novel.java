package cn.kitrst.NUNWeb.domain;

/**
 * Created by Administrator on 2017/3/24.
 */
public class Novel {

    private String novelid;

    private String novelName;

    private String currChap;

    private String rectChap;

    private String url;

    private String encoding;

    public String getNovelid() {
        return novelid;
    }

    public void setNovelid(String novelid) {
        this.novelid = novelid;
    }

    public String getNovelName() {
        return novelName;
    }

    public void setNovelName(String novelName) {
        this.novelName = novelName;
    }

    public String getCurrChap() {
        return currChap;
    }

    public void setCurrChap(String currChap) {
        this.currChap = currChap;
    }

    public String getRectChap() {
        return rectChap;
    }

    public void setRectChap(String rectChap) {
        this.rectChap = rectChap;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }
}
