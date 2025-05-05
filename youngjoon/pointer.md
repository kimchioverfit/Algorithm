# Pointer


### Shared ptr, unique ptr

| 포인터 종류               | 소유권          | 참조 가능 개수            | 자동 해제 | 주요 특징 / 용도                              |
| -------------------- | ------------ | ------------------- | ----- | --------------------------------------- |
| `T*` (raw pointer)   | 없음 (직접 관리)   | 여러 개 가능             | ❌ 아니요 | 메모리 직접 해제 필요 (`delete`)<br>위험하지만 유연함    |
| `std::unique_ptr<T>` | 단독 소유        | 1개 (이동만 가능)         | ✅ 예   | 소유권 명확, 가장 안전한 스마트 포인터                  |
| `std::shared_ptr<T>` | 공동 소유        | 여러 개 가능             | ✅ 예   | 참조 카운트 기반 자동 해제<br>공동 소유 가능             |
| `std::weak_ptr<T>`   | 소유권 없음 (비참조) | 0 (shared\_ptr 참조만) | ❌ 아니요 | `shared_ptr`의 순환 참조 방지용<br>객체 생존 여부 확인용 |

### Function pointer

```cpp
#include <iostream>
using namespace std;

// 함수 정의
int sayHello() {
    cout << "Hello!" << endl;
    return 0;
}

// 함수 포인터 타입 정의
typedef int (*FuncType)();

int main() {
    // 함수 포인터 변수 선언
    FuncType funcPtr = sayHello;

    // 함수 포인터로 함수 호출
    funcPtr();

    return 0;
}


```
