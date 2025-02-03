

# String

Ask about...
1. `ASCII` or `UNICODE`. (Normaly use ASCII)
2. Upper/lower case handling.
3. Space or tab handling.

Technique
1. Solving the problem `backward`. 
 

# Matrix

Technique
1. Transpose / Reverse ...
2. If you have to approach many time for each element, consider using flag with other row or column. This technique reduce time complexity.
 
example below

```cpp
// In MxN Matrix, if one element is 0, then change every value to 0 in same row and column.
#include <iostream>
#include <vector>

void setZeroes(std::vector<std::vector<int>>& matrix) {
    int rows = matrix.size();
    int cols = matrix[0].size();

    bool firstRowZero = false;
    bool firstColZero = false;

    for (int j = 0; j < cols; ++j) {
        if (matrix[0][j] == 0) {
            firstRowZero = true;
            break;
        }
    }

    for (int i = 0; i < rows; ++i) {
        if (matrix[i][0] == 0) {
            firstColZero = true;
            break;
        }
    }

    for (int i = 1; i < rows; ++i) {
        for (int j = 1; j < cols; ++j) {
            if (matrix[i][j] == 0) {
                matrix[i][0] = 0;
                matrix[0][j] = 0;
            }
        }
    }

    for (int i = 1; i < rows; ++i) {
        if (matrix[i][0] == 0) {
            for (int j = 1; j < cols; ++j) {
                matrix[i][j] = 0;
            }
        }
    }

    for (int j = 1; j < cols; ++j) {
        if (matrix[0][j] == 0) {
            for (int i = 1; i < rows; ++i) {
                matrix[i][j] = 0;
            }
        }
    }

    if (firstRowZero) {
        for (int j = 0; j < cols; ++j) {
            matrix[0][j] = 0;
        }
    }

    if (firstColZero) {
        for (int i = 0; i < rows; ++i) {
            matrix[i][0] = 0;
        }
    }
}
```




# Bool
1. Use `bit vector` for redue space complexity.
   - If you use `bool` instead of bit vector, the bool use 1byte(8bit), so it's space complexity is 8times more than bit vector. 
2. 




### Permutation
If num1 and num2 have relationship with permutation....
1. sort() will help. 
2. count element's frequency.


### Palindrome

Every algorithm's minimum time complexity that solving palindrome is O(N) because we should contact every single element. 

Technique
1. Hash table 
   - Count each element's frequency.
     - After loop, if one element's count is odd, then it's not palindrome.
     - Time complexity : O(N)

2. If the problem is determination problem, <u>check the count number same time</u> when approach element whether it's odd or not. 
   
   -  If you doing like this, you can get palindrome determination ASAP when for loop is done.
  
3. **`Bit vector`** (In case of string)

```cpp
bool isPalindromePermutation(const std::string& s) {
    int bitVector = 0;
    for (char c : s) {
        if (std::isalpha(c)) { // Alpahbet to bit vector
            int index = std::tolower(c) - 'a';
            bitVector ^= (1 << index); // Bit toggle with XOR 
        }
    }
    //If 
    return bitVector == 0 || (bitVector & (bitVector - 1)) == 0;
}
```

   - bitVector is int because alphabet is only 26, so don't have to expand if string is ascii.
   - First bitVector is `00000000 00000000 00000000 00000000` (in case of 32 bits env), then if for loop find 'b', then bitVector is now `00000000 00000000 00000000 00000010` because tolower('b') - 'a'  = 1. 
   - After all, if bitVector have '1', then it's not palindrome.
   - But, If input s is odd size, one '1' exist.
   - So, this (bitVector & (bitVector - 1)) will work in that case. (if this condition make you confuse, then just split case with s.size() is odd or even. if s.size() is odd, then check bitVector ==1.)
   - Time complexity **`O(N)`** 


