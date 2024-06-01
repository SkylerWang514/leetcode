package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: leetcode
 * @description:
 * @author: Skyler
 * @create: 2024-04-02 14:15
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    int id;
    String name;
    String address;
}
