public class SortArrayOfZeroesOnesTwos {

    static void sortArray(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {

            if (arr[mid] == 0) {
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;

                low++;
                mid++;
            }

            else if (arr[mid] == 1) {
                mid++;
            }

            else { // arr[mid] == 2
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;

                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,1,1,0,1,2,1,2,0,0,0};

        sortArray(arr);

        for (int k : arr) {
            System.out.print(k + " ");
        }
    }
}




/*

❌ The real issue (subtle but important)

You wrote:

if(arr[mid]==1) mid++;
if(arr[mid]==2){ ... }
if(arr[mid]==0){ ... }

👉 These are three independent if statements

That means:

After one condition runs, the next if can ALSO run in the same iteration
mid or array value may change → causing wrong behavior
🧠 Why this breaks

Example:

Suppose arr[mid] == 1
You do mid++
Now mid moved → next if(arr[mid]==2) checks a new element in same loop

👉 This is logically incorrect flow

🧠 Your second question:
👉 high >= mid vs mid <= high

They are exactly the same mathematically ✅

mid <= high   ⇔   high >= mid
⚡ Then why do we prefer mid <= high?

Because it matches how we think:

mid is moving forward →
high is moving backward ←

So condition reads naturally:

“Process until mid crosses high”

🧠 Logic coach takeaway

Your mistake is not algorithm — it’s control flow thinking

👉 Rule to remember:

When conditions are mutually exclusive → use else if, not multiple if


// Claude Response
Yes, exactly! You nailed it. 🎯

Here's the one-line mental model to remember forever:

> **`mid` moves before the 2nd and 3rd `if` get a chance to check — so they check the wrong element.**

Think of it like this —

Imagine you're a security guard checking 3 things about a person standing in front of you:
- Is their ID valid?
- Are they on the guest list?
- Do they have a ticket?

With `else if` → you check one thing, find the answer, and **send them through**. Done.

With 3 separate `if`s → you check the first thing, the person **walks away**, and now you're checking the 2nd and 3rd things about a **completely different person** who just walked up. 😅

---

So in your code specifically, the danger moment is:

```
arr[mid] == 0  →  if 1 fires  →  mid++   ← mid now points to NEW element
arr[mid] == 1  →  if 2 fires  ← checking the NEW element, not the original one!
```

The original element at `mid` got processed, but the new element at `mid` also got `mid++` applied to it **without ever being swapped or checked properly** — it just got silently skipped over.

That's it. `else if` just says "once you find the answer, stop checking." Three separate `if`s never stop — they keep going even after the ground has shifted under them.

*/


/*

🧠 1. The Core Problem You Faced

You wrote:

if(arr[mid] == 0) { ... }
if(arr[mid] == 1) { mid++; }
if(arr[mid] == 2) { ... }

Instead of:

if(arr[mid] == 0) { ... }
else if(arr[mid] == 1) { mid++; }
else { ... }

👉 At first glance, both look similar
👉 But behavior is fundamentally different

🔥 2. The Real Issue (NOT syntax)

❌ The problem is NOT Java syntax
✅ The problem is control flow + state mutation

🧠 3. What Actually Goes Wrong
👉 Multiple ifs = independent checks

All conditions are evaluated in the same iteration, even if:

You already changed mid
You already modified the array
⚠️ Key mistake
mid++;   // you changed the variable

Then:

if(arr[mid] == 2)

👉 Now you're checking a different element

💣 This causes:
1. Double-processing
One iteration handles multiple elements
2. Skipping proper handling
Elements are processed too early or incorrectly
3. Breaking ordering
Algorithm invariants get disturbed
🧠 4. ROOT CAUSE (most important insight)

You changed the state, but continued logic as if the state didn’t change

This is called:

⚡ Context switching inside a single iteration

🔁 5. What the Algorithm EXPECTS

Dutch National Flag relies on:

✅ Each iteration processes exactly ONE element at mid

❌ Multiple ifs break this:
process current → move → process next → chaos
✅ else if preserves this:
process current → move → STOP → next iteration
🧠 6. Why else if works
if (...) { ... }
else if (...) { ... }
else { ... }

👉 Once one condition runs:

Others are skipped
No re-check using modified variable
🔥 7. The “Variable Change” Rule
🚨 Golden Rule

If you modify the variable used in conditions,
👉 you MUST use else if

🧠 Why?

Because:

You changed the reality
So checking again in same iteration = invalid logic
⚡ One-line intuition

“I changed the state → I must stop checking”

🧠 8. When to use if vs else if
✅ Use multiple ifs

When:

Conditions are independent
More than one can be true
if (x > 0)
if (x % 2 == 0)

👉 Both can run ✔️

✅ Use if / else if

When:

Conditions are mutually exclusive
Only one should run
OR variable is modified
if (x == 0)
else if (x == 1)
else
🧠 9. Your Final Understanding (refined)

You said:

“multiple conditions → if
one condition → else if”

❌ Slightly incorrect

✅ Correct version:

If multiple can be true → use if
If only one should run OR variable changes → use else if

🔥 10. Why your code still passed LeetCode

👉 Important insight:

❌ Passing tests ≠ Correct logic

Your version:

Worked for given inputs
But is not guaranteed correct
🧠 This is called:

⚠️ Accidentally correct code

🧠 11. Deep Mental Model (most important)
❌ Multiple ifs

“Check → change → check again → check again”

👉 Reality keeps shifting while you're still deciding

✅ else if

“Check → decide → act → STOP”

👉 Stable and predictable

🧠 12. Final Intuition (lock this)
⚡ Rule 1

if if if → check ALL

⚡ Rule 2

if else if → choose ONE

⚡ Rule 3 (most important)

If you change the variable → stop checking → use else if

🎯 13. One-line Master Insight

Multiple ifs cause context switching within one iteration,
while else if enforces single, consistent decision flow

🚀 Where you are now

You moved from:

👉 “Why is this failing?”
to
👉 “I understand control flow + state mutation + algorithm invariants”

That’s a big jump.



It may look logically correct condition-by-condition, but control-flow-wise it becomes inconsistent because the context changes inside the same iteration.

In Dutch Flag:

if (arr[mid] == 1) mid++;
if (arr[mid] == 2) ...

After mid++, arr[mid] means a different element.

So yes:

Multiple ifs can cause context switching inside one decision step.

That is why else if is safer:

Decide once → act once → move to next loop.

*/


/*

🧠 What the pointers mean

We maintain 3 regions in the array:

[ 0 ... low-1 ]      → all 0s ✅
[ low ... mid-1 ]    → all 1s ✅
[ mid ... high ]     → unknown ❓
[ high+1 ... end ]   → all 2s ✅
🔥 Why initialize like this?
low = 0;
mid = 0;
high = arr.length - 1;
✅ 1. low = 0
We want to start placing 0s from the beginning
Initially, no 0s are placed → so start at index 0

👉 “Next position where a 0 should go”

✅ 2. mid = 0
This is our current element pointer
We haven’t processed anything yet

👉 So we start scanning from index 0

✅ 3. high = n - 1
We want to place 2s at the end
So we start from the last index

👉 “Next position where a 2 should go”

🧠 Why not start from somewhere else?

Because initially:

No elements are classified
Entire array is unknown

So:

[ mid ... high ] = full array
🔥 What happens during algorithm
If 0 → swap with low, expand 0-region
If 1 → just move forward
If 2 → swap with high, expand 2-region
🧠 Key idea

You are growing sorted regions from both ends inward

⚡ Visual intuition

Start:

[ ? ? ? ? ? ]
  ↑       ↑
 mid     high
low

End:

[ 0 0 1 1 2 2 ]
🎯 One-line answer

We start with low=0, mid=0, high=n-1 because
initially the entire array is unprocessed,
and we expand sorted regions from both ends.

*/