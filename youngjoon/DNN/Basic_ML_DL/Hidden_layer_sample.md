# Hidden layer sample

### 1채널짜리 바이너리 이미지의 수학적 표현
---

## 📌 수학적 표현

### 1. 행렬 형태

이미지가 \( H \times W \) 크기일 때:

```math
X \in \{0, 1\}^{H \times W}
```

예시 (28×28 이미지):

```math
X =
\begin{bmatrix}
0 & 1 & 0 & \cdots \\
1 & 1 & 0 & \cdots \\
\vdots & \vdots & \vdots & \ddots
\end{bmatrix}
\in \{0, 1\}^{28 \times 28}
```

---

### 2. 벡터화 (Flatten)

['백터화란?'](./Vectorization.md)

모델 입력으로 사용하기 위해 1D 벡터로 변환:

```math
x \in \{0, 1\}^{784} \quad \text{(for a 28×28 image)}
```



---

### 3. 텐서 형태 (딥러닝 입력)

채널 정보를 포함한 텐서 표현:

```math
X \in \{0, 1\}^{1 \times H \times W}
```

배치(batch)를 포함하면:

```math
X \in \{0, 1\}^{B \times 1 \times H \times W}
```

여기서 \( B \)는 배치 크기입니다.

---

## 📌 예시: MNIST 이진화

MNIST 이미지를 바이너리로 변환할 때는 일반적으로 임계값을 기준으로 처리합니다:

```math
X_{i,j} =
\begin{cases}
1, & \text{if } \text{pixel}_{i,j} \geq \text{threshold} \\
0, & \text{otherwise}
\end{cases}
```

---

## 🔁 요약

| 표현 방식    | 수학적 형태                        | 설명                  |
|-------------|-----------------------------------|-----------------------|
| 행렬        | \( \{0, 1\}^{H \times W} \)       | 2D 이미지             |
| 벡터        | \( \{0, 1\}^{H \cdot W} \)        | 모델 입력용 1D 벡터   |
| 텐서        | \( \{0, 1\}^{1 \times H \times W} \) | 채널 포함 입력 형태    |
| 배치 텐서   | \( \{0, 1\}^{B \times 1 \times H \times W} \) | 여러 이미지 입력 처리  |
