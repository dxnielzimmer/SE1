package org.hbrs.se1.ws23.uebung2.test;
import org.hbrs.se1.ws23.uebung2.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContainerTest {
    private Container c1 = new Container();
    private Member m1,m2;
    @Test
    void addMemberTest()throws ContainerException{
        m1 = new MemberObjekte(1);
        m2 = new MemberObjekte(2);
        //positive Test
        c1.addMember(m1);
        assertEquals(1,c1.size());

        // positive Test
        c1.addMember(m2);
        assertEquals(2,c1.size());

        // negative Test
        m2 = new MemberObjekte(1);
        try {
            c1.addMember(m2);
        }catch (ContainerException ce){
            assertEquals("Das Member-Objekt mit der ID [" + 1 + "] ist bereits vorhanden!",ce.getMessage());
        }
    }
    @Test
    void delete_Test()throws ContainerException{
        m1 = new MemberObjekte(1);
        m2 = new MemberObjekte(2);

        c1.addMember(m1);
        c1.addMember(m2);

        // positive Test
        assertEquals(c1.deleteMember(2),"Objekt mit der ID: " + 2 + " wurde erfolgreich gelöscht");

        //negative Test
        assertEquals(c1.deleteMember(4),"id: " + 4 + " ist nicht vorhanden");

        //negative Test
        c1.deleteMember(1);
        assertEquals(c1.deleteMember(1),"Liste enthält keine member Objekte");

    }
    @Test
    void size_Test()throws ContainerException{
        //positive Test
        assertEquals(0,c1.size());

        m1 = new MemberObjekte(1);
        m2 = new MemberObjekte(2);

        c1.addMember(m1);
        c1.addMember(m2);

        assertEquals(2,c1.size());
    }
}
