package com.pojo;

import java.io.Serializable;

/**
 * ������ϵ��
 */
public class DistRelaBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4344805553337766064L;
	private String deptcd;//������
	private String sprrdp;//�ϼ�����
	private int levelp;//�ȼ�
	private int stacid;//����
	private String relatp;
	private String reptdp;//�걨Ƶ��
	private String reptfg;//�Ƿ���߱���
	
	/*public DistRelaBean(String deptcd,int levelp,String sprrdp){
		this.deptcd = deptcd;
		this.levelp = levelp;
		this.sprrdp = sprrdp;	
	} */
	public String getDeptcd() {
		return deptcd;
	}
	public void setDeptcd(String deptcd) {
		this.deptcd = deptcd;
	}
	public String getSprrdp() {
		return sprrdp;
	}
	public void setSprrdp(String sprrdp) {
		this.sprrdp = sprrdp;
	}
	public int getLevelp() {
		return levelp;
	}
	public void setLevelp(int levelp) {
		this.levelp = levelp;
	}
	public int getStacid() {
		return stacid;
	}
	public void setStacid(int stacid) {
		this.stacid = stacid;
	}
	public String getRelatp() {
		return relatp;
	}
	public void setRelatp(String relatp) {
		this.relatp = relatp;
	}
	public String getReptdp() {
		return reptdp;
	}
	public void setReptdp(String reptdp) {
		this.reptdp = reptdp;
	}
	public String getReptfg() {
		return reptfg;
	}
	public void setReptfg(String reptfg) {
		this.reptfg = reptfg;
	}

}
