

public class TwoArrayMedian {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length, total = l1+l2;

        double mid=0;

        if (total % 2 == 1) {

            int round = 0;
            for(int i = 0, j=0; round <total/2+1; ) {

                int n1 = (i<nums1.length) ? nums1[i] : Integer.MAX_VALUE;
                int n2 = (j<nums2.length) ? nums2[j] : Integer.MAX_VALUE;

                if(n1<=n2) {
                    round ++;
                    i++;
                    mid = n1;
                }else{
                    round ++;
                    j++;
                    mid = n2;
                }


            }
        } else {
            int m1=0, m2=0;
            int round = 0;
            for(int i = 0, j=0; round <=total/2+1; ) {

                int n1 = (i<nums1.length) ? nums1[i] : Integer.MAX_VALUE;
                int n2 = (j<nums2.length) ? nums2[j] : Integer.MAX_VALUE;

                int s= 0;
                if(n1<=n2) {
                    round ++;
                    i++;
                    s = n1;
                }else{
                    round ++;
                    j++;
                    s = n2;
                }
                if (round == total/2) m1=s;
                if (round == total/2+1) m2=s;



            }
            mid = (m1+m2)/2.0;

        }
        return mid;
    }
}
