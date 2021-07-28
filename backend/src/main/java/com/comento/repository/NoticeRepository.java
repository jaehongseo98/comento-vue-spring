package com.comento.repository;

import java.util.List;

import com.comento.dto.CommCodeDTO;
import com.comento.dto.MoreCodeDTO;
import org.apache.ibatis.annotations.Mapper;

import com.comento.dto.NoticeRequest;
import com.comento.vo.NoticeVO;

@Mapper
public interface NoticeRepository {
	public List<NoticeVO> selectTest(NoticeRequest request);

	public String comeontest();

	public List<CommCodeDTO> selectCode();

	public List<MoreCodeDTO> selectmorecode(String codeid);

}