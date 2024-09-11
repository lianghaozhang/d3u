package com.lianghaozhang.beans;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Abc {
    private List<String> stringList = null;
    private List<Abc> abcList = null;
    private Set<String> stringSet = null;
    private Set<Abc> abcSet = null;
    private Map<Integer, String> stringMap = null;
    private Map<Integer, Abc> abcMap = null;

    public void setAbcList(List<Abc> abcList) {
        this.abcList = abcList;
    }

    public void setAbcSet(Set<Abc> abcSet) {
        this.abcSet = abcSet;
    }

    public void setAbcMap(Map<Integer, Abc> abcMap) {
        this.abcMap = abcMap;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public void setStringSet(Set<String> stringSet) {
        this.stringSet = stringSet;
    }

    public void setStringMap(Map<Integer, String> stringMap) {
        this.stringMap = stringMap;
    }

    public void show(){
        if (stringList != null)
            System.out.println("List: " + stringList);
        if (abcList != null)
            System.out.println("abcList: " + abcList);
        if (stringSet != null)
            System.out.println("Set: " + stringSet);
        if (abcSet != null)
            System.out.println("abcSet: " + abcSet);
        if (stringMap != null)
            System.out.println("Map: " + stringMap);
        if (abcMap != null)
            System.out.println("abcMap: " + abcMap);
    }
}
