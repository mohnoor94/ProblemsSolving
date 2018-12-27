package recursion_and_dynamic_programminng;

import java.util.Deque;
import java.util.LinkedList;

/**
 * In the classic problem of Towers of Hanoi, you have 3 towers and N disks of different sizes which can slide onto any
 * tower. The puzzle starts with disks sorted in ascending order of size from top to bottom (i.e., each disk sit on top
 * of an even larger one). you have the following constraints:
 * - only one disk can be moved at a time.
 * - a disk is slid of the top of one tower onto another tower.
 * - a disk cannot be placed on top of a smaller disk.
 * Write a program to move the disks from the first tower to the last using stacks.
 * ***
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 8.6)
 */
public class TowersOfHanoi {

    public static void main(String[] args) {
        int n = 3;
        Tower[] towers = new Tower[3];
        for (int i = 0; i < 3; i++) {
            towers[i] = new Tower("Tower " + (i + 1));
        }

        for (int i = n; i > 0; i--) {
            towers[0].add(i);
        }

        towers[0].moveDisks(n, towers[2], towers[1]);

        // show final results
        System.out.println("================================");
        for (int i = 0; i < towers.length; i++) {
            Tower tower = towers[i];
            System.out.print(">> Tower " + (i + 1) + ": ");
            tower.getDisks().forEach(d -> System.out.print(d + ", "));
            System.out.println();
        }
    }
}

@SuppressWarnings("WeakerAccess")
class Tower {
    private Deque<Integer> disks;
    private String title;

    public Tower(String title) {
        this.disks = new LinkedList<>();
        this.title = title;
    }

    public Deque<Integer> getDisks() {
        return disks;
    }

    public void add(int d) {
        if (!disks.isEmpty() && disks.peek() <= d) System.out.println("Error placing disk " + d);
        else disks.push(d);
    }

    public void moveTopTo(Tower tower) {
        System.out.println("Move {" + disks.peek() + "} from " + title + " to " + tower.title); // show steps
        tower.add(disks.pop());
    }

    public void moveDisks(int n, Tower destination, Tower buffer) {
        if (n > 0) {
            moveDisks(n - 1, buffer, destination);
            moveTopTo(destination);
            buffer.moveDisks(n - 1, destination, this);
        }
    }
}