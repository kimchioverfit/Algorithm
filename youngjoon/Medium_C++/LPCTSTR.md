# LPCTSTR

LPCTSTR는 Windows API에서 사용되는 데이터 타입

### 🔹 LPCTSTR의 의미

LPCTSTR = Long Pointer to a Constant `TCHAR` String

쉽게 말해: 변경 불가능한 문자열(읽기 전용 문자열)을 가리키는 포인터




[`TCHAR`란? ](./TCHAR.md)

### 🔹 구성 요소

LP = Long Pointer (Windows에서 32비트/64비트 주소 공간을 지칭)

C = Constant (읽기 전용)

TCHAR = 문자 타입 (유니코드/멀티바이트 대응)

STR = 문자열

### 🔹 유니코드 vs ANSI

TCHAR는 컴파일 설정에 따라 다음 중 하나로 결정됩니다:

유니코드 설정이면: TCHAR → wchar_t, LPCTSTR → const wchar_t*

ANSI 설정이면: TCHAR → char, LPCTSTR → const char*