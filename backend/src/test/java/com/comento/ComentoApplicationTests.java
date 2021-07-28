package com.comento;

import com.comento.dto.CommCodeDTO;
import com.comento.service.NoticeService;
import com.comento.service.ServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ComentoApplicationTests {

	@Autowired
	ServiceImpl in;

	@Test
	void selectlist(){
		List<CommCodeDTO> ss = in.getcode();
		System.out.println(ss.get(0).getCommCdId());

	}

	@Test
	void selecttest(){
		String s1 = in.imsunghyun();
		System.out.println(s1);
	}

	@Test
	void contextLoads() {

	}

}
