package edu.citadel.csci603.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;


import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {
    private static final Logger LOG = LogManager.getLogger(LinkedListTest.class.getName());

    private void checkEmpty(LinkedList<String> l)
    {
        assertTrue(l != null,"list was null");
        assertTrue(l.isEmpty(),"list was not empty");
        assertTrue(l.size()==0,"list size was not zero");
        assertTrue(l.toString().equals("[]"),"list toSting not []");
    }


    @Test
    void constructorTest() {
        LOG.info(
                "Testing Constructor: LinkedList()");

        LinkedList<String> l = new LinkedList<String>();

        checkEmpty(l);
    }
    @Test
    void addTest() {

        LinkedList<String> l = new LinkedList<String>();

        LOG.info(
                "Testing add(\"0\") on list with "+l.size()+" elements");

        l.add("0");

        assertFalse(l.isEmpty(),"list remained empty after adding");
        assertTrue(l.size()==1,"list size was not 1");
        assertTrue(l.toString().equals("[0]"),"list toString not \"[0]\"");
        assertTrue(l.get(0).equals("0"),"get(0) did not return \"0\"");
        assertTrue(l.indexOf("0") == 0,"indexOf(\"0\") not 0");

        LOG.info(
                "Testing add(\"1\") on list with "+l.size()+" element");

        l.add("1");

        assertTrue(l.size()==2,"list size was not 2");
        assertTrue(l.toString().equals("[0,1]"),"list toString not \"[0,1]\"");
        assertTrue(l.get(0).equals("0"),"get(0) did not return \"0\"");
        assertTrue(l.get(1).equals("1"),"get(1) did not return \"1\"");
        assertTrue(l.indexOf("0") == 0,"indexOf(\"0\") not 0");
        assertTrue(l.indexOf("1") == 1,"indexOf(\"1\") not 1");

        LOG.info(
                "Testing add(2,\"2\") on list with "+l.size()+" elements");

        l.add(2,"2");

        assertTrue(l.size()==3,"list size was not 3");
        assertTrue(l.toString().equals("[0,1,2]"),"list toString not \"[0,1,2]\"");
        assertTrue(l.get(0).equals("0"),"get(0) did not return \"0\"");
        assertTrue(l.get(1).equals("1"),"get(1) did not return \"1\"");
        assertTrue(l.get(2).equals("2"),"get(2) did not return \"2\"");
        assertTrue(l.indexOf("0") == 0,"indexOf(\"0\") not 0");
        assertTrue(l.indexOf("1") == 1,"indexOf(\"1\") not 1");
        assertTrue(l.indexOf("2") == 2,"indexOf(\"2\") not 2");

        LOG.info(
                "Testing add(0,\"-1\") on list with "+l.size()+" elements");

        l.add(0,"-1");

        assertTrue(l.size()==4,"list size was not 4");
        assertTrue(l.toString().equals("[-1,0,1,2]"),"list toString not \"[-1,0,1,2]\"");
        assertTrue(l.get(0).equals("-1"),"get(0) did not return \"-1\"");
        assertTrue(l.get(1).equals("0"),"get(1) did not return \"0\"");
        assertTrue(l.get(2).equals("1"),"get(2) did not return \"1\"");
        assertTrue(l.get(3).equals("2"),"get(3) did not return \"2\"");
        assertTrue(l.indexOf("-1") == 0,"indexOf(\"-1\") not 0");
        assertTrue(l.indexOf("0") == 1,"indexOf(\"0\") not 1");
        assertTrue(l.indexOf("1") == 2,"indexOf(\"1\") not 2");
        assertTrue(l.indexOf("2") == 3,"indexOf(\"2\") not 3");

        LOG.info(
                "Testing add(2,\"0.5\") on list with "+l.size()+" elements");

        l.add(2,"0.5");

        assertTrue(l.size()==5,"list size was not 5");
        assertTrue(l.toString().equals("[-1,0,0.5,1,2]"),"list toString not \"[-1,0,0.5,1,2]\"");
        assertTrue(l.get(0).equals("-1"),"get(0) did not return \"-1\"");
        assertTrue(l.get(1).equals("0"),"get(1) did not return \"0\"");
        assertTrue(l.get(2).equals("0.5"),"get(2) did not return \"0.5\"");
        assertTrue(l.get(3).equals("1"),"get(3) did not return \"1\"");
        assertTrue(l.get(4).equals("2"),"get(4) did not return \"2\"");
        assertTrue(l.indexOf("-1") == 0,"indexOf(\"-1\") not 0");
        assertTrue(l.indexOf("0") == 1,"indexOf(\"0\") not 1");
        assertTrue(l.indexOf("0.5") == 2,"indexOf(\"0.5\") not 2");
        assertTrue(l.indexOf("1") == 3,"indexOf(\"1\") not 2");
        assertTrue(l.indexOf("2") == 4,"indexOf(\"2\") not 4");

        LOG.info(
                "Testing add(-1,\"bad index\") throws IndexOutOfBoundsException on list with "+l.size()+" elements");


        Throwable e1 =
                assertThrows(
                        IndexOutOfBoundsException.class,
                        ()-> l.add(-1,"bad index"));
        assertEquals("-1",e1.getMessage());

        LOG.info(
                "Testing add(5,\"bad index\") throws IndexOutOfBoundsException on list with "+l.size()+" elements");


        Throwable e2 =
                assertThrows(
                        IndexOutOfBoundsException.class,
                        ()-> l.add(6,"bad index"));
        assertEquals("6",e2.getMessage());


    }

    @Test
    void clearTest() {
        LinkedList<String> l = new LinkedList<String>();

        LOG.info(
                "Testing clear() on list with "+l.size()+" elements");

        l.clear();

        checkEmpty(l);

        for (int i = 0;i < 5; i++)
        {
            l.add(Integer.toString(i));
        }

        LOG.info(
                "Testing clear() on list with "+l.size()+" elements");

        l.clear();

        checkEmpty(l);
    }

    @Test
    void getTest() {

        LinkedList<String> l = new LinkedList<String>();

        for (int i = 0;i < 5; i++)
        {
            l.add(Integer.toString(i));
        }

        LOG.info(
                "Testing get(int) on list with "+l.size()+" elements");

        for (int i = 0;i < 5; i++)
        {
            assertTrue(l.get(i).equals(Integer.toString(i)),"get("+i+") did not return \""+i+"\"");
        }

        LOG.info(
                "Testing get(-1) throws IndexOutOfBoundsException on list with "+l.size()+" elements");


        Throwable e1 =
                assertThrows(
                        IndexOutOfBoundsException.class,
                        ()-> l.get(-1));
        assertEquals("-1",e1.getMessage());

        LOG.info(
                "Testing get(5) throws IndexOutOfBoundsException on list with "+l.size()+" elements");


        Throwable e2 =
                assertThrows(
                        IndexOutOfBoundsException.class,
                        ()-> l.get(5));
        assertEquals("5",e2.getMessage());
    }

    @Test
    void setTest() {

        LinkedList<String> l = new LinkedList<String>();

        for (int i = 0;i < 5; i++)
        {
            l.add(Integer.toString(i));
        }

        LOG.info(
                "Testing set(int) on list with "+l.size()+" elements");

        for (int i = 0;i < 5; i++)
        {
            l.set(i,Integer.toString(i+10));
            assertTrue(l.get(i).equals(Integer.toString(i+10)),"get("+i+") did not return \""+(i+10)+"\"");
        }

        LOG.info(
                "Testing set(-1,\"bad index\") throws IndexOutOfBoundsException on list with "+l.size()+" elements");


        Throwable e1 =
                assertThrows(
                        IndexOutOfBoundsException.class,
                        ()-> l.set(-1,"bad index"));
        assertEquals("-1",e1.getMessage());

        LOG.info(
                "Testing set(5,\"bad index\") throws IndexOutOfBoundsException on list with "+l.size()+" elements");

        Throwable e2 =
                assertThrows(
                        IndexOutOfBoundsException.class,
                        ()-> l.set(5,"bad index"));
        assertEquals("5",e2.getMessage());
    }

    @Test
    void removeTest() {

        LinkedList<String> l = new LinkedList<String>();

        for (int i = 0;i < 5; i++)
        {
            l.add(Integer.toString(i));
        }

        LOG.info(
                "Testing remove(-1) throws IndexOutOfBoundsException on list with "+l.size()+" elements");

        Throwable e1 =
                assertThrows(
                        IndexOutOfBoundsException.class,
                        ()-> l.remove(-1));
        assertEquals("-1",e1.getMessage());

        LOG.info(
                "Testing remove(5) throws IndexOutOfBoundsException on list with "+l.size()+" elements");

        Throwable e2 =
                assertThrows(
                        IndexOutOfBoundsException.class,
                        ()-> l.remove(5));
        assertEquals("5",e2.getMessage());

        LOG.info(
                "Testing remove(0) on list with "+l.size()+" elements");

        assertTrue(l.remove(0).equals("0"),"remove(0) did not return \"0\"");

        LOG.info(
                "Testing remove(3) on list with "+l.size()+" elements");

        assertTrue(l.remove(3).equals("4"),"remove(3) did not return \"4\"");


        LOG.info(
                "Testing remove(1) on list with "+l.size()+" elements");

        assertTrue(l.remove(1).equals("2"),"remove(1) did not return \"2\"");
        assertTrue(l.toString().equals("[1,3]"),"remaining list did not equal [1,3]");

        LOG.info(
                "Testing remove(0) on remaining elements in list with "+l.size()+" elements");

        for (int i = 0;i <= l.size();i++)
        {
            l.remove(0);
        }

        checkEmpty(l);
    }

    @Test
    void indexOfTest() {

        LinkedList<String> l = new LinkedList<String>();

        for (int i = 0;i < 5; i++)
        {
            l.add(Integer.toString(i));
        }

        LOG.info(
                "Testing indexOf(string) on list with "+l.size()+" elements");

        for (int i = 0;i < 5; i++)
        {
             assertTrue(l.indexOf(Integer.toString(i)) == i,"indexOf(\""+i+"\") did not return "+i);
        }

        l.add(3,null);

        LOG.info(
                "Testing indexOf(null) on list with "+l.size()+" elements");

        assertTrue(l.indexOf(null) == 3,"indexOf(null) did not return 3");

        LOG.info(
                "Testing indexOf(\"not found\") on list with "+l.size()+" elements");

        assertTrue(l.indexOf("not found") == -1,"indexOf(\"not found\") did not return -1");
    }

    @Test
    void equalsTest() {

        LinkedList<String> l1 = new LinkedList<String>();
        LinkedList<String> l2 = new LinkedList<String>();

        LOG.info(
                "Testing equals(null) on list with "+l1.size()+" elements");

        assertFalse(l1.equals(null),"equals(null) was not false");

        LOG.info(
                "Testing equals(\"string\") on list with "+l1.size()+" elements");

        assertFalse(l1.equals("string"),"equals(\"string\") was not false");

        LOG.info(
                "Testing equals(list) where lhs and rhs are same list");

        assertTrue(l1.equals(l1),"11.equals(l1) was not true");

        LOG.info(
                "Testing equals(list) where lhs is list with "+l1.size()+" elements and rhs is list with "+l2.size()+" elements");

        assertTrue(l1.equals(l2),"11.equals(l2) was not true");

        for (int i = 0;i < 5; i++)
        {
            if (i == 3)
            {
                l1.add(null);
                l2.add(null);
            }
            l1.add(Integer.toString(i));
            l2.add(Integer.toString(i));
        }

        LOG.info(
                "Testing equals(list) where lhs is list with "+l1.size()+" elements and rhs is list with "+l2.size()+" identical elements");

        assertTrue(l1.equals(l2),"11.equals(l2) was not true");

        l2.remove(4);

        LOG.info(
                "Testing equals(list) where lhs is list with "+l1.size()+" elements and rhs is list with "+l2.size()+" identical elements");

        assertFalse(l1.equals(l2),"11.equals(l2) was not false");

        l2.remove(4);
        String old = l2.set(3,"not null");

        LOG.info(
                "Testing equals(list) where lhs is list with "+l1.size()+" elements and rhs is list with "+l2.size()+" identical elements except for 3rd element rhs being null");

        assertFalse(l1.equals(l2),"11.equals(l2) was not false");

        l2.set(3,old);
        l1.set(3,null);

        LOG.info(
                "Testing equals(list) where lhs is list with "+l1.size()+" elements and rhs is list with "+l2.size()+" identical elements except for 3rd element lhs being null");

        assertFalse(l1.equals(l2),"11.equals(l2) was not false");

        l1.clear();
        l2.clear();

        for (int i = 0;i < 5; i++)
        {
            l1.add(Integer.toString(i));
            l2.add(Integer.toString(i+10));
        }

        LOG.info(
                "Testing equals(list) where lhs is list with "+l1.size()+" elements and rhs is list with "+l2.size()+" different elements");

        assertFalse(l1.equals(l2),"11.equals(l2) was not false");
    }

    @Test
    void toStringTest() {

        LinkedList<String> l = new LinkedList<String>();

        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                l.add(null);
            }
            l.add(Integer.toString(i));
        }


        LOG.info(
                "Testing toString on list with " + l.size() + " elements (including a null element)");

        assertTrue(l.toString().equals("[0,1,2,null,3,4]"), "toString did not equal [0,1,2,null,3,4]");
    }

    @Test
    void iteratorTest() {

        LinkedList<String> l = new LinkedList<String>();

        for (int i = 0; i < 5; i++) {
            l.add(Integer.toString(i));
        }

        LOG.info(
                "Testing iterator on list with " + l.size() + " elements");

        Iterator<String> iter = l.iterator();
        int i = 0;

        while (iter.hasNext())
        {
            assertTrue(iter.next().equals(Integer.toString(i)),"Element at index "+i+" did not equal \""+i+"\"");
            i++;
        }


        LOG.info(
                "Testing iter.next() throws NoSuchElementException when no next element exists");

        Throwable e1 =
                assertThrows(
                        NoSuchElementException.class,
                        ()-> iter.next());
        assertEquals("next",e1.getMessage());

        LOG.info(
                "Testing iter.remove() throws UnsupportedOperationException");

        Throwable e2 =
                assertThrows(
                        UnsupportedOperationException.class,
                        ()-> iter.remove());
        assertEquals("remove",e2.getMessage());

        LOG.info(
                "Testing \"for loop\" implicit iteration with list containing " + l.size() + " elements");

        i = 0;

        for (String s : l)
        {
            assertTrue(s.equals(Integer.toString(i)),"Element at index "+i+" did not equal \""+i+"\"");
            i++;
        }
        
        LOG.info(
                "Testing Iterable.foreach iteration with list containing " + l.size() + " elements");

        final int j[] = {0};

        l.forEach(e -> {assertTrue(e.equals(Integer.toString(j[0])),"Element at index "+j[0]+" did not equal \""+j[0]+"\"");j[0]++;});

    }


    @Test
    void hashCodeTest() {

        LOG.info(
                "Testing hashCode()");

        // For fun, compute the efficiency of the hashCode algorithm by randomly
        // generating one million unique string lists and counting any collisions that
        // occur

        Map<Integer,List<String>> hashes = new HashMap<>();
        long collisions = 0;
        long entries = 0;
        long duplicates = 0;

        Random rand = new Random(0); // generate the same sequence every test

        do
        {
            LinkedList<String> l = new LinkedList<String>();

            // only need to test one empty list, first time through

            if (entries > 0) {
                int listSize = rand.nextInt(19)+1;

                for (int i = 0; i < listSize; i++) {
                    l.add(RandomStringUtils.randomAlphabetic(0, 20));
                }
            }

            int hash = l.hashCode();
            String lStr = l.toString();

            // check for collision

            if (hashes.containsKey(hash))
            {
                List<String> lists = hashes.get(hash);

                if (lists.contains(lStr))
                {
                    // generated a duplicate string - ignore.
                    duplicates++;

                    continue;
                }

                // a collision occurred

                entries++;
                collisions++;
            }
            else
            {
                // this fraction is unique

                List<String> lists = new ArrayList<>();

                lists.add(lStr);

                hashes.put(hash,lists);

                entries++;
            }
        }
        while (entries < 1000000);

        double hashEfficiency = (1.0 - (double)collisions/(double)entries)*100.0;

        LOG.info(
                "LinkedList.hashCode() experienced "+
                        Long.toString(collisions)+
                        " collisions out of "+
                        Long.toString(entries)+
                        " unique Linked Lists - efficiency: "+
                        Double.toString(hashEfficiency)+
                        "%.\nThe test generated "+
                        Long.toString(duplicates)+
                        " duplicate Linked Lists");
    }
}
