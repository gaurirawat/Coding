package revision;

import java.util.*;

//https://leetcode.com/problems/throne-inheritance/
public class Hashing_lc_throne_inheritance {
    Person root;
    HashMap<String,Person> map;
    public Hashing_lc_throne_inheritance(String name) {
        root=new Person(name);
        map=new HashMap<String, Person>();
        map.put(name,root);
    }

    public void birth(String pname, String cname) {
        Person p=map.get(pname);
        Person ch=new Person(cname);
        p.child.add(ch);
        map.put(cname,ch);
    }

    public void death(String name) {
        map.get(name).isDead=true;
    }

    public List<String> getInheritanceOrder() {
        List<String> l=new ArrayList<String>();
        dfs(root,l);
        return l;
    }

    public void dfs(Person root, List<String> l){
        // System.out.println(root.name);
        if(!root.isDead)
            l.add(root.name);
        for(Person x:root.child){
            dfs(x,l);
        }
    }
}

class Person{
    String name;
    boolean isDead;
    ArrayList<Person> child;

    public Person(String name){
        this.name=name;
        isDead=false;
        child=new ArrayList<Person>();
    }
}
