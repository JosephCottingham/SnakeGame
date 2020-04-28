// CSE 205: 11333 | Tue/Thu 4:30 PM
// Assignment: Six Final Project
// Author: Joseph H Cottingham | 1216723703
// Description: Manages the leaderboard member data

package Snake.LeaderBoard;

import Snake.Support.Stack;

import java.io.*;

public class LeaderBoardAdaptor {
    Stack<Member> list = new Stack<Member>();

    public LeaderBoardAdaptor() {
    }

    // adds member and saves data to csv
    public void addMember(Member M) {
        list.push(M);
        exportLeaderBoard();
    }

    // loads from CSV
    public boolean loadLeaderBoard() {
        // Storing in stack and not a 2d array because we need to be able to dynamicaly add to it becuase we do not know the length of the file.
        // stack is also used because first in, last out. The top of the dataset is post likely to have the worst users
        list = new Stack<Member>();
        String line = "";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("leaderboard.csv"));
            while ((line = br.readLine()) != null) {
                String[] m = line.split(",");
                list.push(new Member(m[0], m[1], m[2], m[3]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    // exports to CSV
    public boolean exportLeaderBoard() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("leaderboard.csv");
            for (int y = 0; y < list.size(); y++) {
                Member m = list.get(y);
                fw.append(m.getFirst());
                fw.append(",");
                fw.append(m.getLast());
                fw.append(",");
                fw.append(String.valueOf(m.getAge()));
                fw.append(",");
                fw.append(String.valueOf(m.getScore()));
                fw.append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    // collect Memberdata as a 2d array
    public String[][] getData() {
        quicksort(list); // sorts to order by member score
        // Must populate a new storage meathod because 2d array required for JTable
        String[][] temp = new String[list.size()][4];
        for (int x = 0; x < list.size(); x++) {
            temp[x][0] = list.get(list.size() - 1 - x).getFirst();
            temp[x][1] = list.get(list.size() - 1 - x).getLast();
            temp[x][2] = String.valueOf(list.get(list.size() - 1 - x).getAge());
            temp[x][3] = String.valueOf(list.get(list.size() - 1 - x).getScore());

        }
        return temp;
    }

    public static void quicksort(Stack<Member> list) {
        // calls meathod built for recurserion
        recursiveQuicksort(list, 0);
    }

    private static void recursiveQuicksort(Stack<Member> alist, int pivote) {
        // if pivote values is the out of bounds it returns as sort is complete
        if (pivote >= alist.size()) return;
        // swap index represents the temp storage location where values smaller than the piviote will be moved
        int swapIndex = pivote + 1;
        // loops though moving smaller vlaues to swapIndex
        for (int x = pivote + 1; x < alist.size(); x++) {
            if (alist.get(x).getScore() < alist.get(pivote).getScore()) {
                swap(alist, x, swapIndex);
                swapIndex++;
            }
        }
        // Moves one value before the pivot if their was a lower value, else it swaps with itself
        swap(alist, pivote, swapIndex - 1);

        if (swapIndex > pivote + 1)
            recursiveQuicksort(alist, pivote);
        else
            recursiveQuicksort(alist, pivote + 1);
    }

    private static void swap(Stack<Member> aList, int a, int b) {
        // Swaps values of indexs of a given MyList object
        Member tempVal = aList.get(a);
        aList.set(a, aList.get(b));
        aList.set(b, tempVal);
    }
}
