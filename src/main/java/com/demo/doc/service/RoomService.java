package com.demo.doc.service;

import com.demo.doc.dao.RoomDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoomService {
    @Resource
    private RoomDao roomDao;

    public List queryRoom(){
       return roomDao.queryRoom();
    }

    public int delRoom(long roomId){
        return roomDao.delRoom(roomId);
    }

    public int addRoom(String roomName,String desc) {
        return roomDao.addRoom(roomName,desc);
    }
}
