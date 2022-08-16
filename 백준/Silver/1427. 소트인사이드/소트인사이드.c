#pragma warning(disable : 4996)
#include <stdio.h>

int main()
{
    int N;
    scanf("%d", &N);
    int ary[11];
    int index = 0;
    while (N > 0)
    {
        ary[index++] = N % 10;
        N /= 10;
    }
    int max;
    int temp;
    for (int i = 0; i < index - 1; i++)
    {
        max = i;
        for (int j = i + 1; j < index; j++)
        {
            if (ary[max] < ary[j])
                max = j;
        }
        temp = ary[i];
        ary[i] = ary[max];
        ary[max] = temp;
    }
    for (int i = 0; i < index; i++)
        printf("%d", ary[i]);
}