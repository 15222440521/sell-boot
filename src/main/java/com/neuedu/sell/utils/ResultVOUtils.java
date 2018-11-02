package com.neuedu.sell.utils;

import com.neuedu.sell.VO.ResultVO;

public class ResultVOUtils {
     //如果成功查出数据的话
    public static ResultVO success(Object data){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(data);
        return resultVO;
    }
    //如果没查出数据的话
    public static ResultVO success(){
      return success(null);
    }
    //如果查询出现错误的话
    public static ResultVO error(Integer code, String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;


    }
}
