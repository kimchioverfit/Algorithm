# Classification

분류

미리 정해진 Label, classes로 분류하는 작업 

| 분류 종류                       | 설명                                          |
| --------------------------- | ------------------------------------------- |
| **이진 분류** (Binary)          | 두 개의 클래스 (예: 고양이 vs 개)                      |
| **다중 분류** (Multi-class)     | 세 개 이상 클래스 (예: 0\~9 숫자)                     |
| **다중 레이블 분류** (Multi-label) | 여러 클래스에 동시에 속할 수 있음 (예: 이미지가 고양이이면서도 실외 장면) |

---

### 딥러닝 분류 모델 구조

1. **Input Layer**
   예: 이미지, 텍스트, 센서값 등
   <br>

2. **Hidden Layers** (Fully Connected or CNN)
   다양한 비선형 변환을 통해 특징 추출
   ReLU 같은 활성화 함수 사용
   Input layer 와 Output layer 사이의 모든 층.
   [`nn.Linear, nn.Conv2d`](./nnFunction.md), torch.reshape 등 차원축소하는 여러 함수들이 특징 추출 레이어로 사용됨.  
   <br>

3. **Output Layer**
   이진 분류: 뉴런 1개 + Sigmoid 함수
   다중 분류: 클래스 수만큼 뉴런 + Softmax 함수
   <br>

4. **Loss Function (손실함수)**
   이진 분류: Binary Cross Entropy
   다중 분류: Categorical Cross Entropy 또는 Sparse Categorical Cross Entropy
   <br>

5. **Optimizer**
   경사하강법 기반 (SGD, Adam 등)
   <br>