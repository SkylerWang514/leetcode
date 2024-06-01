import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import entity.TestEntity;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: 笔试
 * @description:
 * @author: Skyler
 * @create: 2023-04-01 09:24
 **/

public class Practice {
    // 测试静态变量
    private static int i;

    //test Set
    public void SetTest(){
        Set<TestEntity> set = new HashSet<>();
        TestEntity entity1 = new TestEntity(1,"wjy",1);
        TestEntity entity2 = new TestEntity(1,"wjy",1);
        //entity1
        set.add(entity1);

        //entity2
        set.add(entity2);

        for (TestEntity e:
                set) {
            System.out.println(e);
        }
        System.out.println(set.size());
    }

    // 测试浅拷贝，这样直接=是浅拷贝
    public void cloneTest(){
//        TestEntity testEntity = new TestEntity();
//        TestEntity testEntity1 = new TestEntity();
//
//        testEntity.setData1(1);
//        testEntity.setData2(1L);
//
//        testEntity1 = testEntity;
//
//        System.out.println("testEntity1 data1:" + testEntity1.getData1());
//        System.out.println("testEntity1 data2:" + testEntity1.getData2());
//
//        testEntity.setData1(2);
//        testEntity.setData2(2L);
//
//        System.out.println("testEntity1 data1:" + testEntity1.getData1());
//        System.out.println("testEntity1 data2:" + testEntity1.getData2());
    }

    public void ListCopy(){
        List<TestEntity> testEntities = new ArrayList<>();
        testEntities.add(new TestEntity(1,"wjy",1));

        List<TestEntity> testEntityList = testEntities.stream().filter(
                testEntity -> testEntity.getAge() == 0
        ).collect(Collectors.toList());

        System.out.println(testEntityList);
    }

    public void testEqual(){
        TestEntity testEntity1 = new TestEntity(1,"w",1);
        TestEntity testEntity2 = new TestEntity(1,"w",1);
        
        System.out.println(testEntity1.equals(testEntity2));

        String s1 = new String("1");
        String s2 = new String("1");
        System.out.println(s1.equals(s2));
    }

    public void testString(){
        String s1 = "1";
        String s2 = "1";

        s2 = "2";
        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);

    }

    public static void main(String[] args) {
        Practice practice = new Practice();
        practice.testString();

    }
}
