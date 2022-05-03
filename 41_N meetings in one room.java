class Pair{
        int start;
        int end;
        
        Pair(int start,int end){
            this.start = start;
            this.end = end;
        }
    }
class Solution 
{
    public static int maxMeetings(int start[], int end[], int n)
    {
        //add 1st meeting to our answer
        int count = 1;
        
        Pair arr[] = new Pair[n];
        //convert start[] and end[] arr to pairs
        for(int i = 0 ;i<n;i++){
            arr[i] = new Pair(start[i],end[i]);
        }
        
        //sort pairs according to the end time;
        Arrays.sort(arr,new Comparator<Pair>(){
            public int compare(Pair p1,Pair p2){
                return p1.end-p2.end;
            }
        });
        
        int recentEnded = arr[0].end;
        
        //if start of current meeting is greater than recentEnded meeting then only add it to our answer
        for(int i= 1; i<n ;i++){
            if(arr[i].start>recentEnded){
                count++;
                recentEnded = arr[i].end;
            }
        }
        
        return count;
    }
}