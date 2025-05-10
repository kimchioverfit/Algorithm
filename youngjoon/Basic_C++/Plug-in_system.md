
```cpp
// 함수 포인터 타입 정의
typedef int (*PluginFunc)(int);
HMODULE dll = LoadLibraryA("plugin.dll");
PluginFunc plugin = (PluginFunc)GetProcAddress(dll, "doWork");


int result = plugin(42);
FreeLibrary(dll);
```

런타임에 로딩된 함수를 포인터로 호출 가능. 

사용하는 경우는 아래와 같음.

| 상황          | 이유                              |
| ----------- | ------------------------------- |
| 플러그인 구조     | 새 기능 추가 시 exe를 안 바꾸고 DLL만 교체 가능 |
| 런타임 로딩      | 성능 또는 라이선스 이유로 일부 기능만 조건부 로딩    |
| 리플렉션 비슷한 구조 | 함수 이름만 알고 실행 가능                 |