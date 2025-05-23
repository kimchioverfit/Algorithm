# wchar_t

C/C++에서 유니코드(Unicode) 문자를 표현하기 위한 데이터 타입

기본 char가 보통 1바이트(8비트)로 ASCII 문자 하나를 표현하는 데 비해, 

wchar_t는 플랫폼에 따라 2바이트 또는 4바이트를 사용하여 더 많은 문자

(예: 한글, 한자, 이모지 등)를 표현할 수 있음

### 요약

| 타입        | 바이트 수                          | 설명              |
| --------- | ------------------------------ | --------------- |
| `char`    | 1바이트 (8비트)                     | ASCII 문자 (영문 등) |
| `wchar_t` | 2바이트(Windows)<br>4바이트(Linux 등) | 유니코드 문자         |

```cpp
#include <iostream>

int main() {
    wchar_t wc = L'한';  // L 접두사로 wchar_t 리터럴 표현
    std::wcout << L"문자: " << wc << std::endl;
    return 0;
}
```

### 참고

Windows에서는 wchar_t가 UTF-16 기반 (2바이트)

Linux에서는 wchar_t가 UTF-32 기반 (4바이트)
