import java.util.*;

/*
If in question stream of data and window diya hai and with time 
or with movement , kuch elements , added, wo remove honge and new element add
then aise window or stream of data  where poorane gets removed and new gets added 
it is like a queue , so we can use queue to solve this problem

it is starter question for sliding window 

sliding window means a fixed-size window that moves over a dataset, and we need to maintain some information about the elements within this window.
jaga sliding window , -> waha DEQUE , why not queue , see , we have liberty more in Deque  becuase dono end me remove/add kar sakte ho 



Approach

1.Include current timestamp wali request
2. [t-3000,t] -> return count of this rnage , we get from size of queue , there are invalid request jo range me naa ho , remove that invalid req -> keep rest -> they are valid 
what is invalid , those who comes into [t-3000,t]
*/
public class RecentCounterProblem {

    static class RecentCounter{
        Deque<Integer> q ;

        public RecentCounter(){
            q = new ArrayDeque<>();

        }



        public int ping(int t) {
            // record the current timestamp
            q.offer(t); // Add the current timestamp to the queue

            // Remove timestamps that are outside the range [t-3000, t]
            while (!q.isEmpty() && q.peek() < t - 3000) {
                q.poll();
            }

            return q.size(); // Return the count of valid requests in the range
        }

    }

    
    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));     // Output: 1
        System.out.println(recentCounter.ping(100));   // Output: 2
        System.out.println(recentCounter.ping(3001));  // Output: 3
        System.out.println(recentCounter.ping(4000));  // Output: 3
    }
}
