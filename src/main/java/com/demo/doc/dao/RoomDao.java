package com.demo.doc.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

@Repository
public class RoomDao {
    @Resource
    private DataSource dataSource;
    @Resource
    private JdbcTemplate jdbcTemplate;

    public List queryRoom(){
        return jdbcTemplate.queryForList("select * ,(select max(credate) from tb_rent where room_id = tb_room.room_id) credate from tb_room where del_flag = 0");
    }

    public int delRoom(long roomId){
        return jdbcTemplate.update("update tb_room set del_flag = 1  where room_id = ?",roomId);
    }

    public int addRoom (String roomName,String desc){
        return  jdbcTemplate.update("insert into tb_room(room_name,room_desc,del_flag)values (?,?,0)",roomName,desc);
    }
}
