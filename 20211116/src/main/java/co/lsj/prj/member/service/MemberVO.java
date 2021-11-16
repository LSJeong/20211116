package co.lsj.prj.member.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {
	private String id;
	private String password;
	private String name;
	private String tel;
	private String address;
	private String author;
}
