package 종합.실습5_대기번호.model.dto;

public class WaitingDto {
    // 멤버변수
    private int wno;
    private String wphone;
    private int wcount;

    // 생성자(기본/전체)
    public WaitingDto() {
    }

    public WaitingDto(int wno, String wphone, int wcount) {
        this.wno = wno;
        this.wphone = wphone;
        this.wcount = wcount;
    }

    // getter/setter/toString
    public int getWno() {
        return wno;
    }

    public void setWno(int wno) {
        this.wno = wno;
    }

    public String getWphone() {
        return wphone;
    }

    public void setWphone(String wphone) {
        this.wphone = wphone;
    }

    public int getWcount() {
        return wcount;
    }

    public void setWcount(int wcount) {
        this.wcount = wcount;
    }

    @Override
    public String toString() {
        return "WaitingDto{" +
                "wno=" + wno +
                ", wphone='" + wphone + '\'' +
                ", wcount=" + wcount +
                '}';
    }

}// class end
