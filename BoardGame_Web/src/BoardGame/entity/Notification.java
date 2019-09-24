package BoardGame.entity;

public class Notification {
	    private int bnote_no;
	    private String bnote_info;
	    private long set_time;

	    public Notification(int bnote_no, String bnote_info, long set_time) {
	        this.bnote_no = bnote_no;
	        this.bnote_info = bnote_info;
	        this.set_time = set_time;
	    }

	    public String toString() {
	        String text = "";
	        return text;
	    }

	    public int getBnote_no() {
	        return bnote_no;
	    }

	    public void setBnote_no(int bnote_no) {
	        this.bnote_no = bnote_no;
	    }

	    public String getBnote_info() {
	        return bnote_info;
	    }

	    public void setBnote_info(String bnote_info) {
	        this.bnote_info = bnote_info;
	    }

	    public long getSet_time() {
	        return set_time;
	    }

	    public void setSet_time(long set_time) {
	        this.set_time = set_time;
	    }
}
