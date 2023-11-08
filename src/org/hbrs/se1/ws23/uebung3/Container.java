package org.hbrs.se1.ws23.uebung3;

import org.hbrs.se1.ws23.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceStrategy;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceStrategyStream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Container {
    private List<Member> liste = new ArrayList<>();
    private static PersistenceStrategyStream<Member> ps_s = new PersistenceStrategyStream<>();
    private static Container container;
    private Container(){}
    public static Container get_container_instance(){
        if(container == null){
            container = new Container();
        }
        return container;
    }

    public List<Member> getCurrentList(){
        return this.liste;
    }

    public void store()throws PersistenceException {
        ps_s.setLocation("filename.txt");
        ps_s.save(liste);
    }

    public void load()throws PersistenceException{
        ps_s.setLocation("filname.txt");
        ps_s.load();
    }

    public void addMember(Member member)throws ContainerException {
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
                iter.remove();
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
