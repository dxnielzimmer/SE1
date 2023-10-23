package org.hbrs.se1.ws23.uebung2;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Container {
    private List<Member> liste = new ArrayList<>();
    public void addMember(Member member)throws ContainerException{
        Iterator<Member> iter = liste.iterator();

        if(liste.isEmpty()){
            liste.add(member);
        }else {
            while (iter.hasNext()) {
                Member m = iter.next();
                if (m.getID() == member.getID()) {
                    throw new ContainerException("Das Member-Objekt mit der ID [" + member.getID() + "] ist bereits vorhanden!");
                }
            }
            liste.add(member);
        }
    }
    public String deleteMember(Integer id){
        Iterator<Member> iter = liste.iterator();

        if(liste.isEmpty() == true){
            return "Liste enthält keine member Objekte";
        }
        while(iter.hasNext()){
            Member m = iter.next();
            if(m.getID() == id){
                iter.remove();          // liste.remove(m);
                return "Objekt mit der ID: " + id + " wurde erfolgreich gelöscht";
            }
        }
        return "id: " + id + " ist nicht vorhanden";
    }

    public void dump(){
        Iterator<Member> iter = liste.iterator();

        while(iter.hasNext()){
            Member m = iter.next();
            System.out.println(m.toString());
        }
    }
    public int size(){
        return liste.size();
    }

}
