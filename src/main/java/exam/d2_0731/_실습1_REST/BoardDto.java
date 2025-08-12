package exam.d2_0731._실습1_REST;

public class BoardDto {
    // 1. 멤버변수
    private int bno;
    private String btitle;

    // 2. 생성자
    public BoardDto() {
    }

    public BoardDto(int bno, String btitle) {
        this.bno = bno;
        this.btitle = btitle;
    }
    // 3.메소드

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getBtitle() {
        return btitle;
    }

    public void setBtitle(String btitle) {
        this.btitle = btitle;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "bno=" + bno +
                ", btitle='" + btitle + '\'' +
                '}';
    }
}
