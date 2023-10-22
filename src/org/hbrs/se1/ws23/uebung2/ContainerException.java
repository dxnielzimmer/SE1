package org.hbrs.se1.ws23.uebung2;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Container {
    private List<Member> liste = new ArrayList<>();

    public void addMember(Member member) throws ContainerException{         // Member objekte mit gleicher id werden noch hinzugefügt
        if(liste.contains(member)){
            throw new ContainerException("Das Member-Objekt mit der ID [" + member.getID() + "] ist bereits vorhanden!");
        }else{
            liste.add(member);
        }
    }
    public String deleteMember(Integer id){
        if(liste.isEmpty() == true){
            return "Liste enthält keine member Objekte";
        }else if(liste.remove(id)){
            return "Member mit der ID: " + id + " wurde erfolgreich gelöscht";
        }else{
            return "id: " + id + " ist nicht vorhanden";
        }
        /* Zu FA2:
         * Welche Nachteile ergeben sich aus ihrer Sicht für ein solchen Fehler-
         * handling gegenüber einer Lösung mit Exceptions? Kurzes Statement!
         *
         *
         *
         * */
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
