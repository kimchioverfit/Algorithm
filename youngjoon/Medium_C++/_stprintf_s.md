# _stprintf_s

문자열을 포맷팅하여 버퍼에 안전하게 출력하는 함수

Windows 환경에서 사용하는 Secure CRT(보안 C 런타임) 함수 중 하나

기본적인 목적은 sprintf나 _stprintf처럼 문자열을 버퍼에 출력하되, 

버퍼 오버플로우를 방지하기 위한 보안 기능이 추가된 버전

```cpp
int _stprintf_s(
    TCHAR *buffer,       // 출력 버퍼
    size_t sizeOfBuffer, // 버퍼 크기 (문자 단위)
    const TCHAR *format, // 포맷 문자열
    ...                  // 가변 인자
);
```

| Parameter             | Description                                     |
| -------------- | -------------------------------------- |
| `buffer`       | 출력 결과를 저장할 버퍼                          |
| `sizeOfBuffer` | 버퍼의 크기 (`TCHAR` 기준 크기)                 |
| `format`       | 출력할 형식을 지정하는 문자열 (`%d`, `%s`, 등 사용 가능) |
| `...`          | 포맷에 따라 들어가는 값들                         |

### ✅ 특징

TCHAR 기반으로 작성되어 있어, 유니코드 설정 여부에 따라 char 또는 wchar_t 버전으로 동작.

ANSI 모드 → sprintf_s

UNICODE 모드 → swprintf_s

버퍼 크기를 초과할 경우 런타임 오류가 발생하며 프로그램이 종료될 수 있음 (Debug CRT 설정 시).

### 🔒 보안 주의사항

_stprintf_s는 입력 길이를 제한하여 버퍼 오버플로우 취약점을 방지합니다.

사용 시 반드시 버퍼 크기를 정확히 계산해줘야 합니다.