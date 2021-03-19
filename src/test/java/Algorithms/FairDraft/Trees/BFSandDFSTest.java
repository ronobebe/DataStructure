package Algorithms.FairDraft.Trees;

import junit.framework.TestCase;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BFSandDFSTest extends TestCase {
    BFSandDFS bfSandDFS;

    @BeforeEach
    public  void setUp() {
         bfSandDFS = new BFSandDFS();
        bfSandDFS.add(21);
        bfSandDFS.add(15);
        bfSandDFS.add(11);
        bfSandDFS.add(18);
        bfSandDFS.add(7);
        bfSandDFS.add(14);
        bfSandDFS.add(17);
        bfSandDFS.add(20);
        bfSandDFS.add(27);
        bfSandDFS.add(25);
        bfSandDFS.add(29);
        bfSandDFS.add(24);
        bfSandDFS.add(26);
        bfSandDFS.add(28);

    }

    @AfterAll
    public static void afterAll() {

        System.out.println("Text case Completed");
    }


    @Test
    void breathFirstSearch() {
        bfSandDFS.breathFirstSearch();
    }

    @Test
    void printInorder() {
        bfSandDFS.printInorder();
    }

    @Test
    void printPreorder() {
        bfSandDFS.printPreorder();
    }

    @Test
    void printPostorder() {
        bfSandDFS.printPostorder();
    }
}