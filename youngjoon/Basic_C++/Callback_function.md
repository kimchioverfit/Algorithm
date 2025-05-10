```cpp
bool compare(int a, int b) { return a > b; }
std::sort(arr, arr + n, compare);  // compare는 함수 포인터
```
위 케이스를 보면 알 수 있듯이, 함수를 파라미터로 쓸 수 있음.