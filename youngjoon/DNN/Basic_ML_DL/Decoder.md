s
# 🧠 딥러닝에서 디코더(Decoder)란?

디코더는 딥러닝 모델에서 **잠재 벡터(latent vector)**를 받아서, 이를 기반으로 **원하는 출력 형태로 복원 또는 변환**하는 부분입니다.  
인코더가 입력을 요약하는 역할이라면, 디코더는 **그 요약된 정보를 풀어내는 역할**을 합니다.

---

## ✅ 디코더의 위치 및 역할

```text
[Input] → [Encoder] → [Latent vector z] → [Decoder] → [Output]
```

- **입력(Input)**: 원시 데이터 (이미지, 텍스트 등)
- **인코더(Encoder)**: 입력을 잠재 벡터 z로 변환
- **디코더(Decoder)**: z로부터 출력 생성
- **출력(Output)**: 예측된 결과 (복원 이미지, 번역된 문장 등)

---

## 📦 예시: Autoencoder

```text
[Latent vector z]
    ↓
[Linear → ReLU]       ← 디코더 hidden layer
    ↓
[Linear → Sigmoid]    ← 디코더 출력
    ↓
[784차원 복원된 이미지 벡터]
```

수학적으로:

\[
\hat{x} = f_{\text{dec}}(z) = \sigma(W_d z + b_d)
\]

---

## 🧱 디코더 내부 구성 요소

| 구성 요소         | 설명                                        |
|------------------|---------------------------------------------|
| Linear Layer     | z를 출력 공간으로 맵핑                       |
| Activation       | 출력 형태에 맞는 활성화 함수 사용             |
| Upsampling       | 이미지 복원 시, 해상도 확장에 사용            |
| ConvTranspose    | 이미지 업샘플링에 사용되는 역컨볼루션        |
| Attention (NLP)  | 문맥을 반영하며 출력 생성 (Transformer 디코더)|

---

## 🧠 디코더 vs 일반 히든 레이어

- 디코더는 **히든 레이어 집합이지만 "출력 생성을 위한 역할"에 집중된 블록**
- 인코더의 반대 방향 흐름을 가짐

---

## 🧠 PyTorch 예시 코드

```python
import torch.nn as nn

class Decoder(nn.Module):
    def __init__(self):
        super().__init__()
        self.layers = nn.Sequential(
            nn.Linear(64, 256),
            nn.ReLU(),
            nn.Linear(256, 784),
            nn.Sigmoid()
        )

    def forward(self, z):
        return self.layers(z)  # output reconstruction
```

---

## 🔚 요약

| 항목         | 설명                                             |
|--------------|--------------------------------------------------|
| 목적         | 잠재 벡터로부터 출력 생성                        |
| 내부 구성    | 여러 히든 레이어로 구성된 출력 생성용 블록        |
| 사용 위치    | 인코더 다음, 출력 직전                            |
| 활용 분야    | Autoencoder, 번역기(Seq2Seq), U-Net, GPT 등       |
