package Snake.LeaderBoard;

import java.io.*;
import java.util.ArrayList;

public class LeaderBoardAdaptor {
    ArrayList<Member> list = new ArrayList<Member>();
    public LeaderBoardAdaptor(){
    }

    public void addMember(Member M){
        list.add(M);
        exportLeaderBoard();
    }

    public boolean loadLeaderBoard(){
        list = new ArrayList<Member>();
        String line = "";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("leaderboard.txt"));
            while ((line = br.readLine()) != null) {
                String[] m = line.split(",");
                list.add(new Member(m[0], m[1], m[2], m[3]));
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

    public boolean exportLeaderBoard(){
        FileWriter fw = null;
        try {
            fw = new FileWriter("leaderboard.txt");
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

    public String[][] getData(){
        quicksort(list);
        String[][] temp = new String[list.size()][4];
        for (int x = 0; x < list.size(); x++){
            temp[x][0] = list.get(list.size()-1-x).getFirst();
            temp[x][1] = list.get(list.size()-1-x).getLast();
            temp[x][2] = String.valueOf(list.get(list.size()-1-x).getAge());
            temp[x][3] = String.valueOf(list.get(list.size()-1-x).getScore());

        }
        return temp;
    }

    public static void quicksort(ArrayList<Member> list) {
        // calls meathod built for recurserion
        recursiveQuicksort(list, 0);
    }

    private static void recursiveQuicksort(ArrayList<Member> aList, int pivote) {
        // if pivote values is the out of bounds it returns as sort is complete
        if (pivote >= aList.size()) return;
        // swap index represents the temp storage location where values smaller than the piviote will be moved
        int swapIndex = pivote + 1;
        // loops though moving smaller vlaues to swapIndex
        for (int x = pivote + 1; x < aList.size(); x++) {
            if (aList.get(x).getScore() < aList.get(pivote).getScore()) {
                swap(aList, x, swapIndex);
                swapIndex++;
            }
        }
        // Moves one value before the pivot if their was a lower value, else it swaps with itself
        swap(aList, pivote, swapIndex - 1);

        if (swapIndex > pivote + 1)
            recursiveQuicksort(aList, pivote);
        else
            recursiveQuicksort(aList, pivote + 1);
    }
    private static void swap(ArrayList<Member> aList, int a, int b) {
        // Swaps values of indexs of a given MyList object
        Member tempVal = aList.get(a);
        aList.set(a, aList.get(b));
        aList.set(b, tempVal);
    }
}
