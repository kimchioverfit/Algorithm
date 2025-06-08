# ✅  Hidden layer


## 🔷 1. 히든 레이어란?

### <u>딥러닝의 가장 핵심적인 부분</u>

**입력층(Input Layer)** 과 **출력층(Output Layer)** 사이

모델의 학습 가능한 파라미터가 대부분 존재하는 곳

여러개의 히든레이어로 ['인코더(Encoder)'](./Encoder.md)를 구성 가능

---
## 🔷 2. 수학적 구조

하나의 히든 레이어는 아래와 같은 **선형변환 + 비선형변환**으로 구성된다:

\[
\mathbf{z} = \mathbf{W} \cdot \mathbf{x} + \mathbf{b}
\]
\[
\mathbf{h} = f(\mathbf{z})
\]

- \(\mathbf{x}\): 입력 벡터
- \(\mathbf{W}\): 가중치 행렬 (학습 대상)
- \(\mathbf{b}\): 바이어스 벡터
- \(f(\cdot)\): 활성화 함수 (ReLU, Sigmoid, Tanh 등)
- \(\mathbf{h}\): 히든 레이어의 출력


### 입력 벡터 예시 

```math
x = 
\begin{bmatrix}
x_1 \\
x_2 \\
\vdots \\
x_n
\end{bmatrix}
\in \mathbb{R}^{n}
```

### 가중치 행렬 예시

```math
W =
\begin{bmatrix}
w_{11} & w_{12} & \cdots & w_{1n} \\
w_{21} & w_{22} & \cdots & w_{2n} \\
\vdots & \vdots & \ddots & \vdots \\
w_{m1} & w_{m2} & \cdots & w_{mn}
\end{bmatrix}
\in \mathbb{R}^{m \times n}
```

### 선형변환 계산식

```math
z = Wx + b =
\begin{bmatrix}
w_{11}x_1 + w_{12}x_2 + \cdots + w_{1n}x_n + b_1 \\
w_{21}x_1 + w_{22}x_2 + \cdots + w_{2n}x_n + b_2 \\
\vdots \\
w_{m1}x_1 + w_{m2}x_2 + \cdots + w_{mn}x_n + b_m
\end{bmatrix}
```

## 출력 벡터의 각 원소 표현

```math
z_i = \sum_{j=1}^{n} w_{ij} x_j + b_i \quad \text{for } i = 1, 2, \dots, m
```

이 식은 하나의 출력 뉴런 \( z_i \)가 모든 입력 \( x_j \)와 연결되어  
**가중합 (weighted sum)** 을 수행한 뒤, 편향 \( b_i \)가 더해지는 구조임을 보여줍니다.

즉, 입력 벡터 공간 \( \mathbb{R}^n \)이  
가중치 행렬 \( W \in \mathbb{R}^{m \times n} \)를 통해  
출력 벡터 공간 \( \mathbb{R}^m \)으로 **사상(mapping)** 되는  
**선형변환(linear transformation)** 입니다.


['이론적 예시 링크'](./Hidden_layer_sample.md) 

---

## 🔷 3. 왜 선형 + 비선형인가?

### ✅ 선형변환만 쓰면?

\[
f(x) = W_2(W_1x) = W'x
\]

- 층을 여러 개 쌓아도 결국 **선형 모델**이 되어 복잡한 패턴 학습 불가능

### ✅ 비선형 함수 추가 시

\[
f(x) = W_2 \cdot \text{None Linear Function}(W_1 x + b_1) + b_2
\]

None Linear Function : sigmoid, softmax, ReLU 등등...
(비선형 함수는 딥러닝에서는 활성함수로도 불린다.)
- 비선형 함수로 인해 **비선형 함수 근사 가능**
- **Universal Approximation Theorem**: 충분한 히든 노드와 비선형함수가 있다면, 어떤 함수도 근사 가능

---

## 🔷 4. 딥러닝 모델에서의 역할

| 구성 요소         | 역할                                 |
|------------------|--------------------------------------|
| Input Layer       | 원본 데이터를 모델에 전달              |
| Hidden Layer(s)   | 입력의 특성 추출 및 고차원 표현 학습  |
| Output Layer      | 최종 예측값 출력                     |

> 히든 레이어는 **모델의 두뇌**이며, 학습된 가중치가 실제 모델의 "지식"을 구성한다.

---

## 🔷 5. 히든 레이어가 많아지면?

- **깊은 신경망 (Deep Neural Network)** 은 히든 레이어가 여러 층인 구조
- 각 층이 점점 더 **추상적이고 고수준의 특징(feature)** 을 추출
- 하지만 다음과 같은 문제 발생 가능:
  - **과적합(overfitting)** 위험 증가
  - **기울기 소실/폭주** 문제
  - **연산량 증가** 및 학습 속도 저하
---

## 🔷 8. 시각적 흐름

Input → [Linear] → [ReLU] → [Linear] → [ReLU] → ... → Output

선형 변환을 한 뒤, ReLU를 통해서 비선형성 부여. 

ReLU의 구체적 원리에 대한 이해를 위해서는 선형대수가 기본이 되어야.

---