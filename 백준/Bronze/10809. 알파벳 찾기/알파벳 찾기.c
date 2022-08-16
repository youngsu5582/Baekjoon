#pragma warning(disable : 4996)
#include <stdio.h>

int main()
{
    char str[100];
    scanf("%s", str);
    int alpha[26];
    int index = 0;
    for (int i = 0; i < 26; i++)
        alpha[i] = -1;
    for (int i = 0; str[i] != NULL; i++)
    {
        index = str[i] - 'a';
        if (alpha[index] >= 0)
            continue;
        else
            alpha[str[i] - 'a'] = i;
    }
    for (int i = 0; i < 26; i++)
        printf("%d ", alpha[i]);
}