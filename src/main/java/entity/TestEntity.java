package entity;

import lombok.*;

/**
 * @program: leetcode
 * @description: 测试实体类
 * @author: Skyler
 * @create: 2023-04-02 11:45
 **/
@Getter
@Setter
public class TestEntity {
    int Id;
    String name;
    int age;
    public TestEntity(int Id,String name,int age){
        this.Id=Id;
        this.age=age;
        this.name=name;
    }
}
