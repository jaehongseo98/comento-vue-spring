package com.comento.controller;

import com.comento.dto.CommCodeDTO;
import com.comento.dto.MoreCodeDTO;
import com.comento.service.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CodeController {
//@RequestParam("code_id") String code_id
    @Autowired
    private final ServiceImpl service;

    @CrossOrigin(origins = "http://localhost:8090")
    @GetMapping(value = "/api/code/selectCodeInfo")
    List<CommCodeDTO> Getlist(){
        List<CommCodeDTO> codeList = service.getcode();
        return codeList;

//        map.put("result_cd", 2001);
//        map.put("result_message", "");
//        map.put("data", empList);
//        return map;
    }

    @CrossOrigin(origins = "http://localhost:8090")
    @GetMapping(value = "/api/code/selectMoreCode")
    List<MoreCodeDTO> getlist(@RequestParam("code_id") String code_id) {
        List<MoreCodeDTO> mcode = service.getmorecode(code_id);
        System.out.println(mcode);
        return mcode;

    }


}
