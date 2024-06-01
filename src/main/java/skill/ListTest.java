package skill;

import entity.Student;

import java.awt.List;
import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.Collectors;

/**
 * @program: leetcode
 * @description:
 * @author: Skyler
 * @create: 2024-04-02 14:14
 **/

public class ListTest {
    private ListTest listTest = new ListTest();
    private ListTest listTest1;
    private volatile ListTest listTest2;
    BlockingDeque<Integer> a = new LinkedBlockingDeque<>();
    Deque<Integer> b = new LinkedList<>();

    private ListTest(){
        System.arraycopy();
    }

    public ListTest getListTest(){
        return listTest;
    }

    public synchronized ListTest getListTest1(){
        if (listTest1 == null){
            listTest1 = new ListTest();
        }
        return listTest1;
    }

    public ListTest getListTest2(){
        if (listTest2 == null){
            synchronized (ListTest.class){
                if (listTest2 == null){
                    listTest2 = new ListTest();
                }
            }
        }
        return listTest2;
    }


}
