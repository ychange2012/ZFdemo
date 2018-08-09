package com.demo.doc.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository
public class BillDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public int addR(long roomId,String bdate,String edate,double price){
        return jdbcTemplate.update("insert into tb_rent(room_id,begindate,enddate,price,credate)values (?,?,?,?,now())",roomId,bdate,edate,price);
    }

    public int addW(long roomId,String bdate,String edate,double bqty,double eqty,double price){
        return jdbcTemplate.update("insert into tb_water(room_id,begindate,enddate,beginqty,endqty,price)values (?,?,?,?,?,?)",roomId,bdate,edate,bqty,eqty,price);
    }

    public int addE(long roomId,String bdate,String edate,double bqty,double eqty,double price){
        return jdbcTemplate.update("insert into tb_ele(room_id,begindate,enddate,beginqty,endqty,price)values (?,?,?,?,?,?)",roomId,bdate,edate,bqty,eqty,price);
    }

    public int addS(long roomId,String bdate,String edate,double price){
        return jdbcTemplate.update("insert into tb_rent_share(room_id,begindate,enddate,price)values (?,?,?,?)",roomId,bdate,edate,price);
    }

    public Map getLastData(long roomId){
        return jdbcTemplate.queryForMap("select * from v_last_data where room_id = ?",roomId);
    }

    public List getPrint(String roomIds){
        String sql = "select *,format((eeqty-ebqty)*eprice,2) etotal," +
                "format((weqty-wbqty)*wprice,2) wtotal,(eeqty-ebqty) eqty," +
                "(weqty-wbqty) wqty, REPLACE(CONCAT(format((eeqty-ebqty)*eprice+(weqty-wbqty)*wprice+rprice+sprice,2)),',','') total " +
                "from v_get_print where room_id in (" + roomIds + " )";
        System.out.println(sql);
        return jdbcTemplate.queryForList(sql);
    }

}
