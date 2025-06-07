# 🔷 대각 행렬 (Diagonal Matrix)

## ✅ 정의

대각 행렬은 **주대각선**(main diagonal, 왼쪽 위에서 오른쪽 아래 방향)에 있는 원소를 제외한 나머지 원소가 모두 0인 **정방행렬**입니다.

즉, 행렬 \( D = [d_{ij}] \) 가 다음 조건을 만족할 때:

$$
d_{ij} = 0 \quad \text{(for all } i \neq j \text{)}
$$

그 행렬은 대각 행렬입니다.

---

## 🧮 예시

다음은 \( 3 \times 3 \) 대각 행렬의 예입니다:

$$
D =
\begin{bmatrix}
5 & 0 & 0 \\
0 & -3 & 0 \\
0 & 0 & 2
\end{bmatrix}
$$

- 주대각선 원소는: 5, -3, 2
- 나머지 원소는 모두 0

---

## 🔢 일반 형태

\( n \times n \) 대각 행렬은 다음과 같이 나타낼 수 있습니다:

$$
D =
\begin{bmatrix}
d_1 & 0 & \cdots & 0 \\
0 & d_2 & \cdots & 0 \\
\vdots & \vdots & \ddots & \vdots \\
0 & 0 & \cdots & d_n
\end{bmatrix}
$$

---

## 📌 성질

1. **전치행렬**: \( D^T = D \) → 대각 행렬은 항상 대칭행렬이다.
2. **곱셈 간단**: \( D\vec{x} \)는 각 성분에 대각 원소를 곱하는 것과 같다.
3. **역행렬 존재 조건**: 모든 \( d_i \neq 0 \)이면 역행렬 존재, 역행렬도 대각 행렬이다.
4. **행렬식**: \( \det(D) = d_1 \cdot d_2 \cdots d_n \)

---

## ✳️ 특수한 대각 행렬

- **영행렬 (Zero Matrix)**: 모든 대각 원소도 0일 때
- **항등행렬 (Identity Matrix)**: 모든 대각 원소가 1일 때

$$
I =
\begin{bmatrix}
1 & 0 & \cdots & 0 \\
0 & 1 & \cdots & 0 \\
\vdots & \vdots & \ddots & \vdots \\
0 & 0 & \cdots & 1
\end{bmatrix}
$$

---

## 🧠 응용 예

- 고유값 분해 (Eigenvalue Decomposition): \( A = PDP^{-1} \) 형태에서 \( D \)는 대각 행렬
- 행렬의 거듭제곱 계산 시 매우 효율적
- 스케일 변환(Scaling) 등에 사용

