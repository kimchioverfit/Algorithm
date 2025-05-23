# TCHAR

TCHAR는 Windows 프로그래밍에서 사용하는 문자형 자료형(type) 중 하나

유니코드와 ANSI 문자셋을 모두 지원하기 위해 만들어짐

```cpp
#ifdef UNICODE
  typedef wchar_t TCHAR;  // 유니코드일 경우
#else
  typedef char TCHAR;     // ANSI일 경우
#endif
```


[`wchar_t`란?](./wchar_t.md)

즉,

UNICODE 매크로가 정의되어 있으면 → TCHAR는 wchar_t (2바이트 문자형, 유니코드)

그렇지 않으면 → TCHAR는 char (1바이트 문자형, ANSI)


### 요약

TCHAR는 Windows에서 유니코드와 ANSI 호환을 위해 사용되는 문자 자료형

유니코드 설정 시 wchar_t, 아니면 char

문자열 함수도 _tcslen, _tcscpy 같은 접두사가 붙은 버전을 사용