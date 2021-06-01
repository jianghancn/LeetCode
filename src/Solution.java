import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int [] numSpace = new int[1000];
        List<StringBuilder> sbs = new ArrayList<>();

        int n = 0;

        StringBuilder sb = new StringBuilder();

        for (String a: words) {
            if(sb.length() == 0) {
                sb.append(a);
            }
            else if(sb.length() + a.length() + 1 <= maxWidth) {
                sb.append(" " + a);
                numSpace[n]++;

            }else {
                sbs.add(sb);
                sb = new StringBuilder();
                sb.append(a);
                n++;
            }

         }

        for(int m = 0; m< sbs.size(); m ++ ) {
            int numSpacesNeed = maxWidth - sb.length();

            int i = 0;

            if(m == sbs.size() -1) {
                StringBuilder sb3 = sbs.get(m);
                while(sb3.length()<maxWidth) {
                    sb3.append(' ');
                }
            }else {
                StringBuilder sb3 = sbs.get(m);

                int from = 1;
                while (sb3.length()<maxWidth) {
                    int len = sb3.length();

                    int spaceIdx = sb.indexOf(" ", from);
                   if(spaceIdx > 0) {
                       sb.insert(spaceIdx, " ");
                   }

                   while(from < sb.length() && sb.charAt(from) == ' ') {
                       from++;
                   }

                   if (from==sb.length()-1) {
                       from=1;
                   }

                }
            }

        }



        return  res;

    }
}