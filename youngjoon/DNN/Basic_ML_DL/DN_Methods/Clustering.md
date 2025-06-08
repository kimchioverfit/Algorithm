
# 딥러닝에서의 클러스터링 (Clustering in Deep Learning)

클러스터링은 데이터를 유사한 속성을 가진 그룹으로 나누는 비지도 학습(Unsupervised Learning) 기법 중 하나입니다. 딥러닝에서 클러스터링은 고차원의 복잡한 데이터(이미지, 텍스트 등)를 의미 있는 군집으로 나누는 데에 활용됩니다.

---

## 1. 클러스터링의 기본 개념

- **정의**: 데이터를 사전에 정의된 레이블 없이 비슷한 특성을 가진 그룹으로 나누는 과정
- **목적**: 데이터의 구조적 특성 파악, 패턴 탐색, 사전 정보 없는 데이터 분류 등
- **대표 알고리즘**:
  - K-means
  - DBSCAN
  - Gaussian Mixture Models (GMM)

---

## 2. 딥러닝과 클러스터링의 결합

### 2.1 이유
- 고차원 데이터에서 직접 클러스터링을 수행하기엔 차원의 저주(Curse of Dimensionality) 문제가 있음
- 딥러닝은 비선형적인 특징을 잘 표현할 수 있으므로, 특성 공간(feature space)을 효과적으로 학습 가능

### 2.2 대표 접근 방식
- **Feature Embedding + Clustering**:
  - 예: CNN + K-means, Autoencoder + GMM
  - 학습된 feature를 low-dimensional space에 투영 후 클러스터링 수행

- **Joint Clustering & Representation Learning**:
  - 특징 추출과 클러스터링을 동시에 학습하는 방식
  - 예: DEC (Deep Embedded Clustering), IDEC, DDC

---

## 3. 주요 기법 설명

### 3.1 Autoencoder 기반 클러스터링
- 입력 데이터를 저차원 공간으로 인코딩한 후 복원
- 인코더의 출력(latent space)을 클러스터링에 사용

```python
class AutoEncoder(nn.Module):
    def __init__(self):
        super().__init__()
        self.encoder = nn.Sequential(
            nn.Linear(784, 128), nn.ReLU(),
            nn.Linear(128, 10)
        )
        self.decoder = nn.Sequential(
            nn.Linear(10, 128), nn.ReLU(),
            nn.Linear(128, 784), nn.Sigmoid()
        )

    def forward(self, x):
        z = self.encoder(x)
        return self.decoder(z), z
```

### 3.2 DEC (Deep Embedded Clustering)
- 학습된 latent vector를 클러스터링에 사용하고, 클러스터 중심과의 유사도를 기반으로 학습
- Kullback-Leibler divergence를 통해 클러스터 중심 업데이트

---

## 4. 활용 사례

- **이미지 분류 전처리**: 라벨 없는 이미지 데이터 셋을 군집화해 라벨링 비용 절감
- **텍스트 토픽 모델링**: 유사한 의미를 가지는 문장/문서를 클러스터링하여 주제 파악
- **이상 탐지**: 정상 그룹과 거리가 먼 클러스터를 이상치로 판단

---

## 5. 클러스터링 성능 평가

- **내부 지표**:
  - Silhouette Score
  - Calinski-Harabasz Index
  - Davies–Bouldin Index

- **외부 지표** (라벨 존재 시):
  - Adjusted Rand Index (ARI)
  - Normalized Mutual Information (NMI)

---

## 6. 참고 문헌

- Xie, J., Girshick, R., & Farhadi, A. (2016). Unsupervised deep embedding for clustering analysis. *ICML*.
- Guo, X., Liu, X., Zhu, E., & Yin, J. (2017). Improved Deep Embedded Clustering with Local Structure Preservation. *IJCAI*

---

## ✅ 요약
딥러닝 기반 클러스터링은 단순한 K-means보다 훨씬 더 유연하고 강력한 구조를 가지며, 고차원 데이터의 의미 있는 군집화를 가능하게 해줍니다. 특히 autoencoder와 결합하거나 joint learning 방식으로 클러스터링을 학습하는 것이 효과적입니다.
