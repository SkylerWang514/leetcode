package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Delete;
import org.joda.time.DateTime;

import java.time.DateTimeException;

/**
 * @program: leetcode
 * @description: 空调开关机记录实体类
 * @author: Skyler
 * @create: 2023-04-14 19:02
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Record {
    private int turnFlag;
}
