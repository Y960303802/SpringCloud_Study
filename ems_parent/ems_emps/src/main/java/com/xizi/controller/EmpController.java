package com.xizi.controller;


import com.xizi.clients.FileClients;
import com.xizi.entity.Emp;
import com.xizi.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class EmpController {

    @Autowired
    private EmpService empService;

    @Autowired
    private FileClients fileClients;

    /**
     * 更新员工信息
     */
    @PostMapping("/emp/update")
    public Map<String,Object> update(Emp emp, MultipartFile photo ){
        HashMap<String, Object> map = new HashMap<>();
        try {
            //1.文件上传
            log.info("头像信息[{}]",photo.getOriginalFilename());
            Map<String, Object> upload = fileClients.upload(photo);
            if(upload.get("state").equals("false")){
                throw new RuntimeException("头像更新失败！！");
            }
            log.info("头像地址: [{}]",upload.get("url").toString());
            emp.setPath(upload.get("url").toString());
            //2.保存员工信息
            empService.update(emp);
            map.put("msg","员工信息更新成功！！");
            map.put("state",true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg","员工信息更新失败！！");
            map.put("state",false);
        }
        return map;
    }


    /**
     * 删除员工
     *
     */
    @GetMapping("/emp/delete")
    public Map<String,Object> delete(Integer id){
        HashMap<String, Object> map = new HashMap<>();
        try {
            empService.delete(id);
            map.put("msg","员工删除成功！！！");
            map.put("state",true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg","员工删除失败！！！");
            map.put("state",false);
        }
        return map;
    }

    /**
     * 保存员工信息
     */
    @PostMapping("/emp/save")
    public Map<String,Object> save(Emp emp, MultipartFile photo ){
        HashMap<String, Object> map = new HashMap<>();
        try {
            //1.文件上传
            log.info("头像信息[{}]",photo.getOriginalFilename());
            Map<String, Object> upload = fileClients.upload(photo);
            if(upload.get("state").equals("false")){
                throw new RuntimeException("头像保存失败！！");
            }
            log.info("头像地址: [{}]",upload.get("url").toString());
            emp.setPath(upload.get("url").toString());
            //2.保存员工信息
            empService.save(emp);
            map.put("msg","员工信息保存成功！！");
            map.put("state",true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg","员工信息保存失败！！");
            map.put("state",false);
        }
        return map;
    }




    /**
     * 员工列表接口
     */

    @GetMapping("/emp/findAll")
    public List<Emp> findAll(){
        return empService.findAll();
    }

}
