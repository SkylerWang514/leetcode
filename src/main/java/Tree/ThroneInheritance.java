package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 1600
 * @author: Skyler
 * @create: 2024-04-07 19:28
 **/

public class ThroneInheritance {
    String name;
    List<ThroneInheritance> children;
    Map<String, ThroneInheritance> generationMap;
    boolean ifDead;
    public ThroneInheritance(String kingName) {
        this.name = kingName;
        this.children = new ArrayList<>();
        this.generationMap = new HashMap<>();
        this.ifDead = false;
        generationMap.put(kingName, this);
    }

    public void birth(String parentName, String childName) {
        ThroneInheritance now = generationMap.get(parentName);
        ThroneInheritance newOne = new ThroneInheritance(childName);
        now.children.add(newOne);
        generationMap.put(childName, newOne);
    }

    public void death(String name) {
        generationMap.get(name).ifDead = true;
    }

    public List<String> getInheritanceOrder() {
        List<String> stringList = new ArrayList<>();
        stringList.add(this.name);
        if (this.children.size() == 0) return stringList;
        else {
            for (ThroneInheritance sons:
                 this.children) {
                if (!sons.ifDead)
                    stringList.addAll(sons.getInheritanceOrder());
            }
        }
        return stringList;
    }
}
