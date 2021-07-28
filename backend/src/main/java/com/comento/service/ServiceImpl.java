package com.comento.service;

import com.comento.dto.CommCodeDTO;
import com.comento.dto.MoreCodeDTO;
import com.comento.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ServiceImpl {

    @Autowired
   private final NoticeRepository mapperda;

   public String imsunghyun(){
       return mapperda.comeontest();
   }

   public List<CommCodeDTO> getcode(){
       System.out.println(mapperda.selectCode());
       return mapperda.selectCode();
   }

   public List<MoreCodeDTO> getmorecode(String morecode){
       return mapperda.selectmorecode(morecode);
   }

}
