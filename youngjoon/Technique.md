
# 알고리즘 정리 노트

---

## 📌 문자열 (String)

### ✅ 체크 포인트
- [ ] ASCII인지 UNICODE인지 확인 (보통 ASCII 기준 문제 출제)
- [ ] 대소문자 처리 고려 (예: `'A'` vs `'a'`)
- [ ] 공백, 탭 등 공백 문자 처리 여부 확인

### 💡 팁
- **뒤에서부터 처리 (backward)** 방식이 유리한 경우가 있음

---

## 📌 행렬 (Matrix)

### 💡 기술적 팁
1. **Transpose** 또는 **Reverse** 활용
2. 같은 행이나 열을 반복 접근할 경우, **flag 배열 또는 원소로 표시하여** 반복 연산을 줄이기

### ✅ 예제: 행/열에 0이 있는 경우 해당 행/열 전체를 0으로 만들기

```cpp
void setZeroes(std::vector<std::vector<int>>& matrix) {
    int rows = matrix.size(), cols = matrix[0].size();
    bool firstRowZero = false, firstColZero = false;

    for (int j = 0; j < cols; ++j)
        if (matrix[0][j] == 0) firstRowZero = true;

    for (int i = 0; i < rows; ++i)
        if (matrix[i][0] == 0) firstColZero = true;

    for (int i = 1; i < rows; ++i)
        for (int j = 1; j < cols; ++j)
            if (matrix[i][j] == 0)
                matrix[i][0] = matrix[0][j] = 0;

    for (int i = 1; i < rows; ++i)
        if (matrix[i][0] == 0)
            for (int j = 1; j < cols; ++j)
                matrix[i][j] = 0;

    for (int j = 1; j < cols; ++j)
        if (matrix[0][j] == 0)
            for (int i = 1; i < rows; ++i)
                matrix[i][j] = 0;

    if (firstRowZero)
        for (int j = 0; j < cols; ++j) matrix[0][j] = 0;

    if (firstColZero)
        for (int i = 0; i < rows; ++i) matrix[i][0] = 0;
}
```

---

## 📌 불리언 및 비트 벡터 (Bool / Bit Vector)

### ✅ 팁
- `bool`은 1바이트 = 8비트 사용 → 공간 비효율적
- **비트 벡터 (bit vector)** 사용 시 메모리 8배 절약 가능

---

## 📌 순열 (Permutation)

### 💡 팁
- 두 문자열이 순열 관계인지 확인하려면:
  - `sort()` 후 비교
  - `unordered_map`으로 문자 빈도 수 비교

---

## 📌 회문 (Palindrome)

### 🕐 시간 복잡도
- 최소 O(N): 전체 문자 확인이 필요

### ✅ 해법 1: 해시맵 이용

```cpp
bool isPalindromeMap(const std::string& s) {
    std::unordered_map<char, int> freq;
    for (char c : s) {
        if (std::isalpha(c)) freq[std::tolower(c)]++;
    }
    int oddCount = 0;
    for (const auto& p : freq) {
        if (p.second % 2 != 0) oddCount++;
        if (oddCount > 1) return false;
    }
    return true;
}
```


### ✅ 해법 2: 비트 벡터 이용 (공간 최적화)

```cpp
bool isPalindromePermutation(const std::string& s) {
    int bitVector = 0;
    for (char c : s) {
        if (std::isalpha(c)) {
            int index = std::tolower(c) - 'a';
            bitVector ^= (1 << index);  // 해당 비트를 XOR 연산으로 토글
        }
    }
    return bitVector == 0 || (bitVector & (bitVector - 1)) == 0;
}
```

#### 🔍 설명

- **bitVector는 int형(32bit)으로 충분**합니다. 알파벳은 소문자 기준 26자이므로 32비트 내에 모두 저장 가능합니다.
- **초기 상태**는 `00000000 00000000 00000000 00000000`입니다.
- 예를 들어 문자열에 `'b'`가 있다면:
  - `'b' - 'a' = 1` → `1 << 1 = 0b10` → `bitVector ^= 0b10`로 해당 비트를 1로 설정
- 동일한 문자가 다시 등장하면 XOR로 해당 비트가 다시 꺼집니다 (즉, 짝수 번 등장하면 0).
- 결국 **bitVector가 0**이면 모든 문자가 짝수 번 등장한 것입니다.
- 하지만 문자열 길이가 홀수이면 **1개의 문자는 홀수번 등장**해도 회문 가능 → 이때는 `bitVector`에 **1개의 비트만 켜져 있어야 함**.
  - 이를 판별하는 조건이 `bitVector & (bitVector - 1) == 0`입니다. (1비트만 켜져 있으면 참)
  - 이게 어렵다면: 문자열 길이가 홀수면 `bitVector == 1`, 짝수면 `bitVector == 0`을 각각 확인해도 됩니다.
- **시간 복잡도**는 `O(N)`입니다.


```cpp
bool isPalindromePermutation(const std::string& s) {
    int bitVector = 0;
    for (char c : s) {
        if (std::isalpha(c)) {
            int index = std::tolower(c) - 'a';
            bitVector ^= (1 << index);
        }
    }
    return bitVector == 0 || (bitVector & (bitVector - 1)) == 0;
}
```

- 짝수 길이 → 모든 비트가 0
- 홀수 길이 → 하나의 비트만 1일 수 있음
- 시간 복잡도: O(N)

---

## ✅ TODO로 관리할 만한 체크리스트

- [ ] ASCII / UNICODE 여부 확인
- [ ] 대소문자 무시 여부 확인
- [ ] 공백, 탭 등 필터링 필요 여부 확인
- [ ] 반복 접근 시 비트 또는 행/열 플래그 사용 고려
- [ ] 회문 여부 판단 시 비트 벡터 활용

---
