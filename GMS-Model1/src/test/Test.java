package test;

import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.Date;

public class Test {
public static void main(String[] args) {
    List<String> lst = TestDao.getInstance().selectAge();
    //age 몇년생인지 추출
    //1988년생 남자
    //880101-1
    //88+01(random)+01(random)+-+1
    //insertinto로 DB저장
    
    String today=new SimpleDateFormat("yyyy").format(new Date());
    int yearint=0,  index=0;
    String month,day,ssn="";
    String birth="";
        for(int i=0;i<23;i++) {
            yearint=Integer.parseInt(today)+1 -Integer.parseInt(lst.get(i));
            month = String.format("%02d", (int)(Math.random()*12)+1);
            day = String.format("%02d", (int)(Math.random()*30)+1);
            birth = String.valueOf(yearint)+ month+day+"-";
            ssn=birth.substring(2, 9);
            index = i+2;
            TestDao.getInstance().updateSsn(ssn, index);
            System.out.println("test : " + index);
            }
        }
}