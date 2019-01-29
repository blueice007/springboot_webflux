package com.blueice.demo.model;

/**
* @Description: TODO
* @author blueice
* @date 2019年1月29日 上午11:13:32
*
*/
public class Result
{
    private int code;
    private String msg;
    private Object data;
    
    public Result()
    {
    }

    public Result(int code, String msg, Object data)
    {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    
    /**
     * @return the code
     */
    public int getCode()
    {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code)
    {
        this.code = code;
    }

    /**
     * @return the msg
     */
    public String getMsg()
    {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    /**
     * @return the data
     */
    public Object getData()
    {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Object data)
    {
        this.data = data;
    }

    @Override
    public String toString()
    {
        return "Result [code=" + code + ", msg=" + msg + ", data=" + data + "]";
    }
    
    
}
