# ✅ Classification(분류) 문제

미리 정해진 Label, classes로 분류하는 작업 

| 분류 종류 | 설명 | Function |
| ---- |----|----|
| **이진 분류** (Binary) | 두 개의 클래스 (예: 고양이 vs 개) | [**`BCE`**](../Loss_Functions/1.BCE.md) (Log loss) |
| **다중 분류** (Multi-class) | 세 개 이상 클래스 (예: 0\~9 숫자) | **CCE** (Categorical Cross Entropy) |
| **다중 레이블 분류** (Multi-label) | 여러 클래스에 동시에 속할 수 있음 (예: 이미지가 고양이이면서도 실외 장면) |[**`BCE`**](../Loss_Functions/1.BCE.md) (For each label)|

---

