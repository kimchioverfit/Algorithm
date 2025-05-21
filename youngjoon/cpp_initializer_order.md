
# C++ 멤버 초기화 순서와 이니셜라이저 리스트

## 문제 개요

다음과 같이 이니셜라이저 리스트에서 멤버 `diameter_range`를 먼저 초기화하고,
그 뒤에 `filterPointsByDiameter` 함수에서 사용했는데도 `diameter_range` 값이 빈 상태로 전달되는 문제가 발생했다:

```cpp
PartitionedPointSample::PartitionedPointSample(std::tuple<Centers, ROI>& inferenceResults)
    : diameter_range{28, 100},
      filtered_points(filterPointsByDiameter(inferenceResults, diameter_range)),
      regions_matrix(defineRegions()) {}
```

## 핵심 원인 🔥

C++에서는 생성자 이니셜라이저 리스트에서의 순서와 무관하게, **멤버 초기화 순서는 클래스에 선언된 순서대로** 진행된다.

```cpp
class PartitionedPointSample {
private:
    std::tuple<Centers, ROI> filtered_points;         // 먼저 초기화됨
    std::vector<std::vector<cv::Rect>> regions_matrix;
    std::vector<std::tuple<cv::Point2f, float, char>> final_points;
    std::vector<unsigned int> diameter_range;         // 나중에 초기화됨
};
```

이 경우, `diameter_range`는 `filtered_points`보다 **나중에 초기화되기 때문에**,  
`filtered_points` 초기화 시점에서 `diameter_range`는 비어 있는 상태이다.

## 해결 방법 ✅

멤버 선언 순서를 바꿔서 `diameter_range`를 먼저 초기화되도록 해야 한다:

```cpp
class PartitionedPointSample {
private:
    std::vector<unsigned int> diameter_range;         // 먼저 선언
    std::tuple<Centers, ROI> filtered_points;         // 나중 선언
    ...
};
```

이렇게 하면:

1. `diameter_range` → `{28, 100}` 으로 초기화됨
2. `filtered_points` → `filterPointsByDiameter(..., diameter_range)` 호출 시 정상 값 사용

## 공식 C++ 문서 인용 📘

> **[C++ standard, §12.6.2/13]:**  
> *"Non-static data members are initialized in the order they were declared in the class definition, not in the order listed in the constructor’s initializer list."*

## 실무 팁 🎯

- **이니셜라이저 리스트의 순서는 의미 없다.**
- **멤버 선언 순서대로 초기화된다.**
- `-Wreorder` 옵션을 켜서 컴파일 시 경고 받도록 설정할 수 있다.

```bash
g++ -Wreorder -o my_program main.cpp
```

## 요약 🔚

| 항목 | 설명 |
|------|------|
| 이니셜라이저 리스트 순서 | 보기 좋게 작성하는 용도일 뿐 |
| 실제 초기화 순서 | 클래스 멤버 선언 순서에 따름 |
| 문제 원인 | `diameter_range`가 `filtered_points`보다 늦게 초기화됨 |
| 해결법 | `diameter_range`를 먼저 선언 |
