
# 🧠 딥러닝에서 인코더(Encoder)란?

인코더는 딥러닝 모델에서 **입력 데이터를 의미 있는 잠재 표현(latent representation)으로 압축**하는 부분을 말합니다.  
보통 여러 개의 **히든 레이어(hidden layers)**로 구성되어 있으며, 입력의 특징을 추출하고 요약하는 역할을 합니다.

---

## ✅ 인코더의 위치 및 역할

```text
[Input] → [Encoder] → [Latent vector z] → [Decoder] → [Output]
```

- **입력(Input)**: 원시 데이터 (이미지, 텍스트, 음성 등)
- **인코더(Encoder)**: 입력을 의미 있는 벡터 z로 변환
- **잠재 벡터 z**: 입력의 핵심 정보만 담긴 압축 표현
- [디코더(Decoder)](./Decoder.md): 벡터 z로부터 출력 복원 또는 생성

---

## 📦 예시: Autoencoder

```text
[784차원 이미지 벡터]
    ↓
[Linear → ReLU]       ← 인코더 hidden layer
    ↓
[Linear → ReLU]       ← 인코더 hidden layer
    ↓
[Latent vector z]      ← 인코더 출력
```

수학적으로:

\[
z = f_{\text{enc}}(x) = \sigma(W_e x + b_e)
\]

---

## 🧱 인코더 내부 구성 요소

| 구성 요소         | 설명                                       |
|------------------|--------------------------------------------|
| Linear Layer     | 입력과 가중치 행렬의 선형 결합               |
| Activation       | 비선형성 추가 (ReLU, GELU, tanh 등)         |
| Dropout / Norm   | 정규화 및 과적합 방지                       |
| Convolution (CNN)| 공간적 특징 추출 (이미지에서 주로 사용)     |
| Attention (NLP)  | 입력 간 관계성 파악 (Transformer 기반)      |

---

## 🧠 인코더 vs 일반 히든 레이어

- 인코더는 일반적인 히든 레이어를 포함하는 **“기능 단위의 블록”**
- 보통 **모델의 앞단에 위치**하며 입력을 처리

---

## 🧠 PyTorch 예시 코드

```python
import torch.nn as nn

class Encoder(nn.Module):
    def __init__(self):
        super().__init__()
        self.layers = nn.Sequential(
            nn.Linear(784, 256),
            nn.ReLU(),
            nn.Linear(256, 64),
            nn.ReLU()
        )

    def forward(self, x):
        return self.layers(x)  # latent vector z
```

---

## 🔚 요약

| 항목         | 설명                                            |
|--------------|-------------------------------------------------|
| 목적         | 입력을 잠재 벡터로 압축                         |
| 내부 구성    | 여러 히든 레이어로 이루어진 블록                 |
| 사용 위치    | 입력층과 출력층 사이, 보통 디코더 이전           |
| 활용 분야    | Autoencoder, Machine Translation, BERT, U-Net 등 |

