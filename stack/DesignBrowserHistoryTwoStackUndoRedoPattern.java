
import java.util.*;

/*
    Problem: Design Browser History

    Pattern: Two Stack Pattern (Undo / Redo)

    Intuition:
    We maintain two stacks:

    1. currHistory:
       Stores the current browsing path.
       The TOP element represents the current webpage.

    2. forwardHistory:
       Stores webpages that we can revisit using the forward operation.

    Think of it like this:

    Homepage -> Google -> YouTube -> GitHub

    currHistory:
    TOP -> GitHub
           YouTube
           Google
           Homepage

    forwardHistory:
    Empty

    When we go BACK:
    - Remove the current page from currHistory.
    - Push that page into forwardHistory.

    When we go FORWARD:
    - Remove the top page from forwardHistory.
    - Push that page into currHistory.

    Important:
    When we VISIT a new URL:
    - Push the new URL into currHistory.
    - Clear the entire forwardHistory.
      Why? Because visiting a new page creates a new browsing path.
*/

public class DesignBrowserHistoryTwoStackUndoRedoPattern {

    class BrowserHistory {

        // Stack 1: Maintains the current browsing history.
        // TOP element = Current webpage.
        Deque<String> currHistory;

        // Stack 2: Maintains pages that can be visited using FORWARD.
        Deque<String> forwardHistory;

        // Constructor: Initializes browser history with homepage.
        public BrowserHistory(String homepage) {

            currHistory = new ArrayDeque<>();
            forwardHistory = new ArrayDeque<>();

            // Initially, homepage is the only page in browsing history.
            currHistory.push(homepage);
        }

        /*
            VISIT OPERATION

            When the user visits a new URL:

            1. Push the new URL into currHistory.
            2. Clear forwardHistory completely.

            Example:

            Before visiting:
            currHistory:   [Google, Homepage]
            forwardHistory: [YouTube, GitHub]

            Visit Amazon:

            currHistory:   [Amazon, Google, Homepage]
            forwardHistory: []

            Previously available forward navigation is lost.
        */

        public void visit(String url) {

            // Push the newly visited URL onto the current history stack.
            currHistory.push(url);

            // A new visit invalidates all previously available forward pages.
            while (!forwardHistory.isEmpty()) {
                forwardHistory.pop();
            }

          // you can do this operation in O(1) by simply doing 
          /*
          forwardHistory = new ArrayDeque<>();
          */
        }

        /*
            BACK OPERATION

            Move backward by at most 'steps' pages.

            Logic:

            1. Check whether we have pages to go back to.
            2. Homepage must always remain in currHistory.
            3. Pop the current page from currHistory.
            4. Push the removed page into forwardHistory.

            Stop when:
            - We have completed all requested steps.
            - Only homepage remains in currHistory.
        */

        public String back(int steps) {

            while (steps > 0) {

                // We need at least 2 pages:
                // One current page and one previous page.
                // If only homepage remains, we cannot go further back.
                if (currHistory.size() > 1) {

                    // Remove the current webpage from current history.
                    String backTab = currHistory.pop();

                    // Store it in forward history so we can revisit it.
                    forwardHistory.push(backTab);

                } else {

                    // Homepage is the first page.
                    // Never remove it from currHistory.
                    break;
                }

                // One backward movement is completed.
                steps--;
            }

            // The TOP of currHistory is now the current webpage.
            return currHistory.peek();
        }

        /*
            FORWARD OPERATION

            Move forward by at most 'steps' pages.

            Logic:

            1. Check whether forwardHistory contains any page.
            2. Pop the next available page from forwardHistory.
            3. Push that page into currHistory.

            Stop when:
            - We have completed all requested steps.
            - forwardHistory becomes empty.
        */

        public String forward(int steps) {

            while (steps > 0) {

                // We can move forward only when forward history is available.
                if (!forwardHistory.isEmpty()) {

                    // Remove the next webpage from forward history.
                    String forwardTab = forwardHistory.pop();

                    // Restore that webpage into current browsing history.
                    currHistory.push(forwardTab);

                } else {

                    // No more forward pages are available.
                    break;
                }

                // One forward movement is completed.
                steps--;
            }

            // Return the current webpage.
            return currHistory.peek();
        }
    }

    public static void main(String[] args) {

        // Create a browser with Google as the homepage.
        DesignBrowserHistoryTwoStackUndoRedoPattern obj =
                new DesignBrowserHistoryTwoStackUndoRedoPattern();

        BrowserHistory browser = obj.new BrowserHistory("google.com");

        // Visit different webpages.
        browser.visit("youtube.com");
        browser.visit("github.com");
        browser.visit("stackoverflow.com");

        // Current page: stackoverflow.com
        System.out.println(browser.back(1));
        // Output: github.com

        System.out.println(browser.back(1));
        // Output: youtube.com

        System.out.println(browser.forward(1));
        // Output: github.com

        // Visiting a new URL clears forward history.
        browser.visit("amazon.com");

        System.out.println(browser.back(2));
        // Output: youtube.com

        System.out.println(browser.forward(2));
        // Output: amazon.com
    }
}
