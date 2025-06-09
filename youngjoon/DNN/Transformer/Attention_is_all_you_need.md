# Attention is all you need (Transformer)

트랜스포머 구조가 처음 등장한 논문

### 1. 목표

RNN이나 CNN 없이, 오직 어텐션 메커니즘만으로 시퀀스-투-시퀀스(seq2seq) 문제 해결하기.
번역(translation), 요약(summarization), 질의응답 등 다양한 NLP 작업에 적용 가능.

---

### 2. 기존 접근법의 문제점

| 방식         | 문제점                                                 |
| ---------- | --------------------------------------------------- |
| RNN / LSTM | 순차 처리로 인해 병렬화 어려움, 긴 문장 기억 어려움 (vanishing gradient) |
| CNN        | 병렬화는 가능하나, 문맥을 장기적으로 파악하기 어려움                       |

---

### 3. 핵심 아이디어: 트랜스포머 (Transformer)

🔥 "시퀀스 모델링은 오직 Attention만으로도 충분하다!"

Self-Attention을 사용해 입력의 모든 토큰 간 관계를 계산함.

병렬 처리가 가능하므로, 학습 속도가 빠르고 문맥 파악이 뛰어남.

['트랜스포머의 병렬 처리 구조']()

---

### 4. 트랜스포머 구조

[입력 임베딩 + 위치 임베딩] → 인코더 × N → 디코더 × N → 출력

인코더(Encoder): 입력 시퀀스를 처리하여 문맥 정보를 압축함

디코더(Decoder): 인코더 정보를 바탕으로 출력 시퀀스를 생성

---

### 5. 핵심 구성 요소
✅ Self-Attention
- 입력 시퀀스 내의 각 단어가 **다른 모든 단어들과의 관계(중요도)**를 계산
- 관계를 계산하는 방식:

$\text{Attention}(Q, K, V) = \text{softmax}\left( \frac{QK^\top}{\sqrt{d_k}} \right)V$

- Q, K, V: Query, Key, Value 행렬 (입력에서 선형 변환을 통해 얻음)

✅ Multi-Head Attention
- 여러 개의 Self-Attention을 병렬적으로 수행하여 다양한 관계 학습

✅ Positional Encoding
- 순서 정보를 보존하기 위해, 입력 벡터에 사인/코사인 기반 위치 인코딩 추가

✅ Feed Forward Network
- 각 토큰별로 독립적으로 처리되는 두 층짜리 완전연결 신경망

✅ Layer Normalization + Residual Connection
- 학습 안정성과 성능 향상을 위해 적용

