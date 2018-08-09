package com.demo.doc.api;

import com.demo.doc.service.RoomService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/room")
public class RoomApi {
    @Resource
    private RoomService roomService;

    @RequestMapping("/queryall")
    public List queryAll(){
        return  roomService.queryRoom();
    }

    @RequestMapping("/del")
    public String delRoom(@RequestParam(value = "id") long id){
        roomService.delRoom(id);
        return null;
    }

    @RequestMapping("/add")
    public  String addRoom(@RequestParam(value = "name" )String name,@RequestParam(value = "desc") String desc){
        roomService.addRoom(name,desc);
        return  null;
    }
}
