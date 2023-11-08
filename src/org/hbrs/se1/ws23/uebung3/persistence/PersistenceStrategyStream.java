package org.hbrs.se1.ws23.uebung3.persistence;

import org.hbrs.se1.ws23.uebung3.Member;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersistenceStrategyStream<E> implements PersistenceStrategy<E> {
    private ObjectInputStream ois;
    private FileInputStream fis;
    private ObjectOutputStream oos;
    private FileOutputStream fos;

    // URL of file, in which the objects are stored
    private String location;

    // Backdoor method used only for testing purposes, if the location should be changed in a Unit-Test
    // Example: Location is a directory (Streams do not like directories, so try this out ;-)!
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    /**
     * Method for opening the connection to a stream (here: Input- and Output-Stream)
     * In case of having problems while opening the streams, leave the code in methods load
     * and save.
     */
    public void openConnection() throws PersistenceException {
    }

    @Override
    /**
     * Method for closing the connections to a stream
     */
    public void closeConnection() throws PersistenceException {
    }

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     */
    public void save(List<E> member) throws PersistenceException  {
        try {
            oos = new ObjectOutputStream(fos);
            fos = new FileOutputStream(location);

            oos.writeObject(member);
            oos.close();
            fos.close();

        } catch (IOException e ) {
            e.printStackTrace();
        }
    }

    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     * Take also a look at the import statements above ;-!
     */
    public List<E> load() throws PersistenceException  {
        // Some Coding hints ;-)

        // ObjectInputStream ois = null;
        // FileInputStream fis = null;
        // List<...> newListe =  null;
        //
        // Initiating the Stream (can also be moved to method openConnection()... ;-)
        // fis = new FileInputStream( " a location to a file" );

        // Tipp: Use a directory (ends with "/") to implement a negative test case ;-)
        // ois = new ObjectInputStream(fis);

        // Reading and extracting the list (try .. catch ommitted here)
        // Object obj = ois.readObject();

        // if (obj instanceof List<?>) {
        //       newListe = (List) obj;
        // return newListe

        // and finally close the streams (guess where this could be...?)

        List<E>  liste = null;
        try {
            fis = new FileInputStream(location);
            ois  = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                liste = (List) obj;
            }
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return liste;
    }
}
