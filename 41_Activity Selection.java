class Solution
{
   static class Meeting implements Comparable<Meeting> {
       private int start,end;
       
       Meeting(int start,int end) {
           this.start = start;
           this.end = end;
       }
       
       public int getStart() {
           return this.start;
       }
       
       public int getEnd() {
           return this.end;
       }
       
       public int compareTo(Meeting other) {
           return this.end - other.end;
       }
   }
   
   public static int activitySelection(int start[], int end[], int n)
   {
       // add your code here
       List<Meeting> list = new ArrayList<>();
       for (int i = 0; i < end.length; i++) {
           list.add(new Meeting(start[i],end[i]));
       }
       Collections.sort(list);
       
       int count = 0;
       int prevStart = -1;
       int prevEnd = -1;
       
       for (Meeting m : list) {
           int e = m.getEnd();
           int s = m.getStart();
           if (prevStart < 0 && prevEnd < 0) {
               count++;
               prevStart = s;
               prevEnd = e;
           }
           else if (s > prevEnd) {
               count++;
               prevStart = s;
               prevEnd = e;
           }
       }
       return count;
   }
}