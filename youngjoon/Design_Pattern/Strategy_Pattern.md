
```cpp
typedef int (*Strategy)(int, int);

int add(int a, int b) { return a + b; }
int mul(int a, int b) { return a * b; }

void execute(int a, int b, Strategy s) {
    cout << "Result: " << s(a, b) << endl;
}

execute(3, 4, add);  // 결과: 7
execute(3, 4, mul);  // 결과: 12

```
위 케이스처럼, 실행 시점에 알고리즘을 선택하게 할 수도 있음. 