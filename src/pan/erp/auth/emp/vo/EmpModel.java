package pan.erp.auth.emp.vo;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import pan.erp.auth.dep.vo.DepModel;

public class EmpModel {
	public static final String EMP_LOGIN_USER_OBJECT_NAME="loginEm";
	
	public static final Integer EMP_GENDER_OF_MAN =1;
	public static final Integer EMP_GENDER_OF_WOMAN =0;
	
	public static final String EMP_GENDER_OF_MAN_VIEW = "ÄÐ";
	public static final String EMP_GENDER_OF_WOMAN_VIEW = "Å®";
	
	public static final Map<Integer, String> genderMap = new HashMap<Integer, String>();
	SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
	static{
		genderMap.put(EMP_GENDER_OF_MAN, EMP_GENDER_OF_MAN_VIEW);
		genderMap.put(EMP_GENDER_OF_WOMAN, EMP_GENDER_OF_WOMAN_VIEW);
	}
	private Long uuid;
	private String userName;
	private String pwd;
	private String name;
	private Integer gender; //1:ÄÐ£»0£ºÅ®
	private String tele;
	private String email;
	private String address;
	private Long birthday;
	private DepModel dm;
	private Long birthday2;
	
	private String birthdayView;
	private String birthday2View;
	private String genderView;
	
	public String getGenderView() {
		return genderView;
	}
	public String getBirthday2View() {
		return birthday2View;
	}
	public void setBirthday2View(String birthday2View) {
		this.birthday2View = birthday2View;
	}
	public Long getBirthday2() {
		return birthday2;
	}
	public void setBirthday2(Long birthday2) {
		this.birthday2 = birthday2;
	}
	public String getBirthdayView() {
		return birthdayView;
	}

	public Long getUuid() {
		return uuid;
	}
	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
		this.genderView=genderMap.get(gender);
	}
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getBirthday() {
		return birthday;
	}
	public void setBirthday(Long birthday) {
		this.birthday = birthday;
		this.birthdayView=ft.format(birthday);
	}
	public DepModel getDm() {
		return dm;
	}
	public void setDm(DepModel dm) {
		this.dm = dm;
	}

}
