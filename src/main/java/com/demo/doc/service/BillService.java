package com.demo.doc.service;

import com.demo.doc.dao.BillDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service
public class BillService {
    @Resource
    private BillDao billDao;
    public int addBill(long roomId,String rbdate,String redate,double rprice,
                       String wbdate,String wedate,double wbqty,double weqty,double wprice,
                       String ebdate,String eedate,double ebqty,double eeqty,double eprice,
                       String sbdate,String sedate,double sprice){
        int rflag = 0;
        int wflag = 0;
        int eflag = 0;
        int sflag = 0;
        sflag = billDao.addR(roomId,rbdate,redate,rprice);
        wflag = billDao.addW(roomId,wbdate,wedate,wbqty,weqty,wprice);
        eflag = billDao.addE(roomId,ebdate,eedate,ebqty,eeqty,eprice);
        sflag = billDao.addS(roomId,sbdate,sedate,sprice);
        if (sflag == 1 && wflag == 1 && eflag == 1 && sflag == 1){
            return 1;
        }

        return  0;

    }

    public Map getLastData(long roomId){
       return billDao.getLastData(roomId);
    }
    public List getPrint(String roomIds){
        return billDao.getPrint(roomIds);
    }
}
