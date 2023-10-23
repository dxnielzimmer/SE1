package org.hbrs.se1.ws23.uebung2.test;
import org.hbrs.se1.ws23.uebung2.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContainerTest {
    private Container c1 = new Container();

    @Test
    void a_test() throws ContainerException {
        Member m1 = new MemberObjekte(1);
        Member m2 = new MemberObjekte(2);
        Member m3 = new MemberObjekte(3);
        Member m4 = new MemberObjekte(4);

        c1.addMember(m1);
        c1.addMember(m2);
        c1.addMember(m3);
        c1.addMember(m4);


        c1.deleteMember(4);

        c1.dump();
        // Size Test
        int size = c1.size();
        assertEquals(3,size);


    }
}
