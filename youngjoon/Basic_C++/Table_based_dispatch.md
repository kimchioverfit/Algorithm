
```cpp
void cmdA() { cout << "A\n"; }
void cmdB() { cout << "B\n"; }

void (*command_table[2])() = { cmdA, cmdB };

command_table[0]();  // "A"
```
switch 문 보다 빠르게 분기 처리가 가능함. 

switch 문은 런타임에 체크를 하는데, 

함수 포인터의 경우 분기 조건없이 바로 함수로 점프함. (어셈블리 점프)

근데 어차피 함수가 돌아가는 시간은 동일하기 때문에 큰 차이는 아닐 수 있음.
