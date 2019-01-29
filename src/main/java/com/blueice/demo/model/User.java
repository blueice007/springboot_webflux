package com.blueice.demo.model;

/**
* @Description: TODO
* @author blueice
* @date 2019年1月28日 下午6:12:51
*
*/
public class User
{
    private int id;
    private String name;
    private int age;
    private String address;
    
    public User(int id,String name, int age, String address)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }
    
    public User()
    {
    }

    /**
     * @return the id
     */
    public int getId()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }
    /**
     * @return the age
     */
    public int getAge()
    {
        return age;
    }
    /**
     * @param age the age to set
     */
    public void setAge(int age)
    {
        this.age = age;
    }
    /**
     * @return the address
     */
    public String getAddress()
    {
        return address;
    }
    /**
     * @param address the address to set
     */
    public void setAddress(String address)
    {
        this.address = address;
    }

    @Override
    public String toString()
    {
        return "User [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + "]";
    }
    
}
