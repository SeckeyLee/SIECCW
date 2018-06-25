package Javabean;

public class LoginBean {
private String lognum;
private String password;
private String backNews;
private boolean success = false;
public String getLognum() {
	return lognum;
}
public void setLognum(String lognum) {
	this.lognum = lognum;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getBackNews() {
	return backNews;
}
public void setBackNews(String backNews) {
	this.backNews = backNews;
}
public boolean isSuccess() {
	return success;
}
public void setSuccess(boolean success) {
	this.success = success;
}

}
