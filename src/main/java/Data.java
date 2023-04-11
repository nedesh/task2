package main.java;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Data {
    private int id;
    private String name;
    private int waterCount;
    private int gasCount1;
    private int gasCount2;
    private int electroCount1;
    private int electroCount2;
}
