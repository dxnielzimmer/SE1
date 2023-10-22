package org.hbrs.se1.ws23.uebung2;

public class MemberObjekte implements Member {
    private Integer id;

    public MemberObjekte(Integer id){
        this.id = id;
    }
    public Integer getID(){
        return this.id;
    }
    public String toString(){
        return "Member (ID = [" + getID() + "])";    }
}
