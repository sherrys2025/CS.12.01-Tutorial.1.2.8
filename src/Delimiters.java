import java.util.ArrayList;

public class Delimiters {
    private String openDel;
    private String closeDel;

    public Delimiters(String open, String close) {
        openDel = open; closeDel = close;
    }

    public ArrayList<String> getDelimitersList(String[] token)
    {
        ArrayList<String> delimiters = new ArrayList<>();
        for (String str: token) {
            if (str.equals(openDel) || str.equals(closeDel)) {
                delimiters.add(str);
            }
        }
        return delimiters;
    }
    public boolean isBalanced(ArrayList<String> delimiters) {
        int close = 0;
        while (!delimiters.isEmpty()) {
            String top = delimiters.get(delimiters.size() - 1);
            delimiters.remove(delimiters.size() - 1);
            if (top.equals(closeDel)) {
                close++;
            }
            if (top.equals(openDel)) {
                close--;
                if (close < 0) {
                    return false;
                }
            }
        }
        return close == 0;
    }

    public String getCloseDel() {
        return closeDel;
    }

    public String getOpenDel() {
        return openDel;
    }
}
