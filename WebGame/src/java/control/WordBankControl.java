/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import runnables.*;

/**
 *
 * @author Bryan
 */
public class WordBankControl implements Serializable {

    private final AtomicInteger atomNum = new AtomicInteger(0);

    public AtomicInteger getAtomNum() {
        return atomNum;
    }

    public WordBankControl() {
        // Empty constructor
    }

    public void buildWordBank() {

        ConcurrentMap<Integer, Runnable> threadController = new ConcurrentHashMap();

        // Create ACP hashMap for Http/JSON files
        threadController.put(0, new PersonNounRunnable());
        threadController.put(1, new AdverbRunnable());
        threadController.put(2, new VerbRunnable());
        threadController.put(3, new AdjectiveRunnable());
        threadController.put(4, new ObjectNounRunnable());

        // Starting executors
        for (int i = 0; i < threadController.size(); i++) {
            Runnable task = threadController.get(i);
            task.run();
        }
    }
}
