
# 🔄 가우스 소거법 (Gaussian Elimination)

다음 연립방정식을 가우스 소거법으로 풉니다:

$$
\begin{aligned}
2x + 3y &= 8 \\
4x - y &= 2
\end{aligned}
$$

### ① 첨가행렬로 표현

$$
\left[
\begin{array}{cc|c}
2 & 3 & 8 \\
4 & -1 & 2
\end{array}
\right]
$$

---

### ② 첫 번째 행의 첫 원소를 1로 만들기 (행 전체를 2로 나눔)

$$
R_1 \div 2 \Rightarrow
\left[
\begin{array}{cc|c}
1 & 1.5 & 4 \\
4 & -1 & 2
\end{array}
\right]
$$

---

### ③ 두 번째 행에서 첫 번째 행의 4배를 빼서 \( x \) 항 제거

$$
R_2 \leftarrow R_2 - 4 \cdot R_1 \Rightarrow
\left[
\begin{array}{cc|c}
1 & 1.5 & 4 \\
0 & -7 & -14
\end{array}
\right]
$$

---

### ④ 두 번째 행의 두 번째 원소를 1로 만들기

$$
R_2 \div (-7) \Rightarrow
\left[
\begin{array}{cc|c}
1 & 1.5 & 4 \\
0 & 1 & 2
\end{array}
\right]
$$

---

### ⑤ 첫 번째 행에서 두 번째 행의 1.5배를 빼서 \( y \) 제거

$$
R_1 \leftarrow R_1 - 1.5 \cdot R_2 \Rightarrow
\left[
\begin{array}{cc|c}
1 & 0 & 1 \\
0 & 1 & 2
\end{array}
\right]
$$

---

### ✅ 최종 결과

- \( x = 1 \)
- \( y = 2 \)

따라서 해는 \( \boxed{(x, y) = (1, 2)} \) 입니다.
